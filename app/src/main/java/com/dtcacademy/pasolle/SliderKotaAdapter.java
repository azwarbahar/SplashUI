package com.dtcacademy.pasolle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class SliderKotaAdapter extends PagerAdapter {
    private Context mContext;
    private List<SliderKotaItem> models;
    private LayoutInflater layoutInflater;

    public SliderKotaAdapter(Context mContext, List<SliderKotaItem> models) {
        this.mContext = mContext;
        this.models = models;
    }


    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.intro_kota,container,false);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageKota);
        TextView title = (TextView) view.findViewById(R.id.title);
        TextView desc = (TextView) view.findViewById(R.id.desc);

        imageView.setImageResource(models.get(position).getImage());
        title.setText(models.get(position).getTitle());
        desc.setText(models.get(position).getDesc());

        container.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

}
