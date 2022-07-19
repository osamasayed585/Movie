package com.seenapay.movie.utils;


import static com.seenapay.movie.utils.CONSTANTS.SHARED_PREFERENCES.SHARED_PREFERENCES_NAME;
import static com.seenapay.movie.utils.CONSTANTS.SHARED_PREFERENCES.LANGUAGE;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.hilt.android.qualifiers.ApplicationContext;
import timber.log.Timber;


@Singleton
public class PreferencesManager {

    public static final String CARD_ID = "CARD_ID";
    private final SharedPreferences sharedPreferences;

    @Inject
    public PreferencesManager(@ApplicationContext Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
    }

    public String getLanguage() {
        return sharedPreferences.getString(LANGUAGE, "en");
    }

    public void setLanguage(String language) {
        sharedPreferences.edit().putString(LANGUAGE, language).apply();

    }
}