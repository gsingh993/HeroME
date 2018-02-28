package com.example.gurjitsingh3499.herome.Activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.gurjitsingh3499.herome.Fragments.MainFragment;
import com.example.gurjitsingh3499.herome.Fragments.PickPowerFragment;
import com.example.gurjitsingh3499.herome.Fragments.PowerFragment;
import com.example.gurjitsingh3499.herome.R;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentInteractionListener,
        PickPowerFragment.OnFragmentInteractionListener,
        PowerFragment.OnFragmentInteractionListener
{
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragment_container);

        if(fragment == null){
            fragment = new MainFragment();
            manager.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }
    public void loadPickPowersScreen(){
        PickPowerFragment pickPowerFragment = new PickPowerFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, pickPowerFragment).addToBackStack(null).commit();
    }

    public void loadPowerScreen(String mParam1, String mParam2){
        Log.i(TAG, "loadPowerScreen: "+mParam1);
        Log.i(TAG, "loadPowerScreen: "+mParam2);
        PowerFragment powerFragment = new PowerFragment();
        powerFragment.newInstance(mParam1,mParam2);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, powerFragment).addToBackStack(null).commit();
    }
    @Override
    public void onMainFragmentInteraction(Uri uri) {

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
