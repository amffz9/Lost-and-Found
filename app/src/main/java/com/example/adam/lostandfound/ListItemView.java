package com.example.adam.lostandfound;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class ListItemView extends ListActivity {

    public ItemCollection items;
    public ItemAdapter itemAdapter;

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        /*
        TODO

        Do something with cliking on an Item
         */

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();//Recieve data from ListActivity

        if (intent.hasExtra("Items"))
        {

            items = (ItemCollection)intent.getSerializableExtra("Items");
        }
        else
        {
            items = new ItemCollection(null);
        }
        itemAdapter = new ItemAdapter(this, R.layout.row, items.items);
        setListAdapter(itemAdapter);
        itemAdapter.notifyDataSetChanged();
    }
}
