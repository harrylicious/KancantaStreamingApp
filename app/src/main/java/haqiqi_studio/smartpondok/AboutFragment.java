package haqiqi_studio.smartpondok;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.transition.Transition;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import haqiqi_studio.smartpondok.Anim.AnimationClasses;
import haqiqi_studio.smartpondok.Classes.Utils;
import haqiqi_studio.smartpondok.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {

    Button shareFB, shareWA;
    Dialog dialog;
    ImageView close, send;
    TextView nama, alamat;

    public AboutFragment() {
        // Required empty public constructor
    }

    public void init() {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dialog.setContentView(R.layout.dialog_msg);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_about, container, false);

        Button sendToEmail = getActivity().findViewById(R.id.dialog_btn_send);
        final MultiAutoCompleteTextView text = v.findViewById(R.id.dialog_txt_msg);

        shareFB = v.findViewById(R.id.shareBtnFB);
        shareWA = v.findViewById(R.id.shareBtnWa);
        send = v.findViewById(R.id.home_img_send);
        close = v.findViewById(R.id.dialog_btn_close);
        nama = v.findViewById(R.id.txtPerusahaan);
        alamat = v.findViewById(R.id.txtPerusahaanAlamat);
        dialog = new Dialog(getContext());

        nama.setSelected(true);
        alamat.setSelected(true);
      try {
          sendToEmail.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  new Utils().composeEmail("kancanta_fm@yahoo.co.id",text.getText().toString());
              }
          });
      }
      catch (Exception e) {
          e.printStackTrace();
      }
        shareFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_TEXT, "Kancanta App Streaming Terbaru : " + "https://play.google.com/store/apps/details?id=haqiqi_studio.smartpondok");
                i.setType("text/plain");
                startActivity(Intent.createChooser(i, "Share to :"));
            }
        });

      shareWA.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent i = new Intent();
              i.setAction(Intent.ACTION_SEND);
              i.putExtra(Intent.EXTRA_TEXT, "Kancanta App Streaming Terbaru : " + "https://play.google.com/store/apps/details?id=haqiqi_studio.smartpondok");
              i.setType("text/plain");
              startActivity(Intent.createChooser(i, "Share to :"));
          }
      });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup();
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                Snackbar.make(v, "Sent!", Snackbar.LENGTH_SHORT).show();
            }
        });

        return v;
    }


    public void showPopup() {
        dialog.setContentView(R.layout.dialog_msg);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.show();
    }

}
