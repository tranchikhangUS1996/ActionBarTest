package com.tranchikhang.actionbartest;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class PizzaDetailActivity extends AppCompatActivity {

    public static final String CAPTION_STRING = "Capption" ;
    public static final String RESID_STRING = "ResID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        String cap = intent.getExtras().getString(CAPTION_STRING,"Pizza");
        int ResId = intent.getExtras().getInt(RESID_STRING);
        ImageView img =(ImageView) findViewById(R.id.pizza_image);
        img.setImageResource(ResId);
        TextView caption =  (TextView) findViewById(R.id.pizza_text);
        caption.setText(cap);
        img.setContentDescription(cap);
    }
}
