package com.iet.lucknow.encore;

/**
 * Created by Abhishek on 09-02-2017.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                day1 tab1 = new day1();
                return tab1;
            case 1:
                day2 tab2 = new day2();
                return tab2;
            case 2:
                day3 tab3 = new day3();
                return tab3;
            case 3:
                day4 tab4 = new day4();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
