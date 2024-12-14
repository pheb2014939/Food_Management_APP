package com.example.androidfinaltest_b2014939;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ViewAllBillsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BillRVAdapter billRVAdapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_bills);



        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.list);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                } else if (item.getItemId() == R.id.list) {

                    return true;
                } else if (item.getItemId() == R.id.total) {
                    startActivity(new Intent(getApplicationContext(), TotalActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                }else if (item.getItemId() == R.id.you) {
                    startActivity(new Intent(getApplicationContext(), UserProfileActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                }
                return false;
            }
        });



        recyclerView = findViewById(R.id.idRVBills);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        billRVAdapter = new BillRVAdapter();
        recyclerView.setAdapter(billRVAdapter);

        databaseHelper = new DatabaseHelper(this);

        // Fetch all bill data from the database
        Cursor cursor = databaseHelper.getAllOrders();
        billRVAdapter.setCursor(cursor);
    }
}
