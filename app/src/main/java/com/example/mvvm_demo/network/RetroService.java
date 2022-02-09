package com.example.mvvm_demo.network;

import com.example.mvvm_demo.model.DataItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetroService {

    @GET("/users")
    Call<List<DataItem>> getDataList();

}
