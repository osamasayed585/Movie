package com.seenapay.movie.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.seenapay.movie.databinding.RowMovieItemBinding;
import com.seenapay.movie.network.Models.beans.Movie;
import com.seenapay.movie.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyMoviesViewHolder> {

    private List<Movie> mData;
    private OnMoviesClickHandler mClickHandler;

    @Inject
    public MoviesAdapter() {
    }

    public void initItemClickListener(OnMoviesClickHandler clickHandler) {
        mClickHandler = clickHandler;
    }

    @NonNull
    @Override
    public MyMoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_movie_item, parent, false);
        return new MyMoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyMoviesViewHolder holder, int position) {
        Movie movie = mData.get(position);
        holder.bind(movie);

    }

    @Override
    public int getItemCount() {
        if (null == mData) return 0;
        return mData.size();
    }

    public void setData(List<Movie> data) {
        mData = data;
        notifyDataSetChanged();
    }

    public class MyMoviesViewHolder extends RecyclerView.ViewHolder {

        RowMovieItemBinding mBinding;

        public MyMoviesViewHolder(@NonNull View itemView) {
            super(itemView);
            mBinding = RowMovieItemBinding.bind(itemView);
            itemView.setOnClickListener(this::onItemClick);
        }

        public void onItemClick(View view) {
            int adapterPosition = getAdapterPosition();


            Movie movie = mData.get(adapterPosition);
            if (mClickHandler != null)
                mClickHandler.onAboutUsPointItemClick(movie);
        }

        public void bind(Movie movie) {

            if (movie.getMultimedia() != null)
                Picasso.get().load(movie.getMultimedia().getSrc())
                        .placeholder(R.drawable.placeholder)
                        .error(R.drawable.placeholder)
                        .into(mBinding.imgCover);

            mBinding.txvTitle.setText(movie.getTitle());
            mBinding.txvPublished.setText(movie.getByline());
            mBinding.txvPublishedDate.setText(movie.getPublicationDate());
        }
    }

    public interface OnMoviesClickHandler {
        void onAboutUsPointItemClick(Movie movie);
    }

}