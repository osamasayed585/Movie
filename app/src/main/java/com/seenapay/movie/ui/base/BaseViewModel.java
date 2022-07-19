package com.seenapay.movie.ui.base;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.seenapay.movie.network.Models.responses.BaseResponse;
import com.seenapay.movie.repository.Repository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.disposables.CompositeDisposable;
import lombok.Getter;
import timber.log.Timber;

@Getter
@HiltViewModel
public class BaseViewModel  extends ViewModel {

    @Inject
    public BaseViewModel() {
    }

    @Inject
    Repository repository;
    @Inject
    CompositeDisposable compositeDisposable;
    @Inject
    MutableLiveData<Boolean> onLoadingMutableLiveData;
    @Inject
    MutableLiveData<BaseResponse> onApiErrorMutableLiveData;


    protected boolean isSuccess(BaseResponse response) {
        if (response.isSuccess()) {
            onApiErrorMutableLiveData.setValue(response);
            Timber.e("From new BaseViewModel %s", response.getMessage());
            return false;
        } else
            return true;

    }

    protected void onFailure(Throwable throwable) {
        onApiErrorMutableLiveData.setValue(BaseResponse.builder().message(throwable.toString()).success(false).build());
        Timber.e(throwable);

    }

    public boolean isInternetAvailable(Object object) {
        return true;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }

}
