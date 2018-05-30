package com.dk.mvpexample.secondscreen.view;

/**
 * Created by dinkark on 25/05/18.
 */

public interface SecondScreenView {
    void showProgress();

    void hideProgress();

    void launchThirdScreen();

    void showData(String data);
}
