package com.iet.lucknow.encore;

import android.content.Intent;
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
public class culturalevents extends Fragment implements AdapterView.OnItemClickListener {
    ListView lv;
    String title[], desc[];
    int[] imgId;
    String data[][];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.eventdesc, container, false);

        lv = (ListView) view.findViewById(R.id.listView4);

        switch (MainActivity.ev) {
        case 1:
            data = alldata.informals;
            getActivity().setTitle("Informals");
            break;
        case 2:
            data = alldata.swaranjali;
            getActivity().setTitle("Swaranjali");
            break;
        case 3:
            data = alldata.management;
            getActivity().setTitle("Management");
            break;
        case 4:
            data = alldata.literary;
            getActivity().setTitle("Literary");
            break;
        case 5:
            data = alldata.finearts;
            getActivity().setTitle("Fine Arts");
            break;
        case 6:
            data = alldata.manchan;
            getActivity().setTitle("Manchan");
            break;
        case 7:
            data = alldata.tarantism;
            getActivity().setTitle("Tarantism");
            break;
        case 8:
            data = alldata.stuntshow;
            getActivity().setTitle("Stunt Show");
            break;
        case 9:
            data = alldata.bandwars;
            getActivity().setTitle("Band Wars");
            break;
        case 10:
            data = alldata.vogue;
            getActivity().setTitle("Vogue");
            break;
        case 11:
            data = alldata.dj;
            getActivity().setTitle("DJ Night");
            break;
        case 12:
            data = alldata.art;
            getActivity().setTitle("Art Exhibition");
            break;
        case 13:
            data = alldata.rj;
            getActivity().setTitle("RJ Show");
            break;
        case 14:
            data = alldata.lens;
            getActivity().setTitle("Lenspark");
            break;
        case 15:
            data = alldata.kavi;
            getActivity().setTitle("Kavi Sammelan");
            break;
        case 16:
            data = alldata.qq;
            getActivity().setTitle("Qawwali Night");
            break;
        case 17:
            data = alldata.theme;
            getActivity().setTitle("Theme Party");
            break;
        case 18:
            data = alldata.rock;
            getActivity().setTitle("Rock Night");
            break;

        }

        ArrayList<SingleRowData> dataSource = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            SingleRowData s = new SingleRowData(
                    getResources().getIdentifier(data[i][1], "drawable", getActivity().getPackageName()), data[i][0],
                    "", "");
            dataSource.add(s);
        }
        CustomAdpevent adapter = new CustomAdpevent(view.getContext(), dataSource);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent i = new Intent(getContext(), eventpage.class);
        i.putExtra("t", data[position][0]);
        i.putExtra("d", data[position][2]);
        i.putExtra("i", getResources().getIdentifier(data[position][1], "drawable", getActivity().getPackageName()));
        startActivity(i);

    }

}
