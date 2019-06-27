package com.iet.lucknow.encore;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


static int sc=0;
    int flag=1;
    static int ev=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setVisibility(View.INVISIBLE);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, new home()).commit();

        Intent i=getIntent();
        Boolean b=i.getBooleanExtra("k",true);
        if(b)
            fragmentManager.beginTransaction().replace(R.id.content_frame, new home()).commit();
        else
            fragmentManager.beginTransaction().replace(R.id.content_frame, new events()).commit();




    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if(flag==0){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.slide_outb, R.anim.fadeout);
            ft.replace(R.id.content_frame, new home(), "fragment");
            ft.commit();
            sc=0;
            flag=1;


        }
        else if(flag==2){
            flag=0;
            //FragmentManager fragmentManager = getSupportFragmentManager();
            //fragmentManager.beginTransaction().replace(R.id.content_frame, new events()).commit();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
//            ft.setCustomAnimations(R.anim.slide_outb, R.anim.fadeout);
            ft.replace(R.id.content_frame, new events(), "fragment");
            ft.commit();
        }
        else
        {finish();System.exit(0);}
            //this.finishAffinity();
            //super.onBackPressed();

        }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Runtime.getRuntime().gc();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_exit) {
            {finish();System.exit(0);}
            return true;
        }
        else if (id == R.id.action_rate) {
            Toast.makeText(this, "Thankyou", Toast.LENGTH_SHORT).show();
            Uri uri = Uri.parse("market://details?id=" + getPackageName());
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
            goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                    Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            try {
                startActivity(goToMarket);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
            }
            return true;
        }else if(id==R.id.action_share){
            final String appPackageName = getApplicationContext().getPackageName();
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "App for Encore Fest , IET Lucknow at: https://play.google.com/store/apps/details?id=" + appPackageName);
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        }else if(id==R.id.action_acc){
            macco(null);
        }else if(id==R.id.action_lic){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.fadein, R.anim.slide_in);
            ft.replace(R.id.content_frame, new license(), "fragment");
            ft.commit();
            flag=0;
        }


        return super.onOptionsItemSelected(item);
    }
    FragmentManager fragmentManager = getSupportFragmentManager();
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.home) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new home()).commit();
            sc=0;
        }else if (id == R.id.events) {
            mevent(null);
        }
        else if (id == R.id.schedule) {
            mschedule(null);
        } else if (id == R.id.notification) {
            mnotification(null);
        } else if (id == R.id.website) {
            mwebsite(null);

        }else if (id == R.id.posters) {
            mposters(null);
        }else if (id == R.id.regi) {
            mreg(null);
        }else if (id == R.id.regibw) {
            String url="http://www.ietencore.com/bandwarsregistration";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
        else if (id == R.id.youtube) {
            myoutube(null);

        }else if (id == R.id.facebook) {
            mfacebook(null);
        }
        else if (id == R.id.sponsors) {
            msponsors(null);
        } else if (id == R.id.team) {
            mteam(null);
        }
        else if (id == R.id.mail) {
            mmail(null);
        }
        else if (id == R.id.aboutus) {
            maboutus(null);
        } else if (id == R.id.contactus) {
            mcontactus(null);
        }else if (id == R.id.map)
        {   mmap(null);
        }
        else if (id == R.id.rule)
        {   String url="http://media.wix.com/ugd/755879_9d5cdb2709214ee0a4957ca937430731.pdf";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




    public static String FACEBOOK_URL = "https://www.facebook.com/EncoreIET/";
    public static String FACEBOOK_PAGE_ID = "EncoreIET";

    //method to get the right URL to use in the intent
    public String getFacebookPageURL(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) { //newer versions of fb app
                return "fb://facewebmodal/f?href=" + FACEBOOK_URL;
            } else { //older versions of fb app
                return "fb://page/" + FACEBOOK_PAGE_ID;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return FACEBOOK_URL; //normal web url
        }
    }

    public void mevent(View view) {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.fadein, R.anim.slide_in);
        ft.replace(R.id.content_frame, new events(), "fragment");
        ft.commit();
        flag=0;
    }
    public void mposters(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.fadein, R.anim.slide_in);
        ft.replace(R.id.content_frame, new gallery(), "fragment");
        ft.commit();
        flag=0;
//        Intent intent = new Intent(this, Posters.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        startActivity(intent);
//        finish();
    }
    public void mschedule(View view) {
//        finish();
//        Intent i=new Intent(this,schedule.class);
//        startActivity(i);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.fadein, R.anim.slide_in);
        ft.replace(R.id.content_frame, new frag_schedule(), "fragment");
        ft.commit();
        flag=0;
    }public void mnotification(View view) {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.fadein, R.anim.slide_in);
        ft.replace(R.id.content_frame, new Notif(), "fragment");
        ft.commit();
        flag=0;

    }public void mwebsite(View view) {
        String url=getString(R.string.website);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

    }public void msponsors(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.fadein, R.anim.slide_in);
        ft.replace(R.id.content_frame, new sponsors(), "fragment");
        ft.commit();
        flag=0;
        Toast.makeText(this, "Don\'t touch the Sponsors ;)", Toast.LENGTH_SHORT).show();

    }
    public void mteam(View view) {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.fadein, R.anim.slide_in);
        ft.replace(R.id.content_frame, new team(), "fragment");
        ft.commit();
        flag=0;

    }
    public void maboutus(View view) {
        //fragmentManager.beginTransaction().replace(R.id.content_frame, new about()).commit();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.fadein, R.anim.slide_in);
        ft.replace(R.id.content_frame, new about(), "fragment");
        ft.commit();
        flag=0;
    }
    public void mcontactus(View view) {
        //fragmentManager.beginTransaction().replace(R.id.content_frame, new contact()).commit();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.fadein, R.anim.slide_in);
        ft.replace(R.id.content_frame, new contact(), "fragment");
        ft.commit();
        flag=0;
    }
    public void mdeveloper(View view) {
        //fragmentManager.beginTransaction().replace(R.id.content_frame, new developer()).commit();
        //transition with animation
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.fadein, R.anim.slide_in);
        ft.replace(R.id.content_frame, new developer(), "fragment");
        // Start the animated transition.
        ft.commit();
        flag=0;

    }

    public void mcultural(View view) {
        //fragmentManager.beginTransaction().replace(R.id.content_frame, new culturalevents(),"event").commit();

        boolean b=false;
        switch(view.getId()){
            case R.id.imageView30:ev=1;b=true;break;
            case R.id.imageView39:ev=2;b=true;break;
            case R.id.imageView31:ev=3;b=true;break;
            case R.id.imageView40:ev=4;b=true;break;
            case R.id.imageView32:ev=5;b=true;break;
            case R.id.imageView33:ev=6;b=true;break;
            case R.id.imageView34:ev=7;b=true;break;
            case R.id.imageView35:ev=8;b=true;break;
            case R.id.imageView37:ev=9;b=true;break;
            case R.id.imageView38:ev=10;b=true;break;
            case R.id.imageView36:ev=11;b=true;break;
            case R.id.imageView41:ev=12;b=true;break;
            case R.id.imageView42:ev=13;b=true;break;
            case R.id.imageView43:ev=14;b=true;break;
            case R.id.imageView44:ev=15;b=true;break;
            case R.id.imageView45:ev=16;b=true;break;
            case R.id.imageView46:ev=17;b=true;break;
            case R.id.imageView47:ev=18;b=true;break;
        }
        if(b){
            ScrollView scc= (ScrollView) findViewById(R.id.scrollView2);
            sc=scc.getScrollY();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
            ft.replace(R.id.content_frame, new culturalevents(), "fragment");
            ft.commit();
            flag=2;
        }
    }

    public void mfacebook(View view) {
        Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
        String facebookUrl = getFacebookPageURL(this);
        facebookIntent.setData(Uri.parse(facebookUrl));
        startActivity(facebookIntent);
    }
    public void myoutube(View view){
        String url=getString(R.string.youtube);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
    public void mmap(View v){
        String uri = String.format(Locale.ENGLISH, "geo:%f,%f", 26.914285, 80.942500);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);
    }
    public void mmail(View v){

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", "encoreietlucknow@gmail.com", null));
        startActivity(Intent.createChooser(emailIntent, null));
    }


    public void mhos1(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:+919412852890"));
        startActivity(intent);

    }
    public void mhos2(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:+917071042327"));
        startActivity(intent);

    }

    public void mregister(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.fadein, R.anim.slide_in);
        ft.replace(R.id.content_frame, new register(), "fragment");
        ft.commit();
        flag=0;
    }

    public void macco(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.fadein, R.anim.slide_in);
        ft.replace(R.id.content_frame, new accomodation(), "fragment");
        ft.commit();
        flag=0;
    }
    public void mprize(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.fadein, R.anim.slide_in);
        ft.replace(R.id.content_frame, new prize(), "fragment");
        ft.commit();
        flag=0;
    }

    public void mreg(View view) {
        String url="http://www.ietencore.com/registration";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
