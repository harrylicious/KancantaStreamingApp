package haqiqi_studio.kancantastreamingapp;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import haqiqi_studio.kancantastreamingapp.AboutFragment;
import haqiqi_studio.kancantastreamingapp.Anim.AnimationClasses;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;

    //This is our viewPager
    private ViewPager viewPager;
    CardView program;
    ViewGroup viewGroup;


    //Fragments

    HomeFragment homeFragment;
    StreamingFragment streamingFragment;
    AboutFragment aboutFragment;

    MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //Initializing viewPager
        viewPager = findViewById(R.id.viewpager);
        program = findViewById(R.id.main_program_card);
        viewGroup = findViewById(R.id.activity_main);





        //Initializing the bottomNavigationView
        //region BottomNavigationView Method
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_streaming:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.action_home:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.action_about:
                                viewPager.setCurrentItem(2);
                                break;
                        }
                        return false;
                    }
                });
        //endregion

        //region ViewPager Event
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }


            @Override
            public void onPageSelected(int position) {

                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: " + position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

       /*  //Disable ViewPager Swipe

       viewPager.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return true;
            }
        });

        */

        setupViewPager(viewPager);
        //endregion


    }

    //region ViewPager Method
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        aboutFragment = new AboutFragment();
        homeFragment = new HomeFragment();
        streamingFragment = new StreamingFragment();

        adapter.addFragment(streamingFragment);
        adapter.addFragment(homeFragment);
        adapter.addFragment(aboutFragment);
        viewPager.setAdapter(adapter);
    }
    //endregion


}
