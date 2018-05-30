package com.dk.mvpexample.firstscreen.view;

/**
 * Created by dinkark on 25/05/18.
 */

public interface FirstScreenView {
    void showProgress();

    void hideProgress();

    void launchSecondScreen();

    void showData(String data);
}
