package com.util;

import com.bean.Department;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;
/*标签库java文件不可以有构造方法*/
public class MytagTest extends SimpleTagSupport {
    private Boolean bate;
    private Department department;

    public Boolean getBate() {
        return bate;
    }

    public void setBate(Boolean bate) {
        this.bate = bate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    @Override
    public void doTag() throws JspException, IOException {
        //直接给页面输出内容
        JspWriter out = this.getJspContext().getOut();
        out.print("this is my tag!");
        /*获得标签中的内容，并且输出*/
        StringWriter sw = new StringWriter();
        this.getJspBody().invoke(sw);
        /*获取EL解析的方式*/
        this.getJspContext().getOut().print(department.getDepartname()+"===");
    }
}
