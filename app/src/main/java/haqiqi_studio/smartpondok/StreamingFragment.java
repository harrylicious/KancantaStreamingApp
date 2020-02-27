package haqiqi_studio.smartpondok;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.IOException;
import java.util.concurrent.Delayed;

import haqiqi_studio.smartpondok.Anim.AnimationClasses;


/**
 * A simple {@link Fragment} subclass.
 */
public class StreamingFragment extends Fragment {
    CardView play;
    ImageView imgPlay, icoStatus;
    TextView status, info, shutdown;
    MediaPlayer mediaPlayer = new MediaPlayer();
    ProgressBar progress;
    boolean isPlaying = true;
    String url = "http://scg.streamingmurah.com:8170/listen.pls;&type=mp3";
    AdView ads1;
    int flag = 0;

    public StreamingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_streaming, container, false);
        play = v.findViewById(R.id.streaming_card_play);
        imgPlay = v.findViewById(R.id.streaming_img_play);
        icoStatus = v.findViewById(R.id.streaming_ico_status);
        status = v.findViewById(R.id.streaming_txt_status);
        info = v.findViewById(R.id.streaming_txt_info_track);
        progress = v.findViewById(R.id.progressBarStreaming);
        shutdown = v.findViewById(R.id.shutdown);

        ads1 = v.findViewById(R.id.adStream);

        if (ads1 != null) {
            AdRequest adRequest = new AdRequest.Builder()
                    .addTestDevice("my_real_device_id")
                    .build();
            ads1.loadAd(adRequest);
        }


        info.setSelected(true);
        info.setText(Html.fromHtml(getResources().getString(R.string.status_on)));
        startPlaying();

        shutdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                System.exit(1);
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPlay();
            }
        });

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

    }

    void setPlay() {
        if (flag == 0) {
            flag = 1;
            new AnimationClasses().setAnimationHyperToObject(play, getContext());
            imgPlay.setImageDrawable(getResources().getDrawable(R.drawable.ic_pause));
            icoStatus.setImageDrawable(getResources().getDrawable(R.drawable.ic_disconnect));
            info.setText(Html.fromHtml(getResources().getString(R.string.status_off)));
            status.setText("TERPUTUS");
            stopPlaying();
        } else {
            flag = 0;
            new AnimationClasses().setAnimationHyperToObject(play, getContext());
            imgPlay.setImageDrawable(getResources().getDrawable(R.drawable.ic_play));
            icoStatus.setImageDrawable(getResources().getDrawable(R.drawable.ic_connect));
            info.setText(Html.fromHtml(getResources().getString(R.string.status_on)));
            status.setText("TERSAMBUNG");
            startPlaying();
        }

    }

    void startPlaying() {
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
