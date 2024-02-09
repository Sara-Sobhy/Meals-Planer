package com.example.meals.FavMeals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.meals.FavAdapter;
import com.example.meals.R;
import com.example.meals.db.AppDataBase;
import com.example.meals.db.MealsDAO;
import com.example.meals.model.Meals;

import java.util.List;

public class Fav_Activity extends AppCompatActivity implements FavLisneter{

    RecyclerView recyclerView;
    MealsDAO productDAO;
    List<Meals> productsList;
    FavAdapter favAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);
        Log.i("Key", "onCreate: hhhhhhhhhhhh");
        AppDataBase appDataBase = AppDataBase.getInstance(this);
        productDAO = appDataBase.getProductDAO();
        recyclerView = findViewById(R.id.FavView);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        LiveData<List<Meals>> products = productDAO.getAllProducts();
        products.observe(this, new Observer<List<Meals>>() {
            @Override
            public void onChanged(List<Meals> products) {
                FavAdapter favAdapter=new FavAdapter(Fav_Activity.this,products,Fav_Activity.this);
                favAdapter.notifyDataSetChanged();
                recyclerView.setAdapter(favAdapter);
            }
        });

    }

    @Override
    public void onRemoveListener(Meals product) {
        new Thread(() -> {
            productDAO.delete(product);
        }).start();
    }
}