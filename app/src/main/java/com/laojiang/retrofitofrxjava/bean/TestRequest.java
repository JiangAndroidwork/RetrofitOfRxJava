package com.laojiang.retrofitofrxjava.bean;

import com.google.gson.annotations.SerializedName;
import com.laojiang.retrofithttp.weight.bean.BaseReponseResult;

import java.util.List;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/3/13 11:17.
 */

public class TestRequest extends BaseReponseResult {
    @Override
    public String toString() {
        return "TestRequest{" +
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
                    "weekId=" + weekId +
                    ", classX=" + classX +
                    ", week='" + week + '\'' +
                    '}';
        }

        /**
         * weekId : 1
         * class : {"3":{"startTime":"09:50","id":7364,"classId":3,"name":"数学","class":"四年级1班","endTime":"10:35","type":"标准课程","classid":9},"2":{"startTime":"08:55","id":7245,"classId":2,"name":"数学","class":"二年级1班","endTime":"09:40","type":"标准课程","classid":7},"1":{"startTime":"08:00","id":7244,"classId":1,"name":"数学","class":"二年级1班","endTime":"08:45","type":"标准课程","classid":7},"6":{},"5":{},"4":{"startTime":"10:45","id":7365,"classId":4,"name":"数学","class":"四年级1班","endTime":"11:30","type":"标准课程","classid":9}}
         * week : 周一
         */

        private int weekId;
        @SerializedName("class")
        private ClassEntity classX;
        private String week;

        public int getWeekId() {
            return weekId;
        }

        public void setWeekId(int weekId) {
            this.weekId = weekId;
        }

        public ClassEntity getClassX() {
            return classX;
        }

        public void setClassX(ClassEntity classX) {
            this.classX = classX;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public static class ClassEntity {
            @Override
            public String toString() {
                return "ClassEntity{" +
                        "_$3=" + _$3 +
                        ", _$2=" + _$2 +
                        ", _$1=" + _$1 +
                        ", _$6=" + _$6 +
                        ", _$5=" + _$5 +
                        ", _$4=" + _$4 +
                        '}';
            }

            /**
             * 3 : {"startTime":"09:50","id":7364,"classId":3,"name":"数学","class":"四年级1班","endTime":"10:35","type":"标准课程","classid":9}
             * 2 : {"startTime":"08:55","id":7245,"classId":2,"name":"数学","class":"二年级1班","endTime":"09:40","type":"标准课程","classid":7}
             * 1 : {"startTime":"08:00","id":7244,"classId":1,"name":"数学","class":"二年级1班","endTime":"08:45","type":"标准课程","classid":7}
             * 6 : {}
             * 5 : {}
             * 4 : {"startTime":"10:45","id":7365,"classId":4,"name":"数学","class":"四年级1班","endTime":"11:30","type":"标准课程","classid":9}
             */

            @SerializedName("3")
            private _$3Entity _$3;
            @SerializedName("2")
            private _$2Entity _$2;
            @SerializedName("1")
            private _$1Entity _$1;
            @SerializedName("6")
            private _$6Entity _$6;
            @SerializedName("5")
            private _$5Entity _$5;
            @SerializedName("4")
            private _$4Entity _$4;

            public _$3Entity get_$3() {
                return _$3;
            }

            public void set_$3(_$3Entity _$3) {
                this._$3 = _$3;
            }

            public _$2Entity get_$2() {
                return _$2;
            }

            public void set_$2(_$2Entity _$2) {
                this._$2 = _$2;
            }

            public _$1Entity get_$1() {
                return _$1;
            }

            public void set_$1(_$1Entity _$1) {
                this._$1 = _$1;
            }

            public _$6Entity get_$6() {
                return _$6;
            }

            public void set_$6(_$6Entity _$6) {
                this._$6 = _$6;
            }

            public _$5Entity get_$5() {
                return _$5;
            }

            public void set_$5(_$5Entity _$5) {
                this._$5 = _$5;
            }

            public _$4Entity get_$4() {
                return _$4;
            }

            public void set_$4(_$4Entity _$4) {
                this._$4 = _$4;
            }

            public static class _$3Entity {
                @Override
                public String toString() {
                    return "_$3Entity{" +
                            "startTime='" + startTime + '\'' +
                            ", id=" + id +
                            ", classId=" + classId +
                            ", name='" + name + '\'' +
                            ", classX='" + classX + '\'' +
                            ", endTime='" + endTime + '\'' +
                            ", type='" + type + '\'' +
                            ", classid=" + classid +
                            '}';
                }

                /**
                 * startTime : 09:50
                 * id : 7364
                 * classId : 3
                 * name : 数学
                 * class : 四年级1班
                 * endTime : 10:35
                 * type : 标准课程
                 * classid : 9
                 */

                private String startTime;
                private int id;
                private int classId;
                private String name;
                @SerializedName("class")
                private String classX;
                private String endTime;
                private String type;
                private int classid;

                public String getStartTime() {
                    return startTime;
                }

                public void setStartTime(String startTime) {
                    this.startTime = startTime;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getClassId() {
                    return classId;
                }

                public void setClassId(int classId) {
                    this.classId = classId;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getClassX() {
                    return classX;
                }

                public void setClassX(String classX) {
                    this.classX = classX;
                }

                public String getEndTime() {
                    return endTime;
                }

                public void setEndTime(String endTime) {
                    this.endTime = endTime;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public int getClassid() {
                    return classid;
                }

                public void setClassid(int classid) {
                    this.classid = classid;
                }
            }

            public static class _$2Entity {
                @Override
                public String toString() {
                    return "_$2Entity{" +
                            "startTime='" + startTime + '\'' +
                            ", id=" + id +
                            ", classId=" + classId +
                            ", name='" + name + '\'' +
                            ", classX='" + classX + '\'' +
                            ", endTime='" + endTime + '\'' +
                            ", type='" + type + '\'' +
                            ", classid=" + classid +
                            '}';
                }

                /**
                 * startTime : 08:55
                 * id : 7245
                 * classId : 2
                 * name : 数学
                 * class : 二年级1班
                 * endTime : 09:40
                 * type : 标准课程
                 * classid : 7
                 */

                private String startTime;
                private int id;
                private int classId;
                private String name;
                @SerializedName("class")
                private String classX;
                private String endTime;
                private String type;
                private int classid;

                public String getStartTime() {
                    return startTime;
                }

                public void setStartTime(String startTime) {
                    this.startTime = startTime;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getClassId() {
                    return classId;
                }

                public void setClassId(int classId) {
                    this.classId = classId;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getClassX() {
                    return classX;
                }

                public void setClassX(String classX) {
                    this.classX = classX;
                }

                public String getEndTime() {
                    return endTime;
                }

                public void setEndTime(String endTime) {
                    this.endTime = endTime;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public int getClassid() {
                    return classid;
                }

                public void setClassid(int classid) {
                    this.classid = classid;
                }
            }

            public static class _$1Entity {
            }

            public static class _$6Entity {
            }

            public static class _$5Entity {
            }

            public static class _$4Entity {
                @Override
                public String toString() {
                    return "_$4Entity{" +
                            "startTime='" + startTime + '\'' +
                            ", id=" + id +
                            ", classId=" + classId +
                            ", name='" + name + '\'' +
                            ", classX='" + classX + '\'' +
                            ", endTime='" + endTime + '\'' +
                            ", type='" + type + '\'' +
                            ", classid=" + classid +
                            '}';
                }

                /**
                 * startTime : 10:45
                 * id : 7365
                 * classId : 4
                 * name : 数学
                 * class : 四年级1班
                 * endTime : 11:30
                 * type : 标准课程
                 * classid : 9
                 */

                private String startTime;
                private int id;
                private int classId;
                private String name;
                @SerializedName("class")
                private String classX;
                private String endTime;
                private String type;
                private int classid;

                public String getStartTime() {
                    return startTime;
                }

                public void setStartTime(String startTime) {
                    this.startTime = startTime;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getClassId() {
                    return classId;
                }

                public void setClassId(int classId) {
                    this.classId = classId;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getClassX() {
                    return classX;
                }

                public void setClassX(String classX) {
                    this.classX = classX;
                }

                public String getEndTime() {
                    return endTime;
                }

                public void setEndTime(String endTime) {
                    this.endTime = endTime;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public int getClassid() {
                    return classid;
                }

                public void setClassid(int classid) {
                    this.classid = classid;
                }
            }
        }
    }
}
