package com.dk.mvpexample.thirdscreen.presenter;

import com.dk.mvpexample.thirdscreen.model.DishDetail;
import com.dk.mvpexample.thirdscreen.model.IThirdScreenDataManager;
import com.dk.mvpexample.thirdscreen.model.MockedThirdScreenDataManager;
import com.dk.mvpexample.thirdscreen.model.ResponseCallback;
import com.dk.mvpexample.thirdscreen.model.RealThirdScreenDataManager;
import com.dk.mvpexample.thirdscreen.view.ThirdScreenView;

/**
 * Created by dinkark on 25/05/18.
 */

public class ThirdScreenPresenter implements IThirdScreenPresenter, ResponseCallback {
    private ThirdScreenView thirdScreenView;
    private IThirdScreenDataManager thirdScreenDataManager;

    public ThirdScreenPresenter(ThirdScreenView thirdScreenView) {
        this.thirdScreenView = thirdScreenView;
        thirdScreenDataManager = new MockedThirdScreenDataManager();
    }

    @Override
    public void loadThirdScreenData() {
        thirdScreenView.showProgress();
        try {

            thirdScreenDataManager.getDataForThirdScreen(this);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onReceiveData(DishDetail data) {
        thirdScreenView.hideProgress();
        thirdScreenView.showData(data);
    }
}
