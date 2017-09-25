package com.laojiang.retrofitofrxjava.bean;

import com.google.gson.annotations.SerializedName;
import com.laojiang.retrofithttp.weight.bean.BaseReponseResult;

/**
 * 类介绍（必填）：登录接口
 * Created by Jiang on 2017/8/21 .
 */

public class ESLoginBean extends BaseReponseResult {

    @Override
    public String toString() {
        return "ESLoginBean{" +
                "message='" + message + '\'' +
                ", resultX=" + resultX +
                '}';
    }

    /**
     * message :
     * result : {"id":9,"name":"李琳","username":"lilin","userType":1,"loginIp":null,"userFace":"http://image.meetyuu.com/userface/2017-08-17/2e7bcc4d-a4a7-4c47-a640-dfc89cad6a85.png","loginTime":0,"accessToken":"9001322B6BCB2B8E5675581AC403D143","flag":0,"easemobAccount":"U9","easemobPassword":"syidkds3","companyId":100000,"companyType":2,"companyName":"怀教网络","companySize":1,"adminFlag":false,"gradeId":null,"gradeName":null,"classId":null,"className":null}
     */

    private String message;
    @SerializedName("result")
    private ResultEntity resultX;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultEntity getResultX() {
        return resultX;
    }

    public void setResultX(ResultEntity resultX) {
        this.resultX = resultX;
    }

    public static class ResultEntity {
        @Override
        public String toString() {
            return "ResultEntity{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", username='" + username + '\'' +
                    ", userType=" + userType +
                    ", loginIp=" + loginIp +
                    ", userFace='" + userFace + '\'' +
                    ", loginTime=" + loginTime +
                    ", accessToken='" + accessToken + '\'' +
                    ", flag=" + flag +
                    ", easemobAccount='" + easemobAccount + '\'' +
                    ", easemobPassword='" + easemobPassword + '\'' +
                    ", companyId=" + companyId +
                    ", companyType=" + companyType +
                    ", companyName='" + companyName + '\'' +
                    ", companySize=" + companySize +
                    ", adminFlag=" + adminFlag +
                    ", gradeId=" + gradeId +
                    ", gradeName=" + gradeName +
                    ", classId=" + classId +
                    ", className=" + className +
                    '}';
        }

        /**
         * id : 9
         * name : 李琳
         * username : lilin
         * userType : 1
         * loginIp : null
         * userFace : http://image.meetyuu.com/userface/2017-08-17/2e7bcc4d-a4a7-4c47-a640-dfc89cad6a85.png
         * loginTime : 0
         * accessToken : 9001322B6BCB2B8E5675581AC403D143
         * flag : 0
         * easemobAccount : U9
         * easemobPassword : syidkds3
         * companyId : 100000
         * companyType : 2
         * companyName : 怀教网络
         * companySize : 1
         * adminFlag : false
         * gradeId : null
         * gradeName : null
         * classId : null
         * className : null
         */

        private int id;
        private String name;
        private String username;
        private int userType;
        private Object loginIp;
        private String userFace;
        private int loginTime;
        private String accessToken;
        private int flag;
        private String easemobAccount;
        private String easemobPassword;
        private int companyId;
        private int companyType;
        private String companyName;
        private int companySize;
        private boolean adminFlag;
        private Object gradeId;
        private Object gradeName;
        private Object classId;
        private Object className;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public Object getLoginIp() {
            return loginIp;
        }

        public void setLoginIp(Object loginIp) {
            this.loginIp = loginIp;
        }

        public String getUserFace() {
            return userFace;
        }

        public void setUserFace(String userFace) {
            this.userFace = userFace;
        }

        public int getLoginTime() {
            return loginTime;
        }

        public void setLoginTime(int loginTime) {
            this.loginTime = loginTime;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public String getEasemobAccount() {
            return easemobAccount;
        }

        public void setEasemobAccount(String easemobAccount) {
            this.easemobAccount = easemobAccount;
        }

        public String getEasemobPassword() {
            return easemobPassword;
        }

        public void setEasemobPassword(String easemobPassword) {
            this.easemobPassword = easemobPassword;
        }

        public int getCompanyId() {
            return companyId;
        }

        public void setCompanyId(int companyId) {
            this.companyId = companyId;
        }

        public int getCompanyType() {
            return companyType;
        }

        public void setCompanyType(int companyType) {
            this.companyType = companyType;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public int getCompanySize() {
            return companySize;
        }

        public void setCompanySize(int companySize) {
            this.companySize = companySize;
        }

        public boolean isAdminFlag() {
            return adminFlag;
        }

        public void setAdminFlag(boolean adminFlag) {
            this.adminFlag = adminFlag;
        }

        public Object getGradeId() {
            return gradeId;
        }

        public void setGradeId(Object gradeId) {
            this.gradeId = gradeId;
        }

        public Object getGradeName() {
            return gradeName;
        }

        public void setGradeName(Object gradeName) {
            this.gradeName = gradeName;
        }

        public Object getClassId() {
            return classId;
        }

        public void setClassId(Object classId) {
            this.classId = classId;
        }

        public Object getClassName() {
            return className;
        }

        public void setClassName(Object className) {
            this.className = className;
        }
    }
}
