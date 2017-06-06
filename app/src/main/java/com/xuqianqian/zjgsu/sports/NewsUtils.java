package com.xuqianqian.zjgsu.sports;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;

/**
 * Created by z on 2017/5/31.
 */

public class NewsUtils {
    public static ArrayList<NewsBean> getAllNews(Context context) {

        ArrayList<NewsBean> arrayList = new ArrayList<NewsBean>();

        for(int i = 0 ;i <2;i++)
        {
            NewsBean newsBean = new NewsBean();
            newsBean.title ="新体谈|请用敬畏之心对待马拉松";
            newsBean.des= "前几天的北京有多热，现在的马拉松就有多热。";
            newsBean.news_url= "http://sports.sina.com.cn/run/2017-05-24/doc-ifyfkkme0336365.shtml";
            newsBean.icon = ContextCompat.getDrawable(context, R.drawable.adb);
            newsBean.time = "05月24日 09:47";
            arrayList.add(newsBean);

            NewsBean newsBean1 = new NewsBean();
            newsBean1.title ="墨西哥一女性穿凉鞋裙子参加马拉松 赢得冠军";
            newsBean1.des= "据外媒报道，在墨西哥的一场超级马拉松赛事中，来自当地部落的22岁女性拉米雷斯，穿着凉鞋和裙子跑完了50公里的全程，并且赢得冠军。";
            newsBean1.news_url= "http://sports.sina.com.cn/run/2017-05-24/doc-ifyfkkme0335197.shtml";
            newsBean1.icon = ContextCompat.getDrawable(context, R.drawable.b);
            newsBean1.time = "05月24日 09:41";
            arrayList.add(newsBean1);

            NewsBean newsBean2 = new NewsBean();
            newsBean2.title ="女子夜跑半年甩掉脂肪肝 半年时间减重20斤";
            newsBean2.des= "临近端午节，昼长夜短、白天气温高，而当夜幕降临，凉风袭来时，无疑是上班族们进行户外运动的最佳时刻";
            newsBean2.news_url= "http://sports.sina.com.cn/run/2017-05-24/doc-ifyfkqwe0885231.shtml";
            newsBean2.icon = ContextCompat.getDrawable(context, R.drawable.c);
            newsBean2.time = "05月24日 09:41";
            arrayList.add(newsBean2);

            NewsBean newsBean3 = new NewsBean();
            newsBean3.title ="【讲堂】6种饮料跑前不要喝！如何补水看这里";
            newsBean3.des= "夏日炎炎，各位跑友对饮水的需求量也越来越大。跑后补水固然重要但是跑前的喝水方法也同样不可小觑！那跑前究竟应该如何补水，又有哪些是跑前不该喝的呢？";
            newsBean3.news_url= "http://sports.sina.com.cn/run/2017-05-24/doc-ifyfkkme0330770.shtml";
            newsBean3.icon = ContextCompat.getDrawable(context, R.drawable.d);
            newsBean3.time = "05月24日 09:21";
            arrayList.add(newsBean3);

            NewsBean newsBean4 = new NewsBean();
            newsBean4.title ="智美CEO致歉春马抢跑事件：人生没有白走的路";
            newsBean4.des= "北京时间5月21日，首届长春马拉松正式鸣枪起跑，而由于发生了抢跑事件，让春马备受争议。";
            newsBean4.news_url= "http://sports.sina.com.cn/run/2017-05-23/doc-ifyfkqiv6701626.shtml";
            newsBean4.icon = ContextCompat.getDrawable(context, R.drawable.e);
            newsBean4.time = "05月23日 11:59";
            arrayList.add(newsBean4);
        }
        return arrayList;
    }
}
