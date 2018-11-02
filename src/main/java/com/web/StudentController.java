package com.web;

import com.bean.Student;
import com.github.pagehelper.PageInfo;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @RequestMapping("Educational/student/getstulist")
    public String getstulist(String stuname, String studentno,Integer stusex,
                             @RequestParam(value="index",defaultValue = "1") int pageindex,
                             ModelMap map,
                             @RequestParam(value="size",defaultValue = "5") int size){
        System.out.println("student Service");
        PageInfo stulist = studentService.getall(stuname, studentno, stusex, pageindex, size, null, null);
        List<Student> list = stulist.getList();
        for (Student o : list) {
            System.out.println(o+"=====");
        }
        map.put("stulist",stulist);
        map.put("stuname",stuname);
        map.put("studentno",studentno);
        map.put("stusex",stusex);
        map.put("size",size);
        return "/Educational/student/list";
    }
}
