package cn.gebixiaoba.entity;

import java.io.Serializable;

/**
 * T_Course
 * @author 
 */
public class Course implements Serializable {
    /**
     * 课程名称
     */
    private Integer courseid;

    private String caption;

    /**
     * 授课教师
     */
    private String teacher;

    /**
     * 教材ISBN编号
     */
    private String textbook;

    /**
     * 授课学期
     */
    private String term;

    /**
     * 授课时间段
     */
    private String time;

    private static final long serialVersionUID = 1L;

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTextbook() {
        return textbook;
    }

    public void setTextbook(String textbook) {
        this.textbook = textbook;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Course other = (Course) that;
        return (this.getCourseid() == null ? other.getCourseid() == null : this.getCourseid().equals(other.getCourseid()))
            && (this.getCaption() == null ? other.getCaption() == null : this.getCaption().equals(other.getCaption()))
            && (this.getTeacher() == null ? other.getTeacher() == null : this.getTeacher().equals(other.getTeacher()))
            && (this.getTextbook() == null ? other.getTextbook() == null : this.getTextbook().equals(other.getTextbook()))
            && (this.getTerm() == null ? other.getTerm() == null : this.getTerm().equals(other.getTerm()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCourseid() == null) ? 0 : getCourseid().hashCode());
        result = prime * result + ((getCaption() == null) ? 0 : getCaption().hashCode());
        result = prime * result + ((getTeacher() == null) ? 0 : getTeacher().hashCode());
        result = prime * result + ((getTextbook() == null) ? 0 : getTextbook().hashCode());
        result = prime * result + ((getTerm() == null) ? 0 : getTerm().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", courseid=").append(courseid);
        sb.append(", caption=").append(caption);
        sb.append(", teacher=").append(teacher);
        sb.append(", textbook=").append(textbook);
        sb.append(", term=").append(term);
        sb.append(", time=").append(time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}