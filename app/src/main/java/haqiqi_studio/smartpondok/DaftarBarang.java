package haqiqi_studio.smartpondok;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import haqiqi_studio.smartpondok.Activities.LihatPesanan;

public class DaftarBarang extends AppCompatActivity {

    CardView card1, card2, card3, card4, makanan, pakaian, alat_tulis, obatan;
    ImageView img1, img2, img3, img4;
    TextView txt1, txt2, txt3, txt4;
    TextView harga1, harga2, harga3, harga4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_barang);

        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);
        makanan = findViewById(R.id.makanan);
        pakaian = findViewById(R.id.pakaian);
        alat_tulis = findViewById(R.id.alat_tulis);
        obatan = findViewById(R.id.obatan);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt1);
        txt3 = findViewById(R.id.txt1);
        txt4 = findViewById(R.id.txt1);

        harga1 = findViewById(R.id.harga1);
        harga2 = findViewById(R.id.harga2);
        harga3 = findViewById(R.id.harga3);
        harga4 = findViewById(R.id.harga4);

        makanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makanan();
            }
        });


        pakaian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pakaian();
            }
        });

        alat_tulis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alat_tulis();
            }
        });

        obatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obatan();
            }
        });

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LihatPesanan.class));
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LihatPesanan.class));
            }
        });
    }

    void makanan() {
        img1.setImageDrawable(getResources().getDrawable(R.drawable.makanan));
        img2.setImageDrawable(getResources().getDrawable(R.drawable.makanan));
        img3.setImageDrawable(getResources().getDrawable(R.drawable.makanan));
        img4.setImageDrawable(getResources().getDrawable(R.drawable.makanan));

        txt1.setText("Kentang goreng");
        txt2.setText("Kentang goreng Lkp");
        txt3.setText("Kentang goreng mini");
        txt4.setText("Kentg goreng spesial");

        harga1.setText("Rp 8.000");
        harga2.setText("Rp 12.000");
        harga3.setText("Rp 6.000");
        harga4.setText("Rp 15.000");
    }

    void pakaian() {
        txt1.setText("Busana Muslim");
        txt1.invalidate();
        txt2.setText("Busana Santri");
        txt2.invalidate();
        txt3.setText("Busana Maulid");
        txt3.invalidate();
        txt4.setText("Busana Pondok");
        txt4.invalidate();

        img1.setImageDrawable(getResources().getDrawable(R.drawable.pakaian));
        img2.setImageDrawable(getResources().getDrawable(R.drawable.pakaian));
        img3.setImageDrawable(getResources().getDrawable(R.drawable.pakaian));
        img4.setImageDrawable(getResources().getDrawable(R.drawable.pakaian));

        harga1.setText("Rp 60.000");
        harga2.setText("Rp 65.000");
        harga3.setText("Rp 70.000");
        harga4.setText("Rp 75.000");
    }

    void alat_tulis() {
        img1.setImageDrawable(getResources().getDrawable(R.drawable.alat_tulis));
        img2.setImageDrawable(getResources().getDrawable(R.drawable.alat_tulis));
        img3.setImageDrawable(getResources().getDrawable(R.drawable.alat_tulis));
        img4.setImageDrawable(getResources().getDrawable(R.drawable.alat_tulis));

        for (int i = 0; i < 4; i++) {
            txt1.setText("Buku Polpen");
            txt2.setText("Buku santri");
            txt3.setText("Polpen");
            txt4.setText("Spidol");
        }


        harga1.setText("Rp 6.000");
        harga2.setText("Rp 7.000");
        harga3.setText("Rp 3.000");
        harga4.setText("Rp 4.000");
    }

    void obatan() {
        img1.setImageDrawable(getResources().getDrawable(R.drawable.obatan));
        img2.setImageDrawable(getResources().getDrawable(R.drawable.obatan));
        img3.setImageDrawable(getResources().getDrawable(R.drawable.obatan));
        img4.setImageDrawable(getResources().getDrawable(R.drawable.obatan));

        txt1.setText("Paramex");
        txt2.setText("Panadol");
        txt3.setText("Hufagrip");
        txt4.setText("Paracetamol");

        harga1.setText("Rp 6.000");
        harga2.setText("Rp 7.000");
        harga3.setText("Rp 3.000");
        harga4.setText("Rp 4.000");
    }
}
