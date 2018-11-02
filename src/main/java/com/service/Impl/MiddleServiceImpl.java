package com.service.Impl;

import com.bean.Middle;
import com.dao.MiddleMapper;
import com.service.MiddleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MiddleServiceImpl implements MiddleService {
    @Autowired
    private MiddleMapper middleMapper;
    @Override
    public int deleteByPrimaryKey(Integer middleid) {
        return 0;
    }

    @Override
    public int insert(Middle record) {
        return 0;
    }

    @Override
    public int insertSelective(Middle record) {
        return 0;
    }

    @Override
    public Middle selectByPrimaryKey(Integer middleid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Middle record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Middle record) {
        return 0;
    }

    @Override
    public int insertRM(Map map) {
        System.out.println("===="+middleMapper);
        System.out.println(map.get("roleid"));
        int[] ids=(int[])map.get("ids");
        for (int id : ids) {
            System.out.println(id);
        }
        int k=middleMapper.insertMiddle(map);
        System.out.println("受影响:"+k );
        return k;
    }


    @Override
    public int updateMiddle(int roleid, int[] menuids) {
        int ms = middleMapper.deleteByroleid(roleid);
        Map map=new HashMap<>();
        for (int m : menuids) {
            System.out.println("middleservice"+m);
        }
        map.put("roleid",roleid);
        map.put("ids",menuids);
        int is=middleMapper.insertMiddle(map);
        if(ms==1&&is>=1){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public int deleteByRoleid(Integer roleid) {
        return middleMapper.deleteByroleid(roleid);
    }

    @Override
    public List<Middle> selectByRoleid(Integer roleid) {
        return middleMapper.selectByRoleid(roleid);
    }

    @Override
    public List<Middle> selectByField(Map map) {
        return middleMapper.selectByField(map);
    }

    @Override
    public int deleteByField(Map map) {
        return middleMapper.deleteByField(map);
    }
}
