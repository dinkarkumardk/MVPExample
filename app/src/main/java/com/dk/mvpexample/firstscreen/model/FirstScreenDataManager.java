package com.dk.mvpexample.firstscreen.model;

/**
 * Created by dinkark on 25/05/18.
 */

public class FirstScreenDataManager implements IFirstScreenDataManager {

    @Override
    public void getDataForFirstScreen(final ResponseCallback responseCallback) {
        final String string = "Data for First view";
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
