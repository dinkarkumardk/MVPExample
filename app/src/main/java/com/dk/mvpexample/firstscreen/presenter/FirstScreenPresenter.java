package com.dk.mvpexample.firstscreen.presenter;

import com.dk.mvpexample.firstscreen.model.FirstScreenDataManager;
import com.dk.mvpexample.firstscreen.model.IFirstScreenDataManager;
import com.dk.mvpexample.firstscreen.model.ResponseCallback;
import com.dk.mvpexample.firstscreen.view.FirstScreenView;

/**
 * Created by dinkark on 25/05/18.
 */

public class FirstScreenPresenter implements IFirstScreenPresenter,ResponseCallback {
    FirstScreenView firstScreenView;
    IFirstScreenDataManager firstScreenDataManager;

    public FirstScreenPresenter(FirstScreenView firstScreenView) {
        this.firstScreenView = firstScreenView;
        firstScreenDataManager = new FirstScreenDataManager();
    }

    @Override
    public void loadFirstScreenData() {
        firstScreenView.showProgress();
        try {

            firstScreenDataManager.getDataForFirstScreen(this);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onReceiveData(String data) {
        firstScreenView.hideProgress();
        firstScreenView.showData(data);
    }
}
