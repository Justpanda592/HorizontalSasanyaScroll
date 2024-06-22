package com.example.horizontalsasanyascroll;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class FavoriteAdapter extends CursorAdapter {
    private DBHelper dbHelper;
    private FavoriteActivity favoriteActivity;
    public FavoriteAdapter(FavoriteActivity favoriteActivity, Cursor c, DBHelper dbHelper) {
        super(favoriteActivity.getContext(), c, 0);
        this.favoriteActivity = favoriteActivity;
        this.dbHelper = dbHelper;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.favorite_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView itemName = view.findViewById(R.id.txt_name);
        TextView itemPrice = view.findViewById(R.id.txt_cost);
        ImageView itemImage = view.findViewById(R.id.image);

        final int id = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
        String name = cursor.getString(cursor.getColumnIndexOrThrow("item_name"));
        int price = cursor.getInt(cursor.getColumnIndexOrThrow("item_price"));
        String image = cursor.getString(cursor.getColumnIndexOrThrow("item_image"));

        itemName.setText(name);
        itemPrice.setText(String.valueOf(price) + " р.");
        int imageResId = context.getResources().getIdentifier(image, null, context.getPackageName());

        itemImage.setImageResource(imageResId);
        itemImage.getLayoutParams().width = 325;
        itemImage.getLayoutParams().height = 325;
        Bitmap bitmap = BitmapFactory.decodeResource(itemImage.getResources(), imageResId);
        Bitmap circularBitmap = ImageHelper.getRoundedCornerBitmap(bitmap, 400);
        itemImage.setImageBitmap(circularBitmap);

        view.findViewById(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.deleteItemFromFavorite(id);
                updateCursor();
            }
        });
    }
    private void updateCursor() {
        Cursor newCursor = dbHelper.getFavoriteItems();
        changeCursor(newCursor);
        notifyDataSetChanged();
        favoriteActivity.checkIfFavoriteIsEmpty();
    }
}
