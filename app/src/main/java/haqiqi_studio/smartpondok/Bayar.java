package haqiqi_studio.smartpondok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import haqiqi_studio.smartpondok.Activities.MainActivity;
import haqiqi_studio.smartpondok.CustomFonts.MyTextView_Roboto_Regular;

public class Bayar extends AppCompatActivity{
    private CardView bri, ntb, mastercard;
    public ImageView rightmark1,rightmark2,rightmark3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayar);

        MyTextView_Roboto_Regular kembali = findViewById(R.id.kembali);
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });


    }
}
