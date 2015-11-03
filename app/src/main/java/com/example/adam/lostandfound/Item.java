package com.example.adam.lostandfound;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by Adam on 10/15/2015.
 */
public class Item implements Serializable{

    public int itemId;
    public int itemTypeId;
    public int status;
    public String location;
    public String foundDate;

    public Item(JSONObject item)
    {
            itemId = Integer.parseInt(item.optString("item_id"));
            itemTypeId = Integer.parseInt(item.optString("item_type_id"));
            status = Integer.parseInt(item.optString("status"));

            location = item.optString("location");
            foundDate = item.optString("found_date");

        }

    @Override
    public String toString() {

        return "Location Found: " + location + "\n"
                + "Found Date: " + foundDate;

    }
}


