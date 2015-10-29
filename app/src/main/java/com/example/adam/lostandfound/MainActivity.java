package com.example.adam.lostandfound;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends ListActivity {

    ArrayList<ItemCollection> listItems = new ArrayList<>();


    CustomAdapter adapter;

    public MainActivity self = null;//Singleton


    /*
    constructor
     */
    public MainActivity(){
        self = this;
    }

    /*
    Inner Classes
     */
    private class Network extends AsyncTask<String,Integer,String> {

        private String data = null;

        @Override
        protected String doInBackground(String... params) {

            InputStream in;
            try {

                in = new URL(params[0]).openStream();

                data = new Scanner(in).useDelimiter("\\A").next();
                return android.text.Html.fromHtml(data).toString();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }

        @Override
        protected void onPostExecute(String s) {

            if(s == null)
            {
                return;
            } else {
                Log.d("JSON", s);
            }
            JSONObject response = null;
            JSONArray data = null;
            try {
                response = new JSONObject(s);
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
            Log.d("response",response.optString("status"));
            if (response.optString("status").equalsIgnoreCase("ok")) {
                Log.d("Network", "Data Recieved");
                data = response.optJSONArray("data");
            }
            else
            {
                Log.d("Network", "Data NOT Recieved");
            }
            if (data != null) {
                for(int i = 0; i < data.length(); i++)
                {
                    listItems.add(new ItemCollection(data.optJSONObject(i)));
                }

            }


            /*for(int i = 0; i < items.length(); i++)
            {
                //listItems.add((items.items.get(i)));

            }*/
            adapter.notifyDataSetChanged();
            super.onPostExecute(s);

        }
    }

    /*
    Activity Functions
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Intent intent = getIntent();
        if (intent.hasExtra("Item"))
        {
            item = (ItemCollection)intent.getSerializableExtra("Item");
        }
        else
        {
            item = new ItemCollection(null);
        }*/



        adapter = new CustomAdapter(this, R.layout.row, listItems);


        setListAdapter(adapter);

        //Change url on the executing network to what is needed
        new Network().execute("http://goose.col.missouri.edu/unions/api/item");
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);


        Intent intent = new Intent(MainActivity.this,ListItemView.class);
        intent.putExtra("Items", (ItemCollection)adapter.getItem(position));//Store data for next Activity
        startActivity(intent);
        //Log.d("onClick", (adapter.getItem(position).toString()));
        /*
        This is were I need to change views
         */
        adapter.notifyDataSetChanged();

    }
}
