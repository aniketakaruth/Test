package com.mowize.testapp.models;

/**
 * Created by Ravi Mathpal on 06-02-2018.
 */

public class SubCategory {

    private int categoryId;
    private String categoryName;

    public SubCategory(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
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
}
