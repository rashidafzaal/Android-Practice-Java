package com.example.rashid.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

public class ListViewActivity extends AppCompatActivity {

    MyDataClass[] array;
    CustomAdapter adapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        EditText ed1 = (EditText) findViewById(R.id.edit1);

        //populate objects
        MyDataClass c1 = new MyDataClass("I am Row1 Text", "I ha been done successfully with the great covergae", R.drawable.pic);
        MyDataClass c2 = new MyDataClass("Place Sometime", "It has been done successfully with the great covergae", R.drawable.pic);
        MyDataClass c3 = new MyDataClass("I am Row3 Text", "It has been done successfully with the great covergae", R.drawable.pic);
        MyDataClass c4 = new MyDataClass("I am Row4 Text", "It has been done successfully with the great covergae", R.drawable.pic);
        MyDataClass c5 = new MyDataClass("I am Row5 Text", "It has been done successfully with the great covergae", R.drawable.pic);
        MyDataClass c6 = new MyDataClass("I am Row6 Text", "It has been done successfully with the great covergae", R.drawable.pic);
        MyDataClass c7 = new MyDataClass("I am Row7 Text", "It has been done successfully with the great covergae", R.drawable.pic);

        //populate array and set adapter
        array = new MyDataClass[] {c1,c2,c3,c4,c5,c6,c7};
        adapter = new CustomAdapter(this,R.layout.list_row,array);
        lv = (ListView) findViewById(R.id.list1);
        lv.setAdapter(adapter);

        //Search Functionality
        ed1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.filter(String.valueOf(s));
            }
            @Override
            public void afterTextChanged(Editable s) {


            }
        });
    }

}
