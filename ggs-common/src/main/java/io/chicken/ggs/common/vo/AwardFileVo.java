package io.chicken.ggs.common.vo;

import org.springframework.web.multipart.MultipartFile;

public class AwardFileVo {
    private Long id;
    private String filename;

    private String filetargetname;

    private String filetype;

    private String filepath;

    private String filedetail;

    private String remark;

   // private MultipartFile file;


    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getFiledetail() {
        return filedetail;
    }

    public void setFiledetail(String filedetail) {
        this.filedetail = filedetail;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

  /*  public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }*/

    public String getFiletargetname() {
        return filetargetname;
    }

    public void setFiletargetname(String filetargetname) {
        this.filetargetname = filetargetname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AwardFileVo{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", filetargetname='" + filetargetname + '\'' +
                ", filetype='" + filetype + '\'' +
                ", filepath='" + filepath + '\'' +
                ", filedetail='" + filedetail + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
