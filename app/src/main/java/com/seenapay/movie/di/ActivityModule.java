package com.seenapay.movie.di;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.PagerSnapHelper;


import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.qualifiers.ActivityContext;

@Module
@InstallIn(ActivityComponent.class)
public class ActivityModule {

    @Provides
    public AlertDialog providerAlertDialog(@ActivityContext Context context) {
        return new AlertDialog.Builder(context).create();
    }
}
