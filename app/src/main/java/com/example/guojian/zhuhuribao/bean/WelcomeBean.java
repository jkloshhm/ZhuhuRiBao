package com.example.guojian.zhuhuribao.bean;

import java.util.List;

/**
 * Created by guojian on 2017/4/18.
 */

public class WelcomeBean {


    /**
     * url : https://pic1.zhimg.com/v2-0bf26092e8bd38a59d08dc9326fe5ca8.jpg
     * start_time : 1492486211
     * impression_tracks : ["https://sugar.zhihu.com/track?vs=1&ai=3908&ut=&cg=2&ts=1492486211.82&si=58ab6b5a47934161982ddb752bf40028&lu=0&hn=ad-engine.ad-engine.872e1e3a&at=impression&pf=PC&az=11&sg=cd0d4ea6ae423e0ea9b0e258a1e38cb0"]
     * type : 0
     * id : 3908
     */

    private String url;
    private int start_time;
    private int type;
    private String id;
    private List<String> impression_tracks;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStart_time() {
        return start_time;
    }

    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getImpression_tracks() {
        return impression_tracks;
    }

    public void setImpression_tracks(List<String> impression_tracks) {
        this.impression_tracks = impression_tracks;
    }

}
