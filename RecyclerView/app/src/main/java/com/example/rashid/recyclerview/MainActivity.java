package com.example.rashid.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<MyDataClass> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new MoviesAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
    }
    private void prepareMovieData() {
        MyDataClass movie = new MyDataClass("Mad Max: Fury Road", "Action & Adventure", "2015",R.drawable.batman);
        movieList.add(movie);

        movie = new MyDataClass("Inside Out", "Animation, Kids & Family", "2015",R.drawable.dexter);
        movieList.add(movie);

        movie = new MyDataClass("Star Wars: Episode VII - The Force Awakens", "Action", "2015",R.drawable.jerry);
        movieList.add(movie);

        movie = new MyDataClass("Shaun the Sheep", "Animation", "2015",R.drawable.pikachu);
        movieList.add(movie);

        movie = new MyDataClass("The Martian", "Science Fiction & Fantasy", "2015",R.drawable.superman);
        movieList.add(movie);

        movie = new MyDataClass("Mission: Impossible Rogue Nation", "Action", "2015",R.drawable.tom);
        movieList.add(movie);

        movie = new MyDataClass("Up", "Animation", "2009",R.drawable.tyson);
        movieList.add(movie);

        movie = new MyDataClass("Star Trek", "Science Fiction", "2009",R.drawable.pikachu);
        movieList.add(movie);

        movie = new MyDataClass("The LEGO Movie", "Animation", "2014",R.drawable.batman);
        movieList.add(movie);

        movie = new MyDataClass("Iron Man", "Action & Adventure", "2008",R.drawable.batman);
        movieList.add(movie);

        movie = new MyDataClass("Aliens", "Science Fiction", "1986",R.drawable.dexter);
        movieList.add(movie);

        movie = new MyDataClass("Chicken Run", "Animation", "2000",R.drawable.jerry);
        movieList.add(movie);

        movie = new MyDataClass("Back to the Future", "Science Fiction", "1985",R.drawable.pikachu);
        movieList.add(movie);

        movie = new MyDataClass("Raiders of the Lost Ark", "Action & Adventure", "1981",R.drawable.superman);
        movieList.add(movie);

        movie = new MyDataClass("Goldfinger", "Action & Adventure", "1965",R.drawable.tom);
        movieList.add(movie);

        movie = new MyDataClass("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014",R.drawable.tyson);
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }
}
