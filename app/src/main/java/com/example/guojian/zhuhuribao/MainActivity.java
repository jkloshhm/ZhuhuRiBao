package com.example.guojian.zhuhuribao;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.guojian.zhuhuribao.bean.DailyListBean;
import com.example.guojian.zhuhuribao.util.LogToastUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tool_bar)
    Toolbar toolBar;
    //@BindView(R.id.text)
    TextView text;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefresh;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.my_scrollview)
    MyScrollview myScrollview;

    private DailyListAdapter mDailyListAdapter;
    private List<String> images = new ArrayList<>();
    private List<String> titles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setSupportActionBar(toolBar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_menu);
        }
        mSwipeRefresh.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.CYAN, Color.RED);
        mSwipeRefresh.setRefreshing(true);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ZhuHuApiService.HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ZhuHuApiService zhuHuApiService = retrofit.create(ZhuHuApiService.class);
        zhuHuApiService.getDailyList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DailyListBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                    }

                    @Override
                    public void onNext(@NonNull DailyListBean dailyListBean) {
                        String s = dailyListBean.getDate();
                        LogToastUtils.showShort(MainActivity.this, s);

                        //1.今日热文
                        List<DailyListBean.StoriesBean> storiesBeanList = dailyListBean.getStories();
                        mDailyListAdapter = new DailyListAdapter(storiesBeanList);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setAdapter(mDailyListAdapter);
                        //text.setText("" + s);

                        //2. 轮播图热门消息
                        final List<DailyListBean.TopStoriesBean> mTopStoriesBeanList = dailyListBean.getTop_stories();
                        for (int i = 0; i < mTopStoriesBeanList.size(); i++) {
                            images.add(mTopStoriesBeanList.get(i).getImage());
                            titles.add(mTopStoriesBeanList.get(i).getTitle());
                        }
                        //设置banner样式
                        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
                        //设置banner动画效果
                        banner.setBannerAnimation(Transformer.CubeOut);
                        //设置图片加载器
                        banner.setImageLoader(new GlideImageLoader());
                        //设置图片集合
                        banner.setImages(images);
                        banner.setBannerTitles(titles);
                        banner.setDelayTime(5000);
                        //banner设置方法全部调用完毕时最后调用
                        banner.start();
                        banner.setOnBannerListener(new OnBannerListener() {
                            @Override
                            public void OnBannerClick(int position) {
                                int id = mTopStoriesBeanList.get(position).getId();
                                LogToastUtils.showShort(MainActivity.this, "" + id);
                                Intent mIntent = new Intent(MainActivity.this, DailyDetailActivity.class);
                                mIntent.putExtra("newsId", id);
                                startActivity(mIntent);
                            }
                        });
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                        LogToastUtils.showShort(MainActivity.this, e.toString());
                    }

                    @Override
                    public void onComplete() {
                        mSwipeRefresh.setRefreshing(false);
                        myScrollview.setVisibility(View.VISIBLE);
                    }
                });
    }
}
