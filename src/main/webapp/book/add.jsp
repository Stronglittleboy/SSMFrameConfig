<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
	学生信息管理平台
</title>
	<link href="../Style/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
	<link href="../Style/ks.css" rel="stylesheet" type="text/css" />
	<link href="../css/mine.css" type="text/css" rel="stylesheet">
    <script src="../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="../Script/Common.js" type="text/javascript"></script>
    <script src="../Script/Data.js" type="text/javascript"></script>
    <script>
        function sma() {
           var path = $("[name=myfile]").val()+" ";
            pathutil(path);
        }
        function pathutil(path) {
            console.log(path)
            strs=path.split("/"); //字符分割
            var number = path.indexOf(".");
            var s = path.substring(number,path.length);
            var number1 = path.lastIndexOf("\\");
            var s1 = path.substring(number1+1,number);
            $("[name=informationname]").val(s1);
            $("[name=filetype]").val(s)
        }
    </script>

</head>
<body>

		<div class="div_head">
            <span>
                <span style="float:left">当前位置是：书籍管理-》资料上传</span>
                <span style="float:right;margin-right: 8px;font-weight: bold"></span>
            </span>
        </div>
</div>
<div class="cztable">
    <form action="/book/add" method="post" enctype="multipart/form-data">
	<table border="1" width="100%" class="table_a">
                <tr>
                    <td>资料类型 ：<span style="color:red">*</span>：</td>
                    <td>
					<select name="infoid">
                        <c:forEach items="${infotype}" var="type">
                            <option value="${type.infoid}">${type.infotype}</option>
                        </c:forEach>
                    </select>	
                    </td>
                </tr>

                <tr>
                    <td>上传人：<span style="color:red">*</span>：</td>
                    <td>
						<input type="text"  name="uploader" value="
						${userbean.userName}" /></td>
                </tr>
				<tr>
                    <td>上传：<span style="color:red">*</span>：</td>
                    <td>
                        <input type="file" name="myfile" value="" onchange="sma()"/>
                    </td> 
                </tr>
                <tr>
                    <td>资料名称 ：<span style="color:red">*</span>：</td>
                    <td>
                        <input type="text" name="informationname" readonly  />
                    </td>
                </tr>
                <tr>
                    <td>格式：<span style="color:red">*</span>：</td>
                    <td>
                        <input type="text" readonly name="filetype" value="" /></td>
                </tr>

                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="提交"> <input type="submit" value="返回" onclick="history.back();">
                    </td>
                </tr>  
            </table>
	</form>
</div>

            </div>
        </div>
    </div>
</body>
</html>
