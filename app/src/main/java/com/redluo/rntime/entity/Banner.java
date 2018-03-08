package com.redluo.rntime.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by luo
 * on 2018/2/1
 * in Rntime
 */

public class Banner implements Serializable{


    /**
     * newFlag : 1517468241550
     * dataList : [{"logoFile":"http://m.zhcw.com/upload/resources/image/2018/02/01/1069734.jpg","title":"公益，福彩永不褪色的主题","url":"http://m.zhcw.com/khd/zx/tt/banner/15314128.shtml"},{"logoFile":"http://m.zhcw.com/upload/resources/image/2017/11/30/712451.png","title":"招聘：寻找不一样的你","url":"http://m.zhcw.com/khd/zy/lb/4447564.shtml"}]
     */

    private String newFlag;
    private List<BannerListBean> bannerList;

    public String getNewFlag() {
        return newFlag;
    }

    public void setNewFlag(String newFlag) {
        this.newFlag = newFlag;
    }

    public List<BannerListBean> getDataList() {
        return bannerList;
    }

    public void setDataList(List<BannerListBean> dataList) {
        this.bannerList = dataList;
    }

    public static class BannerListBean {
        /**
         * logoFile : http://m.zhcw.com/upload/resources/image/2018/02/01/1069734.jpg
         * title : 公益，福彩永不褪色的主题
         * url : http://m.zhcw.com/khd/zx/tt/banner/15314128.shtml
         */

        private String logoFile;
        private String title;
        private String url;

        public String getLogoFile() {
            return logoFile;
        }

        public void setLogoFile(String logoFile) {
            this.logoFile = logoFile;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
