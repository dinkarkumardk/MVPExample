package com.dk.mvpexample.secondscreen.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dk.mvpexample.R;
import com.dk.mvpexample.firstscreen.view.FirstScreenFragment;
import com.dk.mvpexample.secondscreen.presenter.ISecondScreenPresenter;
import com.dk.mvpexample.secondscreen.presenter.SecondScreenPresenter;
import com.dk.mvpexample.thirdscreen.view.ThirdScreenFragment;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SecondScreenFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SecondScreenFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondScreenFragment extends Fragment implements SecondScreenView {
    public static final String TAG = SecondScreenFragment.class.getSimpleName();
    private OnFragmentInteractionListener mListener;
    private ProgressBar progressBar;
    private TextView textView;
    private Button button;
    private ISecondScreenPresenter secondScreenPresenter;
    public SecondScreenFragment() {
        // Required empty public constructor
    }

    public static SecondScreenFragment newInstance() {
        SecondScreenFragment fragment = new SecondScreenFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        secondScreenPresenter = new SecondScreenPresenter(this);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second_screen, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        progressBar = view.findViewById(R.id.second_screen_progress_bar);
        textView = view.findViewById(R.id.second_screen_tv);
        button = view.findViewById(R.id.second_screen_button);
        button.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                launchThirdScreen();
            }
        });
        secondScreenPresenter.loadSecondScreenData();
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
    public void launchThirdScreen() {
        if (mListener != null) {
            mListener.onFragmentChange(ThirdScreenFragment.newInstance(), ThirdScreenFragment.TAG);
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentChange(Fragment fragment, String tag);
    }
}
