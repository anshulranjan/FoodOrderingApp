package com.example.mainproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class PlaceOrder extends AppCompatActivity {
    TimePicker timepicker;
    Button button;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        timepicker = (TimePicker) findViewById(R.id.timePicker);
        timepicker.setIs24HourView(true);
        button = findViewById(R.id.buttonConfirm);
        builder = new AlertDialog.Builder(this);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                builder.setMessage("Your Order has been Placed");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }

                });
                AlertDialog alert = builder.create();
                alert.setTitle("Congratulations");
                alert.show();

            }

        });
    }
}
