package com.iet.lucknow.encore;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by abhishek on 24-09-2016.
 */
public class gallery extends Fragment {
    View v;
    String gallery[][] = alldata.posters;
    int size = gallery.length;
    TextView tv[] = new TextView[size];
    ImageView im[] = new ImageView[size];

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.gallery, container, false);
        getActivity().setTitle("Encore Gallery");
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        Resources res = getResources();
        for (int i = 1; i < size; i++) {
            String b = "tv" + i;
            String c = "im" + i;
            tv[i] = (TextView) getView().findViewById(res.getIdentifier(b, "id", getContext().getPackageName()));
            im[i] = (ImageView) getView().findViewById(res.getIdentifier(c, "id", getContext().getPackageName()));
            tv[i].setText(gallery[i][0]);
            Glide.with(getContext())
                    .load(getResources().getIdentifier(gallery[i][1], "drawable", getActivity().getPackageName()))
                    .crossFade().into(im[i]);
        }
    }
}
