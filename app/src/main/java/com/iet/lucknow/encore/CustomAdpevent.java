package com.iet.lucknow.encore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

/**
 * Created by abhishek on 18-07-2016.
 */
public class CustomAdpevent extends BaseAdapter {

    ArrayList<SingleRowData> dataSource;
    Context c;
    String number[];

    CustomAdpevent(Context context, ArrayList d) {
        c = context;
        dataSource = d;
    }

    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = li.inflate(R.layout.eventdetail, parent, false);
        ImageView image = (ImageView) row.findViewById(R.id.imageView26);
        TextView title = (TextView) row.findViewById(R.id.textView22);
        SingleRowData rowdata = dataSource.get(position);
        Glide.with(c).load(rowdata.id).crossFade().into(image);
        title.setText(rowdata.title);
        return row;
    }
}
