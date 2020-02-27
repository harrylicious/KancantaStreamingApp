package haqiqi_studio.smartpondok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

import haqiqi_studio.smartpondok.Activities.PembayaranBRI;
import haqiqi_studio.smartpondok.Activities.PembayaranNTB;

public class MetodeBayar extends AppCompatActivity  implements View.OnClickListener{
    private CardView bri, ntb, mastercard;
    public ImageView rightmark1,rightmark2,rightmark3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metode_bayar);

        bri = (CardView) findViewById(R.id.bri);
        ntb = (CardView) findViewById(R.id.ntb);
        mastercard = (CardView) findViewById(R.id.mastercard);
        rightmark1 = (ImageView) findViewById(R.id.rightmark1);
        rightmark2 = (ImageView) findViewById(R.id.rightmark2);
        rightmark3 = (ImageView) findViewById(R.id.rightmark3);

        bri.setOnClickListener(this);
        ntb.setOnClickListener(this);
        mastercard.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.bri:

                rightmark1.setImageResource(R.drawable.ic_right);
                rightmark2.setImageResource(R.drawable.ic_round);
                rightmark3.setImageResource(R.drawable.ic_round);
                startActivity(new Intent(getApplicationContext(), PembayaranBRI.class));
                break;

            case R.id.ntb:

                rightmark1.setImageResource(R.drawable.ic_round);
                rightmark2.setImageResource(R.drawable.ic_right);
                rightmark3.setImageResource(R.drawable.ic_round);
                startActivity(new Intent(getApplicationContext(), PembayaranNTB.class));
                break;

            case R.id.mastercard:

                rightmark1.setImageResource(R.drawable.ic_round);
                rightmark2.setImageResource(R.drawable.ic_round);
                rightmark3.setImageResource(R.drawable.ic_right);
                break;



        }
    }
}
