package com.example.adam.lostandfound;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ItemView extends Activity {

    public Item item = null;
    public TextView text = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);

        Intent intent = getIntent();//Recieve data from ListActivity

        if (intent.hasExtra("Item"))
        {
            item = (Item)intent.getSerializableExtra("Item");
        }
        else
        {
            item = new Item(null);
        }

        text = (TextView)findViewById(R.id.textView);

        text.setText(item.toString());
    }
    public void claimed(View view)
    {
        Button button = (Button)view;
        button.setText("Claimed");//example
        /*TODO
        Set Item to claimed
        Possibly set to unclaim
         */
        Log.d("Claimed", "I was Claimed!");
    }
}
