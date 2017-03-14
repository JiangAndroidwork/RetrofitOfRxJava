package com.laojiang.retrofitofrxjava.bean;

import java.util.List;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/3/14 8:25.
 */

public class TestHomeWork {

    @Override
    public String toString() {
        return "TestHomeWork{" +
                "code='" + code + '\'' +
                ", msg=" + msg +
                ", result=" + result +
                '}';
    }

    /**
     * code : 1
     * msg : null
     * result : [{"class_id":7,"course_name":"数学","course_id":1,"class_name":"二年级1班"},{"class_id":9,"course_name":"数学","course_id":1,"class_name":"四年级1班"}]
     */

    private String code;
    private Object msg;
    private List<ResultEntity> result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public List<ResultEntity> getResult() {
        return result;
    }

    public void setResult(List<ResultEntity> result) {
        this.result = result;
    }

    public static class ResultEntity {
        @Override
        public String toString() {
            return "ResultEntity{" +
                    "class_id=" + class_id +
                    ", course_name='" + course_name + '\'' +
                    ", course_id=" + course_id +
                    ", class_name='" + class_name + '\'' +
                    '}';
        }

        /**
         * class_id : 7
         * course_name : 数学
         * course_id : 1
         * class_name : 二年级1班
         */

        private int class_id;
        private String course_name;
        private int course_id;
        private String class_name;

        public int getClass_id() {
            return class_id;
        }

        public void setClass_id(int class_id) {
            this.class_id = class_id;
        }

        public String getCourse_name() {
            return course_name;
        }

        public void setCourse_name(String course_name) {
            this.course_name = course_name;
        }

        public int getCourse_id() {
            return course_id;
        }

        public void setCourse_id(int course_id) {
            this.course_id = course_id;
        }

        public String getClass_name() {
            return class_name;
        }

        public void setClass_name(String class_name) {
            this.class_name = class_name;
        }
    }
}
