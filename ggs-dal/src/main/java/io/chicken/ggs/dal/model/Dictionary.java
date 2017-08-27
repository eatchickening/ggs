package io.chicken.ggs.dal.model;

public class Dictionary {
    private Long id;

    private String biztype;

    private String bizcode;

    private String datavalue;

    private Byte status;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBiztype() {
        return biztype;
    }

    public void setBiztype(String biztype) {
        this.biztype = biztype == null ? null : biztype.trim();
    }

    public String getBizcode() {
        return bizcode;
    }

    public void setBizcode(String bizcode) {
        this.bizcode = bizcode == null ? null : bizcode.trim();
    }

    public String getDatavalue() {
        return datavalue;
    }

    public void setDatavalue(String datavalue) {
        this.datavalue = datavalue == null ? null : datavalue.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "id=" + id +
                ", biztype='" + biztype + '\'' +
                ", bizcode='" + bizcode + '\'' +
                ", datavalue='" + datavalue + '\'' +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                '}';
    }
}