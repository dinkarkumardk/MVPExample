package com.dk.mvpexample.secondscreen.presenter;

import com.dk.mvpexample.secondscreen.model.ISecondScreenDataManager;
import com.dk.mvpexample.secondscreen.model.ResponseCallback;
import com.dk.mvpexample.secondscreen.model.SecondScreenDataManager;
import com.dk.mvpexample.secondscreen.view.SecondScreenView;

/**
 * Created by dinkark on 25/05/18.
 */

public class SecondScreenPresenter implements ISecondScreenPresenter,ResponseCallback {
    SecondScreenView secondScreenView;
    ISecondScreenDataManager secondScreenDataManager;

    public SecondScreenPresenter(SecondScreenView secondScreenView) {
        this.secondScreenView = secondScreenView;
        secondScreenDataManager = new SecondScreenDataManager();
    }

    @Override
    public void loadSecondScreenData() {
        secondScreenView.showProgress();
        try {

            secondScreenDataManager.getDataForSecondScreen(this);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onReceiveData(String data) {
        secondScreenView.hideProgress();
        secondScreenView.showData(data);
    }
}
