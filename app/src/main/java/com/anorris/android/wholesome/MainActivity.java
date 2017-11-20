package com.anorris.android.wholesome;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends FragmentActivity {

    private int currentPosition = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = (ViewPager)findViewById(R.id.view_pager);
        pager.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));
        pager.setCurrentItem(currentPosition);

    }


    private class MainPagerAdapter extends FragmentPagerAdapter{

        public MainPagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position){
            switch (position){
                case 0: return PastGoalsFragment.newInstance("PastGoalsInstance, Instance 1");
                case 1: return GoalFragment.newInstance("GoalInstance, Instance 1");
                case 2: return EventsFragment.newInstance("EventsInstance, Instance 1");
                default: return GoalFragment.newInstance("GoalFragment, Instance 2");
            }
        }

        @Override
        public int getCount(){
            return 3;
        }
    }
}
