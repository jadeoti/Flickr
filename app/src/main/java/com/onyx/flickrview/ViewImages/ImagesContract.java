package com.onyx.flickrview.viewImages;

import android.support.annotation.NonNull;

import com.onyx.flickrview.data.Image;

import java.util.List;

/**
 * Created by onyekaanene on 17/11/2017.
 */

public interface ImagesContract {
    interface View {

        void setProgressIndicator(boolean active);

        void getImages(Image[] images);
//        void getImages(List<Image> images);

    }
    interface ActionsListener {

        void loadImages(boolean forceUpdate);
    }
}
