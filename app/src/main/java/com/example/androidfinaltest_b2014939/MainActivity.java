package com.example.androidfinaltest_b2014939;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerNoodleMenu;
    private EditText editTextCustomerName;
    private EditText editTextPhoneNumber;
    private EditText editTextQuantity;
    private TextView textViewTotalPrice;
    private Button buttonAddOrder;


    private DatabaseHelper databaseHelper;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigator);
//        bottomNavigationView.setSelectedItemId(R.id.home);
//
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                if (item.getItemId() == R.id.home) {
//                    return true;
//                } else if (item.getItemId() == R.id.list) {
//                    startActivity(new Intent(getApplicationContext(), ViewAllBillsActivity.class));
//                    overridePendingTransition(0, 0);
//                    return true;
//                } else if (item.getItemId() == R.id.total) {
//                    startActivity(new Intent(getApplicationContext(), ViewAllBillsActivity.class));
//                    overridePendingTransition(0, 0);
//                    return true;
//                }else if (item.getItemId() == R.id.you) {
//                    startActivity(new Intent(getApplicationContext(), UserProfileActivity.class));
//                    overridePendingTransition(0, 0);
//                    return true;
//                }
//                return false;
//            }
//        });
//
//        // Initialize views
//        spinnerNoodleMenu = findViewById(R.id.spinner_noodle_menu);
//        editTextCustomerName = findViewById(R.id.edit_text_customer_name);
//        editTextPhoneNumber = findViewById(R.id.edit_text_phone_number);
//        editTextQuantity = findViewById(R.id.edit_text_quantity);
//        textViewTotalPrice = findViewById(R.id.text_view_total_price);
//        buttonAddOrder = findViewById(R.id.button_add_order);
//        Button btn_view_all_bill = findViewById(R.id.btn_view_all_bill);
//
//        btn_view_all_bill.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), ViewAllBillsActivity.class));
//
//            }
//        });
//
//
//        // Initialize database helper
//        databaseHelper = new DatabaseHelper(this);
//
//        // Create an ArrayList to store noodle names
//        ArrayList<String> noodleMenuList = new ArrayList<>();
//        noodleMenuList.add("Mì cay bò Mỹ");
//        noodleMenuList.add("Mì cay bò Úc");
//        noodleMenuList.add("Mì cay Hải sản");
//        noodleMenuList.add("Mì cay Xúc xích");
//        noodleMenuList.add("Mì cay Đặc biệt");
//
//        // Create ArrayAdapter using the ArrayList
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, noodleMenuList);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinnerNoodleMenu.setAdapter(adapter);
//
//        // Handle button click to add order
//        buttonAddOrder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String noodleName = spinnerNoodleMenu.getSelectedItem().toString();
//                String customerName = editTextCustomerName.getText().toString();
//                String phoneNumber = editTextPhoneNumber.getText().toString();
//                int quantity = Integer.parseInt(editTextQuantity.getText().toString());
//
//                // Assume price per unit is known for each type of noodle
//                double pricePerUnit = getPricePerUnit(noodleName);
//
//                // Calculate total price
//                double totalPrice = databaseHelper.calculateTotalPrice(quantity, pricePerUnit);
//
//                // Display total price
//                textViewTotalPrice.setText(String.valueOf(totalPrice));
//
//                // Add order to database
//                databaseHelper.addOrder(noodleName, customerName, phoneNumber, quantity, totalPrice);
//
//                // after adding the data we are displaying a toast message.
//                Toast.makeText(MainActivity.this, "Order added successfully!", Toast.LENGTH_SHORT).show();
//                editTextCustomerName.setText("");
//                editTextPhoneNumber.setText("");
//                editTextQuantity.setText("");
//            }
//        });
//
//
//    }
//
//    // Method to get price per unit for a given noodle type (you need to implement this)
//    private double getPricePerUnit(String noodleName) {
//        // Implement this method to retrieve price per unit for the selected noodle type
//        // from a database or any other data source
//        // You can hardcode prices here for simplicity
//        // Example:
//        if (noodleName.equals("Mì cay bò Mỹ")) {
//            return 43000;
//        } else if (noodleName.equals("Mì cay bò Úc")) {
//            return 45000;
//        }else if (noodleName.equals("Mì cay Hải sản")) {
//            return 45000;
//        }else if (noodleName.equals("Mì cay Xúc xích")) {
//            return 45000;
//        }else if (noodleName.equals("Mì cay Đặc biệt")) {
//            return 65000;
//        }   else {
//            return 0.0;
//        }
//    }//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    return true;
                } else if (item.getItemId() == R.id.list) {
                    startActivity(new Intent(getApplicationContext(), ViewAllBillsActivity.class));
                    overridePendingTransition(0, 0);
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

        // Initialize views
        spinnerNoodleMenu = findViewById(R.id.spinner_noodle_menu);
        editTextCustomerName = findViewById(R.id.edit_text_customer_name);
        editTextPhoneNumber = findViewById(R.id.edit_text_phone_number);
        editTextQuantity = findViewById(R.id.edit_text_quantity);
        textViewTotalPrice = findViewById(R.id.text_view_total_price);
        buttonAddOrder = findViewById(R.id.button_add_order);
        Button btn_view_all_bill = findViewById(R.id.btn_view_all_bill);

        // Initialize database helper
        databaseHelper = new DatabaseHelper(this);

        // Create an ArrayList to store noodle names
        ArrayList<String> noodleMenuList = new ArrayList<>();
        noodleMenuList.add("Mì cay bò Mỹ");
        noodleMenuList.add("Mì cay bò Úc");
        noodleMenuList.add("Mì cay Hải sản");
        noodleMenuList.add("Mì cay Xúc xích");
        noodleMenuList.add("Mì cay Đặc biệt");

        // Create ArrayAdapter using the ArrayList
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, noodleMenuList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNoodleMenu.setAdapter(adapter);

        // Calculate and display initial total price
        calculateAndDisplayTotalPrice();

        // Handle text changes in quantity EditText
        editTextQuantity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculateAndDisplayTotalPrice();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Handle item selection change in spinner
        spinnerNoodleMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Recalculate and display total price when noodle item selection changes
                calculateAndDisplayTotalPrice();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        // Handle click on "Add Order" button
        buttonAddOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noodleName = spinnerNoodleMenu.getSelectedItem().toString();
                String customerName = editTextCustomerName.getText().toString();
                String phoneNumber = editTextPhoneNumber.getText().toString();
                int quantity = 0;
                if (!editTextQuantity.getText().toString().isEmpty()) {
                    quantity = Integer.parseInt(editTextQuantity.getText().toString());
                }

                // Assume price per unit is known for each type of noodle
                double pricePerUnit = getPricePerUnit(noodleName);

                // Calculate total price
                double totalPrice = quantity * pricePerUnit;

                // Display total price
                textViewTotalPrice.setText(String.valueOf(totalPrice));

                // Add order to database
                databaseHelper.addOrder(noodleName, customerName, phoneNumber, quantity, totalPrice);


                    // Order added successfully
                    // Display success message
                    Toast.makeText(MainActivity.this, "Order added successfully!", Toast.LENGTH_SHORT).show();
                    // Clear input fields after adding the order
                    editTextCustomerName.setText("");
                    editTextPhoneNumber.setText("");
                    editTextQuantity.setText("");

            }
        });


        // Handle click on "View All Bills" button
        btn_view_all_bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ViewAllBillsActivity.class));
            }
        });
    }

    // Method to calculate and display the total price
    private void calculateAndDisplayTotalPrice() {
        String noodleName = spinnerNoodleMenu.getSelectedItem().toString();
        int quantity = 0;
        if (!editTextQuantity.getText().toString().isEmpty()) {
            quantity = Integer.parseInt(editTextQuantity.getText().toString());
        }

        // Assume price per unit is known for each type of noodle
        double pricePerUnit = getPricePerUnit(noodleName);

        // Calculate total price
        double totalPrice = quantity * pricePerUnit;

        // Display total price
        textViewTotalPrice.setText(String.valueOf(totalPrice));
    }

    // Method to get price per unit for a given noodle type (you need to implement this)
    private double getPricePerUnit(String noodleName) {
        // Implement this method to retrieve price per unit for the selected noodle type
        // from a database or any other data source
        // You can hardcode prices here for simplicity
        // Example:
        if (noodleName.equals("Mì cay bò Mỹ")) {
            return 43000;
        } else if (noodleName.equals("Mì cay bò Úc")) {
            return 45000;
        } else if (noodleName.equals("Mì cay Hải sản")) {
            return 45000;
        } else if (noodleName.equals("Mì cay Xúc xích")) {
            return 45000;
        } else if (noodleName.equals("Mì cay Đặc biệt")) {
            return 65000;
        } else {
            return 0.0;
        }



//        // Initialize views
//        spinnerNoodleMenu = findViewById(R.id.spinner_noodle_menu);
//        editTextCustomerName = findViewById(R.id.edit_text_customer_name);
//        editTextPhoneNumber = findViewById(R.id.edit_text_phone_number);
//        editTextQuantity = findViewById(R.id.edit_text_quantity);
//        textViewTotalPrice = findViewById(R.id.text_view_total_price);
//        buttonAddOrder = findViewById(R.id.button_add_order);
//        Button btn_view_all_bill = findViewById(R.id.btn_view_all_bill);
//
//        // Initialize database helper
//        databaseHelper = new DatabaseHelper(this);
//
//        // Create an ArrayList to store noodle names
//        ArrayList<String> noodleMenuList = new ArrayList<>();
//        noodleMenuList.add("Mì cay bò Mỹ");
//        noodleMenuList.add("Mì cay bò Úc");
//        noodleMenuList.add("Mì cay Hải sản");
//        noodleMenuList.add("Mì cay Xúc xích");
//        noodleMenuList.add("Mì cay Đặc biệt");
//
//        // Create ArrayAdapter using the ArrayList
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, noodleMenuList);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinnerNoodleMenu.setAdapter(adapter);
//
//        // Calculate and display initial total price
//        calculateAndDisplayTotalPrice();
//
//        // Handle text changes in quantity EditText
//        editTextQuantity.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                calculateAndDisplayTotalPrice();
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {}
//        });
//
//        // Handle click on "Add Order" button
//        buttonAddOrder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String noodleName = spinnerNoodleMenu.getSelectedItem().toString();
//                String customerName = editTextCustomerName.getText().toString();
//                String phoneNumber = editTextPhoneNumber.getText().toString();
//                int quantity = 0;
//                if (!editTextQuantity.getText().toString().isEmpty()) {
//                    quantity = Integer.parseInt(editTextQuantity.getText().toString());
//                }
//
//                // Assume price per unit is known for each type of noodle
//                double pricePerUnit = getPricePerUnit(noodleName);
//
//                // Calculate total price
//                double totalPrice = quantity * pricePerUnit;
//
//                // Display total price
//                textViewTotalPrice.setText(String.valueOf(totalPrice));
//
//                // Add order to database
//                databaseHelper.addOrder(noodleName, customerName, phoneNumber, quantity, totalPrice);
//
//
//                    // Order added successfully
//                    // Display success message
//                    Toast.makeText(MainActivity.this, "Order added successfully!", Toast.LENGTH_SHORT).show();
//                    // Clear input fields after adding the order
//                    editTextCustomerName.setText("");
//                    editTextPhoneNumber.setText("");
//                    editTextQuantity.setText("");
//
//            }
//        });
//
//        // Handle click on "View All Bills" button
//        btn_view_all_bill.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), ViewAllBillsActivity.class));
//            }
//        });
//    }
//
//    // Method to calculate and display the total price
//    private void calculateAndDisplayTotalPrice() {
//        String noodleName = spinnerNoodleMenu.getSelectedItem().toString();
//        int quantity = 0;
//        if (!editTextQuantity.getText().toString().isEmpty()) {
//            quantity = Integer.parseInt(editTextQuantity.getText().toString());
//        }
//
//        // Assume price per unit is known for each type of noodle
//        double pricePerUnit = getPricePerUnit(noodleName);
//
//        // Calculate total price
//        double totalPrice = quantity * pricePerUnit;
//
//        // Display total price
//        textViewTotalPrice.setText(String.valueOf(totalPrice));
//    }
//
//    // Method to get price per unit for a given noodle type (you need to implement this)
//    private double getPricePerUnit(String noodleName) {
//        // Implement this method to retrieve price per unit for the selected noodle type
//        // from a database or any other data source
//        // You can hardcode prices here for simplicity
//        // Example:
//        if (noodleName.equals("Mì cay bò Mỹ")) {
//            return 43000;
//        } else if (noodleName.equals("Mì cay bò Úc")) {
//            return 45000;
//        } else if (noodleName.equals("Mì cay Hải sản")) {
//            return 45000;
//        } else if (noodleName.equals("Mì cay Xúc xích")) {
//            return 45000;
//        } else if (noodleName.equals("Mì cay Đặc biệt")) {
//            return 65000;
//        } else {
//            return 0.0;
//        }
    }

}

