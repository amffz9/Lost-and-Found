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


import java.util.List;

/**
 * Created by Adam on 10/22/2015.
 */
public class ItemAdapter extends ArrayAdapter<Item> implements Filterable
{
    public ItemAdapter(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);
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

       Log.d("ItemAdapter", "Hello");
        Item p = getItem(position);

        if (p != null) {
            /*
            Load Views
             */

            ItemCell cell = (ItemCell)v;
            Log.d("getView", cell.toString());
            cell.setLocationFound(p.location);
            cell.setDateFound(p.foundDate);
        }

        return v;
    }

    @Override
    public Filter getFilter() {
        //TODO
        return super.getFilter();
    }
}
