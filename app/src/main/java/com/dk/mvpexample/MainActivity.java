package com.dk.mvpexample;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dk.mvpexample.firstscreen.view.FirstScreenFragment;
import com.dk.mvpexample.secondscreen.view.SecondScreenFragment;
import com.dk.mvpexample.thirdscreen.view.ThirdScreenFragment;

public class MainActivity extends AppCompatActivity implements FirstScreenFragment.OnFragmentInteractionListener, SecondScreenFragment.OnFragmentInteractionListener ,ThirdScreenFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(FirstScreenFragment.newInstance(), FirstScreenFragment.TAG);
    }


    @Override
    public void onFragmentChange(Fragment fragment, String tag) {
        replaceFragment(fragment, tag);
    }

    void replaceFragment(Fragment fragment, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment, tag)
                .commit();
    }
}
