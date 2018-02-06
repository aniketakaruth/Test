package com.mowize.testapp;

import com.mowize.testapp.models.MainCategory;

import java.util.List;

/**
 * Created by Ravi Mathpal on 06-02-2018.
 */

public interface MainActivityView {

    void showData(List<MainCategory> listOfCategories);

}
