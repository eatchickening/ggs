package io.chicken.ggs.dal.model;

public class Student {
    private Long id;

    private String studentid;

    private String name;

    private String sex;

    private String award;

    private String score;

    private String moral;

    private String intellectual;

    private String physical;

    private String schoolcode;
    private String  schoolname;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid == null ? null : studentid.trim();
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

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award == null ? null : award.trim();
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    public String getMoral() {
        return moral;
    }

    public void setMoral(String moral) {
        this.moral = moral == null ? null : moral.trim();
    }

    public String getIntellectual() {
        return intellectual;
    }

    public void setIntellectual(String intellectual) {
        this.intellectual = intellectual == null ? null : intellectual.trim();
    }

    public String getPhysical() {
        return physical;
    }

    public void setPhysical(String physical) {
        this.physical = physical == null ? null : physical.trim();
    }

    public String getSchoolcode() {
        return schoolcode;
    }

    public void setSchoolcode(String schoolcode) {
        this.schoolcode = schoolcode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }
}