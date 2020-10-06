package com.tookhelper.tookhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tookhelper.tookcore.TookAnalytics;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TookAnalytics.Event("asdasd", "497FaF0112932", this);


    }
}
