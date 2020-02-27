package haqiqi_studio.smartpondok.Activities;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

import haqiqi_studio.smartpondok.Activities.MainActivity;
import haqiqi_studio.smartpondok.CustomAdapter;
import haqiqi_studio.smartpondok.Model.DataModel;
import haqiqi_studio.smartpondok.R;

public class ListProgram extends AppCompatActivity {
    ArrayList<DataModel> dataModels;
    ListView listView;
    AdView ads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_program);

        final android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar_list);
        toolbar.setTitle("LIST PROGRAM");
        toolbar.setNavigationIcon(R.drawable.ic_back);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });


        listView=findViewById(R.id.list);

        dataModels= new ArrayList<>();

        dataModels.add(new DataModel("Intips", "Dwipa Amlia", "08:00","September 23, 2008"));
        dataModels.add(new DataModel("Galeri Siang", "Rabiatul Adawiyah", "09:00","February 9, 2009"));
        dataModels.add(new DataModel("Budaya Batur Sasak (BBS)", "Muhir", "02:00","April 27, 2009"));
        dataModels.add(new DataModel("Wajah Pariwisata","Maria Sarabova","04:00","September 15, 2009"));
        dataModels.add(new DataModel("Indie Kancanta", "Aghitya Dani", "07:30","October 26, 2009"));
        dataModels.add(new DataModel("Berugak Kancanta", "Noviandi Saputra", "09:30","May 20, 2010"));
        dataModels.add(new DataModel("Catatan Peristiwa", "Wak Mang", "10:30","December 6, 2010"));
        dataModels.add(new DataModel("Dunia Usaha","Hasnaini","04:00","September 15, 2009"));
        dataModels.add(new DataModel("Musik Aktivitas","Hasnaini","04:00","September 15, 2009"));
        dataModels.add(new DataModel("Warta Lotim","Hasnaini","04:00","September 15, 2009"));

        CustomAdapter adapter= new CustomAdapter(dataModels,getApplicationContext());
        if (listView == null) {
            Log.d("1", "Listview Null");
        }
        else if (adapter == null) {
            Log.d("2", "Adapter Null");
        }

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DataModel dataModel= dataModels.get(position);

                Snackbar.make(view, dataModel.getName() + " ("+dataModel.getVersion_number() + ")" +"\n"+dataModel.getType() ,Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
            }
        });
    }


}