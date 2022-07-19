package com.seenapay.movie.utils;

public class CONSTANTS {

    public static class API {
        public static String BASE_URL = "https://api.nytimes.com/svc/movies/v2/";
    }

    public static class INTENTS {
        public static final String NAME = "name";
        public static final String OBJECT = "object";

        public static final int VERIFY_USER = 1;
    }

    public static class SHARED_PREFERENCES {
        /*

          Shared Preferences Constants

        */

        public static final String SHARED_PREFERENCES_NAME = "movies";
        public static final String LANGUAGE = "language";
    }
}
