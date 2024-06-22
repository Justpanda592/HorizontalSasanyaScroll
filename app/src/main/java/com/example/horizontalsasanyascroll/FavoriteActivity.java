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

public class FavoriteActivity extends Fragment {
    private GridView gridViewFavorite;
    private DBHelper dbHelper;
    private TextView emptyView;
    private FavoriteAdapter favoriteAdapter;
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_favorites, container, false);

        gridViewFavorite = view.findViewById(R.id.grid_view_favorite);
        emptyView = view.findViewById(R.id.empty_view);
        dbHelper = new DBHelper(getContext());

        loadFavoriteItems();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        loadFavoriteItems();
    }

    private void loadFavoriteItems() {
        Cursor cursor = dbHelper.getFavoriteItems();
        favoriteAdapter = new FavoriteAdapter(this, cursor, dbHelper);
        gridViewFavorite.setAdapter(favoriteAdapter);
        checkIfFavoriteIsEmpty();
    }

    public void checkIfFavoriteIsEmpty() {
        if (favoriteAdapter.getCount() == 0) {
            gridViewFavorite.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
        } else {
            gridViewFavorite.setVisibility(View.VISIBLE);
            emptyView.setVisibility(View.GONE);
        }
    }
}

