package com.seenapay.movie.ui.movieDetails;

import androidx.core.content.res.ResourcesCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.seenapay.movie.R;
import com.seenapay.movie.databinding.ActivityMoviesDetailsBinding;
import com.seenapay.movie.network.Models.beans.Movie;
import com.seenapay.movie.ui.base.BaseActivity;
import com.seenapay.movie.utils.CONSTANTS;
import com.squareup.picasso.Picasso;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MoviesDetailsActivity extends BaseActivity {

    private ActivityMoviesDetailsBinding mBinding;
    private Movie mMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMoviesDetailsBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        ReceiptAndPresentationData();

    }

    private void ReceiptAndPresentationData() {
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

        mBinding.mainLayout.setVisibility(View.GONE);
        mBinding.photoFullScreen.setVisibility(View.VISIBLE);
        mBinding.actionBar.setVisibility(View.VISIBLE);

        mBinding.txvTitleScreen.setText(mMovie.getTitle());


        if (mMovie.getMultimedia() != null)
            Picasso.get().load(mMovie.getMultimedia().getSrc())
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder)
                    .into(mBinding.imgFullScreen);

        mBinding.btnBack.setOnClickListener(this::onBackFromImage
        );

    }

    private void onBackFromImage(View view) {
        mBinding.photoFullScreen.setVisibility(View.GONE);
        mBinding.actionBar.setVisibility(View.GONE);
        mBinding.mainLayout.setVisibility(View.VISIBLE);

    }
}