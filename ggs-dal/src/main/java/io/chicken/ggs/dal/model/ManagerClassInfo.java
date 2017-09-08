package io.chicken.ggs.dal.model;

import java.io.Serializable;

public class ManagerClassInfo implements Serializable {
    private static final long serialVersionUID = 3381095860040182344L;

    private Long id;

    private String teacherid;

    private String classcode;

    private String schoolcode;

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

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode == null ? null : classcode.trim();
    }

    public String getSchoolcode() {
        return schoolcode;
    }

    public void setSchoolcode(String schoolcode) {
        this.schoolcode = schoolcode == null ? null : schoolcode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}