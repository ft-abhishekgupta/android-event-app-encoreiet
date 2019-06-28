package com.iet.lucknow.encore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.iet.lucknow.encore.stab.SlidingTabLayout;

public class schedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        setTitle("Schedule");

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new schedulepageradapter(getSupportFragmentManager(), schedule.this));
        SlidingTabLayout slidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        slidingTabLayout.setViewPager(viewPager);
    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("k", true);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish();
    }
}
