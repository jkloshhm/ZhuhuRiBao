package com.example.guojian.zhuhuribao.bean;

import java.util.List;

/**
 * Created by guojian on 2017/5/18.
 */

public class DailyListBean {

    /**
     * date : 20170518
     * stories : [{"title":"还记得初中课本说的可燃冰吗？它终于被中国首次成功开采","ga_prefix":"051814","images":["https://pic1.zhimg.com/v2-cd841c22dee6d2ce2817cbb6960998f8.jpg"],"multipic":true,"type":0,"id":9427389},{"title":"70 年，戛纳这个不起眼的小城一步步成为电影的「圣地」","ga_prefix":"051813","images":["https://pic1.zhimg.com/v2-ebe05fb440f0042381c1ebd175a81b94.jpg"],"multipic":true,"type":0,"id":9425616},{"images":["https://pic4.zhimg.com/v2-b18be6acbef497b34389da4c2c4164ab.jpg"],"type":0,"id":9425743,"ga_prefix":"051812","title":"看书是看，刷手机也是看，怎么就有问题了？"},{"images":["https://pic2.zhimg.com/v2-290f0cc88b50ebce9b5dbf603b6fc655.jpg"],"type":0,"id":9425936,"ga_prefix":"051812","title":"大误 · 16 头身才是黄金比例"},{"title":"Google I/O 完整盘点，这才是地球上最「性感」的发布会","ga_prefix":"051809","images":["https://pic3.zhimg.com/v2-30fa81605900de562afaa26232366ae6.jpg"],"multipic":true,"type":0,"id":9426650},{"images":["https://pic3.zhimg.com/v2-2b1ef8b368c8996dd9c7a85a2100a55a.jpg"],"type":0,"id":9425417,"ga_prefix":"051808","title":"好奇怪，人们一边爱着小众品牌，一边又扎堆排着热门餐厅"},{"images":["https://pic3.zhimg.com/v2-572e6bf0424f69d433ded2ee2b97eb4a.jpg"],"type":0,"id":9426375,"ga_prefix":"051807","title":"微信增加了一个「新功能」，这下百度要慌了"},{"images":["https://pic4.zhimg.com/v2-b886d6a43cf9e161b0f5c5639156e07b.jpg"],"type":0,"id":9426106,"ga_prefix":"051807","title":"英雄联盟电竞比赛中被选用 / 禁止的最多的英雄有哪些？"},{"images":["https://pic2.zhimg.com/v2-789128b322cef6fc37b74fa67bff64a1.jpg"],"type":0,"id":9425966,"ga_prefix":"051807","title":"中国食品安全现状如何？媒体、监管和老百姓都值得分析"},{"images":["https://pic4.zhimg.com/v2-470bdcbdb9e60c185940d91ef8fa5b17.jpg"],"type":0,"id":9425072,"ga_prefix":"051806","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic4.zhimg.com/v2-9cefd8baab0e69e346ee3362a67ff9f3.jpg","type":0,"id":9427389,"ga_prefix":"051814","title":"还记得初中课本说的可燃冰吗？它终于被中国首次成功开采"},{"image":"https://pic4.zhimg.com/v2-f127090ca8a40972f9d8400b3bd5e6b7.jpg","type":0,"id":9426650,"ga_prefix":"051809","title":"Google I/O 完整盘点，这才是地球上最「性感」的发布会"},{"image":"https://pic2.zhimg.com/v2-84d051199b13d07a990713360642daf9.jpg","type":0,"id":9426375,"ga_prefix":"051807","title":"微信增加了一个「新功能」，这下百度要慌了"},{"image":"https://pic4.zhimg.com/v2-baf06e797821d713137f52b4617eab0f.jpg","type":0,"id":9426106,"ga_prefix":"051807","title":"英雄联盟电竞比赛中被选用 / 禁止的最多的英雄有哪些？"},{"image":"https://pic3.zhimg.com/v2-540a982ce376a7b8dbb4d3eda5eaa5d2.jpg","type":0,"id":9425417,"ga_prefix":"051808","title":"好奇怪，人们一边爱着小众品牌，一边又扎堆排着热门餐厅"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * title : 还记得初中课本说的可燃冰吗？它终于被中国首次成功开采
         * ga_prefix : 051814
         * images : ["https://pic1.zhimg.com/v2-cd841c22dee6d2ce2817cbb6960998f8.jpg"]
         * multipic : true
         * type : 0
         * id : 9427389
         */

        private String title;
        private String ga_prefix;
        private boolean multipic;
        private int type;
        private int id;
        private List<String> images;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic4.zhimg.com/v2-9cefd8baab0e69e346ee3362a67ff9f3.jpg
         * type : 0
         * id : 9427389
         * ga_prefix : 051814
         * title : 还记得初中课本说的可燃冰吗？它终于被中国首次成功开采
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
