package com.example.adam.lostandfound;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by muitprogram on 10/20/15.
 */
public class CustomAdapter extends ArrayAdapter<Item> {

    public CustomAdapter(Context context, int resource, Item[] objects) {

        super(context, resource, objects);
    }

    public CustomAdapter(Context context, int resource) {
        super(context, resource);
    }

    public CustomAdapter(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);
    }

    @Override
    public void addAll(Item... items) {
        super.addAll(items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View v = convertView;


        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.row, null);
        }

        //Log.d("CustomAdapter", "Hello");
        Item p = getItem(position);

        if (p != null) {
            /*
            Load Views
             */
            TextView textView = (TextView) v;

            //Log.d("CustomAdapter", p.foundDate);
            textView.setText(Integer.toString(p.itemId));
            /*
            Put data into views
             */

        }

        return v;
    }
}
