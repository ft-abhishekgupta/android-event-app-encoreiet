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
public class CustomAdpevent extends BaseAdapter  {

    ArrayList<SingleRowData> dataSource;
    Context c;
    String number[];
    CustomAdpevent(Context context, ArrayList d){
        c=context;
        dataSource=d;
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
        //inflation of layout composite view
        LayoutInflater li= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=li.inflate(R.layout.eventdetail,parent,false);
        ImageView image= (ImageView) row.findViewById(R.id.imageView26);
        TextView title= (TextView) row.findViewById(R.id.textView22);
        //TextView call = (TextView) row.findViewById(R.id.textView34);
        //TextView desc= (TextView) row.findViewById(R.id.textView33);



        SingleRowData rowdata=dataSource.get(position);
        //image.setImageResource(rowdata.id);
        Glide.with(c).load(rowdata.id).crossFade().into(image);
        //Glide.with(c).load(R.drawable.b).asGif().into(image);

        title.setText(rowdata.title);
//        desc.setText("");
//        call.setText(rowdata.time);
//            desc.setVisibility(View.INVISIBLE);
//            desc.setClickable(false);

//        call.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:"+number[position]));
//                parent.getContext().startActivity(intent);
//            }
//        });
        return row;
    }


}
