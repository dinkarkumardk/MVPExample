package com.dk.mvpexample.secondscreen.model;


/**
 * Created by dinkark on 25/05/18.
 */

public class SecondScreenDataManager implements ISecondScreenDataManager {

    @Override
    public void getDataForSecondScreen(final ResponseCallback responseCallback) {
        final String string = "Data for second view";
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
                        responseCallback.onReceiveData(string);
                    }
                }


            };
            t.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
