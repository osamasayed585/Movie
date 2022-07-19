package com.seenapay.movie.di;

import androidx.lifecycle.MutableLiveData;


import com.seenapay.movie.network.Models.responses.BaseResponse;
import com.seenapay.movie.network.Models.responses.MovieResponse;
import com.seenapay.movie.network.services.ApiServices;
import com.seenapay.movie.utils.CONSTANTS;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.scopes.ViewModelScoped;
import io.reactivex.disposables.CompositeDisposable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;
import okhttp3.logging.HttpLoggingInterceptor;


@Module
@InstallIn(ViewModelComponent.class)
public class NetworkModule {

    @Provides
    @ViewModelScoped
    public ApiServices provideApiInterface(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(CONSTANTS.API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
                .create(ApiServices.class);
    }


    @Provides
    @ViewModelScoped
    public OkHttpClient okHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }


    @Provides
    @ViewModelScoped
    public HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    @Provides
    public CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    public MutableLiveData<Boolean> provideBooleanMutableLiveData() {
        return new MutableLiveData<>();
    }

    @Provides
    public MutableLiveData<String> provideStringMutableLiveData() {
        return new MutableLiveData<>();
    }

    @Provides
    public MutableLiveData<BaseResponse> provideBaseResponseMutableLiveData() {
        return new MutableLiveData<>();
    }

    @Provides
    public MutableLiveData<MovieResponse> provideMovieResponseMutableLiveData() {
        return new MutableLiveData<>();
    }
}
