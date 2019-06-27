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
public class accomodation extends Fragment {
    View v;TextView tv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.accomodation,container,false);
        getActivity().setTitle("Accommodation Policy -");

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        TextView tv= (TextView) getActivity().findViewById(R.id.textView14);
        tv.setText("\nCollege Ambassador should inform the ENCORE Hospitality Team\n" +
                "about the details of accommodation required at least 3 days before the\n" +
                "festival starts.\n" +
                "\n" +
                "All participants should contact their College Ambassador (hereafter,\n" +
                "called CA) of their college.\n" +
                "\n" +
                "When your contingent arrives at IET Lucknow, you have to come to\n" +
                "registration desk, Student Activity Center (SAC) along with your\n" +
                "college ID card. The CC should have the list of his/her entire team\n" +
                "with their interested event mentioned. Your place of stay will be allotted\n" +
                "along with your accommodation details. Accommodation would be\n" +
                "strictly on shared basis.\n" +
                "\n" +
                "Each student will be given accommodation only after it has been\n" +
                "confirmed by the Hospitality Members through the CA of the respective\n" +
                "college.\n" +
                "\n" +
                "Students can avail accommodation facilities from 4th March\n" +
                "2017 at 11:00 am to 8th March, 2017 at 09:00 am.\n" +
                "\n" +
                "CHARGES -\n" +
                "\n" +
                "Online Charges for accommodation are Rs. 500/- per person (without\n" +
                "breakfast, lunch and dinner) out of which Rs. 100/ - is refundable. The charges will be the same irrespective\n" +
                "of duration of stay up to a maximum of 4 days i.e. from 11:00 AM, 20th March\n" +
                "to 09:00 AM, 24th March, 2016.\n" +
                "\n" +
                "Fooding will be arranged in hostel mess with Rs. 50/- per plate for dinner\n" +
                "and lunch, and Rs. 30/- per plate for breakfast.\n" +
                "\u200B\n" +
                "Total fee for 4 days (including food) = 400 + (130 x 4) + 100 = Rs. 1020/-\n" +
                "Rs. 100/- Refundable\n" +
                "\n" +
                "In exceptional circumstances the refund amount may be forfeited\n" +
                "subject to any misbehavior or damage to any accessories.\n" +
                "\n" +
                "Disciplinary action will be taken accordingly and respective college\n" +
                "authorities will be notified.\n" +
                "\n" +
                "The payment will be done in cash only and CA must ensure receipt of\n" +
                "the amount paid.");
    }
}
