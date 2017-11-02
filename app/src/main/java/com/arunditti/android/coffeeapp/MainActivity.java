package com.arunditti.android.coffeeapp;

import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
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
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        //Log.v("MainActivity", "Name: " + name);

        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWippedCream = whippedCreamCheckbox.isChecked();
       // Log.v("MainActivity", "Has whipped cream " + hasWippedCream);

        CheckBox chocolateCheckbox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckbox.isChecked();
        //Log.v("MainActivity", "Has chocolate " + hasChocolate);

        int totalPrice = calculatePrice();
        String orderSummaryMessage = createOrderSummary(name, totalPrice, hasWippedCream, hasChocolate);
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
     * @param addWhippedCream to add whipped cream
     * @param addChocolate to add chocolate
     * @return text summary
     */
    private String createOrderSummary(String name, int  totalPrice, boolean addWhippedCream, boolean addChocolate) {
        String orderSummaryMessage = "Name: " + name;
        orderSummaryMessage += "\nAdd whipped cream? " + addWhippedCream;
        orderSummaryMessage +="\nAdd chocolate? " + addChocolate;
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
