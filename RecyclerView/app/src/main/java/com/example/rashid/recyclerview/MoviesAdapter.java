package com.example.rashid.recyclerview;

import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rashid on 8/29/2017.
 */

public class MoviesAdapter  extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<MyDataClass> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;
        ImageView image;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            image = (ImageView) view.findViewById(R.id.imageview);
        }
    }
    public MoviesAdapter(List<MyDataClass> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MoviesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView); 
    }

    @Override
    public void onBindViewHolder(MoviesAdapter.MyViewHolder holder, int position)
    {
        MyDataClass movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
        holder.image.setImageResource(movie.getImg());

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
