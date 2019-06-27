package com.iet.lucknow.encore;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by abhishek on 15-08-2016.
 */
public class team extends Fragment implements AdapterView.OnItemClickListener {
    ListView lv;
    static int xx=0;
    static String namepass="",numberpass="";
    String phone[],title[],desc[];



    String team[][]=alldata.team;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.team, container, false);
        getActivity().setTitle("Team");

        lv = (ListView) view.findViewById(R.id.listView3);

        ArrayList<SingleRowData> dataSource = new ArrayList<>();
        for (int i = 0; i < team.length; i++) {
            SingleRowData s = new SingleRowData(getResources().getIdentifier(team[i][3]+"2","drawable",getActivity().getPackageName()), team[i][0],team[i][1],team[i][2]);
            dataSource.add(s);
        }
        CustomAdpteam adapter=new CustomAdpteam(view.getContext(),dataSource);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
        return view;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        namepass=team[position][0];
        numberpass=team[position][2];
        xx=getResources().getIdentifier(team[position][3],"drawable",getActivity().getPackageName());


        calldialog cd=new calldialog();
        if(!numberpass.equals("0"))
            cd.show(getActivity().getFragmentManager(),"My Custom Dialog");
    }


}
