package com.mvcdemo.mvcdemo.entity;

public class Student {
    private int sid;
    private String sname;
    private String major;
    private int sage;
    private int status;

    public Student(int sid, String sname, String major, int sage, int status) {
        this.sid = sid;
        this.sname = sname;
        this.major = major;
        this.sage = sage;
        this.status = status;
    }
    public Student(){}

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", major='" + major + '\'' +
                ", sage=" + sage +
                ", status=" + status +
                '}';
    }
}
