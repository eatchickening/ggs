package io.chicken.ggs.dal.model;

import java.io.Serializable;

public class Teacher implements Serializable {
    private static final long serialVersionUID = -5248840726391286939L;

    private Long id;

    private String teacherid;

    private String name;

    private String sex;

    private String classname;

    private String schoolId;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid == null ? null : teacherid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId == null ? null : schoolId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teacherid='" + teacherid + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", classname='" + classname + '\'' +
                ", schoolId='" + schoolId + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}