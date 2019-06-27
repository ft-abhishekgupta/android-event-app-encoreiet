package com.iet.lucknow.encore;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by abhishek on 15-08-2016.
 */
public class day2 extends Fragment {
    ListView lv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.day1, container, false);

        lv = (ListView) view.findViewById(R.id.listView);

        String day[][]=alldata.day1;


        ArrayList<SingleRowData> dataSource = new ArrayList<>();
        for (int i = 0; i < day.length; i++) {
            SingleRowData s = new SingleRowData(getResources().getIdentifier(day[i][3],"drawable",getActivity().getPackageName()), day[i][0], day[i][1],day[i][2]);
            dataSource.add(s);
        }
        CustomAdp adapter=new CustomAdp(view.getContext(),dataSource);
        lv.setAdapter(adapter);

        return view;
    }

}
//class SingleRowData {
//    int id;
//    String title;
//    String desc;
//    String time;
//
//
//    SingleRowData(int i,String t,String d,String ti) {
//        id=i;
//        title=t;
//        desc=d;
//        time=ti;
//    }

