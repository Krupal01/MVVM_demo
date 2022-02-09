package com.example.mvvm_demo.viewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvm_demo.repository.DataRepository;

public class DataViewModelFactory implements ViewModelProvider.Factory {

    DataRepository repository;
    public DataViewModelFactory(DataRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new DataViewModel(repository);
    }
}
