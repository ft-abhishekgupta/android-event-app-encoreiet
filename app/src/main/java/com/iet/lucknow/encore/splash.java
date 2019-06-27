package com.iet.lucknow.encore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by abhishek on 15-08-2016.
 */
public class splash extends Activity{

    Animation fadein,move;
    ImageView i1,i2;
int flag=0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splashscreen);


        i2= (ImageView) findViewById(R.id.imageView14);

        fadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
        move = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);


        i2.startAnimation(fadein);

        int secondsDelayed = 5;
        new Handler().postDelayed(new Runnable() {
            public void run() {
//                startActivity(new Intent(splash.this, MainActivity.class));
//                finish();
                finish();


                if(flag==0){
                    Intent intent = new Intent(splash.this, MainActivity.class);
                startActivity(intent);}

            }
        }, secondsDelayed * 1000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        flag=1;
    }

    @Override
    protected void onResume() {
        super.onResume();flag=0;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.gc();
        Runtime.getRuntime().gc();
    }
}
