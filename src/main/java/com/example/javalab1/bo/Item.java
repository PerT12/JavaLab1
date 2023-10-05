package com.example.javalab1.bo;

import com.example.javalab1.db.ItemDB;
import java.util.Collection;

public class Item {

    private int id;
    private String name;
    private String description;

    static public Collection searchItems(String group) {
        return ItemDB.searchItems(group);
    }

    protected Item(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}