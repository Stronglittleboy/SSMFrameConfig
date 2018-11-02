<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生信息管理平台</title>
	<link href="../../Style/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
	<link href="../../Style/ks.css" rel="stylesheet" type="text/css" />
	<link href="../../css/mine.css" type="text/css" rel="stylesheet">
    <script src="../../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="../../Script/Common.js" type="text/javascript"></script>
    <script src="../../Script/Data.js" type="text/javascript"></script>

<script>
	function del(){
		confirm("确认删除？");
	}
</script>
<script type="text/javascript">
    window.onload=function () {
        $("[name=choose]").click(function () {
            //alert($(this)[0].checked);
            var classid = $("[name=classid]");
            console.log(classid)
            for (var i = 0; i < classid.length; i++) {
                classid[i].checked = $(this)[0].checked;
            }
        })
    }
</script>
<script type="text/javascript">
    function doexcel() {
        var classid=$("[name=classid]");
        var state=1;
        for (var i=0;i<classid.length;i++){
            console.log("进入循环")
            if(classid[i].checked==true){
                console.log("进入判断")
                state=2;
                document.forms[1].submit();
                break
            }
        }
        console.log("开始")
		console.log(state)
        if(state==1){
            alert("请先选择班级")
        }
    }
</script>

</head>
<body>
	
	<div class="div_head" style="width: 100%;text-align:center;">
		<span> <span style="float:left">当前位置是：教务中心-》班级管理</span> <span
			style="float: right; margin-right: 8px; font-weight: lighter">
            <a style="text-decoration: blink" href="javascript:void(0)" onclick="doexcel()">【导出excel】</a>
            <a style="text-decoration: blink" href="/Educational/class/getDepts">【新增班级】&emsp;&emsp;&emsp;&emsp;</a>
		</span>
		</span>
	</div>

	<div class="cztable">
		<div>
			<ul class="seachform1">
				<form action="/Educational/class/getclasslist" method="post">
					<li>
						<label>班级名称:</label>
						<input name="name" type="text" class="scinput1" value=""/>&nbsp;&nbsp;
						<input  type="submit" class="scbtn" value="查询"/>&nbsp;
					</li>
						
				</form>
            </ul>
            <form action="/Educational/class/doexcel" method="post">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tbody><tr style="font-weight: bold;">
                		<th  width="8%">
						<input type="checkbox" name="choose"/>
						</th>
                        <th >院系</th>
						<th width="">班级编号</th>
						<th width="">班级名称</th>
                        <th width="15%">班主任老师</th>						
                        <th width="15%">人数</th>
						<th width="15%">班级状态</th>
						<th width="20%">操作</th>  
                    </tr>
				<c:forEach items="${pi.list}" var="cla">
					<tr id="product1">
                        <td align="center"><input type="checkbox" value="${cla.classid}" name="classid"/></td>
						<td align="center">${cla.department.departname}</td>
						<td align="center">${cla.classnum}</td>
						<td align="center">${cla.classname}</td>
						<td align="center">${cla.classteacher}</td>
						<td align="center">${cla.peoplecount}</td>
						<td align="center">${cla.classstate}</td>
						<td align="center">
							<c:if test="${cla.classstate=='未审核'||cla.classstate=='审核未通过'}">
								<a href="info.html">详情</a>
								修改
								提交审核
								删除
							</c:if>
							<c:if test="${cla.classstate=='已毕业'||cla.classstate=='审核中'}">
								<a href="info.html">详情</a>
							</c:if>							<c:if test="${cla.classstate=='审核通过'}">
								<a href="javascript:location.href='../book/list.html'">发书</a>
								<a href="info.html">详情</a>
						</c:if>
						</td>
					</tr>
				</c:forEach>
                <tr>
                    <td colspan="20" style="text-align: center;">
                        <a style="text-decoration: none;" href="#">
                            <a href="/Educational/class/getclasslist?classname=${cname}&classnum=${cnum}&index=${pi.pageNum}&size=${size}">首页</a>
                            <a href="/Educational/class/getclasslist?classname=${cname}&classnum=${cnum}&index=${pi.prePage}&size=${size}">上一页</a>
                            <c:forEach var="i" begin="1" end="${pi.pages}">
                                <a href="/Educational/class/getclasslist?classname=${cname}&classnum=${cnum}&index=${i}&size=${size}">${i}</a>
                            </c:forEach>
                            <a href="/Educational/class/getclasslist?classname=${cname}&classnum=${cnum}&index=${pi.nextPage}&size=${size}">下一页</a>
                            <a href="/Educational/class/getclasslist?classname=${cname}&classnum=${cnum}&index=${pi.pages}&size=${size}">尾页</a>
                            共${pi.total}条
                            每页显示
                            <select name="num">
                                <option value="5" <c:if test="${size==5}">selected</c:if> >5</option>
                                <option value="10" <c:if test="${size==10}">selected</c:if>>10</option>
                                <option value="15" <c:if test="${size==15}">selected</c:if>>15</option>
                            </select>   ${pi.pageNum}/${pi.pages} </a>
                    </td>
                    <script type="text/javascript">
                        $(function(){
                            $("[name=num]").change(function(){
                                var size=$(this).val();
                                location.href="/Educational/class/getclasslist?size="+size;
                            });
                        })
                    </script>
                </tr>
                </tbody>

</table>
            </form>
	</div>
	</div>

	</div>
</body>
</html>
