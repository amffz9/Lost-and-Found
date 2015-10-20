package com.example.adam.lostandfound;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

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

        if (items == null) {
            return;
        }
        for (int i = 0; i < items.length(); i++) {
            this.items.add(new Item(items.optJSONObject(i)));
        }

    }

    public void addItem(JSONObject item) {
        this.items.add(new Item(item));
    }

    public Item getItemById(int id) {
        for (int i = 0; i < items.size(); i++) {

            Item item = items.get(i);

            if (item.itemId == id) {
                return item;
            }
        }

        return null;//Item does not exist
    }

    public Item[] getItemArray() {
        return Arrays.copyOf(items.toArray(), items.toArray().length, Item[].class);

    }

    @Override
    public String toString() {

        return super.toString();
    }
}
