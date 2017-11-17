package com.onyx.flickrview.data;

import android.support.annotation.Nullable;
import com.google.gson.annotations.SerializedName;
import com.google.common.base.Objects;


/**
 * Created by onyekaanene on 17/11/2017.
 */

public class Image {
    @Nullable
    @SerializedName("title")
    private final String mTitle;
    @Nullable
    @SerializedName("description")
    private final String mDescription;
    @Nullable
    @SerializedName("media")
    private final String mImageUrl;

    public Image(@Nullable String title, @Nullable String description, @Nullable String imageUrl) {
        mTitle = title;
        mDescription = description;
        mImageUrl = imageUrl;
    }

    @Nullable
    public String getmTitle() {
        return mTitle;
    }

    @Nullable
    public String getmDescription() {
        return mDescription;
    }

    @Nullable
    public String getmImageUrl() {
        return mImageUrl;
    }

    public boolean isEmpty() {
        return (mTitle == null || "".equals(mTitle)) &&
                (mDescription == null || "".equals(mDescription));
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Image image = (Image) object;
        return Objects.equal(mTitle, image.mTitle) &&
                Objects.equal(mDescription, image.mDescription) &&
                Objects.equal(mImageUrl, image.mImageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mTitle, mDescription, mImageUrl);
    }
}
