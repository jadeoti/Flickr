package com.onyx.flickrview;

import com.onyx.flickrview.data.Image;
import com.onyx.flickrview.viewimages.ImagesContract;
import com.onyx.flickrview.viewimages.ImagesPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.verify;

/**
 * Created by onyekaanene on 19/11/2017.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(ImagesPresenter.class)
public class ImagesPresenterTest {

    private Image[] IMAGES = new Image[2];
    private Image.ImageUrl[] IMAGE_URLS = new Image.ImageUrl[2];

    @Mock
    private ImagesContract.View mImagesView;
    @Mock
    private ImagesPresenter mImagesPresenter;

    private ImagesPresenter.FetchImageTask mFetchTask;

    @Before
    public void setupImagesPresenter() {
        // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this);

        // Get a reference to the class under test
        mImagesPresenter = new ImagesPresenter(mImagesView);
        IMAGE_URLS[0]= (new Image.ImageUrl("https://farm5.staticflickr.com/4540/26747405149_69887188f3_m.jpg"));
        IMAGE_URLS[1]= (new Image.ImageUrl("https://farm5.staticflickr.com/4552/26747405829_7f5649eb7b_m.jpg"));
        IMAGES[0] = new Image("Accumulation", "Pascal_Bandelier posted a photo", IMAGE_URLS[0]);
        IMAGES[1] = new Image("2017 Secret City Half", "kenshelton400 posted a photo", IMAGE_URLS[1]);

        mFetchTask= PowerMockito.mock(ImagesPresenter.FetchImageTask.class);
    }
    @Test
    public void loadImagesToView() {

        mImagesPresenter.loadImages(true);
//
//
//        verify(mImagesPresenter.FetchImageTask())
//        // Then progress indicator is hidden and notes are shown in UI
        verify(mImagesView).setProgressIndicator(false);
        verify(mImagesView).getImages(IMAGES);
    }

}
