package com.example.guojian.zhuhuribao;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import androidx.core.widget.NestedScrollView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.guojian.zhuhuribao.bean.NewsDetailsBean;
import com.example.guojian.zhuhuribao.util.LogToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DailyDetailActivity extends AppCompatActivity {

    @BindView(R.id.web_view)
    WebView webView;
    /*    @BindView(R.id.progress_bar)
        ProgressBar progressBar;*/
    @BindView(R.id.news_image_view)
    ImageView newsImageView;
    @BindView(R.id.toolBar_news_detail_activity)
    Toolbar toolBarNewsDetailActivity;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.appBar)
    AppBarLayout appBar;
    @BindView(R.id.nested_scrollView)
    NestedScrollView nestedScrollView;
    @BindView(R.id.swipe_refresh)
    MySwipeRefreshLayout swipeRefresh;

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_detail);
        ButterKnife.bind(this);
        setSupportActionBar(toolBarNewsDetailActivity);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            //actionBar.setHomeAsUpIndicator(R.mipmap.back);
            //actionBar.setBackgroundDrawable(getResources().getDrawable(R.mipmap.back));
            //actionBar.setTitle("");
        }
        swipeRefresh.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.CYAN, Color.RED);
        swipeRefresh.setRefreshing(true);
        //collapsingToolbar.setTitle("");
        Intent mIntent = getIntent();
        int newsId = mIntent.getIntExtra("newsId", 0);
        //progressBar.setVisibility(View.VISIBLE);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ZhuHuApiService.HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ZhuHuApiService zhuHuApiService = retrofit.create(ZhuHuApiService.class);
        zhuHuApiService.getNewsContent(newsId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsDetailsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewsDetailsBean newsDetailsBean) {
                        String body = newsDetailsBean.getBody();
                        String imageUrl = newsDetailsBean.getImage();
                        String newsTitle = newsDetailsBean.getTitle();
                        LogToastUtils.showShort(DailyDetailActivity.this, newsTitle);
                        collapsingToolbar.setTitle(newsTitle);
                        //collapsingToolbar.setScrimsShown(true);
                        collapsingToolbar.setCollapsedTitleGravity(Gravity.LEFT);
                        collapsingToolbar.setExpandedTitleMarginStart(0);
                        collapsingToolbar.setScrollBarSize(5);
                        WebSettings webSettings = webView.getSettings();
                        //webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
                        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
                        webView.loadDataWithBaseURL(null, getHtmlData(body),
                                "text/html", "utf-8", null);
                        Glide.with(DailyDetailActivity.this)
                                .load(imageUrl).into(newsImageView);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        //progressBar.setVisibility(View.GONE);
                        swipeRefresh.setRefreshing(false);
                        appBar.setVisibility(View.VISIBLE);
                        nestedScrollView.setVisibility(View.VISIBLE);
                    }
                });
    }

    private String getHtmlData(String bodyHTML) {
        String head = "<head><style>img{max-width: 100%; width:auto; height: auto; " +
                "vertical-align: middle; }" +
                //"body{margin:15px;}" +
                "</style>" +
                "</head>";
        return "<html>" + head + "<body>" + bodyHTML + "</body></html>";
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
