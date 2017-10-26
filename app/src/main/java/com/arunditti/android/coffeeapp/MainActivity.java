package com.arunditti.android.coffeeapp;

import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //This method is used to increment the quantity
    public void incrementQuantity(View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    //This method will decrement the quantity
    public void decrementQuantity(View view) {
        quantity = quantity - 1;
        display(quantity);
    }

    // This method is called when the button is clicked
    public void submitOrder(View view) {
        displayPrice(quantity * 5);
    }

    // This method shows the given quantity value on the screen
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    // This method displays the price
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }


}
