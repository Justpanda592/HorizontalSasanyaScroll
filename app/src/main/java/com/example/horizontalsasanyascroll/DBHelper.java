package com.example.horizontalsasanyascroll;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";
    private static final String DATABASE_NAME = "shop.db";
    private static final int DATABASE_VERSION = 7;

    private static final String TABLE_CART = "cart";
    private static final String COLUMN_CART_ID = "_id";
    private static final String COLUMN_CART_NAME = "item_name";
    private static final String COLUMN_CART_PRICE = "item_price";
    private static final String COLUMN_CART_IMAGE = "item_image";
    private static final String COLUMN_CART_ML = "item_ml";
    private static final String COLUMN_CART_DESC = "item_desc";

    private static final String TABLE_FAVORITES = "favorites";
    private static final String COLUMN_FAVORITE_ID = "_id";
    private static final String COLUMN_FAVORITE_NAME = "item_name";
    private static final String COLUMN_FAVORITE_PRICE = "item_price";
    private static final String COLUMN_FAVORITE_IMAGE = "item_image";
    private static final String COLUMN_FAVORITE_ML = "item_ml";
    private static final String COLUMN_FAVORITE_DESC = "item_desc";

    private static final String TABLE_AUDIT = "audit";
    private static final String COLUMN_AUDIT_ID = "_id";
    private static final String COLUMN_AUDIT_ACTION = "action";
    private static final String COLUMN_TIMESTAMP = "timestamp";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "Создание таблиц");
        String CREATE_TABLE_CART = "CREATE TABLE " + TABLE_CART + "("
                + COLUMN_CART_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_CART_NAME + " TEXT,"
                + COLUMN_CART_PRICE + " INT,"
                + COLUMN_CART_IMAGE + " TEXT,"
                + COLUMN_CART_ML + " INT,"
                + COLUMN_CART_DESC + " TEXT"
                + ")";
        db.execSQL(CREATE_TABLE_CART);
        String CREATE_TABLE_FAVORITES = "CREATE TABLE " + TABLE_FAVORITES + "("
                + COLUMN_FAVORITE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_FAVORITE_NAME + " TEXT,"
                + COLUMN_FAVORITE_PRICE + " INT,"
                + COLUMN_FAVORITE_IMAGE + " TEXT,"
                + COLUMN_FAVORITE_ML + " INT,"
                + COLUMN_FAVORITE_DESC + " TEXT"
                + ")";
        db.execSQL(CREATE_TABLE_FAVORITES);
        String CREATE_TABLE_AUDIT = "CREATE TABLE " + TABLE_AUDIT + "("
                + COLUMN_AUDIT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_AUDIT_ACTION + " TEXT,"
                + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                + ")";
        db.execSQL(CREATE_TABLE_AUDIT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 7) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_CART);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_FAVORITES);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_AUDIT);
            onCreate(db);
        }
    }

    private void logAudit(String action) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put(COLUMN_AUDIT_ACTION, action);
            db.insert(TABLE_AUDIT, null, values);
            Log.d(TAG, "В журнал аудита добавлено: " + action);
        } catch (Exception e) {
            Log.e(TAG, "Ошибка при добавлении в журнал аудита", e);
        } finally {
            db.close();
        }
    }

    public void clearAuditLog() {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.delete(TABLE_AUDIT, null, null);
            Log.d(TAG, "ВСЁ содержимое журнала аудита было стёрто");
        } catch (Exception e) {
            Log.e(TAG, "Ошибка при чистке журнала аудита", e);
        } finally {
            db.close();
        }
    }

    public Cursor getAuditLogs() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_AUDIT, null);
    }

    public void addItemToCart(String itemName, int itemPrice, String itemImage, int itemMl, String itemDesc) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put(COLUMN_CART_NAME, itemName);
            values.put(COLUMN_CART_PRICE, itemPrice);
            values.put(COLUMN_CART_IMAGE, itemImage);
            values.put(COLUMN_CART_ML, itemMl);
            values.put(COLUMN_CART_DESC, itemDesc);
            db.insert(TABLE_CART, null, values);
            Log.d(TAG, "Добавлено в корзину: " + itemName + " - " + itemPrice + " - " + itemImage + " - " + itemMl + " - " + itemDesc);
            logAudit("Добавлено в корзину: " + itemName);
        } catch (Exception e) {
            Log.e(TAG, "Ошибка при добавлении в корзину", e);
        } finally {
            db.close();
        }
    }

    public void deleteItemFromCart(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.delete(TABLE_CART, COLUMN_CART_ID + " = ?", new String[]{String.valueOf(id)});
            Log.d(TAG, "Удалено с корзины: " + id);
            logAudit("Удалено с корзины: " + id);
        } catch (Exception e) {
            Log.e(TAG, "Ошибка при удалении с корзины", e);
        } finally {
            db.close();
        }
    }

    public Cursor getCartItems() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_CART, null);
    }

    public void addItemToFavorite(String itemName, int itemPrice, String itemImage, int itemMl, String itemDesc) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put(COLUMN_FAVORITE_NAME, itemName);
            values.put(COLUMN_FAVORITE_PRICE, itemPrice);
            values.put(COLUMN_FAVORITE_IMAGE, itemImage);
            values.put(COLUMN_FAVORITE_ML, itemMl);
            values.put(COLUMN_FAVORITE_DESC, itemDesc);
            db.insert(TABLE_FAVORITES, null, values);
            Log.d(TAG, "Добавлено в избранное: " + itemName + " - " + itemPrice + " - " + itemImage + " - " + itemMl + " - " + itemDesc);
            logAudit("Добавлено в избранное: " + itemName);
        } catch (Exception e) {
            Log.e(TAG, "Ошибка при добавлении в избранное", e);
        } finally {
            db.close();
        }
    }

    public void deleteItemFromFavorite(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.delete(TABLE_FAVORITES, COLUMN_FAVORITE_ID + " = ?", new String[]{String.valueOf(id)});
            Log.d(TAG, "Удалено с избранного: " + id);
            logAudit("Удалено с избранного: " + id);
        } catch (Exception e) {
            Log.e(TAG, "Ошибка при удалении с избранного", e);
        } finally {
            db.close();
        }
    }

    public Cursor getFavoriteItems() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_FAVORITES, null);
    }
}
