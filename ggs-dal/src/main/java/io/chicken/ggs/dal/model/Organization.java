package io.chicken.ggs.dal.model;

import java.io.Serializable;

public class Organization implements Serializable {
    private static final long serialVersionUID = 6382528199140572450L;

    private Long id;

    private String organcode;

    private String name;

    private String areacode;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgancode() {
        return organcode;
    }

    public void setOrgancode(String organcode) {
        this.organcode = organcode == null ? null : organcode.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode == null ? null : areacode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", organcode='" + organcode + '\'' +
                ", name='" + name + '\'' +
                ", areacode='" + areacode + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}