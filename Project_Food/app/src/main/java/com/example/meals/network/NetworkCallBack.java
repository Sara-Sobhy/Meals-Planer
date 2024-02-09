package com.example.meals.network;

import com.example.meals.model.Meals;

import java.util.List;

public interface NetworkCallBack {
    public void onSuccess(List<Meals> mealsList);
    public void onFailure(String error);
}
