package com.dk.mvpexample.thirdscreen.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dk.mvpexample.R;
import com.dk.mvpexample.firstscreen.view.FirstScreenFragment;
import com.dk.mvpexample.thirdscreen.model.DishDetail;
import com.dk.mvpexample.thirdscreen.presenter.IThirdScreenPresenter;
import com.dk.mvpexample.thirdscreen.presenter.ThirdScreenPresenter;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ThirdScreenFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ThirdScreenFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThirdScreenFragment extends Fragment implements ThirdScreenView {
    public static final String TAG = ThirdScreenFragment.class.getSimpleName();
    private OnFragmentInteractionListener mListener;
    private ProgressBar progressBar;
    private TextView rating;
    private TextView name;
    private TextView address;
    private TextView tagline;
    private ImageView pic;
    private Button button;
    private LinearLayout LLDishDetails;
    private IThirdScreenPresenter thirdScreenPresenter;

    public ThirdScreenFragment() {
        // Required empty public constructor
    }

    public static ThirdScreenFragment newInstance() {
        ThirdScreenFragment fragment = new ThirdScreenFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        thirdScreenPresenter = new ThirdScreenPresenter(this);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third_screen, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        LLDishDetails = view.findViewById(R.id.ll_dish_detail);
        rating = view.findViewById(R.id.rating);
        name = view.findViewById(R.id.name);
        address = view.findViewById(R.id.address);
        tagline = view.findViewById(R.id.tagline);
        pic = view.findViewById(R.id.pic);
        progressBar = view.findViewById(R.id.third_screen_progress_bar);
        button = view.findViewById(R.id.third_screen_button);
        button.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                launchFirstScreen();
            }
        });
        thirdScreenPresenter.loadThirdScreenData();
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
        LLDishDetails.setVisibility(View.GONE);
        button.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
                LLDishDetails.setVisibility(View.VISIBLE);
                button.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void launchFirstScreen() {
        if (mListener != null) {
            mListener.onFragmentChange(FirstScreenFragment.newInstance(), FirstScreenFragment.TAG);
        }
    }

    @Override
    public void showData(final DishDetail data) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                rating.setText(String.format(getString(R.string.rating_placeholder), data.getRating()));
                name.setText(data.getName());
                address.setText(data.getAddress());
                tagline.setText(data.getTagline());
                Picasso.get().load(data.getPic()).into(pic);
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
