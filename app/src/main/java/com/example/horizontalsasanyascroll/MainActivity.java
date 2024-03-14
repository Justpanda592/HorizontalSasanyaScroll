package com.example.horizontalsasanyascroll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridview = (GridView) findViewById(R.id.gridView1);
        gridview.setAdapter(new ImageAdapter(this));
        gridview.setOnItemClickListener(gridviewOnItemClickListener);
        final Button btn_hor1 = findViewById(R.id.btn_hor1);
        final Button btn_hor2 = findViewById(R.id.btn_hor2);
        final Button btn_hor3 = findViewById(R.id.btn_hor3);
        final Button btn_hor4 = findViewById(R.id.btn_hor4);
        final Button btn_hor5 = findViewById(R.id.btn_hor5);
        final Button btn_hor6 = findViewById(R.id.btn_hor6);
        final Button btn_hor7 = findViewById(R.id.btn_hor7);
        btn_hor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_hor1.setBackgroundColor(getResources().getColor(R.color.activeColor));
                btn_hor2.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor3.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor4.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor5.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor6.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor7.setBackgroundColor(getResources().getColor(R.color.btn_not));
            }
        });
        btn_hor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_hor2.setBackgroundColor(getResources().getColor(R.color.activeColor));
                btn_hor1.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor3.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor4.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor5.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor6.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor7.setBackgroundColor(getResources().getColor(R.color.btn_not));
            }
        });
        btn_hor3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_hor3.setBackgroundColor(getResources().getColor(R.color.activeColor));
                btn_hor2.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor1.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor4.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor5.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor6.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor7.setBackgroundColor(getResources().getColor(R.color.btn_not));
            }
        });
        btn_hor4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_hor4.setBackgroundColor(getResources().getColor(R.color.activeColor));
                btn_hor2.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor3.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor1.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor5.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor6.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor7.setBackgroundColor(getResources().getColor(R.color.btn_not));
            }
        });
        btn_hor5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_hor5.setBackgroundColor(getResources().getColor(R.color.activeColor));
                btn_hor2.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor3.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor4.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor1.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor6.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor7.setBackgroundColor(getResources().getColor(R.color.btn_not));
            }
        });
        btn_hor6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_hor6.setBackgroundColor(getResources().getColor(R.color.activeColor));
                btn_hor2.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor3.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor4.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor5.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor7.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor1.setBackgroundColor(getResources().getColor(R.color.btn_not));
            }
        });
        btn_hor7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_hor7.setBackgroundColor(getResources().getColor(R.color.activeColor));
                btn_hor2.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor3.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor4.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor5.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor6.setBackgroundColor(getResources().getColor(R.color.btn_not));
                btn_hor1.setBackgroundColor(getResources().getColor(R.color.btn_not));
            }
        });

    }
    private GridView.OnItemClickListener gridviewOnItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View v, int position,
                                long id) {
        }
    };
}