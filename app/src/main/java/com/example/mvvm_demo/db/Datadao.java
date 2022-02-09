package com.example.mvvm_demo.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.mvvm_demo.model.DataItem;

import java.util.List;

@Dao
public interface Datadao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void InsertAllData(List<DataItem> dataItems);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void InsertData(DataItem dataItem);

    @Query("select * from DataItem")
    List<DataItem> GetAllData();
}
