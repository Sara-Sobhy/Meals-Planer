package com.example.meals.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.meals.model.Meals;

import java.util.List;

@Dao
public interface MealsDAO {
    @Query("select * from meal_table")
    public LiveData<List<Meals>> getAllProducts();
    @Insert
    public void insert(Meals product);
    @Delete
    public void delete(Meals product);
}
