package com.dao;

import com.bean.Books;
import com.bean.Leavebill;

import java.util.List;
import java.util.Map;

public interface LeavebillMapper {
    //    根据指定字段获取请假列表
    public List<Leavebill> getallbyfield(Map map);
    //    删除请假列表
    public int delete(int id);
    //    修改请假
    public int update(Leavebill leavebill);
//    添加
    public int insert(Leavebill leavebill);
}