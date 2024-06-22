package com.example.horizontalsasanyascroll;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.widget.Toast;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.List;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class CartActivity extends Fragment {
    private GridView gridViewCart;
    private DBHelper dbHelper;
    private TextView emptyView;
    private TextView totalPriceView;
    private CartAdapter cartAdapter;
    private Button BtnBuy;
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_cart, container, false);

        gridViewCart = view.findViewById(R.id.grid_view_cart);
        emptyView = view.findViewById(R.id.empty_view);
        totalPriceView = view.findViewById(R.id.total_price);
        BtnBuy = view.findViewById(R.id.btn_buy);
        dbHelper = new DBHelper(getContext());

        loadCartItems();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        loadCartItems();
    }

    private void loadCartItems() {
        Cursor cursor = dbHelper.getCartItems();
        cartAdapter = new CartAdapter(this, cursor, dbHelper);
        gridViewCart.setAdapter(cartAdapter);
        checkIfCartIsEmpty();
        calculateTotalPrice();
    }

    public void checkIfCartIsEmpty() {
        if (cartAdapter.getCount() == 0) {
            gridViewCart.setVisibility(View.GONE);
            totalPriceView.setVisibility(View.GONE);
            BtnBuy.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
        } else {
            gridViewCart.setVisibility(View.VISIBLE);
            totalPriceView.setVisibility(View.VISIBLE);
            BtnBuy.setVisibility(View.VISIBLE);
            emptyView.setVisibility(View.GONE);
        }
    }

    public void calculateTotalPrice() {
        int totalPrice = 0;
        Cursor cursor = dbHelper.getCartItems();
        if (cursor.moveToFirst()) {
            do {
                int price = cursor.getInt(cursor.getColumnIndexOrThrow("item_price"));
                totalPrice += price;
            } while (cursor.moveToNext());
        }
        cursor.close();
        totalPriceView.setText("Итого: " + totalPrice + " р.");
    }
}
