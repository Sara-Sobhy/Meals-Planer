package com.example.meals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.meals.FavMeals.Fav_Activity;
import com.example.meals.getAllmeals.AllMeals;

public class MainActivity extends AppCompatActivity {

    Button btnAllProducts;
    Button btnFavoriteProducts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAllProducts = findViewById(R.id.btnAllProducts);
        btnFavoriteProducts = findViewById(R.id.btnFavoriteProducts);
        btnAllProducts.setOnClickListener(v -> {
            Intent intent = new Intent(this, AllMeals.class);
            startActivity(intent);
        });
        btnFavoriteProducts.setOnClickListener(v -> {
            Intent intent = new Intent(this, Fav_Activity.class);
            startActivity(intent);
        });

    }
}