package com.example.flixster.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.flixster.R;
import com.example.flixster.models.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.Viewholder> {

    Context context;
    List<Movie> movies;

    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    // Ususally involves inflating a layout from XML and returning holder
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("Movieadapter", "onCreateViewHolder");
       View movieView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new Viewholder(movieView);
    }
    //Involves populating data into item through holder
    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Log.d("MovieAdapter", "onViewHolder" + position);
        //Get movie at the position
        Movie movie = movies.get(position);
        //Bind movie data into view holder
        holder.bind(movie);
    }
    // Returns total item count in list
    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        TextView tvTitle;
        TextView tvOverview;
        ImageView ivPoster;

        public Viewholder(@NonNull View itemView){
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvOverview = itemView.findViewById(R.id.tvOverview);
            ivPoster = itemView.findViewById(R.id.ivPoster);
        }

        public void bind(Movie movie) {
            tvTitle.setText(movie.getTitle());
            tvOverview.setText(movie.getOverview());

            Glide.with(context).load(movie.getPosterPath()).into(ivPoster);
        }
    }

}
