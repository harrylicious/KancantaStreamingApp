package haqiqi_studio.smartpondok;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ProfileWali extends Fragment {


    public ProfileWali() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile_wali, container, false);
        // Inflate the layout for this fragment
        return v;
    }
}
