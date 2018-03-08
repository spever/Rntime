package com.redluo.rntime.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by luo
 * on 2018/2/1
 * in Rntime
 */

public class NewsItem implements Serializable {

    /**
     * dataList : [{"logoFile":"http://m.zhcw.com/upload/resources/image/2018/02/01/1069730.png","publishDate":"2018-02-01 10:48:00","summary":"新年迎好运，福彩送惊喜。福彩2018年贺岁版生肖彩票刮刮乐\u201c戊戌狗\u201d系列上市！为回馈广大彩民，2月6日至3月16日，河南福彩将举行即开票\u201c戊戌狗\u201d回馈活动。","title":"河南福彩送金条迎戊戌狗","url":"http://m.zhcw.com/khd/zx/tt/gdlb/15314132.shtml"},{"logoFile":"http://m.zhcw.com/upload/resources/image/2018/02/01/1069700.jpg","publishDate":"2018-02-01 09:34:00","summary":"\u201c我们希望成为广州这座\u2018慈善之城\u2019最好的代言人，请为我们投下您宝贵的一票！\u201d1月26日下午，由广州福彩资助的第三届广州福彩公益慈善项目大赛决赛隆重召开，由广州市残疾人福利基金会推荐的\u201c追梦天使\u201d等10个项目被评选为\u201c十佳项目\u201d。","title":"广州福彩连续三年资助公益大赛","url":"http://m.zhcw.com/khd/zx/tt/gdlb/15307978.shtml"},{"logoFile":"http://m.zhcw.com/upload/resources/image/2018/01/31/1069407.jpg","publishDate":"2018-01-31 00:09:00","summary":"中彩网讯 1月30日晚，中国福利彩票双色球游戏进行第2018013期开奖。当期双色球红球号码为06、08、13、15、22、33，蓝球号码为06。","title":"双色球013期：头奖9注700万","url":"http://m.zhcw.com/khd/zx/tt/gdlb/15270122.shtml"},{"logoFile":"","publishDate":"2018-01-30 22:21:00","summary":"双色球第2018013期开奖结果：\n红球：06 08 13 15 22 33\n蓝球：06","title":"双色球013期开奖结果","url":"http://m.zhcw.com/khd/zx/tt/gdlb/15268112.shtml"},{"logoFile":"http://m.zhcw.com/upload/resources/image/2018/01/30/1069382.png","publishDate":"2018-01-30 18:04:00","summary":"本次抽奖结果将在中国福利彩票官网(www.cwl.gov.cn)、公益时报和中彩网公布，彩民也可拨打中国福利彩票服务热线95189518查询中奖结果。","title":"2017福彩积分服务回馈活动开奖公告","url":"http://m.zhcw.com/khd/zx/tt/gdlb/15266100.shtml"},{"logoFile":"http://m.zhcw.com/upload/resources/image/2018/01/30/1069288.png","publishDate":"2018-01-30 12:11:00","summary":"上周，（1月22日~1月28日）双色球2018010-2018012期，共产生头奖22注，总销量10.55亿元，目前奖池累积金额为4.06亿元。据统计，上周双色球销量前五名分别是广东（不含深圳）以9623万多元高居榜首，浙江以8047万多元位列第二，山东以6235万多元排名第三，江苏以5389万多元排名第四，四川以5293万多元排名第五。","title":"上周双色球销量10.55亿 ","url":"http://m.zhcw.com/khd/zx/tt/gdlb/15258958.shtml"},{"logoFile":"","publishDate":"2018-01-29 10:42:00","summary":"近日，佛山市福利彩票发行中心兑奖处迎来了一位90后彩民刘小姐，她接触刮刮乐时间不长，是一位\u201c菜鸟\u201d彩民，却在2018年初之际，幸运收获了刮刮乐\u201c幸运双星\u201d大奖12万元，这也是佛山福彩刮刮乐今年来第一个大奖。","title":"佛山刮刮乐今年首个头奖诞生","url":"http://m.zhcw.com/khd/zx/tt/gdlb/15238429.shtml"},{"logoFile":"http://m.zhcw.com/upload/resources/image/2018/01/29/1068968.jpg","publishDate":"2018-01-29 00:31:00","summary":"中彩网讯 1月28日晚，中国福利彩票双色球游戏进行第2018012期开奖。当期双色球红球号码为11、12、13、19、26、28，蓝球号码为12。","title":"双色球012期：头奖8注719万","url":"http://m.zhcw.com/khd/zx/tt/gdlb/15226059.shtml"},{"logoFile":"","publishDate":"2018-01-28 21:32:00","summary":"双色球第2018012期开奖结果：\n红球：11 12 13 19 26 28\n蓝球：12\n2017年是福彩即开票伴随中国福利彩票成长的第三十年。","title":"双色球012期开奖结果","url":"http://m.zhcw.com/khd/zx/tt/gdlb/15222036.shtml"},{"logoFile":"","publishDate":"2018-01-26 19:19:01","summary":"根据《彩票管理条例实施细则》（财政部 民政部 国家体育总局令第67号）和《国务院办公厅关于2018年部分节假日安排的通知》（国办发明电〔2017〕12号）的有关规定，现将2018年彩票市场春节休市有关事项公告如下。","title":"2018年彩票市场春节休市公告","url":"http://m.zhcw.com/khd/zx/tt/gdlb/15199781.shtml"},{"logoFile":"http://m.zhcw.com/upload/resources/image/2018/01/26/1068875.jpg","publishDate":"2018-01-26 12:22:47","summary":"回首2017，中国福利彩票与公益同行，扶老、助残、救孤、济困，始终陪伴在你我身边。","title":"公益，福彩永不褪色的主题","url":"http://m.zhcw.com/khd/zx/tt/gdlb/15187420.shtml"},{"logoFile":"http://m.zhcw.com/upload/resources/image/2018/01/26/1068682.png","publishDate":"2018-01-26 10:06:00","summary":"近期，多款刮刮乐新票陆续登陆酒泉争奇斗艳,深受彩民追捧,丰厚大奖也接踵而来,这不,年轻时尚的\u201c5动奇迹\u201d上市不久,酒泉90后小伙在位于金塔县中山街的62212316号投注站初次尝鲜,就幸运地拔得头筹刮中一等奖10万元。","title":"酒泉90后尝鲜\"5动奇迹\"刮中10万","url":"http://m.zhcw.com/khd/zx/tt/gdlb/15177037.shtml"},{"logoFile":"http://m.zhcw.com/upload/resources/image/2018/01/26/1068652.jpg","publishDate":"2018-01-26 09:52:00","summary":"\u201c刮中奖已经两天了，到现在我心里还是怦怦直跳呢！\u201d \u201c百发百中？点球大战\u201d彩票一直是福彩刮刮乐的热销票种，它以绿茵球场、动感十足的足球，吸引着年轻的彩民。","title":"从化夫妻逛街中\"点球大战\"20万","url":"http://m.zhcw.com/khd/zx/tt/gdlb/15175994.shtml"},{"logoFile":"http://m.zhcw.com/upload/resources/image/2018/01/25/1068592.jpg","publishDate":"2018-01-25 22:37:00","summary":"1月25日晚，中国福利彩票双色球游戏进行第2018011期开奖。当期双色球红球号码为03、10、21、23、27、33，蓝球号码为11。","title":"双色球011期：头奖8注735万","url":"http://m.zhcw.com/khd/zx/tt/gdlb/15168879.shtml"},{"logoFile":"","publishDate":"2018-01-25 21:34:00","summary":"双色球第2018011期开奖结果：\n红球：03 10 21 23 27 33\n蓝球：11？\n2017年是福彩即开票伴随中国福利彩票成长的第三十年。","title":"双色球011期开奖结果","url":"http://m.zhcw.com/khd/zx/tt/gdlb/15166864.shtml"},{"logoFile":"http://m.zhcw.com/upload/resources/image/2018/01/25/1068569.jpg","publishDate":"2018-01-25 15:23:50","summary":"这是一个跟过年有关的故事\n故事很短，却很温情~","title":"过年了 把\u201c狗\u201d带回家~","url":"http://m.zhcw.com/khd/zx/tt/gdlb/15164851.shtml"},{"logoFile":"http://m.zhcw.com/upload/resources/image/2018/01/25/1068511.png","publishDate":"2018-01-25 11:53:01","summary":"中国福利彩票自诞生之日起，始终坚持以\u201c扶老、助残、救孤、济困\u201d为发行宗旨。2017年9月底，山西福彩中心开展了主题为\u201c福彩扶老？社会敬老\u201d宣传活动，旨在通过系列活动彰显福利彩票扶老公益属性，传承敬老传统美德，引领正确时代风向。","title":"福彩扶老·公益为本","url":"http://m.zhcw.com/khd/zx/tt/gdlb/15157676.shtml"},{"logoFile":"http://m.zhcw.com/upload/resources/image/2018/01/25/1068442.jpg","publishDate":"2018-01-25 10:27:02","summary":"近日，在巴州库尔勒市各大购物广场、商超、网吧等公共场所，一款自助购彩神器福彩\u201c小黄人\u201d闪亮登场，引来广大市民和彩民朋友的关注和喜爱。","title":"小黄人亮相库尔勒","url":"http://m.zhcw.com/khd/zx/tt/gdlb/15153599.shtml"},{"logoFile":"","publishDate":"2018-01-24 15:29:01","summary":"中国福利彩票以\u201c扶老、助残、救孤、济困\u201d为发行宗旨，为了更好地践行福彩宗旨，树立良好的公益形象，展现福彩公益金的使用成果，山东省福利彩票发行中心组织策划了主题为\u201c大爱民政·阳光福彩\u201d公益金资助项目媒体采风活动，让媒体代表切身感受公益项目，通过众多媒体的真实报道让社会公众对福彩、对公益有更深刻、更全面的了解。","title":"创新宣传驱动福彩公益再升温","url":"http://m.zhcw.com/khd/zx/tt/gdlb/15142281.shtml"},{"logoFile":"http://m.zhcw.com/upload/resources/image/2018/01/24/1068287.jpg","publishDate":"2018-01-24 13:28:00","summary":"","title":"2017年12月份全国彩票销售情况","url":"http://m.zhcw.com/khd/zx/tt/gdlb/15139229.shtml"}]
     * pageSize : 20
     * pageNo : 1
     * totalPage : 372
     */

    private int pageSize;
    private int pageNo;
    private int totalPage;
    private List<DataListBean> dataList;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<DataListBean> getDataList() {
        return dataList;
    }

    public void setDataList(List<DataListBean> dataList) {
        this.dataList = dataList;
    }

    public static class DataListBean {
        /**
         * logoFile : http://m.zhcw.com/upload/resources/image/2018/02/01/1069730.png
         * publishDate : 2018-02-01 10:48:00
         * summary : 新年迎好运，福彩送惊喜。福彩2018年贺岁版生肖彩票刮刮乐“戊戌狗”系列上市！为回馈广大彩民，2月6日至3月16日，河南福彩将举行即开票“戊戌狗”回馈活动。
         * title : 河南福彩送金条迎戊戌狗
         * url : http://m.zhcw.com/khd/zx/tt/gdlb/15314132.shtml
         */

        private String logoFile;
        private String publishDate;
        private String summary;
        private String title;
        private String url;

        public String getLogoFile() {
            return logoFile;
        }

        public void setLogoFile(String logoFile) {
            this.logoFile = logoFile;
        }

        public String getPublishDate() {
            return publishDate;
        }

        public void setPublishDate(String publishDate) {
            this.publishDate = publishDate;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
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
