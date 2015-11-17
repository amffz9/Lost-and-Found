package com.example.adam.lostandfound;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by muitprogram on 10/20/15.
 */
public class CustomAdapter extends ArrayAdapter<ItemCollection> {

    public CustomAdapter(Context context, int resource, List<ItemCollection> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {//dequereusablecell......


        View v = convertView;


        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = (CategoryListCell)vi.inflate(R.layout.cell, null);
        }

        //Log.d("CustomAdapter", "Hello");
        ItemCollection p = getItem(position);

        if (p != null) {
            /*
            Load Views
             */
            CategoryListCell cell = (CategoryListCell) v;

            //Log.d("CustomAdapter", p.foundDate);
            cell.setDescriptionText(p.item_type);
            cell.setCountText(Integer.toString(p.items.size()));

            /*
            Put data into views
             */

        }

        return v;
    }
}
