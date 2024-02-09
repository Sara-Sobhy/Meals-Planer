package com.example.meals.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "meal_table")
public class Meals {
/*
        @PrimaryKey
        @NonNull
        String idCategory;

        String strCategory;
        String strCategoryThumb;
        String strCategoryDescription;


        public Meals(@NonNull String idCategory, String strCategory, String strCategoryThumb, String strCategoryDescription) {
            this.idCategory = idCategory;
            this.strCategory = strCategory;
            this.strCategoryThumb = strCategoryThumb;
            this.strCategoryDescription = strCategoryDescription;
        }

        public void setIdCategory(@NonNull String idCategory) {
            this.idCategory = idCategory;
        }

        public void setStrCategory(String strCategory) {
            this.strCategory = strCategory;
        }

        public void setStrCategoryThumb(String strCategoryThumb) {
            this.strCategoryThumb = strCategoryThumb;
        }

        public void setStrCategoryDescription(String strCategoryDescription) {
            this.strCategoryDescription = strCategoryDescription;
        }

        @NonNull
        public String getIdCategory() {
            return idCategory;
        }

        public String getStrCategory() {
            return strCategory;
        }

        public String getStrCategoryThumb() {
            return strCategoryThumb;
        }

        public String getStrCategoryDescription() {
            return strCategoryDescription;
        }

*/
   @PrimaryKey
   @NonNull
    String strMeal;

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }
}
