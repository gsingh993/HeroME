package com.example.gurjitsingh3499.herome.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.gurjitsingh3499.herome.Activities.MainActivity;
import com.example.gurjitsingh3499.herome.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PickPowerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PickPowerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PickPowerFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    private static final String TAG = "PickPowerFragment";
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Button turtleBtn;
    private Button lightningBtn;
    private Button flightBtn;
    private Button webBtn;
    private Button laserBtn;
    private Button strengthBtn;

    private Button pickPowerBtn;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PickPowerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PickPowerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PickPowerFragment newInstance(String param1, String param2) {
        PickPowerFragment fragment = new PickPowerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_pick_power,container,false);
        turtleBtn = (Button) view.findViewById(R.id.turtleBtn);
        lightningBtn = (Button) view.findViewById(R.id.lightningBtn);
        flightBtn = (Button) view.findViewById(R.id.flightBtn);
        webBtn = (Button) view.findViewById(R.id.webBtn);
        laserBtn = (Button) view.findViewById(R.id.laserBtn);
        strengthBtn = (Button) view.findViewById(R.id.strengthBtn1);
        pickPowerBtn = (Button) view.findViewById(R.id.showBackstoryBtn);

        turtleBtn.setOnClickListener(this);
        lightningBtn.setOnClickListener(this);
        flightBtn.setOnClickListener(this);
        webBtn.setOnClickListener(this);
        laserBtn.setOnClickListener(this);
        strengthBtn.setOnClickListener(this);



        pickPowerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity)getActivity();
                mainActivity.loadPowerScreen(mParam1, mParam2);
            }
        });





        return view;
    }

    @Override
    public void onClick(View view) {


        turtleBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.turtle_power,0,0,0);
        lightningBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lightning,0,0,0);
        flightBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.super_man_crest,0,0,0);
        webBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.spider_web,0,0,0);
        laserBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.laser_vision,0,0,0);
        strengthBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.super_man_crest,0,0,0);



        Button button = (Button)view;
        int leftDrawable = 0;

        if(button == turtleBtn){
            leftDrawable = R.drawable.turtle_power;
            mParam1 = getResources().getStringArray(R.array.turtlePower)[0];
            mParam2 = getResources().getStringArray(R.array.turtlePower)[1];
        }else if(button == lightningBtn){
            leftDrawable = R.drawable.lightning;
            mParam1 = getResources().getStringArray(R.array.lightning)[0];
            mParam2 = getResources().getStringArray(R.array.lightning)[1];
        }else if(button == flightBtn){
            leftDrawable = R.drawable.super_man_crest;
            mParam1 = getResources().getStringArray(R.array.flight)[0];
            mParam2 = getResources().getStringArray(R.array.flight)[1];
        }else if(button == webBtn){
            leftDrawable = R.drawable.spider_web;
            mParam1 = getResources().getStringArray(R.array.webslinging)[0];
            mParam2 = getResources().getStringArray(R.array.webslinging)[1];
        }else if(button == laserBtn){
            leftDrawable = R.drawable.laser_vision;
            mParam1 = getResources().getStringArray(R.array.laservision)[0];
            mParam2 = getResources().getStringArray(R.array.laservision)[1];
        }else if(button == strengthBtn){
            leftDrawable = R.drawable.super_strength;
            mParam1 = getResources().getStringArray(R.array.superstrength)[0];
            mParam2 = getResources().getStringArray(R.array.superstrength)[1];
        }
        button.setCompoundDrawablesWithIntrinsicBounds(leftDrawable,0,R.drawable.item_selected,0);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
