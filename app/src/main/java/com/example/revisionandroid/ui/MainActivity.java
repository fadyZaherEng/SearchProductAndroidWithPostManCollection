package com.example.revisionandroid.ui;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.revisionandroid.R;
import com.example.revisionandroid.pogo.DataItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rv);
        MVVM mvvm = ViewModelProviders.of(this).get(MVVM.class);
        mvvm.getData();

        mvvm.mutableLiveData.observe(this, new Observer<List<DataItem>>() {
            @Override
            public void onChanged(List<DataItem> dataItems) {
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                adapter=new Adapter(
                        dataItems, new myInterface() {
                    @Override
                    public void sendData(String name) {
                        Toast.makeText(MainActivity.this,name, Toast.LENGTH_SHORT).show();
                    }
                },MainActivity.this
                );
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });
    }
}