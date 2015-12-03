package com.example.adam.lostandfound;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListItemView extends ListActivity {

    public ItemCollection items;
    public ItemAdapter itemAdapter;

    private ListView lv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = getListView();
        Intent intent = getIntent();//Recieve data from ListActivity

        if (intent.hasExtra("Items"))
        {

            items = (ItemCollection)intent.getSerializableExtra("Items");
        }
        else
        {
            items = new ItemCollection(null);
        }
        Log.d("count", Integer.toString(items.items.size()));
        itemAdapter = new ItemAdapter(this, R.layout.itemlistcell, items.items);
        setListAdapter(itemAdapter);
        itemAdapter.notifyDataSetChanged();

       EditText search = (EditText) findViewById(R.id.editText);

        //Make a Text Listener

        TextWatcher listener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.e("Text Changed", "OnTextChanged()");
                itemAdapter.getFilter().filter(s);


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        lv.setTextFilterEnabled(true);
        search.addTextChangedListener(listener);


    }
}
