package com.onyx.flickrview.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Morph-Deji on 19-Nov-17.
 */

public class FlickrApiResponse {

    @SerializedName("items")
    private Image[] images;

    public Image[] getImages() {
        return images;
    }

    public void setImages(Image[] images) {
        this.images = images;
    }
}
