package com.iet.lucknow.encore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by abhishek on 24-09-2016.
 */
public class prize extends Fragment {
    View v;TextView tv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.prize,container,false);
        getActivity().setTitle("Prizes -");

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        TextView tv= (TextView) getActivity().findViewById(R.id.textView14);
        tv.setText("" +
                "DRAMATICS\n" +
                "• Nukkad: \n  10000/-(1st ) 5000/-(2nd )\n" +
                "• Skit: \n  4000/-(1st ) 2000/-(2nd )\n" +
                "• MIME: \n  3000/-(1st )\n" +
                "• Main Play: \n  5000/-( st ) 2000/-(2nd )\n" +
                "\nCHOREO\n" +
                "• Allegrato: \n  10000/-(1st ) 5000/-(2nd )\n" +
                "• Solo Dance: \n  1500/-(1st ) 500/-(2nd )\n" +
                "• Two to Tango: \n  3000/-(1st ) 1500/-(2nd )\n" +
                "\nSWARANJALI\n" +
                "• Sur Sangram: \n  1500/-(1st ) 700/-(2nd ) 300/-(3rd )\n" +
                "• Duets: \n  3000/-(1st ) 1500/-(2nd ) 600/-(3rd )\n" +
                "\nBAND WARS AND WESTERN MUSIC\n" +
                "• Band Wars: \n  25000/-(1st) 10000/-(2nd)\n" +
                "• Western Music: \n  1000/-(1st ) 600/-(2nd ) 400/-(3rd )\n" +
                "\nVOGUE\n" +
                "• Mr. & Ms. Ethnic: \n  8000/-\n" +
                "• Mr. & Ms. Western: \n  8000/-\n" +
                "• Mr. & Ms. Indo-Western: \n  8000/-\n" +
                "• Mr. & Ms. Vogue: \n  10000/-\n" +
                "\nLITERARY\n" +
                "• Parliamentary Debate(English): \n  3000/-(1st ) 1500/-(2nd )\n" +
                "• Creative writing: \n  1000/-(1st ) 500/-(2nd )\n" +
                "• Poetry Slam: \n  1500/-(1st ) 700/-(2nd)\n" +
                "\nFINE ARTS\n" +
                "• Modern Painting: \n  1500/-(1st ) 700/-(2nd ) 300/-(3rd )\n" +
                "• Tattoo Making: \n  700/-(1st ) 400/-(2nd ) 200/-(3rd )\n" +
                "• Dress Making: \n  1500/-(1st ) 700/-(2nd ) 300/-(3rd )\n" +
                "• Craft Making: \n  1000/-(1st ) 500/-(2nd ) 200/-(3rd )\n" +
                "• Street Painting: \n  1000/-(1st ) 500/-(2nd ) 200/-(3rd )\n" +
                "• Face Painting: \n  700/-(1st ) 400/-(2nd ) 200/-(3rd )\n" +
                "• B/W Sketching: \n  1000/-(1st ) 500/-(2nd ) 200/-(3rd ) \n" +
                "• T-Shirt Painting: \n  700/-(1st ) 400/-(2nd ) 200/-(3rd )\n" +
                "• Spray Painting: \n  500/-(1st ) 300/-(2nd ) 200/-(3rd )\n" +
                "\nMANAGEMANT EVENTS\n" +
                "• Ad Mad: \n  1500/-(1st ) 1200/-(2nd ) 800/-(3rd )\n" +
                "• Logo Logic: \n  1500/-(1st ) 1200/-(2nd ) 800/-(3rd )\n" +
                "• Marketing Star: \n  1500/-(1st ) 1200/-(2nd ) 800/-(3rd )\n" +
                "• Business Quiz: \n  1500/-(1st ) 1200/-(2nd ) 800/-(3rd ) ");
    }
}
