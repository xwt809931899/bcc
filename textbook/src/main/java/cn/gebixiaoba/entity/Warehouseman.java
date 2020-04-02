package cn.gebixiaoba.entity;

import java.io.Serializable;

/**
 * T_Warehouseman
 * @author 
 */
public class Warehouseman implements Serializable {
    private String warehousemanid;

    private String name;

    private String password;

    private Boolean gender;

    private static final long serialVersionUID = 1L;

    public String getWarehousemanid() {
        return warehousemanid;
    }

    public void setWarehousemanid(String warehousemanid) {
        this.warehousemanid = warehousemanid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
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
        Warehouseman other = (Warehouseman) that;
        return (this.getWarehousemanid() == null ? other.getWarehousemanid() == null : this.getWarehousemanid().equals(other.getWarehousemanid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWarehousemanid() == null) ? 0 : getWarehousemanid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", warehousemanid=").append(warehousemanid);
        sb.append(", name=").append(name);
        sb.append(", password=").append(password);
        sb.append(", gender=").append(gender);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}