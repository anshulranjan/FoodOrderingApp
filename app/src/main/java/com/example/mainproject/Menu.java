package com.example.mainproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {
    RecyclerView recyclerView;
    ProductAdapter adapter;
    Button b1,b2,b3;
    List<Product> productList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        productList = new ArrayList<>();
        b1=(Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button3);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Profile.class));
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Menu.this, Login.class));
                }
        });
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productList.add(
                    new Product(
                            1,
                            "Butter Naan - Dipped in Butter",
                            "North Indian",
                            4.3,
                            "25",
                            R.drawable.butternaan));

            productList.add(
                    new Product(
                            1,
                            "Dal Fry - New Taste to Tadka",
                            "North - Indian, South- Indian",
                            4.1,
                            "90",
                            R.drawable.dalfry));

            productList.add(
                    new Product(
                            1,
                            "Paneer Butter Masala - Sweet and Spicy",
                            "Western Style",
                            4.9,
                            "230",
                            R.drawable.paneerbutter));
            productList.add(
                    new Product(
                            1,
                            "Paneer Chilli - Cruncy and Tasty",
                            "Chinese",
                            3.6,
                            "140",
                            R.drawable.paneerchilli));
            productList.add(
                    new Product(
                            1,
                            "Paneer Pulao - with Peas, Carrot",
                            "Chinese, North Cuisines",
                            4.5,
                            "150",
                            R.drawable.paneerpulao));
            productList.add(
                    new Product(
                            1,
                            "Paneer Tikka - Cruncy and Dry",
                            "Chinese, North Indian",
                            4.4,
                            "190",
                            R.drawable.paneertikka));

            ProductAdapter adapter = new ProductAdapter(this, productList);
            recyclerView.setAdapter(adapter);


    }
}
