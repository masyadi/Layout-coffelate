package com.xample.masyadi.coffelate2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MenuDetailActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);

        toolbar = (Toolbar) findViewById(R.id.toolbar_detail);
        toolbar.setTitle("Detail");
        setSupportActionBar(toolbar);

    }
}
