package com.seenapay.movie.ui.movieDetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.seenapay.movie.R;
import com.seenapay.movie.databinding.ActivityMoviesDetailsBinding;
import com.seenapay.movie.network.Models.beans.Movie;
import com.seenapay.movie.utils.CONSTANTS;
import com.squareup.picasso.Picasso;

import dagger.hilt.android.AndroidEntryPoint;
import timber.log.Timber;

@AndroidEntryPoint
public class MoviesDetailsActivity extends AppCompatActivity {

    private ActivityMoviesDetailsBinding mBinding;
    private Movie mMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMoviesDetailsBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mMovie = getIntent().getParcelableExtra(CONSTANTS.INTENTS.OBJECT);

        if (mMovie.getMultimedia() != null)
            Picasso.get().load(mMovie.getMultimedia().getSrc())
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder)
                    .into(mBinding.imgCover);

        mBinding.txvTitle.setText(mMovie.getTitle());
        mBinding.txvPublishedBy.setText(mMovie.getByline());
        mBinding.txvRating.setText(mMovie.getRating());
        mBinding.txvSummary.setText(mMovie.getSummary());
        mBinding.txvDate.setText(mMovie.getPublicationDate());

        mBinding.imgCover.setOnClickListener(this::onImageClicked);

    }

    private void onImageClicked(View view) {
        Toast.makeText(getApplicationContext(), "test for  do anything", Toast.LENGTH_SHORT).show();
    }
}