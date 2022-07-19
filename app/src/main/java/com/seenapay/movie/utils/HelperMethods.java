package com.seenapay.movie.utils;

import android.content.Context;
import android.content.res.Configuration;

import java.util.Locale;


public class HelperMethods {



    public static void setLocale(Context context, String lang) {
        Locale locale = new Locale(lang);
        Configuration config = new Configuration(context.getResources().getConfiguration());
        Locale.setDefault(locale);
        config.setLocale(locale);

        context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());

    }
}
