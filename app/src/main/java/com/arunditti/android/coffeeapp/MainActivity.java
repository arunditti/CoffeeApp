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
        displayQuantity(quantity);
    }

    //This method will decrement the quantity
    public void decrementQuantity(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    // This method is called when the button is clicked
    public void submitOrder(View view) {
        int totalPrice = calculatePrice();
        String orderSummaryMessage = createOrderSummary(totalPrice);
        displayMessage(orderSummaryMessage);
    }

    /** Calculate the price of the order
     *
     * @return total price
     */
    private int calculatePrice() {
        int pricePerCup = 5;
        int totalPrice = quantity * pricePerCup;
        return totalPrice;
    }

    /**
     * create summary of the order
     * @param totalPrice of the order
     * @return text summary
     */
    private String createOrderSummary(int  totalPrice) {
        String orderSummaryMessage = "Name: Anushri Tiwari";
        orderSummaryMessage = orderSummaryMessage + "\nQuantity: " + quantity;
        orderSummaryMessage = orderSummaryMessage +"\nTotal: $" +totalPrice;
        orderSummaryMessage = orderSummaryMessage + "\nThank You!";
        return orderSummaryMessage;
    }

    // This method shows the given quantity value on the screen
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView)findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}
