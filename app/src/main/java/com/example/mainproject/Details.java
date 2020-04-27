package com.example.mainproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;


public class Details extends AppCompatActivity {
    private static final String TAG = "GalleryActivity";
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        FirebaseAuth.getInstance();
        Log.d(TAG, "onCreate: started.");
        getIncomingIntent();
        button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PlaceOrder.class);
                intent.putExtra("oname",getIntent().getStringExtra("image_name"));
                intent.putExtra("price",getIntent().getStringExtra("price"));
                startActivity(intent);

            }
        });

    }
    private void getIncomingIntent() {
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");
        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name") && getIntent().hasExtra("res") && getIntent().hasExtra("price")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");
            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            String reso = getIntent().getStringExtra("res");
            String price = getIntent().getStringExtra("price");

            setImage(imageUrl, imageName,reso,price);
        }
    }

    private void setImage(String imageUrl, String imageName, String reso, String price) {
        TextView name = findViewById(R.id.image_description);
        name.setText(imageName);
        TextView resource = findViewById(R.id.textView2);
        resource.setText(reso);
        TextView pri = findViewById(R.id.textView3);
        pri.setText(price);
        ImageView image = findViewById(R.id.imageView2);
    }

}
