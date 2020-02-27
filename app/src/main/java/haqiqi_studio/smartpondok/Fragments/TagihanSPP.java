package haqiqi_studio.smartpondok.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import haqiqi_studio.smartpondok.Dummy.DummyContent;
import haqiqi_studio.smartpondok.Dummy.DummyContent.DummyItem;
import haqiqi_studio.smartpondok.MetodeBayar;
import haqiqi_studio.smartpondok.R;


public class TagihanSPP extends Fragment {
    Button bayar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_spp, container, false);
        bayar = view.findViewById(R.id.item_bayar);

        bayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MetodeBayar.class));
            }
        });

        return view;
    }

}
