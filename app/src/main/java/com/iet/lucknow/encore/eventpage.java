package com.iet.lucknow.encore;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class eventpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_eventpage);

        Intent i=getIntent();
        String title=i.getStringExtra("t");
        String desc=i.getStringExtra("d");
        int im=i.getIntExtra("i",R.drawable.qwe);

        ImageView image= (ImageView) findViewById(R.id.toolbarImage);
        image.setImageResource(im);
        TextView t= (TextView) findViewById(R.id.textView42);
        CollapsingToolbarLayout c= (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
        c.setTitle(title);
        t.setText(desc);
    }
}
