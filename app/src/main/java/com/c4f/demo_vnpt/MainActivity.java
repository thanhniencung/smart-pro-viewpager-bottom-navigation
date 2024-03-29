package com.c4f.demo_vnpt;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.c4f.demo_vnpt.adapter.ViewPagerAdapter;
import com.c4f.demo_vnpt.contant.AppConstant;
import com.c4f.demo_vnpt.fragment.ProfileFragment;
import com.c4f.demo_vnpt.fragment.RepositoryFragment;
import com.c4f.demo_vnpt.helper.SharedPreferenceHelper;
import com.c4f.demo_vnpt.model.BaseResponse;
import com.c4f.demo_vnpt.model.req.ReqLogin;
import com.c4f.demo_vnpt.model.res.ResLogin;
import com.c4f.demo_vnpt.model.res.ResProduct;
import com.c4f.demo_vnpt.network.GithubService;
import com.c4f.demo_vnpt.network.RestCallback;
import com.c4f.demo_vnpt.network.model.RestError;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class MainActivity extends AppCompatActivity  {
    public static final int REPO_TAB_INDEX = 0;
    public static final int PROFILE_TAB_INDEX = 1;

    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;

    public void demoCallSignInApi() {
        GithubService.get().signIn(ReqLogin.createRequestBody())
                .enqueue(new RestCallback<BaseResponse<ResLogin>>() {
                    @Override
                    public void onSuccess(BaseResponse<ResLogin> data) {
                        data.getData();

                        SharedPreferenceHelper.setSharedPreferenceString(
                                MainActivity.this,
                                AppConstant.Key.TOKEN, data.getData().getToken());

                        String a = "";
                    }

                    @Override
                    public void onFailure(RestError restError) {
                        String a = "";
                    }
                });

    }

    public void getProductList() {
        GithubService.get().getProductList()
                .enqueue(new RestCallback<BaseResponse<List<ResProduct>>>() {
                    @Override
                    public void onSuccess(BaseResponse<List<ResProduct>> data) {
                        String a = "";
                    }

                    @Override
                    public void onFailure(RestError restError) {
                        String b = "";
                    }
                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Github Trending");

        viewPager = findViewById(R.id.viewpager);
        bottomNavigationView = findViewById(R.id.bottom_navigation);


        getProductList();



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
