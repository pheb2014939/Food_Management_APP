package com.example.androidfinaltest_b2014939;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// DatabaseHelper.java
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "orders.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_ORDERS = "orders";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NOODLE_NAME = "noodle_name";
    private static final String COLUMN_CUSTOMER_NAME = "customer_name";
    private static final String COLUMN_PHONE_NUMBER = "phone_number";
    private static final String COLUMN_QUANTITY = "quantity";
    private static final String COLUMN_TOTAL_PRICE = "total_price";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_ORDERS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NOODLE_NAME + " TEXT, "
                + COLUMN_CUSTOMER_NAME + " TEXT, "
                + COLUMN_PHONE_NUMBER + " TEXT, "
                + COLUMN_QUANTITY + " INTEGER, "
                + COLUMN_TOTAL_PRICE + " REAL)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDERS);
        onCreate(db);
    }




    public void addOrder(String noodleName, String customerName, String phoneNumber, int quantity, double totalPrice) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOODLE_NAME, noodleName);
        values.put(COLUMN_CUSTOMER_NAME, customerName);
        values.put(COLUMN_PHONE_NUMBER, phoneNumber);
        values.put(COLUMN_QUANTITY, quantity);
        values.put(COLUMN_TOTAL_PRICE, totalPrice);
        db.insert(TABLE_ORDERS, null, values);
        db.close();
        // Add order to database

    }

    public Cursor getAllOrders() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM orders", null);
    }


    public double calculateTotalPrice(int quantity, double pricePerUnit) {
        return quantity * pricePerUnit;
    }
}
