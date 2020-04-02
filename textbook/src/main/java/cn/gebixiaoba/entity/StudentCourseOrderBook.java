package cn.gebixiaoba.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2020/3/26.
 */
public class StudentCourseOrderBook implements Serializable {

    private String caption;

    private String name;

    private String time;

    private String term;

    private int courseid;

    private static final long serialVersionUID = 1L;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }
}
