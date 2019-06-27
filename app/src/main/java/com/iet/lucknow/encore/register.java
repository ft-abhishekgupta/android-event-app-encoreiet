package com.iet.lucknow.encore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerButton;

/**
 * Created by abhishek on 24-09-2016.
 */
public class register extends Fragment {
    View v;TextView tv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.register,container,false);
        getActivity().setTitle("Registration -");

        return v;
    }



    @Override
    public void onResume() {
        super.onResume();

        ShimmerButton tv2=(ShimmerButton) getView().findViewById(R.id.button);
        Shimmer shimmer2 = new Shimmer();
        shimmer2.setDuration(2000);
        shimmer2.start(tv2);

        TextView tv= (TextView) getActivity().findViewById(R.id.textView14);
        tv.setText("\nFrom each college one student representative will be selected as College\n" +
                "Ambassador (hereafter, called CA).\n" +
                "\n" +
                "CA should forward this registration link and process details to all the\n" +
                "participants.\n" +
                "\n" +
                "All participants should contact the CA of their college.\n" +
                "\n" +
                "Every participant is to register on our website (www.ietencore.com). This is mandatory\n" +
                "for all participants. Unregistered cases will not be entertained at later\n" +
                "stages.\n" +
                "\n" +
                "This registration link is available till 17th March, 2017.\n" +
                "\n" +
                "Event registration will be done after your contingent arrives at IET Lucknow, you have to come to registration desk, Student Activity Center (SAC) along with your college ID card. The CA should have the list of his/her entire team with their interested event mentioned and registration amount of the event(which is mentioned in next section).\n" +
                "\n" +
                "Combined Registration Amount for All Solo Events: ₹450.\n" +
                "\n" +
                "Each participant should have 2 passport size photographs and college ID at the time of registration.\n" +
                "\n" +
                "All event registrations should be done on first day of the festival.\n" +
                "\n" +
                "No outside student without id card will be entertained and will be handed over to college authorities and fellow college will be disqualified from all sort of participations pending legal actions.\n" +
                "\n" +
                "In case of participation in only Fine Arts Events, the participant must, at least, take part in any four Fine Arts Events to register himself for the fest, to get accomodation, and to participate in the night events.");
    }


}
