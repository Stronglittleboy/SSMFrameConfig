package com.service.Impl;

import com.bean.Classes;
import com.bean.Student;
import com.dao.ClassesMapper;
import com.dao.StudentMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ClassesMapper classesMapper;
    @Override
    public int deleteByPrimaryKey(Integer studentid) {
        return 0;
    }

    @Override
    public int insert(Student record) {
        return 0;
    }

    @Override
    public int insertSelective(Student record) {
        return 0;
    }

    @Override
    public Student selectByPrimaryKey(Integer studentid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Student record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return 0;
    }

    @Override
    @Transactional
    public Classes getStuClass(int UserId) {
        System.out.println("jinru");
        System.out.println(UserId);
        Student student = studentMapper.selectByPrimaryKey(UserId);
        System.out.println(student.getClassid()+"=====");
        Integer classid = student.getClassid();
        Classes classes = classesMapper.selectByPrimaryKey(classid);
        System.out.println(classes);
        return classes;
    }

    @Override
    public PageInfo getall(String stuname, String studentno, Integer stusex, int pageindex, int size, int[] ids, String stustate) {
        //封装模糊查条件
        Map map=new HashMap();
        map.put("stuname",stuname);
        map.put("studentno",studentno);
        map.put("stusex",stusex);
        map.put("ids",ids);
        map.put("stustate",stustate);
        PageHelper.startPage(pageindex,size);
        List list= studentMapper.getall(map);
        for (Object o : list) {
            Student s= (Student) o;
            System.out.println("service-=0-0="+o);
        }
        PageInfo pi=new PageInfo(list);
        return pi;
    }
}
