package com.laojiang.retrofitofrxjava.bean;

import com.google.gson.annotations.SerializedName;
import com.laojiang.retrofithttp.weight.bean.BaseReponseResult;

import java.util.List;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/3/13 13:23.
 */

public class GetInfo extends BaseReponseResult {
    @Override
    public String toString() {
        return "GetInfo{" +
                "resultX=" + resultX +
                '}';
    }

    @SerializedName("result")
    private List<ResultEntity> resultX;

    public List<ResultEntity> getResultX() {
        return resultX;
    }

    public void setResultX(List<ResultEntity> resultX) {
        this.resultX = resultX;
    }

    public static class ResultEntity {
        @Override
        public String toString() {
            return "ResultEntity{" +
                    "exam_name='" + exam_name + '\'' +
                    ", exam_end_time='" + exam_end_time + '\'' +
                    ", exam_start_time='" + exam_start_time + '\'' +
                    ", examId=" + examId +
                    ", exam_my_count=" + exam_my_count +
                    ", exam_my_list=" + exam_my_list +
                    '}';
        }

        /**
         * exam_name : 新增考试
         * exam_my_list : [{"startDate":1488766140000,"exam_start_time":1488766140000,"codeMian":"","id":57,"plat_id":12,"exam_id":15,"codeDeputy":"","exam_end_time":1488773340000,"roomTeacherId":154,"name":"数学","teacherMian":"张亭宇","grade_id":8,"course_id":1,"courseName":"第一考场","room":101}]
         * exam_end_time : 2017-03-07 10:00:00.0
         * exam_start_time : 2017-03-06 10:00:00.0
         * examId : 15
         * exam_my_count : 1
         */

        private String exam_name;
        private String exam_end_time;
        private String exam_start_time;
        private int examId;
        private int exam_my_count;
        private List<ExamMyListEntity> exam_my_list;

        public String getExam_name() {
            return exam_name;
        }

        public void setExam_name(String exam_name) {
            this.exam_name = exam_name;
        }

        public String getExam_end_time() {
            return exam_end_time;
        }

        public void setExam_end_time(String exam_end_time) {
            this.exam_end_time = exam_end_time;
        }

        public String getExam_start_time() {
            return exam_start_time;
        }

        public void setExam_start_time(String exam_start_time) {
            this.exam_start_time = exam_start_time;
        }

        public int getExamId() {
            return examId;
        }

        public void setExamId(int examId) {
            this.examId = examId;
        }

        public int getExam_my_count() {
            return exam_my_count;
        }

        public void setExam_my_count(int exam_my_count) {
            this.exam_my_count = exam_my_count;
        }

        public List<ExamMyListEntity> getExam_my_list() {
            return exam_my_list;
        }

        public void setExam_my_list(List<ExamMyListEntity> exam_my_list) {
            this.exam_my_list = exam_my_list;
        }

        public static class ExamMyListEntity {
            /**
             * startDate : 1488766140000
             * exam_start_time : 1488766140000
             * codeMian :
             * id : 57
             * plat_id : 12
             * exam_id : 15
             * codeDeputy :
             * exam_end_time : 1488773340000
             * roomTeacherId : 154
             * name : 数学
             * teacherMian : 张亭宇
             * grade_id : 8
             * course_id : 1
             * courseName : 第一考场
             * room : 101
             */

            private long startDate;
            private long exam_start_time;
            private String codeMian;
            private int id;
            private int plat_id;
            private int exam_id;
            private String codeDeputy;
            private long exam_end_time;
            private int roomTeacherId;
            private String name;
            private String teacherMian;
            private int grade_id;
            private int course_id;
            private String courseName;
            private int room;

            public long getStartDate() {
                return startDate;
            }

            public void setStartDate(long startDate) {
                this.startDate = startDate;
            }

            public long getExam_start_time() {
                return exam_start_time;
            }

            public void setExam_start_time(long exam_start_time) {
                this.exam_start_time = exam_start_time;
            }

            public String getCodeMian() {
                return codeMian;
            }

            public void setCodeMian(String codeMian) {
                this.codeMian = codeMian;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getPlat_id() {
                return plat_id;
            }

            public void setPlat_id(int plat_id) {
                this.plat_id = plat_id;
            }

            public int getExam_id() {
                return exam_id;
            }

            public void setExam_id(int exam_id) {
                this.exam_id = exam_id;
            }

            public String getCodeDeputy() {
                return codeDeputy;
            }

            public void setCodeDeputy(String codeDeputy) {
                this.codeDeputy = codeDeputy;
            }

            public long getExam_end_time() {
                return exam_end_time;
            }

            public void setExam_end_time(long exam_end_time) {
                this.exam_end_time = exam_end_time;
            }

            public int getRoomTeacherId() {
                return roomTeacherId;
            }

            public void setRoomTeacherId(int roomTeacherId) {
                this.roomTeacherId = roomTeacherId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTeacherMian() {
                return teacherMian;
            }

            public void setTeacherMian(String teacherMian) {
                this.teacherMian = teacherMian;
            }

            public int getGrade_id() {
                return grade_id;
            }

            public void setGrade_id(int grade_id) {
                this.grade_id = grade_id;
            }

            public int getCourse_id() {
                return course_id;
            }

            public void setCourse_id(int course_id) {
                this.course_id = course_id;
            }

            public String getCourseName() {
                return courseName;
            }

            public void setCourseName(String courseName) {
                this.courseName = courseName;
            }

            public int getRoom() {
                return room;
            }

            public void setRoom(int room) {
                this.room = room;
            }
        }
    }
}
