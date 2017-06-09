package com.example.rxjavatest;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Integer[] images={R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
    private List<Integer> images= new ArrayList<>();//{R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        images.add(R.mipmap.ic_launcher);
        images.add(R.mipmap.ic_launcher);
        images.add(R.mipmap.ic_launcher);

        Banner banner = (Banner) findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        banner.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        //banner设置方法全部调用完毕时最后调用
        banner.start();

    }
}
