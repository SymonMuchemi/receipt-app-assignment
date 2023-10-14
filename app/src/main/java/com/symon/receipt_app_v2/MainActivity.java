package com.symon.receipt_app_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button milkButton, sugarButton, breadButton, grandTotalButton, discountButton, netPayButton;
    EditText milkPrice, milkPriceVat, actualMilkPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}