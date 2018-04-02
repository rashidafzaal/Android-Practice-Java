package com.example.rashid.customlistview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/**
 * Created by rashid on 7/31/2017.
 */

public class CustomAdapter extends ArrayAdapter<MyDataClass>
{
    Context c;
    int layoutFile;
    MyDataClass [] data;
    private ArrayList<MyDataClass> arraylist;

    public CustomAdapter(Context c, int layoutFile, MyDataClass[] data) {
        super(c, layoutFile, data);
        this.c = c;
        this.layoutFile = layoutFile;
        this.data = data;
        this.arraylist = new ArrayList<MyDataClass>(Arrays.asList(data));
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View row,row2;
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) c).getLayoutInflater();
            row = inflater.inflate(R.layout.list_row, parent, false);
        } else {
            row = (View) convertView;
        }

        if (data[position] == null) {
            LayoutInflater inflater = ((Activity) c).getLayoutInflater();
            row2 = inflater.inflate(R.layout.list_row, parent, false);
            return row2;
        } else {
            TextView txt = (TextView) row.findViewById(R.id.text1);
            txt.setText(data[position].getText1());

            TextView txt2 = (TextView) row.findViewById(R.id.text2);
            txt2.setText(data[position].getText2());

            ImageView img = (ImageView) row.findViewById(R.id.img1);
            img.setImageResource(data[position].getImg());

            return row;
        }

    }
    //Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());

        Arrays.fill(data, null);
        if (charText.length() == 0) {
            data = arraylist.toArray(new MyDataClass[arraylist.size()]);
        } else {
            int index = 0;
            for (MyDataClass wp : arraylist) {
                if (wp.getText1().toLowerCase(Locale.getDefault()).contains(charText) ||
                        wp.getText2().toLowerCase(Locale.getDefault()).contains(charText)) {
                    data[index] = wp;
                    index++;
                }

            }
        }
        notifyDataSetChanged();
    }
}