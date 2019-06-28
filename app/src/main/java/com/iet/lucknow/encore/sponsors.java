package com.iet.lucknow.encore;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tyrantgit.explosionfield.ExplosionField;

/**
 * Created by abhishek on 15-08-2016.
 */
public class sponsors extends Fragment {
    View v;
    static ExplosionField mExplosionField;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.sponsors, container, false);
        getActivity().setTitle("Sponsors");
        addListener(v.findViewById(R.id.root));
        mExplosionField = ExplosionField.attach2Window(getActivity());
        return v;
    }

    void addListener(View root) {
        if (root instanceof ViewGroup) {
            ViewGroup parent = (ViewGroup) root;
            for (int i = 0; i < parent.getChildCount(); i++) {
                addListener(parent.getChildAt(i));
            }
        } else {
            root.setClickable(true);
            root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    mExplosionField.explode(v);
                    CountDownTimer c = new CountDownTimer(1500, 500) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                        }

                        @Override
                        public void onFinish() {
                            v.setAlpha(1);
                            v.setScaleX(1);
                            v.setScaleY(1);
                            if (getView() == v)
                                addListener(getView().findViewById(R.id.root));
                        }
                    }.start();
                }
            });
        }
    }
}
