package io.chicken.ggs.common.vo;

import java.util.List;

public class OrganVo {

    private Integer organId;

    private String organcode;

    private String organName;

    List<DepartVo> departVoList;

    public Integer getOrganId() {
        return organId;
    }

    public void setOrganId(Integer organId) {
        this.organId = organId;
    }

    public String getOrgancode() {
        return organcode;
    }

    public void setOrgancode(String organcode) {
        this.organcode = organcode;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public List<DepartVo> getDepartVoList() {
        return departVoList;
    }

    public void setDepartVoList(List<DepartVo> departVoList) {
        this.departVoList = departVoList;
    }

    @Override
    public String toString() {
        return "OrganVo{" +
                "organId=" + organId +
                ", organcode='" + organcode + '\'' +
                ", organName='" + organName + '\'' +
                ", departVoList=" + departVoList +
                '}';
    }
}
