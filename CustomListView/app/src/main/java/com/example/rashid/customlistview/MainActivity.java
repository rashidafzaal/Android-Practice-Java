package com.example.rashid.customlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclick_button(View view)
    {
        Intent i = new Intent(MainActivity.this, ListViewActivity.class);
        startActivity(i);
    }
}
