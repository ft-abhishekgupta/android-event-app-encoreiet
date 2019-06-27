package com.iet.lucknow.encore;

/**
 * Created by abhishek on 13-08-2016.
 */


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class schedulepageradapter extends FragmentPagerAdapter {

    // Holds tab titles
    private String tabTitles[] = new String[] { "Day 0 - 9th Nov", "Day 1 - 10th Nov", "Day 2 - 11th Nov","Day 3 - 12th Nov" };
    private Context context;

    public schedulepageradapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return 4;
    }

    // Return the correct Fragment based on index
    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new day1();
        } else if(position == 1) {
            return new day2();
        } else if(position == 2) {
            return new day3();
        } else if(position == 3) {
            return new day4();
        }

        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Return the tab title to SlidingTabLayout
        return tabTitles[position];
    }
}