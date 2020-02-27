package haqiqi_studio.smartpondok.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import haqiqi_studio.smartpondok.CustomFonts.EditText_Roboto_Regular;
import haqiqi_studio.smartpondok.CustomFonts.MyTextView_Roboto_Medium;
import haqiqi_studio.smartpondok.CustomFonts.MyTextView_Roboto_Regular;
import haqiqi_studio.smartpondok.MetodeBayar;
import haqiqi_studio.smartpondok.R;

public class BayarLangsung extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayar_langsung);

        MyTextView_Roboto_Medium gunakan_saldo = findViewById(R.id.gunakan);
        MyTextView_Roboto_Regular metode_bayar = findViewById(R.id.bayar_lain);

        metode_bayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MetodeBayar.class));
            }
        });

    }
}
