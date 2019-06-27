package com.iet.lucknow.encore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class frag_schedule extends Fragment{
    View v;TabLayout tabLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.frag_schedule, container, false);
        getActivity().setTitle("Schedule");



        return v;

    }

    @Override
    public void onResume() {
        super.onResume();
//
//        Toolbar toolbar = (Toolbar) getView().findViewById(R.id.toolbar);
//        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        tabLayout = (TabLayout) getView().findViewById(R.id.tab_layout);
        if (tabLayout.getTabCount() == 0) {
            tabLayout.addTab(tabLayout.newTab().setText("20 March"));
            tabLayout.addTab(tabLayout.newTab().setText("21 March"));
            tabLayout.addTab(tabLayout.newTab().setText("22 March"));
            tabLayout.addTab(tabLayout.newTab().setText("23 March"));
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

            final ViewPager viewPager = (ViewPager) getView().findViewById(R.id.pager);
            final PagerAdapter adapter = new PagerAdapter
                    (getActivity().getSupportFragmentManager(), tabLayout.getTabCount());
            viewPager.setAdapter(adapter);
            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
            tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
    }
}
