package haqiqi_studio.kancantastreamingapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_home, container, false);

        CardView program = v.findViewById(R.id.main_program_card);
        CardView iklan = v.findViewById(R.id.main_iklan_card);
        CardView lagu = v.findViewById(R.id.main_lagu_card);
        CardView aktivitas = v.findViewById(R.id.main_aktivitas_card);

        program.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ListProgram.class));
            }
        });

        iklan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), IklanActivity.class));
            }
        });

        lagu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), LaguActivity.class));
            }
        });

        aktivitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AktivitasActivity.class));
            }
        });
        return v;
    }

}
