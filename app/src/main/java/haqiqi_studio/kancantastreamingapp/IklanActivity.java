package haqiqi_studio.kancantastreamingapp;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import haqiqi_studio.kancantastreamingapp.Classes.DownloadFromURL;
import haqiqi_studio.kancantastreamingapp.Classes.Utils;

public class IklanActivity extends AppCompatActivity {
    Dialog dialog;
    Button pesan, download, no2, email1, email2;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iklan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_iklan);
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setTitle("IKLAN");
        setSupportActionBar(toolbar);

        dialog = new Dialog(this);
        final ImageView close = findViewById(R.id.dialog_kontak_btn_close);
        pesan = findViewById(R.id.iklan_btn_pesan);
        download = findViewById(R.id.iklan_btn_download);
        Button no1 = findViewById(R.id.dialog_btn_no1);
        no2 = findViewById(R.id.dialog_btn_no2);
        email1 = findViewById(R.id.dialog_btn_email1);
        email2 = findViewById(R.id.dialog_btn_email2);
        scrollView = findViewById(R.id.scrollIklan);





        try {
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
            });

            pesan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new Utils().sendToWA("+6287864806896");
                }
            });

            download.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new DownloadFromURL().execute("www.google.com");

                }
            });

            no1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new Utils().sendToWA("+6287864806896");
                }
            });

            no2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new Utils().sendToWA("+6285934896663");
                }
            });


            FloatingActionButton fab =  findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.setContentView(R.layout.dialog_kontak);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                    dialog.show();
                }
            });
        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }
    }




}
