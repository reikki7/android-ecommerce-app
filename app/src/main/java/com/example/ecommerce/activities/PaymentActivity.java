package com.example.ecommerce.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ecommerce.R;

public class PaymentActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView subTotal, discount, shipping, total;
    Button paymentBtn;
    double amount = 0.0;
    double totalBill = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        toolbar = findViewById(R.id.payment_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount = 0.0;
                totalBill = 0.0;
                finish();
            }
        });

        totalBill = getIntent().getDoubleExtra("totalBill", 0.0);
        amount = getIntent().getDoubleExtra("amount", 0.0);

        subTotal = findViewById(R.id.sub_total);
        discount = findViewById(R.id.textView17);
        shipping = findViewById(R.id.textView18);

        total = findViewById(R.id.total_amt);
        paymentBtn = findViewById(R.id.pay_btn);

        if (amount != 0.0) {
            subTotal.setText("$" + amount);
        } else {
            subTotal.setText("$" + totalBill);
        }

        double subtotalValue = Double.parseDouble(String.valueOf(amount));
        double subtotalValue2 = Double.parseDouble(String.valueOf(totalBill));
        double discountValue = Double.parseDouble(discount.getText().toString().replace("$", ""));
        double shippingValue = Double.parseDouble(shipping.getText().toString().replace("$", ""));

        double totalValue = ((subtotalValue2 + subtotalValue) - discountValue) + shippingValue;
        total.setText("$" + totalValue);
    }
}
