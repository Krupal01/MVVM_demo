package com.example.mvvm_demo.repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvm_demo.db.Datadao;
import com.example.mvvm_demo.model.DataItem;
import com.example.mvvm_demo.network.RetroIntance;
import com.example.mvvm_demo.network.RetroService;
import com.example.mvvm_demo.utils.NetworkUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataRepository {

    RetroService service;
    Datadao datadao;
    Context context;

    public DataRepository(RetroService service, Datadao datadao , Context context) {
        this.service = service;
        this.datadao = datadao;
        this.context = context;
    }



    public MutableLiveData<List<DataItem>> getDataList(){
        MutableLiveData<List<DataItem>> LiveDataList = new MutableLiveData<>();
        if (new NetworkUtil(context).IsConnected()){
            Call<List<DataItem>> call = service.getDataList();
            call.enqueue(new Callback<List<DataItem>>() {
                @Override
                public void onResponse(Call<List<DataItem>> call, Response<List<DataItem>> response) {
                    if (response.body()!= null){
                        LiveDataList.postValue(response.body());
                        datadao.InsertAllData(response.body());
                        Log.i("krupal","response not null");
                    }else {
                        Log.i("krupal","response null");
                    }
                }

                @Override
                public void onFailure(Call<List<DataItem>> call, Throwable t) {
                    Log.i("krupal","response fail");
                }
            });
        }else {
            LiveDataList.postValue(datadao.GetAllData());
            Log.i("krupal","Data from Database");
        }
        return LiveDataList;
    }

}
