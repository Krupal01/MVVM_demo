package com.example.mvvm_demo.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroIntance {

    public static Retrofit getInstance(){
        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
//https://jsonplaceholder.typicode.com/users