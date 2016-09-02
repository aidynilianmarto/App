package com.example.pc.olx.Offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by pc on 27.8.2016 г..
 */
public class Category {

    private String name;
    private ArrayList<Category> subcategories;


    public Category(String name) {

        this.name = name;
    }

    public void addCategory(Category category) {
        subcategories.add(category);
    }

    public List getSubcategories() {
        return Collections.unmodifiableList(subcategories);
    }

    @Override
    public String toString() {
        return name;
    }
}
