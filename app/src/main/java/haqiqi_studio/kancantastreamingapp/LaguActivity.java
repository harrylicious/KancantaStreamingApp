package haqiqi_studio.kancantastreamingapp;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import haqiqi_studio.kancantastreamingapp.Anim.AnimationClasses;
import haqiqi_studio.kancantastreamingapp.Classes.*;

import java.io.IOException;
import java.util.ArrayList;

import haqiqi_studio.kancantastreamingapp.Model.DataModel;

public class LaguActivity extends AppCompatActivity {
    ArrayList<DataModel> dataModels;
    ListView listView;
    MediaPlayer mediaPlayer;
    ProgressBar progress;
    FloatingActionButton play;
    boolean isPlaying = true;
    int flag = 0;
    String url = "http://sci.streamingmurah.com:8321/;stream.mp3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lagu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_lagu);
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setTitle("LAGU");
        setSupportActionBar(toolbar);

        progress = findViewById(R.id.progressBarLagu);
        play = findViewById(R.id.fabPlay);
        mediaPlayer = new MediaPlayer();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               setPlay();
            }
        });

        listView=findViewById(R.id.listLagu);

        dataModels= new ArrayList<>();

        dataModels.add(new DataModel("Suara Kancanta", "Martini Shufyna", "08:00","September 23, 2008"));
        dataModels.add(new DataModel("Suara Kancanta (Sasak)", "Martini Shufyna", "09:00","February 9, 2009"));
        dataModels.add(new DataModel("Jinggle Kancanta", "Muhir, S.Pd", "02:00","April 27, 2009"));
        dataModels.add(new DataModel("Suara Kancanta","RISA D.U.A","04:00","September 15, 2009"));
        haqiqi_studio.kancantastreamingapp.CustomAdapterListSong adapter= new haqiqi_studio.kancantastreamingapp.CustomAdapterListSong(dataModels,getApplicationContext());
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

    void setPlay() {
        if (flag == 0) {
            flag = 1;
            play.setImageDrawable(getResources().getDrawable(R.drawable.ic_pause));
            stopPlaying();
        } else {
            flag = 0;
            play.setImageDrawable(getResources().getDrawable(R.drawable.ic_play));
            startPlaying();
        }

    }

    void startPlaying() {
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(url);
        } catch (IllegalArgumentException e1) {
            e1.printStackTrace();
        } catch (SecurityException e1) {
            e1.printStackTrace();
        } catch (IllegalStateException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            mediaPlayer.prepareAsync();
            progress.setVisibility(View.VISIBLE);
        } catch (IllegalStateException e1) {
            e1.printStackTrace();
        }
        mediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(MediaPlayer mp, int percent) {

            }
        });
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mediaPlayer.start();
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mediaPlayer.isPlaying()) {
            //
        }
    }


    private void stopPlaying() {
        if (mediaPlayer.isPlaying()) {
            isPlaying = false;
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

}
