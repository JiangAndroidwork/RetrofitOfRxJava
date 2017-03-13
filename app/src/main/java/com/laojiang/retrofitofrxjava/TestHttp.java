package com.laojiang.retrofitofrxjava;

import java.util.List;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/3/13 8:47.
 */

public class TestHttp {
    @Override
    public String toString() {
        return "TestHttp{" +
                "count=" + count +
                ", start=" + start +
                ", total=" + total +
                ", title='" + title + '\'' +
                ", subjects=" + subjects +
                '}';
    }

    /**
     * count : 10
     * start : 0
     * total : 250
     * subjects : [{"rating":{"max":10,"average":9.6,"stars":"50","min":0},"genres":["犯罪","剧情"],"title":"肖申克的救赎","casts":[{"alt":"https://movie.douban.com/celebrity/1054521/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/17525.jpg","large":"https://img3.doubanio.com/img/celebrity/large/17525.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/17525.jpg"},"name":"蒂姆·罗宾斯","id":"1054521"},{"alt":"https://movie.douban.com/celebrity/1054534/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/34642.jpg","large":"https://img3.doubanio.com/img/celebrity/large/34642.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/34642.jpg"},"name":"摩根·弗里曼","id":"1054534"},{"alt":"https://movie.douban.com/celebrity/1041179/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/5837.jpg","large":"https://img1.doubanio.com/img/celebrity/large/5837.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/5837.jpg"},"name":"鲍勃·冈顿","id":"1041179"}],"collect_count":1038013,"original_title":"The Shawshank Redemption","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1047973/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/230.jpg","large":"https://img3.doubanio.com/img/celebrity/large/230.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/230.jpg"},"name":"弗兰克·德拉邦特","id":"1047973"}],"year":"1994","images":{"small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p480747492.jpg","large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p480747492.jpg","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p480747492.jpg"},"alt":"https://movie.douban.com/subject/1292052/","id":"1292052"},{"rating":{"max":10,"average":9.4,"stars":"50","min":0},"genres":["剧情","动作","犯罪"],"title":"这个杀手不太冷","casts":[{"alt":"https://movie.douban.com/celebrity/1025182/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/8833.jpg","large":"https://img3.doubanio.com/img/celebrity/large/8833.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/8833.jpg"},"name":"让·雷诺","id":"1025182"},{"alt":"https://movie.douban.com/celebrity/1054454/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/2274.jpg","large":"https://img3.doubanio.com/img/celebrity/large/2274.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/2274.jpg"},"name":"娜塔莉·波特曼","id":"1054454"},{"alt":"https://movie.douban.com/celebrity/1010507/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/104.jpg","large":"https://img3.doubanio.com/img/celebrity/large/104.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/104.jpg"},"name":"加里·奥德曼","id":"1010507"}],"collect_count":1004004,"original_title":"Léon","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1031876/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/33301.jpg","large":"https://img3.doubanio.com/img/celebrity/large/33301.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/33301.jpg"},"name":"吕克·贝松","id":"1031876"}],"year":"1994","images":{"small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p511118051.jpg","large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p511118051.jpg","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p511118051.jpg"},"alt":"https://movie.douban.com/subject/1295644/","id":"1295644"},{"rating":{"max":10,"average":9.5,"stars":"50","min":0},"genres":["剧情","爱情","同性"],"title":"霸王别姬","casts":[{"alt":"https://movie.douban.com/celebrity/1003494/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/67.jpg","large":"https://img1.doubanio.com/img/celebrity/large/67.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/67.jpg"},"name":"张国荣","id":"1003494"},{"alt":"https://movie.douban.com/celebrity/1050265/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/10381.jpg","large":"https://img3.doubanio.com/img/celebrity/large/10381.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/10381.jpg"},"name":"张丰毅","id":"1050265"},{"alt":"https://movie.douban.com/celebrity/1035641/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/1399268395.47.jpg","large":"https://img1.doubanio.com/img/celebrity/large/1399268395.47.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/1399268395.47.jpg"},"name":"巩俐","id":"1035641"}],"collect_count":729428,"original_title":"霸王别姬","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1023040/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/750.jpg","large":"https://img3.doubanio.com/img/celebrity/large/750.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/750.jpg"},"name":"陈凯歌","id":"1023040"}],"year":"1993","images":{"small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p1910813120.jpg","large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p1910813120.jpg","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p1910813120.jpg"},"alt":"https://movie.douban.com/subject/1291546/","id":"1291546"},{"rating":{"max":10,"average":9.4,"stars":"50","min":0},"genres":["剧情","爱情"],"title":"阿甘正传","casts":[{"alt":"https://movie.douban.com/celebrity/1054450/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/551.jpg","large":"https://img3.doubanio.com/img/celebrity/large/551.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/551.jpg"},"name":"汤姆·汉克斯","id":"1054450"},{"alt":"https://movie.douban.com/celebrity/1002676/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/51737.jpg","large":"https://img1.doubanio.com/img/celebrity/large/51737.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/51737.jpg"},"name":"罗宾·怀特","id":"1002676"},{"alt":"https://movie.douban.com/celebrity/1031848/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/1345.jpg","large":"https://img3.doubanio.com/img/celebrity/large/1345.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1345.jpg"},"name":"加里·西尼斯","id":"1031848"}],"collect_count":896812,"original_title":"Forrest Gump","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1053564/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/505.jpg","large":"https://img3.doubanio.com/img/celebrity/large/505.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/505.jpg"},"name":"罗伯特·泽米吉斯","id":"1053564"}],"year":"1994","images":{"small":"https://img1.doubanio.com/view/movie_poster_cover/ipst/public/p510876377.jpg","large":"https://img1.doubanio.com/view/movie_poster_cover/lpst/public/p510876377.jpg","medium":"https://img1.doubanio.com/view/movie_poster_cover/spst/public/p510876377.jpg"},"alt":"https://movie.douban.com/subject/1292720/","id":"1292720"},{"rating":{"max":10,"average":9.5,"stars":"50","min":0},"genres":["剧情","喜剧","爱情"],"title":"美丽人生","casts":[{"alt":"https://movie.douban.com/celebrity/1041004/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/26764.jpg","large":"https://img3.doubanio.com/img/celebrity/large/26764.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/26764.jpg"},"name":"罗伯托·贝尼尼","id":"1041004"},{"alt":"https://movie.douban.com/celebrity/1000375/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/9548.jpg","large":"https://img1.doubanio.com/img/celebrity/large/9548.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/9548.jpg"},"name":"尼可莱塔·布拉斯基","id":"1000375"},{"alt":"https://movie.douban.com/celebrity/1000368/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/45590.jpg","large":"https://img3.doubanio.com/img/celebrity/large/45590.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/45590.jpg"},"name":"乔治·坎塔里尼","id":"1000368"}],"collect_count":493970,"original_title":"La vita è bella","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1041004/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/26764.jpg","large":"https://img3.doubanio.com/img/celebrity/large/26764.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/26764.jpg"},"name":"罗伯托·贝尼尼","id":"1041004"}],"year":"1997","images":{"small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p510861873.jpg","large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p510861873.jpg","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p510861873.jpg"},"alt":"https://movie.douban.com/subject/1292063/","id":"1292063"},{"rating":{"max":10,"average":9.2,"stars":"50","min":0},"genres":["剧情","动画","奇幻"],"title":"千与千寻","casts":[{"alt":"https://movie.douban.com/celebrity/1023337/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/1463193210.13.jpg","large":"https://img3.doubanio.com/img/celebrity/large/1463193210.13.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1463193210.13.jpg"},"name":"柊瑠美","id":"1023337"},{"alt":"https://movie.douban.com/celebrity/1005438/","avatars":{"small":"https://img5.doubanio.com/img/celebrity/small/44986.jpg","large":"https://img5.doubanio.com/img/celebrity/large/44986.jpg","medium":"https://img5.doubanio.com/img/celebrity/medium/44986.jpg"},"name":"入野自由","id":"1005438"},{"alt":"https://movie.douban.com/celebrity/1045797/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/18785.jpg","large":"https://img3.doubanio.com/img/celebrity/large/18785.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/18785.jpg"},"name":"夏木真理","id":"1045797"}],"collect_count":803103,"original_title":"千と千尋の神隠し","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1054439/","avatars":{"small":"https://img5.doubanio.com/img/celebrity/small/616.jpg","large":"https://img5.doubanio.com/img/celebrity/large/616.jpg","medium":"https://img5.doubanio.com/img/celebrity/medium/616.jpg"},"name":"宫崎骏","id":"1054439"}],"year":"2001","images":{"small":"https://img5.doubanio.com/view/movie_poster_cover/ipst/public/p1910830216.jpg","large":"https://img5.doubanio.com/view/movie_poster_cover/lpst/public/p1910830216.jpg","medium":"https://img5.doubanio.com/view/movie_poster_cover/spst/public/p1910830216.jpg"},"alt":"https://movie.douban.com/subject/1291561/","id":"1291561"},{"rating":{"max":10,"average":9.4,"stars":"50","min":0},"genres":["剧情","历史","战争"],"title":"辛德勒的名单","casts":[{"alt":"https://movie.douban.com/celebrity/1031220/","avatars":{"small":"https://img5.doubanio.com/img/celebrity/small/44906.jpg","large":"https://img5.doubanio.com/img/celebrity/large/44906.jpg","medium":"https://img5.doubanio.com/img/celebrity/medium/44906.jpg"},"name":"连姆·尼森","id":"1031220"},{"alt":"https://movie.douban.com/celebrity/1054393/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/1374649659.58.jpg","large":"https://img1.doubanio.com/img/celebrity/large/1374649659.58.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/1374649659.58.jpg"},"name":"本·金斯利","id":"1054393"},{"alt":"https://movie.douban.com/celebrity/1006956/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/28941.jpg","large":"https://img3.doubanio.com/img/celebrity/large/28941.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/28941.jpg"},"name":"拉尔夫·费因斯","id":"1006956"}],"collect_count":473337,"original_title":"Schindler's List","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1054440/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/34602.jpg","large":"https://img3.doubanio.com/img/celebrity/large/34602.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/34602.jpg"},"name":"史蒂文·斯皮尔伯格","id":"1054440"}],"year":"1993","images":{"small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p492406163.jpg","large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p492406163.jpg","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p492406163.jpg"},"alt":"https://movie.douban.com/subject/1295124/","id":"1295124"},{"rating":{"max":10,"average":9.2,"stars":"45","min":0},"genres":["剧情","爱情","灾难"],"title":"泰坦尼克号","casts":[{"alt":"https://movie.douban.com/celebrity/1041029/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/470.jpg","large":"https://img3.doubanio.com/img/celebrity/large/470.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/470.jpg"},"name":"莱昂纳多·迪卡普里奥","id":"1041029"},{"alt":"https://movie.douban.com/celebrity/1054446/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/53358.jpg","large":"https://img1.doubanio.com/img/celebrity/large/53358.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/53358.jpg"},"name":"凯特·温丝莱特","id":"1054446"},{"alt":"https://movie.douban.com/celebrity/1031864/","avatars":{"small":"https://img5.doubanio.com/img/celebrity/small/45186.jpg","large":"https://img5.doubanio.com/img/celebrity/large/45186.jpg","medium":"https://img5.doubanio.com/img/celebrity/medium/45186.jpg"},"name":"比利·赞恩","id":"1031864"}],"collect_count":824487,"original_title":"Titanic","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1022571/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/33715.jpg","large":"https://img3.doubanio.com/img/celebrity/large/33715.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/33715.jpg"},"name":"詹姆斯·卡梅隆","id":"1022571"}],"year":"1997","images":{"small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p457760035.jpg","large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p457760035.jpg","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p457760035.jpg"},"alt":"https://movie.douban.com/subject/1292722/","id":"1292722"},{"rating":{"max":10,"average":9.2,"stars":"50","min":0},"genres":["剧情","动作","科幻"],"title":"盗梦空间","casts":[{"alt":"https://movie.douban.com/celebrity/1041029/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/470.jpg","large":"https://img3.doubanio.com/img/celebrity/large/470.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/470.jpg"},"name":"莱昂纳多·迪卡普里奥","id":"1041029"},{"alt":"https://movie.douban.com/celebrity/1101703/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/3517.jpg","large":"https://img1.doubanio.com/img/celebrity/large/3517.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/3517.jpg"},"name":"约瑟夫·高登-莱维特","id":"1101703"},{"alt":"https://movie.douban.com/celebrity/1012520/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/118.jpg","large":"https://img1.doubanio.com/img/celebrity/large/118.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/118.jpg"},"name":"艾伦·佩吉","id":"1012520"}],"collect_count":904583,"original_title":"Inception","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1054524/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/673.jpg","large":"https://img3.doubanio.com/img/celebrity/large/673.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/673.jpg"},"name":"克里斯托弗·诺兰","id":"1054524"}],"year":"2010","images":{"small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p513344864.jpg","large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p513344864.jpg","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p513344864.jpg"},"alt":"https://movie.douban.com/subject/3541415/","id":"3541415"},{"rating":{"max":10,"average":9.3,"stars":"50","min":0},"genres":["喜剧","爱情","科幻"],"title":"机器人总动员","casts":[{"alt":"https://movie.douban.com/celebrity/1009535/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/13028.jpg","large":"https://img1.doubanio.com/img/celebrity/large/13028.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/13028.jpg"},"name":"本·贝尔特","id":"1009535"},{"alt":"https://movie.douban.com/celebrity/1000389/","avatars":{"small":"https://img5.doubanio.com/img/celebrity/small/1365856130.16.jpg","large":"https://img5.doubanio.com/img/celebrity/large/1365856130.16.jpg","medium":"https://img5.doubanio.com/img/celebrity/medium/1365856130.16.jpg"},"name":"艾丽莎·奈特","id":"1000389"},{"alt":"https://movie.douban.com/celebrity/1018022/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/31068.jpg","large":"https://img1.doubanio.com/img/celebrity/large/31068.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/31068.jpg"},"name":"杰夫·格尔林","id":"1018022"}],"collect_count":587108,"original_title":"WALL·E","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1036450/","avatars":{"small":"https://img5.doubanio.com/img/celebrity/small/1467359656.96.jpg","large":"https://img5.doubanio.com/img/celebrity/large/1467359656.96.jpg","medium":"https://img5.doubanio.com/img/celebrity/medium/1467359656.96.jpg"},"name":"安德鲁·斯坦顿","id":"1036450"}],"year":"2008","images":{"small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p449665982.jpg","large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p449665982.jpg","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p449665982.jpg"},"alt":"https://movie.douban.com/subject/2131459/","id":"2131459"}]
     * title : 豆瓣电影Top250
     */

    private int count;
    private int start;
    private int total;
    private String title;
    private List<SubjectsEntity> subjects;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SubjectsEntity> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectsEntity> subjects) {
        this.subjects = subjects;
    }

    public static class SubjectsEntity {
        @Override
        public String toString() {
            return "SubjectsEntity{" +
                    "rating=" + rating +
                    ", title='" + title + '\'' +
                    ", collect_count=" + collect_count +
                    ", original_title='" + original_title + '\'' +
                    ", subtype='" + subtype + '\'' +
                    ", year='" + year + '\'' +
                    ", images=" + images +
                    ", alt='" + alt + '\'' +
                    ", id='" + id + '\'' +
                    ", genres=" + genres +
                    ", casts=" + casts +
                    ", directors=" + directors +
                    '}';
        }

        /**
         * rating : {"max":10,"average":9.6,"stars":"50","min":0}
         * genres : ["犯罪","剧情"]
         * title : 肖申克的救赎
         * casts : [{"alt":"https://movie.douban.com/celebrity/1054521/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/17525.jpg","large":"https://img3.doubanio.com/img/celebrity/large/17525.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/17525.jpg"},"name":"蒂姆·罗宾斯","id":"1054521"},{"alt":"https://movie.douban.com/celebrity/1054534/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/34642.jpg","large":"https://img3.doubanio.com/img/celebrity/large/34642.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/34642.jpg"},"name":"摩根·弗里曼","id":"1054534"},{"alt":"https://movie.douban.com/celebrity/1041179/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/5837.jpg","large":"https://img1.doubanio.com/img/celebrity/large/5837.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/5837.jpg"},"name":"鲍勃·冈顿","id":"1041179"}]
         * collect_count : 1038013
         * original_title : The Shawshank Redemption
         * subtype : movie
         * directors : [{"alt":"https://movie.douban.com/celebrity/1047973/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/230.jpg","large":"https://img3.doubanio.com/img/celebrity/large/230.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/230.jpg"},"name":"弗兰克·德拉邦特","id":"1047973"}]
         * year : 1994
         * images : {"small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p480747492.jpg","large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p480747492.jpg","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p480747492.jpg"}
         * alt : https://movie.douban.com/subject/1292052/
         * id : 1292052
         */

        private RatingEntity rating;
        private String title;
        private int collect_count;
        private String original_title;
        private String subtype;
        private String year;
        private ImagesEntity images;
        private String alt;
        private String id;
        private List<String> genres;
        private List<CastsEntity> casts;
        private List<DirectorsEntity> directors;

        public RatingEntity getRating() {
            return rating;
        }

        public void setRating(RatingEntity rating) {
            this.rating = rating;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getCollect_count() {
            return collect_count;
        }

        public void setCollect_count(int collect_count) {
            this.collect_count = collect_count;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getSubtype() {
            return subtype;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public ImagesEntity getImages() {
            return images;
        }

        public void setImages(ImagesEntity images) {
            this.images = images;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<String> getGenres() {
            return genres;
        }

        public void setGenres(List<String> genres) {
            this.genres = genres;
        }

        public List<CastsEntity> getCasts() {
            return casts;
        }

        public void setCasts(List<CastsEntity> casts) {
            this.casts = casts;
        }

        public List<DirectorsEntity> getDirectors() {
            return directors;
        }

        public void setDirectors(List<DirectorsEntity> directors) {
            this.directors = directors;
        }

        public static class RatingEntity {
            /**
             * max : 10
             * average : 9.6
             * stars : 50
             * min : 0
             */

            private int max;
            private double average;
            private String stars;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public double getAverage() {
                return average;
            }

            public void setAverage(double average) {
                this.average = average;
            }

            public String getStars() {
                return stars;
            }

            public void setStars(String stars) {
                this.stars = stars;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        public static class ImagesEntity {
            /**
             * small : https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p480747492.jpg
             * large : https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p480747492.jpg
             * medium : https://img3.doubanio.com/view/movie_poster_cover/spst/public/p480747492.jpg
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }

        public static class CastsEntity {
            /**
             * alt : https://movie.douban.com/celebrity/1054521/
             * avatars : {"small":"https://img3.doubanio.com/img/celebrity/small/17525.jpg","large":"https://img3.doubanio.com/img/celebrity/large/17525.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/17525.jpg"}
             * name : 蒂姆·罗宾斯
             * id : 1054521
             */

            private String alt;
            private AvatarsEntity avatars;
            private String name;
            private String id;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public AvatarsEntity getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsEntity avatars) {
                this.avatars = avatars;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public static class AvatarsEntity {
                /**
                 * small : https://img3.doubanio.com/img/celebrity/small/17525.jpg
                 * large : https://img3.doubanio.com/img/celebrity/large/17525.jpg
                 * medium : https://img3.doubanio.com/img/celebrity/medium/17525.jpg
                 */

                private String small;
                private String large;
                private String medium;

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }
            }
        }

        public static class DirectorsEntity {
            /**
             * alt : https://movie.douban.com/celebrity/1047973/
             * avatars : {"small":"https://img3.doubanio.com/img/celebrity/small/230.jpg","large":"https://img3.doubanio.com/img/celebrity/large/230.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/230.jpg"}
             * name : 弗兰克·德拉邦特
             * id : 1047973
             */

            private String alt;
            private AvatarsEntityX avatars;
            private String name;
            private String id;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public AvatarsEntityX getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsEntityX avatars) {
                this.avatars = avatars;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public static class AvatarsEntityX {
                /**
                 * small : https://img3.doubanio.com/img/celebrity/small/230.jpg
                 * large : https://img3.doubanio.com/img/celebrity/large/230.jpg
                 * medium : https://img3.doubanio.com/img/celebrity/medium/230.jpg
                 */

                private String small;
                private String large;
                private String medium;

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }
            }
        }
    }
}
