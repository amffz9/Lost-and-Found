package com.example.adam.lostandfound;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Adam on 11/17/2015.
 */
public class CategoryListCell extends RelativeLayout {

    public TextView description = null;
    public TextView count = null;

    public CategoryListCell(Context context) {
        super(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.categorylistcell,this);
        description = (TextView)this.findViewById(R.id.description);
        count = (TextView)this.findViewById(R.id.count);
    }

    public CategoryListCell(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.categorylistcell,this);
        description = (TextView)this.findViewById(R.id.description);
        count = (TextView)this.findViewById(R.id.count);
    }

    public CategoryListCell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.categorylistcell,this);
        description = (TextView)this.findViewById(R.id.description);
        count = (TextView)this.findViewById(R.id.count);
    }
    public  void setDescriptionText(String text)
    {
        description.setText(text);
    }
    public void setCountText(String text)
    {
        count.setText(text);
    }


}
