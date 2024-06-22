package com.example.horizontalsasanyascroll;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

public class CustomDialog extends Dialog {
    public CustomDialog(Context context) {
        super(context);
        setContentView(R.layout.custom_dialog);
        TextView textViewMessage = findViewById(R.id.text_view_message);
        ImageView image = findViewById(R.id.image);
        Button buttonBack = findViewById(R.id.btn_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hide();
            }
        });
    }
}
