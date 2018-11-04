package com.example.rkjc.news_app_2;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils {

    final static String NEWS_BASE_URL = "https://newsapi.org/v1/articles?source=the-next-web&sortBy=latest";
    final static String source = "source";
    final static String SOURCEInfo = "the-next-web";
    final static String SORT_BY = "sortBy";
    final static String LATEST = "latest";
    final static String API = "apiKey";
    final static String API_KEY = "4d204dd39e054ad7af357fef89af7eb9";

    //method to build URLS
    public static URL buildUrl() {
        Uri builtUri = Uri.parse(NEWS_BASE_URL).buildUpon()
                .appendQueryParameter(source, SOURCEInfo)
                .appendQueryParameter(SORT_BY, LATEST)
                .appendQueryParameter(API, API_KEY)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
            Log.d("myTag", "THE NEW FORMED URL " + builtUri);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException{
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {

            InputStream in = urlConnection.getInputStream();
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();

            if(hasInput){
                //Log.d("scan", "Scanner value: " + scanner.next());
                return scanner.next();
            }
            else{
                return null;
            }
        }finally {
            urlConnection.disconnect();
        }
    }
}
