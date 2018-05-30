package com.dk.mvpexample.thirdscreen.model;


/**
 * Created by dinkark on 25/05/18.
 */

public class MockedThirdScreenDataManager implements IThirdScreenDataManager {

    @Override
    public void getDataForThirdScreen(final ResponseCallback responseCallback) {
        try {
            final Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    } finally {
                        responseCallback.onReceiveData(MockDishDetailProvider.getSampleDishDetail());
                    }
                }


            };
            t.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
