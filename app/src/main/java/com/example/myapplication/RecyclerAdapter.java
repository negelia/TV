package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>  {
    private final LayoutInflater inflater;
    private final List<Model> movies;

    RecyclerAdapter(Context context, List<Model> movies) {
        this.movies = movies;
        this.inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Model state = movies.get(position);
        holder.imgView.setImageResource(state.getImg());
        holder.nameMovie.setText(state.getName());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imgView;
        final TextView nameMovie;
        ViewHolder(View view){
            super(view);
            imgView = itemView.findViewById(R.id.img);
            nameMovie = itemView.findViewById(R.id.txt);
        }
    }
}
