package com.laojiang.retrofitofrxjava;


import java.util.List;

import com.laojiang.retrofithttp.weight.bean.BaseReponse;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/3/9 10:21.
 */

public class TestBean extends BaseReponse {
    @Override
    public String toString() {
        return "TestBean{" +
                "result=" + result +
                '}';
    }

    private List<ResultEntity> result;

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
                    "id=" + id +
                    ", platId=" + platId +
                    ", semesterId=" + semesterId +
                    ", examname='" + examname + '\'' +
                    ", state=" + state +
                    ", istest=" + istest +
                    ", issystem=" + issystem +
                    ", schoolNo='" + schoolNo + '\'' +
                    ", studentNum=" + studentNum +
                    '}';
        }

        /**
         * id : 10
         * platId : 12
         * semesterId : 13
         * examname : 测试考号导出
         * state : 0
         * istest : 0
         * issystem : 0
         * schoolNo : 1611
         * studentNum : 8
         */

        private int id;
        private int platId;
        private int semesterId;
        private String examname;
        private int state;
        private int istest;
        private int issystem;
        private String schoolNo;
        private int studentNum;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPlatId() {
            return platId;
        }

        public void setPlatId(int platId) {
            this.platId = platId;
        }

        public int getSemesterId() {
            return semesterId;
        }

        public void setSemesterId(int semesterId) {
            this.semesterId = semesterId;
        }

        public String getExamname() {
            return examname;
        }

        public void setExamname(String examname) {
            this.examname = examname;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public int getIstest() {
            return istest;
        }

        public void setIstest(int istest) {
            this.istest = istest;
        }

        public int getIssystem() {
            return issystem;
        }

        public void setIssystem(int issystem) {
            this.issystem = issystem;
        }

        public String getSchoolNo() {
            return schoolNo;
        }

        public void setSchoolNo(String schoolNo) {
            this.schoolNo = schoolNo;
        }

        public int getStudentNum() {
            return studentNum;
        }

        public void setStudentNum(int studentNum) {
            this.studentNum = studentNum;
        }
    }
}
