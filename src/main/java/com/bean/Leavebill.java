package com.bean;


import java.util.Date;

public class Leavebill {

  private Integer id;
  private Integer days;
  private String content;
  private Date date;
  private String remark;
  private UserTb userTb;
  private Integer state;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getDays() {
    return days;
  }

  public void setDays(Integer days) {
    this.days = days;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public UserTb getUserTb() {
    return userTb;
  }

  public void setUserTb(UserTb userTb) {
    this.userTb = userTb;
  }

  public Integer getState() {
    return state;
  }

  public void setState(Integer state) {
    this.state = state;
  }
}
