package com.symon.receipt_app_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button milkButton, sugarButton, flourButton, breadButton, grandTotalButton, discountButton, netPayButton;
    EditText milkPrice, milkPriceVat, actualMilkPrice;
    EditText sugarPrice, sugarPriceVat, actualSugarPrice;
    EditText breadPrice, breadPriceVat, actualBreadPrice;
    EditText flourPrice, flourPriceVat, actualFlourPrice;

    int milkCount = 0, sugarCount = 0, breadCount = 0, flourCount = 0;
    float milkPriceValue = 100, sugarPriceValue = 130, breadPriceValue = 70, flourPriceValue = 180;
    float milkGrossAmount = 0, sugarGrossAmount = 0, breadGrossAmount = 0, flourGrossAmount = 0;
    float milkVat = 0, sugarVat = 0, breadVat = 0, flourVat = 0;
    float milkDiscount = 0, sugarDiscount = 0, breadDiscount = 0, flourDiscount = 0;

    float actualMilkPriceValue = 0, actualSugarPriceValue = 0, actualBreadPriceValue = 0, actualFlourPriceValue = 0;

    float calculateGrossAmount(float price, int count) {
        return price * count;
    }

    float calculateVat(float price) {
        return (float) (price * 0.16);
    }

    float calculateActualPrice(float grossAmount){
        return grossAmount - calculateVat(grossAmount);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // binding the buttons
        milkButton = findViewById(R.id.milk_button);
        sugarButton = findViewById(R.id.sugar_button);
        flourButton = findViewById(R.id.flour_button);
        breadButton = findViewById(R.id.bread_button);
        grandTotalButton = findViewById(R.id.grand_total_button);
        discountButton = findViewById(R.id.discount_button);
        netPayButton = findViewById(R.id.net_pay_button);

        // clicking the milk button increments the milk count but up to 4
        milkButton.setOnClickListener(v -> {
            if (milkCount < 4) {
                milkCount++;
                milkPriceValue += 100.0;
                milkGrossAmount = calculateGrossAmount(milkPriceValue, milkCount);
                milkVat = calculateVat(milkGrossAmount);
                milkPrice.setText(String.valueOf(milkGrossAmount));
                milkPriceVat.setText(String.valueOf(milkVat));
                actualMilkPriceValue = calculateActualPrice(milkGrossAmount);


//                milkPrice.setText(String.valueOf(calculateGrossAmount(milkPriceValue, milkCount)));
//                milkPriceVat.setText(String.valueOf(calculateVat(milkPriceValue * milkCount)));
            }
        });
    }
}