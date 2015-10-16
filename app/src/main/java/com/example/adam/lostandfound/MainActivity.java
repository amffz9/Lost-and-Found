package com.example.adam.lostandfound;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends ListActivity {

    ArrayList<String> listItems = new ArrayList<>();
    ArrayAdapter<String> adapter;

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

            InputStream in = null;
            try {
                in = new URL(params[0]).openStream();
                data = new Scanner(in).useDelimiter("\\A").next();
                return data;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }

        @Override
        protected void onPostExecute(String s) {
            Items items = null;
            if(data == null)
            {
                return;
            }
            JSONArray data = null;
            try {
                data = new JSONArray(this.data);
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
            items = new Items(data);
            super.onPostExecute(s);

            for(int i = 0; i < items.length(); i++)
            {
                listItems.add(items.items.get(i).toString());
            }

            adapter.notifyDataSetChanged();

        }
    }

    /*
    Activity Functions
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new ArrayAdapter<String>(this,R.layout.row, listItems);


        setListAdapter(adapter);




        //Change url on the executing network to what is needed
        new Network().execute("http://brettbrusda.me/api/item.php");
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        listItems.add(Integer.toString(position));
        /*
        This is were I need to change views
         */
        adapter.notifyDataSetChanged();

    }
}
