package cn.gebixiaoba.entity;

import java.io.Serializable;

/**
 * T_Student
 * @author 
 */
public class Student implements Serializable {
    private String stuid;

    private String name;

    private Boolean gender;

    private String clazz;

    private Integer faculty;

    private String password;

    private static final long serialVersionUID = 1L;

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public Integer getFaculty() {
        return faculty;
    }

    public void setFaculty(Integer faculty) {
        this.faculty = faculty;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        Student other = (Student) that;
        return (this.getStuid() == null ? other.getStuid() == null : this.getStuid().equals(other.getStuid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getClazz() == null ? other.getClazz() == null : this.getClazz().equals(other.getClazz()))
            && (this.getFaculty() == null ? other.getFaculty() == null : this.getFaculty().equals(other.getFaculty()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStuid() == null) ? 0 : getStuid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getClazz() == null) ? 0 : getClazz().hashCode());
        result = prime * result + ((getFaculty() == null) ? 0 : getFaculty().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stuid=").append(stuid);
        sb.append(", name=").append(name);
        sb.append(", gender=").append(gender);
        sb.append(", clazz=").append(clazz);
        sb.append(", faculty=").append(faculty);
        sb.append(", password=").append(password);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}