package com.dk.mvpexample.firstscreen.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dk.mvpexample.R;
import com.dk.mvpexample.firstscreen.presenter.FirstScreenPresenter;
import com.dk.mvpexample.firstscreen.presenter.IFirstScreenPresenter;
import com.dk.mvpexample.secondscreen.view.SecondScreenFragment;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FirstScreenFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FirstScreenFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstScreenFragment extends Fragment implements FirstScreenView {
    public static final String TAG = FirstScreenFragment.class.getSimpleName();
    private ProgressBar progressBar;
    private TextView textView;
    private Button button;
    private OnFragmentInteractionListener mListener;
    private IFirstScreenPresenter firstScreenPresenter;

    public FirstScreenFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FirstScreenFragment newInstance() {
        FirstScreenFragment fragment = new FirstScreenFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firstScreenPresenter = new FirstScreenPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first_screen, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        progressBar = view.findViewById(R.id.first_screen_progress_bar);
        textView = view.findViewById(R.id.first_screen_tv);
        button = view.findViewById(R.id.first_screen_button);
        button.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                launchSecondScreen();
            }
        });
        firstScreenPresenter.loadFirstScreenData();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.GONE);
        button.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
                textView.setVisibility(View.VISIBLE);
                button.setVisibility(View.VISIBLE);
            }
        });


    }

    @Override
    public void launchSecondScreen() {
        if (mListener != null) {
            mListener.onFragmentChange(SecondScreenFragment.newInstance(), SecondScreenFragment.TAG);
        }
    }

    @Override
    public void showData(final String data) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.setText(data);
            }
        });

    }

    public interface OnFragmentInteractionListener {
        void onFragmentChange(Fragment fragment, String tag);
    }
}
