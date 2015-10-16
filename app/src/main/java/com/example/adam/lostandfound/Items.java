package com.example.adam.lostandfound;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * Created by Adam on 10/15/2015.
 */
public class Items {
    public ArrayList<Item> items = new ArrayList<Item>();

    public int length()
    {
        return items.size();
    }

    public Items(JSONArray items){

        for (int i = 0; i < items.length(); i++) {
            this.items.add(new Item(items.optJSONObject(i)));
        }

    }
}
