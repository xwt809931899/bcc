package cn.gebixiaoba.entity;

import java.io.Serializable;

/**
 * T_SelectCourse
 * @author 
 */
public class Selectcourse implements Serializable {
    private String stuid;

    private Integer courseid;

    private Boolean isorderbook;

    private static final long serialVersionUID = 1L;

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public Boolean getIsorderbook() {
        return isorderbook;
    }

    public void setIsorderbook(Boolean isorderbook) {
        this.isorderbook = isorderbook;
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
        Selectcourse other = (Selectcourse) that;
        return (this.getStuid() == null ? other.getStuid() == null : this.getStuid().equals(other.getStuid()))
            && (this.getCourseid() == null ? other.getCourseid() == null : this.getCourseid().equals(other.getCourseid()))
            && (this.getIsorderbook() == null ? other.getIsorderbook() == null : this.getIsorderbook().equals(other.getIsorderbook()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStuid() == null) ? 0 : getStuid().hashCode());
        result = prime * result + ((getCourseid() == null) ? 0 : getCourseid().hashCode());
        result = prime * result + ((getIsorderbook() == null) ? 0 : getIsorderbook().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stuid=").append(stuid);
        sb.append(", courseid=").append(courseid);
        sb.append(", isorderbook=").append(isorderbook);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}