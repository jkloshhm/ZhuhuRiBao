package com.example.guojian.zhuhuribao;

import com.example.guojian.zhuhuribao.bean.DailyListBean;
import com.example.guojian.zhuhuribao.bean.NewsDetailsBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by guojian on 2017/5/19.
 */

public interface ZhuHuApiService {//http://news-at.zhihu.com/api/4/news/latest
    String HOST = "http://news-at.zhihu.com/api/4/";

    /**
     * 最新日报
     */

    @GET("news/latest")
    Observable<DailyListBean> getDailyList();

    @GET("news/{id}")
    Observable<NewsDetailsBean> getNewsContent(@Path("id") int id);
}
