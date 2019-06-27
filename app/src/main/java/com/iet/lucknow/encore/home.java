package com.iet.lucknow.encore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerButton;

import pl.droidsonroids.gif.GifTextView;

/**
 * Created by abhishek on 15-08-2016.
 */
public class home extends Fragment {
    View v;
    ShimmerButton tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv11,tv12,tv13,tv14;
    Shimmer shimmer2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.home,container,false);
//        v=inflater.inflate(R.layout.home,container,false);
        getActivity().setTitle("Home");

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        GifTextView g= (GifTextView) getActivity().findViewById(R.id.mologo);
        g.setBackgroundResource(R.drawable.b);
        g.setVisibility(View.VISIBLE);


        tv3=(ShimmerButton) getView().findViewById(R.id.button3);
        tv4=(ShimmerButton) getView().findViewById(R.id.button4);
        tv5=(ShimmerButton) getView().findViewById(R.id.button5);
        tv6=(ShimmerButton) getView().findViewById(R.id.button6);
        tv7=(ShimmerButton) getView().findViewById(R.id.button7);
        tv8=(ShimmerButton) getView().findViewById(R.id.button8);
        tv9=(ShimmerButton) getView().findViewById(R.id.button9);
        tv11=(ShimmerButton) getView().findViewById(R.id.button11);
        tv12=(ShimmerButton) getView().findViewById(R.id.button12);
        tv13=(ShimmerButton) getView().findViewById(R.id.button13);
        tv14=(ShimmerButton) getView().findViewById(R.id.button14);
        shimmer2 = new Shimmer();
        shimmer2.setDuration(2000);

        shimmer2.setStartDelay(500);

        shimmer2.start(tv3);
        shimmer2.start(tv4);
        shimmer2.start(tv5);
        shimmer2.start(tv6);
        shimmer2.start(tv7);
        shimmer2.start(tv8);
        shimmer2.start(tv9);
        shimmer2.start(tv11);
        shimmer2.start(tv12);
        shimmer2.start(tv13);
        shimmer2.start(tv14);



    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.gc();
        Runtime.getRuntime().gc();
        GifTextView g= (GifTextView) getActivity().findViewById(R.id.mologo);
        if(g!=null){
        g.setBackgroundResource(0);
        g.setVisibility(View.INVISIBLE);}
    }

}
