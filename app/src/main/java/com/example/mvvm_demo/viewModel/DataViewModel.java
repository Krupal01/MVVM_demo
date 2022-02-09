package com.example.mvvm_demo.viewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm_demo.model.DataItem;
import com.example.mvvm_demo.network.RetroIntance;
import com.example.mvvm_demo.network.RetroService;
import com.example.mvvm_demo.repository.DataRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataViewModel extends ViewModel {

    DataRepository dataRepository;

    public DataViewModel(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public MutableLiveData<List<DataItem>> getLiveDataList() {
        return dataRepository.getDataList();
    }

//    private MutableLiveData<List<DataItem>> LiveDataList = new MutableLiveData<>();
//    public void makeApiCall() {
//        RetroService service = RetroIntance.getInstance().create(RetroService.class);
//        Call<List<DataItem>> call = service.getDataList();
//        call.enqueue(new Callback<List<DataItem>>() {
//            @Override
//            public void onResponse(Call<List<DataItem>> call, Response<List<DataItem>> response) {
//                if (response.body()!= null){
//                    LiveDataList.postValue(response.body());
//                    Log.i("krupal","response not null");
//                }else {
//                    Log.i("krupal","response null");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<DataItem>> call, Throwable t) {
//
//            }
//        });
//    }
}
