package com.tranchikhang.actionbartest;

import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class order_Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public void onClickDone(View view) {
        Snackbar snackbar = Snackbar.make(findViewById(R.id.myCoordinator),"your order have been updated",Snackbar.LENGTH_SHORT);
        snackbar.setAction("undo",this);
        snackbar.show();
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this,"Undone",Toast.LENGTH_SHORT).show();
    }
}
