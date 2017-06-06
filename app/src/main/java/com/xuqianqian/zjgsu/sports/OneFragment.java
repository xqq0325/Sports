package com.xuqianqian.zjgsu.sports;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xuqianqian.zjgsu.sports.track.TrackApplication;
import com.xuqianqian.zjgsu.sports.track.activity.BaseActivity;
import com.xuqianqian.zjgsu.sports.track.activity.TracingActivity;
import com.xuqianqian.zjgsu.sports.track.model.ItemInfo;
import com.xuqianqian.zjgsu.sports.track.utils.BitmapUtil;
import com.xuqianqian.zjgsu.sports.track.*;
import com.xuqianqian.zjgsu.sports.R;


import com.xuqianqian.zjgsu.sports.track.utils.CommonUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/5/8.
 */

public class OneFragment extends Fragment{
    private int imageIds[];
    private String[] titles;
    public ArrayList<ImageView> images;
    public ArrayList<View> dots;
    private TextView title;
    private ViewPager mViewPager;
    private ViewPagerAdapter adapter;

    private int oldPosition = 0;//记录上一次点的位置
    private int currentItem; //当前页面
    private ScheduledExecutorService scheduledExecutorService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        imageIds = new int[]{
                R.drawable.adb,
                R.drawable.b,
                R.drawable.c,
                R.drawable.d,
                R.drawable.e,
        };

        //图片标题
        titles = new String[]{
                "新体谈|请用敬畏之心对待马拉松",
                "墨西哥一女性穿凉鞋裙子参加马拉松 赢得冠军",
                "女子夜跑半年甩掉脂肪肝 半年时间减重20斤",
                "【讲堂】6种饮料跑前不要喝！如何补水看这里",
                "智美CEO致歉春马抢跑事件：人生没有白走的路"
        };

        //显示的图片
        images = new ArrayList<ImageView>();
        for(int i =0; i < imageIds.length; i++){
            ImageView imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(imageIds[i]);

            images.add(imageView);
        }

        //显示的点
        dots = new ArrayList<View>();
        dots.add(view.findViewById(R.id.dot_0));
        dots.add(view.findViewById(R.id.dot_1));
        dots.add(view.findViewById(R.id.dot_2));
        dots.add(view.findViewById(R.id.dot_3));
        dots.add(view.findViewById(R.id.dot_4));

        title = (TextView) view.findViewById(R.id.title);
        title.setText(titles[0]);

        mViewPager = (ViewPager) view.findViewById(R.id.vp);

        Button bt = (Button)view.findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TracingActivity.class);
                startActivity(intent);
            }
        });

        adapter = new ViewPagerAdapter();
        mViewPager.setAdapter(adapter);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                title.setText(titles[position]);

                dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
                dots.get(position).setBackgroundResource(R.drawable.dot_focused);

                oldPosition = position;
                currentItem = position;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
        return view;


    }

    private class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return images.size();
        }

        //是否是同一张图片
        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup view, int position, Object object) {
//            super.destroyItem(container, position, object);
//            view.removeViewAt(position);
            view.removeView(images.get(position));

        }

        @Override
        public Object instantiateItem(ViewGroup view, int position) {
            view.addView(images.get(position));

            return images.get(position);
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        //每隔2秒钟切换一张图片
        scheduledExecutorService.scheduleWithFixedDelay(new ViewPagerTask(), 2, 2, TimeUnit.SECONDS);
    }


    private class ViewPagerTask implements Runnable {

        @Override
        public void run() {
            currentItem = (currentItem +1) % imageIds.length;
            handler.obtainMessage().sendToTarget();
        }

    }

    private Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            mViewPager.setCurrentItem(currentItem);
        }

    };

    @Override
    public void onStop() {
        super.onStop();
    }


}
