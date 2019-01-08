package com.example.viewpagerandfragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class NextActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {


    private static final int NUM_PAGES = 3;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    Menu myActionBarMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        initUi();
    }

    private void initUi() {
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setCurrentItem(1);
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());
        mPager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

    @Override
    public void onPageSelected(int position) {
//        Toast.makeText(NextActivity.this, "PageSelected = "+ position, Toast.LENGTH_SHORT).show();
        if (position == 0) {
            setMyMenu("Workouts", R.menu.menu_home_left);
        }
        if (position == 1) {
            setMyMenu("- - -", R.menu.menu_home_center);
        }
        if (position == 2) {
            setMyMenu("GPS Exercise", R.menu.menu_home_right);
        }
    }

    private void setMyMenu(String title, int menu)
    {
        setTitle(title);
        myActionBarMenu.clear();
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(menu, myActionBarMenu);

    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new LeftFragment();
                case 1:
                    return new CenterFragment();
                case 2:
                    return new RightFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        setTitle("- - -");
        this.myActionBarMenu = menu;
        getMenuInflater().inflate(R.menu.menu_home_center, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}
