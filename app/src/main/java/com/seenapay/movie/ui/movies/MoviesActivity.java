package com.seenapay.movie.ui.movies;

import android.content.Intent;
import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;

import com.seenapay.movie.R;
import com.seenapay.movie.adapters.MoviesAdapter;
import com.seenapay.movie.databinding.ActivityMoviesBinding;
import com.seenapay.movie.network.Models.beans.Movie;
import com.seenapay.movie.network.Models.requests.MoviesRequest;
import com.seenapay.movie.network.Models.responses.MovieResponse;
import com.seenapay.movie.ui.base.BaseActivity;
import com.seenapay.movie.ui.movieDetails.MoviesDetailsActivity;
import com.seenapay.movie.utils.CONSTANTS;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import timber.log.Timber;

@AndroidEntryPoint
public class MoviesActivity extends BaseActivity {

    private ActivityMoviesBinding mBinding;
    private MoviesViewModel mViewModel;

    @Inject
    MoviesAdapter mMoviesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMoviesBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        // setup view model
        mViewModel = new ViewModelProvider(this).get(MoviesViewModel.class);

        mViewModel.getOnApiErrorMutableLiveData().observe(this, this::onApiError);
        mViewModel.getOnLoadingMutableLiveData().observe(this, this::onLoading);
        mViewModel.getMoviesResponseMutableLiveData().observe(this, this::onMoviesResponse);

        // setup RecyclerView
        mBinding.movies.setAdapter(mMoviesAdapter);
        mMoviesAdapter.initItemClickListener(this::OnMovieClicked);
    }

    private void OnMovieClicked(Movie movie) {

        Intent intent = new Intent(this, MoviesDetailsActivity.class);
        intent.putExtra(CONSTANTS.INTENTS.OBJECT, movie);
        startActivity(intent);
    }

    private void onMoviesResponse(MovieResponse movieResponse) {
        Timber.d("-----  Response");
        mMoviesAdapter.setData(movieResponse.getResults());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.requestMovies(setRequest());
    }

    private MoviesRequest setRequest() {
        return new MoviesRequest("godfather",getResources().getString(R.string.api_key));
    }
}