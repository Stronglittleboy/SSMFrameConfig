package com.bean;

import java.util.Date;

public class Information{
    private Integer informationid;
    private String informationname;
    private Integer infoid;
    private Date date;
    private String filetype;
    private String uploader;
    private String path;
    private Infotype infotype;

    public Integer getInformationid() {
        return informationid;
    }

    public void setInformationid(Integer informationid) {
        this.informationid = informationid;
    }

    public String getInformationname() {
        return informationname;
    }

    public void setInformationname(String informationname) {
        this.informationname = informationname;
    }

    public Integer getInfoid() {
        return infoid;
    }

    public void setInfoid(Integer infoid) {
        this.infoid = infoid== null ? null : infoid;;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Infotype getInfotype() {
        return infotype;
    }

    public void setInfotype(Infotype infotype) {
        this.infotype = infotype;
    }
}
