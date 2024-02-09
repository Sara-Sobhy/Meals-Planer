package com.example.meals.network;

import com.example.meals.model.Meals;

import java.util.List;

public class MealResponse {
    List<Meals> meals;

    public List<Meals> getMeals() {
        return meals;
    }

    public void setMeals(List<Meals> meals){
        this.meals=meals;
    }
}
