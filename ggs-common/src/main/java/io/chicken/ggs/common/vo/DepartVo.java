package io.chicken.ggs.common.vo;

import java.util.List;

public class DepartVo {
    private Integer departId;

    private String departcode;

    private String departName;

    List<Post> post;

    public Integer getDepartId() {
        return departId;
    }

    public void setDepartId(Integer departId) {
        this.departId = departId;
    }

    public String getDepartcode() {
        return departcode;
    }

    public void setDepartcode(String departcode) {
        this.departcode = departcode;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "DepartVo{" +
                "departId=" + departId +
                ", departcode='" + departcode + '\'' +
                ", departName='" + departName + '\'' +
                ", post=" + post +
                '}';
    }
}
