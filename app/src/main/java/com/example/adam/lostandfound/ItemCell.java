package com.example.adam.lostandfound;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Adam on 11/30/2015.
 */
public class ItemCell extends RelativeLayout {

    private TextView locationFound = null;
    private TextView dateFound = null;

    public ItemCell(Context context) {
        super(context);

        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.itemlistcell,this);

        locationFound = (TextView)findViewById(R.id.location);
        dateFound = (TextView)findViewById(R.id.date);
    }

    public ItemCell(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.itemlistcell,this);

        locationFound = (TextView)findViewById(R.id.location);
        dateFound = (TextView)findViewById(R.id.date);
    }

    public ItemCell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.itemlistcell,this);

        locationFound = (TextView)findViewById(R.id.location);
        dateFound = (TextView)findViewById(R.id.date);
    }

    public void setLocationFound(String text)
    {
        locationFound.setText(text);
    }
    public void setDateFound(String text)
    {
        dateFound.setText(text);
    }
}
