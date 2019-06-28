package com.iet.lucknow.encore;

/**
 * Created by abhishek on 12-09-2016.
 */
import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends PagerAdapter {

    Context context;
    String posters[][] = alldata.posters;

    public CustomAdapter(Context context) {
        this.context = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View viewItem = inflater.inflate(R.layout.image_item, container, false);
        ImageView imageView = (ImageView) viewItem.findViewById(R.id.imageView28);
        imageView.setImageResource(
                context.getResources().getIdentifier(posters[position][1], "drawable", context.getPackageName()));
        TextView textView1 = (TextView) viewItem.findViewById(R.id.textView27);
        textView1.setText(posters[position][0]);
        ((ViewPager) container).addView(viewItem);

        return viewItem;
    }

    @Override
    public int getCount() {
        return posters.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == ((View) object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }

}