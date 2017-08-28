package io.chicken.ggs.common.vo;

/**
 * Created by nyh on 8/28/17.
 */
public class TeacherList {
    private Integer id;
    private String teacherid;
    private String teaname;
    private String reasex;
    private String reaclass;
    private String teaschool;
    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public String getTeaname() {
        return teaname;
    }

    public void setTeaname(String teaname) {
        this.teaname = teaname;
    }

    public String getReasex() {
        return reasex;
    }

    public void setReasex(String reasex) {
        this.reasex = reasex;
    }

    public String getReaclass() {
        return reaclass;
    }

    public void setReaclass(String reaclass) {
        this.reaclass = reaclass;
    }

    public String getTeaschool() {
        return teaschool;
    }

    public void setTeaschool(String teaschool) {
        this.teaschool = teaschool;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
