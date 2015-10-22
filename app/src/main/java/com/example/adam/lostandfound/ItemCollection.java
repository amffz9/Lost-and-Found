package com.example.adam.lostandfound;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 10/22/2015.
 */
public class ItemCollection implements Serializable
{
    public int item_type_id;
    public String item_type;
    public ArrayList<Item> items;

    public ItemCollection(JSONObject json)
    {

        item_type_id = json.optInt("item_type_id");
        item_type = json.optString("item_type");

        JSONArray items = null;
        this.items = new ArrayList<>();
        items = json.optJSONArray("items");

        for (int i = 0; i < items.length() ; i++) {

            Log.d("ItemCollection", "Adding Items");
            this.items.add(new Item(items.optJSONObject(i)));
        }

    }

    @Override
    public String toString() {


        StringBuilder string = new StringBuilder();
        for (int i = 0; i < items.size() ; i++) {
            string.append(items.get(i).toString());
        }

        return string.toString();
    }
}
