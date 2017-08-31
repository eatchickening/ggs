package io.chicken.ggs.dal.model;

import java.io.Serializable;

public class Depart implements Serializable {
    private static final long serialVersionUID = 7522962744996835368L;

    private Long id;

    private String departcode;

    private String name;

    private String organcode;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartcode() {
        return departcode;
    }

    public void setDepartcode(String departcode) {
        this.departcode = departcode == null ? null : departcode.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getOrgancode() {
        return organcode;
    }

    public void setOrgancode(String organcode) {
        this.organcode = organcode == null ? null : organcode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        return "Depart{" +
                "id=" + id +
                ", departcode='" + departcode + '\'' +
                ", name='" + name + '\'' +
                ", organcode='" + organcode + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}