package com.seenapay.movie.ui.movies;

import androidx.lifecycle.MutableLiveData;

import com.seenapay.movie.network.Models.requests.MoviesRequest;
import com.seenapay.movie.network.Models.responses.MovieResponse;
import com.seenapay.movie.ui.base.BaseViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import lombok.Getter;

@Getter
@HiltViewModel
public class MoviesViewModel extends BaseViewModel {

    @Inject
    public MoviesViewModel() {
    }

    @Inject
    MutableLiveData<MovieResponse> moviesResponseMutableLiveData;

    public MutableLiveData<MovieResponse> requestMovies(MoviesRequest moviesRequest) {
        getCompositeDisposable().add(Observable.just(moviesRequest)
                .doOnNext(__ -> getOnLoadingMutableLiveData().setValue(true))
                .observeOn(Schedulers.io())
                .takeWhile(this::isInternetAvailable)
                .flatMap(date -> getRepository().requestMovies(date))
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> getOnLoadingMutableLiveData().setValue(false))
                .takeWhile(this::isSuccess)
                .subscribe(response -> moviesResponseMutableLiveData.setValue(response), this::onFailure));
        return moviesResponseMutableLiveData;
    }


}
