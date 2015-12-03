package com.example.adam.lostandfound;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;


import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 10/22/2015.
 */
public class ItemAdapter extends ArrayAdapter<Item> implements Filterable
{
    private ArrayList<Item> objects = null;
    private ItemFilter filter = null;

    public ItemAdapter(Context context, int resource, ArrayList<Item> objects) {
        super(context, resource, objects);
        this.objects = objects;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;


        //Log.d("getView", convertView.toString());
        if (v == null) {
            Log.d("getView", "v is null!");
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = (ItemCell)vi.inflate(R.layout.itemcell, null);

        }

       //Log.d("ItemAdapter", "Hello");
        Item p = objects.get(position);

        if (p != null) {
            /*
            Load Views
             */

            ItemCell cell = (ItemCell)v;
            //Log.d("getView", cell.toString());
            cell.setLocationFound(p.location);
            cell.setDateFound(p.foundDate);
        }

        return v;
    }

    @Override
    public Filter getFilter() {

        if(filter == null)
        {
            Log.d("Creating Filter","");
            filter = new ItemFilter(objects,this);
        }

        return filter;
    }


}
