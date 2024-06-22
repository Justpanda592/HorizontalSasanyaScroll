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
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import org.w3c.dom.Text;

public class AuditActivity extends Fragment {
    private ListView listViewAudit;
    private Button btnClearAudit;
    private DBHelper dbHelper;
    private TextView emptyView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_audit, container, false);

        listViewAudit = view.findViewById(R.id.list_view_audit);
        btnClearAudit = view.findViewById(R.id.btn_clear_audit);
        dbHelper = new DBHelper(getContext());
        emptyView = view.findViewById(R.id.empty_view);

        loadAuditLogs();

        btnClearAudit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.clearAuditLog();
                loadAuditLogs();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        loadAuditLogs();
    }

    private void loadAuditLogs() {
        Cursor cursor = dbHelper.getAuditLogs();
        String[] from = new String[]{"action", "timestamp"};
        int[] to = new int[]{R.id.audit_action, R.id.audit_timestamp};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getContext(),
                R.layout.audit_item, cursor, from, to, 0);
        listViewAudit.setAdapter(adapter);
        checkIfAuditIsEmpty();
    }

    public void checkIfAuditIsEmpty() {
        if (listViewAudit.getCount() == 0) {
            listViewAudit.setVisibility(View.GONE);
            btnClearAudit.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
        } else {
            listViewAudit.setVisibility(View.VISIBLE);
            btnClearAudit.setVisibility(View.VISIBLE);
            emptyView.setVisibility(View.GONE);
        }
    }
}

