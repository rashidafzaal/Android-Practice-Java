package com.example.rashid.lifecyclepractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "Create", Toast.LENGTH_SHORT).show();
    }


    public void nextActivity(View v)
    {
        Intent i = new Intent(MainActivity.this, Second.class);
        startActivity(i);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(MainActivity.this, "Start", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(MainActivity.this, "Re-Start", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this, "Pause", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onResume(){
        super.onResume();
        Toast.makeText(MainActivity.this, "Resume", Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this, "Stop", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this, "Destroyed", Toast.LENGTH_SHORT).show();
    }
}
