package com.example.meals.network;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MealClient {
    private static final String TAG = "MealClient";
    private static MealClient instance =null;
    private MealClient()
    {

    }

    public static MealClient getInstance() {
        if(instance == null)
        {
            instance= new MealClient();
        }
        return instance;
    }
    public void makeNetworkCall(NetworkCallBack networkCallBack)
    {
        Log.i("TAG", "makeNetworkCall: hiiiiiiiiiiiiiiiiiiii");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/api/json/v1/1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MealService productService= retrofit.create(MealService.class);
        Call<MealResponse> call=productService.getAllProducts();
        call.enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                if(response.isSuccessful())
                {
                    Log.i("Key", "onResponse: sucessssssssssssssssss");
                    Log.i("Key", "onResponse: "+response.body().meals.size());
                    networkCallBack.onSuccess(response.body().getMeals());
                }
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable t) {
                Log.i(TAG, "onFailure: faaaaaaaaaaaaaaaaaaaaaaaaail");
                t.printStackTrace();
            }
        });

    }
}
