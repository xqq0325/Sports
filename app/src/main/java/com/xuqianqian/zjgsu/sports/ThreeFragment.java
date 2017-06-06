package com.xuqianqian.zjgsu.sports;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import android.widget.AdapterView.OnItemClickListener;

public class ThreeFragment extends Fragment implements OnItemClickListener {
    private Context mContext;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);


        mContext = getActivity();
        ListView lv_news = (ListView) view.findViewById(R.id.lv_news);
        ArrayList<NewsBean> allNews = NewsUtils.getAllNews(mContext);
        NewsAdapter newsAdapter = new NewsAdapter(mContext, allNews);
        lv_news.setAdapter(newsAdapter);
        lv_news.setOnItemClickListener(this);
        return view;


    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {


        NewsBean bean = (NewsBean) parent.getItemAtPosition(position);

        String url = bean.news_url;


        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);

    }
}





