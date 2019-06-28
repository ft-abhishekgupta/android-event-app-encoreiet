package com.iet.lucknow.encore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ScrollView;

/**
 * Created by abhishek on 15-08-2016.
 */
public class events extends Fragment {
    View v;
    ScrollView scc;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.events, container, false);
        setRetainInstance(true);
        getActivity().setTitle("Encore 2K17");
        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        MainActivity.sc = scc.getScrollY();
    }

    @Override
    public void onResume() {
        super.onResume();
        scc = (ScrollView) getView().findViewById(R.id.scrollView2);
        scc.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                scc.scrollTo(0, MainActivity.sc);
                getView().getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.gc();
        Runtime.getRuntime().gc();
    }

    @Override
    public void onStop() {
        super.onStop();
        ImageView i1 = (ImageView) getView().findViewById(R.id.imageView30);
    }
}
