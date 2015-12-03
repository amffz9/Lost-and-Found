package com.example.adam.lostandfound;

import android.util.Log;
import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 12/2/2015.
 */

    public class ItemFilter extends Filter {

    ArrayList<Item> objects = null;
    ArrayList<Item> filteredobjects = null;
    ItemAdapter adapter = null;

        public ItemFilter(ArrayList<Item> objects, ItemAdapter adapter)
        {
            this.objects = (ArrayList<Item>)objects.clone();
            this.adapter = adapter;
        }
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults results = new FilterResults();

            if(constraint == null || constraint.length() == 0)
            {

                //Log.d("NO Constraint","Hello");
                results.values = objects;
                results.count = objects.size();
            }
            else
            {
                List<Item> items = new ArrayList<Item>();

                for (Item i : objects)
                {
                    if (i.location.toLowerCase().startsWith(constraint.toString().toLowerCase()))
                    {
                        items.add(i);


                    }
                }
                results.values = items;
                //Log.d("Constrained","LKJ:LKJ:LKJ:LK" );
                results.count = items.size();
                //Log.e("result size", Integer.toString(results.count));
            }


            Log.d("Values: ", results.values.toString());
            Log.d("Count: ", Integer.toString(results.count));


            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            if(results.count == 0)
            {

                adapter.clear();
                Log.d("Publish Results", "NO Results");
            }
            else
            {

                if (constraint.length() == 0)
                {
                    adapter.notifyDataSetInvalidated();//no valid results
                    adapter.clear();
                    adapter.addAll(objects);
                    return;
                }
               //adapter.notifyDataSetChanged();
                //adapter.clear();
                ArrayList<Item> items = new ArrayList<>();

                Log.e("Results count", Integer.toString(results.count));
                Log.d("Result: ", results.values.toString());

                //??????
               // results.values = objects.subList(0, results.count);
                adapter.clear();


               adapter.addAll((ArrayList<Item>)results.values);
                adapter.notifyDataSetChanged();




               //adapter.notifyDataSetInvalidated();
                //addAll((List<Item>) results.values);


            }

        }
    }

