package com;

import com.bean.Menu;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/*研究String-Json——数组之间的转化*/
public class StringtoJson {
    public static void main(String[] args) {
        String str2=",{menuid:34,menuname:'我的资料'}";
        String str="[{\n" +
                "\t\"menuid\": \"28\",\n" +
                "\t\"menuname\": \"个人中心\"\n" +
                "}, {\n" +
                "\t\"menuid\": \"26\",\n" +
                "\t\"menuname\": \"世界之物\"\n" +
                "}]";
        ObjectMapper mapper=new ObjectMapper();
        List<Menu> menus= null;
        try {
            menus = mapper.readValue(str, new TypeReference<List<Menu>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(menus.get(0).getMenuname());


    }
}
