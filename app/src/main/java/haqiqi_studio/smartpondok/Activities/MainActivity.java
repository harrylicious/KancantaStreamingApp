package haqiqi_studio.smartpondok.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import haqiqi_studio.smartpondok.AboutFragment;
import haqiqi_studio.smartpondok.DaftarBarang;
import haqiqi_studio.smartpondok.Fragments.Chat;
import haqiqi_studio.smartpondok.HomeFragment;
import haqiqi_studio.smartpondok.ProfileWali;
import haqiqi_studio.smartpondok.R;
import haqiqi_studio.smartpondok.TransaksiFragment;
import haqiqi_studio.smartpondok.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    //This is our viewPager
    private ViewPager viewPager;
    CardView makanan;
    ViewGroup viewGroup;


    //Fragments

    HomeFragment homeFragment;
    TransaksiFragment transaksiFragment;
    Chat chatFragment;
    ProfileWali profileFragment;


    MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //Initializing viewPager
        viewPager = findViewById(R.id.viewpager);

        viewGroup = findViewById(R.id.activity_main);

        //Initializing the bottomNavigationView
        //region BottomNavigationView Method
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_home:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.action_notif:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.action_message:
                                viewPager.setCurrentItem(2);
                                break;
                            case R.id.action_profile:
                                viewPager.setCurrentItem(3);
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
        chatFragment = new Chat();
        homeFragment = new HomeFragment();
        transaksiFragment = new TransaksiFragment();
        profileFragment = new ProfileWali();

        adapter.addFragment(homeFragment, "");
        adapter.addFragment(transaksiFragment, "");
        adapter.addFragment(chatFragment, "");
        adapter.addFragment(profileFragment, "");
        viewPager.setAdapter(adapter);
    }
    //endregion


}
