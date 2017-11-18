package com.onyx.flickrview.service;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by onyekaanene on 17/11/2017.
 */

public final class FlickrService {
    public static final FlickrService INSTANCE = new FlickrService();
    private static final String URL_BASE = "https://api.flickr.com/services/feeds/photos_public.gne";

    final static String FORMAT_PARAM = "format";

    private static final String format = "json";


    public static URL buildUrl() {
        Uri builtUri = Uri.parse(URL_BASE).buildUpon()
                .appendQueryParameter(FORMAT_PARAM, format)
                .build();
        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }
    public static String getResponse(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}
