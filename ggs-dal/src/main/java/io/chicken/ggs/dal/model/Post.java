package io.chicken.ggs.dal.model;

import java.io.Serializable;

public class Post implements Serializable {
    private static final long serialVersionUID = -9132709922943299800L;

    private Long id;

    private String postcode;

    private String name;

    private String departcode;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDepartcode() {
        return departcode;
    }

    public void setDepartcode(String departcode) {
        this.departcode = departcode == null ? null : departcode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", postcode='" + postcode + '\'' +
                ", name='" + name + '\'' +
                ", departcode='" + departcode + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}