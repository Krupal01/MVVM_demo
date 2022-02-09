package com.example.mvvm_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.mvvm_demo.adapter.DataAdapter;
import com.example.mvvm_demo.databinding.ActivityMainBinding;
import com.example.mvvm_demo.db.DataDatabase;
import com.example.mvvm_demo.db.Datadao;
import com.example.mvvm_demo.model.DataItem;
import com.example.mvvm_demo.network.RetroIntance;
import com.example.mvvm_demo.network.RetroService;
import com.example.mvvm_demo.repository.DataRepository;
import com.example.mvvm_demo.viewModel.DataViewModel;
import com.example.mvvm_demo.viewModel.DataViewModelFactory;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    DataViewModel viewModel;
    DataAdapter adapter;
    ArrayList<DataItem> items;
    DataRepository repository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RetroService service = RetroIntance.getInstance().create(RetroService.class);
        Datadao datadao = DataDatabase.getInstance(getApplicationContext()).datadao();
        repository = new DataRepository(service,datadao,getApplicationContext());

        viewModel = new ViewModelProvider(this,new DataViewModelFactory(repository)).get(DataViewModel.class);
        adapter = new DataAdapter();
        items = new ArrayList<>();


        viewModel.getLiveDataList().observe(this, new Observer<List<DataItem>>() {
            @Override
            public void onChanged(List<DataItem> dataItems) {
                items.addAll(dataItems);
                adapter.notifyDataSetChanged();
            }
        });

        adapter.setItemList(items);
        binding.rcvData.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.rcvData.setAdapter(adapter);


    }
}