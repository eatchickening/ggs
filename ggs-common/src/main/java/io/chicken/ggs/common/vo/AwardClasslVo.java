package io.chicken.ggs.common.vo;

public class AwardClasslVo {
    private Long id;
    private String schoolcode;

    private String classcode;

    private Integer classquota;

    private String remark;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode;
    }

    public Integer getClassquota() {
        return classquota;
    }

    public void setClassquota(Integer classquota) {
        this.classquota = classquota;
    }

    @Override
    public String toString() {
        return "AwardClasslVo{" +
                "id=" + id +
                ", schoolcode='" + schoolcode + '\'' +
                ", classcode='" + classcode + '\'' +
                ", classquota=" + classquota +
                ", remark='" + remark + '\'' +
                '}';
    }
}