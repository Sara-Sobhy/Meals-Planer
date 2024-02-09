package com.example.meals.getAllmeals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.meals.AllmealsAdapter;
import com.example.meals.R;
import com.example.meals.db.AppDataBase;
import com.example.meals.db.MealsDAO;
import com.example.meals.model.Meals;
import com.example.meals.network.MealClient;
import com.example.meals.network.NetworkCallBack;

import java.util.ArrayList;
import java.util.List;

public class AllMeals extends AppCompatActivity implements NetworkCallBack, AllMealLisenter {

    RecyclerView recyclerView;
    AppDataBase appDataBase;
    MealsDAO mealsDAO;
    AllmealsAdapter myRecyclerAdapter;
    List<Meals> mealsList = new ArrayList<>(); // Initialize empty list
    MealClient productClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_meals);
        productClient=MealClient.getInstance();
        Log.i("key", "onCreate: beforeeeeeeeeeeeeeeeeeee");
        productClient.makeNetworkCall(this);
        Log.i("key", "onCreate: afteeeeeeeeeeeeeeeeeer");
        recyclerView = findViewById(R.id.reView);
        LinearLayoutManager linear= new LinearLayoutManager(this);
        linear.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linear);
        appDataBase= AppDataBase.getInstance(this);
        mealsDAO=appDataBase.getProductDAO();

         myRecyclerAdapter = new AllmealsAdapter(this, new ArrayList<>(), this);
        recyclerView.setAdapter(myRecyclerAdapter);

    }
    @Override
    public void onSuccess(List<Meals> mealsList ){
        Log.i("Key", "onSuccess: " + mealsList.get(0));
         //myRecyclerAdapter= new AllmealsAdapter(this,mealsList,this);
        //recyclerView.setAdapter(myRecyclerAdapter);
         myRecyclerAdapter.setMyList(mealsList);
    }

    @Override
    public void onFailure(String error) {
        Log.i("TAG", "onFailure: "+ error);
    }

    @Override
    public void addOnClickLister(Meals product) {
        new Thread(() -> {
            mealsDAO.insert(product);
        }).start();
    }
}