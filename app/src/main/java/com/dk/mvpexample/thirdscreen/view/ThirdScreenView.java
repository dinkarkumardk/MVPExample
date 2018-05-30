package com.dk.mvpexample.thirdscreen.view;

import com.dk.mvpexample.thirdscreen.model.DishDetail;

/**
 * Created by dinkark on 25/05/18.
 */

public interface ThirdScreenView {
    void showProgress();

    void hideProgress();

    void launchFirstScreen();

    void showData(DishDetail data);
}
