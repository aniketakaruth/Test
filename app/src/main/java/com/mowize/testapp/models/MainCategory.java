package com.mowize.testapp.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ravi Mathpal on 06-02-2018.
 */

public class MainCategory {

    private int categoryId;
    private String categoryName;
    private List<SubCategory> listOfSubCategories;

    public MainCategory(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        listOfSubCategories = new ArrayList<>();
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<SubCategory> getListOfSubCategories() {
        return listOfSubCategories;
    }

    public void setListOfSubCategories(List<SubCategory> listOfSubCategories) {
        this.listOfSubCategories = listOfSubCategories;
    }

    public void addSubCategory(SubCategory subCategory){
        listOfSubCategories.add(subCategory);
    }

}
