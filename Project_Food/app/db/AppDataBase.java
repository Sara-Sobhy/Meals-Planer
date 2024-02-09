package com.example.meals.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.meals.model.Meals;

@Database(entities = {Meals.class},version = 1)
public abstract class AppDataBase extends RoomDatabase{
        private static AppDataBase instance=null;
        public abstract MealsDAO getProductDAO();
        public static AppDataBase getInstance(Context context) {
            if(instance == null)
            {
                instance = Room.databaseBuilder(context.getApplicationContext(),AppDataBase.class,"productsdb").build();
            }
            return instance;
        }

}
