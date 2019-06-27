package com.iet.lucknow.encore;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Posters extends AppCompatActivity {
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posters);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        PagerAdapter adapter = new CustomAdapter(Posters.this);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
//        finish();
//        Intent i=new Intent(this,MainActivity.class);
//        startActivity(i);

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();System.gc();
        Runtime.getRuntime().gc();
    }
}
