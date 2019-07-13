package com.c4f.demo_vnpt;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.c4f.demo_vnpt.adapter.ViewPagerAdapter;
import com.c4f.demo_vnpt.fragment.ProfileFragment;
import com.c4f.demo_vnpt.fragment.RepositoryFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    public static final int REPO_TAB_INDEX = 0;
    public static final int PROFILE_TAB_INDEX = 1;

    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Github Trending");

        viewPager = findViewById(R.id.viewpager);
        bottomNavigationView = findViewById(R.id.bottom_navigation);



        List<Fragment> mFragmentList = new ArrayList<>();
        mFragmentList.add(RepositoryFragment.newInstance("Repository"));
        mFragmentList.add(ProfileFragment.newInstance("Profile"));


        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), mFragmentList);
        viewPager.setAdapter(adapter);

        // Bắt sự kiện khi user swipe qua lại các fragment của ViewPager
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setActiveTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.tab_repo:
                        viewPager.setCurrentItem(REPO_TAB_INDEX);
                        break;
                    case R.id.tab_profile:
                        viewPager.setCurrentItem(PROFILE_TAB_INDEX);
                        break;
                }
                return true;
            }
        });
    }

    private void setActiveTab(int pos) {
        switch (pos) {
            case REPO_TAB_INDEX:
                bottomNavigationView.setSelectedItemId(R.id.tab_repo);
                return;
            case PROFILE_TAB_INDEX:
                bottomNavigationView.setSelectedItemId(R.id.tab_profile);
                return;
        }
    }


}
