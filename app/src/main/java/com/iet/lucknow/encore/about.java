package com.iet.lucknow.encore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

/**
 * Created by abhishek on 15-08-2016.
 */
public class about extends Fragment {
    View v;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.aboutus,container,false);
        getActivity().setTitle("About ");


        Shimmer shimmer = new Shimmer();
        shimmer.setDuration(2000);
        shimmer.setDirection(Shimmer.ANIMATION_DIRECTION_LTR);

        ShimmerTextView tv= (ShimmerTextView) v.findViewById(R.id.textView7);
        ShimmerTextView tv2= (ShimmerTextView) v.findViewById(R.id.textView8);
        ShimmerTextView tv3= (ShimmerTextView) v.findViewById(R.id.textView11);
        shimmer.start(tv);
        shimmer.start(tv2);
        shimmer.start(tv3);
        return v;
    }
}