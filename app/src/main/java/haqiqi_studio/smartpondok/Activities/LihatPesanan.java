package haqiqi_studio.smartpondok.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import haqiqi_studio.smartpondok.CustomFonts.Button_Roboto_Medium;
import haqiqi_studio.smartpondok.R;

public class LihatPesanan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_pesanan);

        Button_Roboto_Medium bayar = findViewById(R.id.item_bayar);
        bayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), BayarLangsung.class));
            }
        });
    }
}
