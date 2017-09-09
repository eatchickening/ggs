package io.chicken.ggs.common.vo;

public class ClassInfoVo {


    private String classname;
    private String schoolcode;
    private String classlevel;
    private String classcode;



    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getSchoolcode() {
        return schoolcode;
    }

    public void setSchoolcode(String schoolcode) {
        this.schoolcode = schoolcode;
    }

    public String getClasslevel() {
        return classlevel;
    }

    public void setClasslevel(String classlevel) {
        this.classlevel = classlevel;
    }

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode;
    }

    @Override
    public String toString() {
        return "ClassInfoVo{" +
                ", classname='" + classname + '\'' +
                ", schoolcode='" + schoolcode + '\'' +
                ", classlevel='" + classlevel + '\'' +
                ", classcode='" + classcode + '\'' +
                '}';
    }
}