package haqiqi_studio.smartpondok.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import haqiqi_studio.smartpondok.AboutFragment;
import haqiqi_studio.smartpondok.Fragments.TagihanSPP;
import haqiqi_studio.smartpondok.Fragments.TagihanSPPMendatang;
import haqiqi_studio.smartpondok.Fragments.TagihanSPPTerbayar;
import haqiqi_studio.smartpondok.HomeFragment;
import haqiqi_studio.smartpondok.ProfileWali;
import haqiqi_studio.smartpondok.R;
import haqiqi_studio.smartpondok.TransaksiFragment;
import haqiqi_studio.smartpondok.ViewPagerAdapter;
import haqiqi_studio.smartpondok.ui.main.SectionsPagerAdapter;

public class PembayaranSPP extends AppCompatActivity {

    TagihanSPP tagihanSPP;
    TagihanSPPMendatang tagihanSPPMendatang;
    TagihanSPPTerbayar tagihanSPPTerbayar;
    ViewPager viewPager;
    TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran_spp);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        viewPager = findViewById(R.id.view_pager);
        setupViewPager(viewPager);
        tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });


    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        tagihanSPP = new TagihanSPP();
        tagihanSPPMendatang = new TagihanSPPMendatang();
        tagihanSPPTerbayar = new TagihanSPPTerbayar();

        adapter.addFragment(tagihanSPP,"TAGIHAN");
        adapter.addFragment(tagihanSPPMendatang,"MENDATANG");
        adapter.addFragment(tagihanSPPTerbayar,"SUDAH BAYAR");

        viewPager.setAdapter(adapter);
    }
}