package com.mowize.testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mowize.testapp.models.MainCategory;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    RecyclerView list;
    MainActivityController controller;
    List<MainCategory> listOfCategories;

    MainCategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new MainActivityController(this, getApplicationContext());

        list = (RecyclerView) findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));

        controller.makeServerRequest();


    }

    @Override
    public void showData(List<MainCategory> listOfCategories) {
        this.listOfCategories = listOfCategories;

        adapter = new MainCategoryAdapter(listOfCategories, new MainCategoryAdapter.onRowSelected() {
            @Override
            public void onRowSelected(MainCategory mainCategory) {

            }
        });
        list.setAdapter(adapter);

    }
}
