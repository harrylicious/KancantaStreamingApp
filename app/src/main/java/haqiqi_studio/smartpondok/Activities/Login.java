package haqiqi_studio.smartpondok.Activities;

import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import haqiqi_studio.smartpondok.CustomFonts.Button_Roboto_Medium;
import haqiqi_studio.smartpondok.CustomFonts.MyTextView_Roboto_Medium;
import haqiqi_studio.smartpondok.CustomFonts.MyTextView_Roboto_Regular;
import haqiqi_studio.smartpondok.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        MyTextView_Roboto_Medium login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        MyTextView_Roboto_Regular kembali = findViewById(R.id.kembali);
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(1);
            }
        });
    }
}
