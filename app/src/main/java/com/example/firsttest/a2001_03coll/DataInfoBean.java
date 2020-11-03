package com.example.firsttest.a2001_03coll;

import java.util.List;

public class DataInfoBean {

    /**
     * data : {"curPage":1,"datas":[{"author":"扔物线","chapterId":249,"chapterName":"干货资源","courseId":13,"desc":"","envelopePic":"","id":160390,"link":"https://www.bilibili.com/video/BV1CA41177Se","niceDate":"10小时前","origin":"","originId":12554,"publishTime":1603935097000,"title":"Android 面试黑洞&mdash;&mdash;当我按下 Home 键再切回来，会发生什么？","userId":80317,"visible":0,"zan":0},{"author":"wangjianxiandev","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"简单天气APP，使用彩云天气api，使用Kotlin语言基于MVVM模式结合JetPack组件库：LiveData、ViewModel、Lifecycle、Navigation、Room组件，以及使用协程+Retrofit进行网络请求 开发的一款天气app","envelopePic":"https://www.wanandroid.com/blogimgs/1493b21f-34d7-4e0f-b33d-1ebe1b432691.png","id":160387,"link":"http://www.wanandroid.com/blog/show/2786","niceDate":"10小时前","origin":"","originId":15181,"publishTime":1603934286000,"title":"简单天气--Kotlin+JetPack+协程+MVVM架构","userId":80317,"visible":0,"zan":0},{"author":"Ruheng","chapterId":26,"chapterName":"基础UI控件","courseId":13,"desc":"详解Android图文混排实现。","envelopePic":"","id":160386,"link":"http://www.jianshu.com/p/6843f332c8df","niceDate":"10小时前","origin":"","originId":1165,"publishTime":1603934187000,"title":"Android图文混排实现方式详解","userId":80317,"visible":0,"zan":0}],"offset":0,"over":true,"pageCount":1,"size":20,"total":3}
     * errorCode : 0
     * errorMsg :
     */

    private DataBean data;
    private int errorCode;
    private String errorMsg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static class DataBean {
        /**
         * curPage : 1
         * datas : [{"author":"扔物线","chapterId":249,"chapterName":"干货资源","courseId":13,"desc":"","envelopePic":"","id":160390,"link":"https://www.bilibili.com/video/BV1CA41177Se","niceDate":"10小时前","origin":"","originId":12554,"publishTime":1603935097000,"title":"Android 面试黑洞&mdash;&mdash;当我按下 Home 键再切回来，会发生什么？","userId":80317,"visible":0,"zan":0},{"author":"wangjianxiandev","chapterId":294,"chapterName":"完整项目","courseId":13,"desc":"简单天气APP，使用彩云天气api，使用Kotlin语言基于MVVM模式结合JetPack组件库：LiveData、ViewModel、Lifecycle、Navigation、Room组件，以及使用协程+Retrofit进行网络请求 开发的一款天气app","envelopePic":"https://www.wanandroid.com/blogimgs/1493b21f-34d7-4e0f-b33d-1ebe1b432691.png","id":160387,"link":"http://www.wanandroid.com/blog/show/2786","niceDate":"10小时前","origin":"","originId":15181,"publishTime":1603934286000,"title":"简单天气--Kotlin+JetPack+协程+MVVM架构","userId":80317,"visible":0,"zan":0},{"author":"Ruheng","chapterId":26,"chapterName":"基础UI控件","courseId":13,"desc":"详解Android图文混排实现。","envelopePic":"","id":160386,"link":"http://www.jianshu.com/p/6843f332c8df","niceDate":"10小时前","origin":"","originId":1165,"publishTime":1603934187000,"title":"Android图文混排实现方式详解","userId":80317,"visible":0,"zan":0}]
         * offset : 0
         * over : true
         * pageCount : 1
         * size : 20
         * total : 3
         */

        private int curPage;
        private int offset;
        private boolean over;
        private int pageCount;
        private int size;
        private int total;
        private List<DatasBean> datas;

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public boolean isOver() {
            return over;
        }

        public void setOver(boolean over) {
            this.over = over;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public static class DatasBean {
            /**
             * author : 扔物线
             * chapterId : 249
             * chapterName : 干货资源
             * courseId : 13
             * desc :
             * envelopePic :
             * id : 160390
             * link : https://www.bilibili.com/video/BV1CA41177Se
             * niceDate : 10小时前
             * origin :
             * originId : 12554
             * publishTime : 1603935097000
             * title : Android 面试黑洞&mdash;&mdash;当我按下 Home 键再切回来，会发生什么？
             * userId : 80317
             * visible : 0
             * zan : 0
             */

            private String author;
            private int chapterId;
            private String chapterName;
            private int courseId;
            private String desc;
            private String envelopePic;
            private int id;
            private String link;
            private String niceDate;
            private String origin;
            private int originId;
            private long publishTime;
            private String title;
            private int userId;
            private int visible;
            private int zan;

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public int getChapterId() {
                return chapterId;
            }

            public void setChapterId(int chapterId) {
                this.chapterId = chapterId;
            }

            public String getChapterName() {
                return chapterName;
            }

            public void setChapterName(String chapterName) {
                this.chapterName = chapterName;
            }

            public int getCourseId() {
                return courseId;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getEnvelopePic() {
                return envelopePic;
            }

            public void setEnvelopePic(String envelopePic) {
                this.envelopePic = envelopePic;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getNiceDate() {
                return niceDate;
            }

            public void setNiceDate(String niceDate) {
                this.niceDate = niceDate;
            }

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public int getOriginId() {
                return originId;
            }

            public void setOriginId(int originId) {
                this.originId = originId;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getVisible() {
                return visible;
            }

            public void setVisible(int visible) {
                this.visible = visible;
            }

            public int getZan() {
                return zan;
            }

            public void setZan(int zan) {
                this.zan = zan;
            }
        }
    }
}
