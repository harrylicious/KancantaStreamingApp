package haqiqi_studio.smartpondok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import haqiqi_studio.smartpondok.Activities.Keranjang;
import haqiqi_studio.smartpondok.Activities.PembayaranSPP;
import haqiqi_studio.smartpondok.Activities.ProfilSantri;


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

        CardView spp = v.findViewById(R.id.spp);
        CardView profil1 = v.findViewById(R.id.profil1);
        CardView transfer = v.findViewById(R.id.transfer);
        CardView makanan = v.findViewById(R.id.makanan);

        ImageView cart = v.findViewById(R.id.home_cart);




        spp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), PembayaranSPP.class));
            }
        });

        profil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), ProfilSantri.class));
            }
        });

        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), Bayar.class));
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), Keranjang.class));
            }
        });

        makanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), DaftarBarang.class));
            }
        });

        return v;
    }

}
