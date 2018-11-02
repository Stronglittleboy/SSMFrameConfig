<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
	学生信息管理平台
</title>
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
        function edit() {
            if(confirm("确认修改吗？")){
                var check=$("[type='checkbox']");
                var count=0;
                for (var i = 0; i <check.length ; i++) {
                    if(check[i].checked){
                        count++;
                    }
                }
                if (count==1){
                    alert("必选选择角色拥有的权限菜单目录")
                } else {
                    document.forms[0].submit();
                }
            }
        }
    </script>
    <script>
        function cout(menuid) {
            console.log("123")
            var sonmenu='down'+menuid;
            console.log(sonmenu);
            var downlist=$("[class="+sonmenu+"]");
            var topmenu=$("[class="+"top"+menuid+"]")[0];
            for (var i = 0; i < downlist.length; i++) {
                downlist[i].checked=topmenu.checked;
            }
        }
        function check(menuid) {
            var downmenu=$("[class=down"+menuid+"]");
            var topmenu=$("[class=top"+menuid+"]");
            for (var i = 0; i <downmenu.length ; i++) {
                if(downmenu[i].checked){
                    topmenu[0].checked=true;
                }
            }
        }
        function tijiao() {
            var check=$("[type='checkbox']");
            var count=0;
            for (var i = 0; i <check.length ; i++) {
                if(check[i].checked){
                    count++;
                }
            }
            if (count==1){
                alert("必选选择角色拥有的权限菜单目录")
            } else {
                document.forms[0].submit();
            }
        }
    </script>

    
</head>
<body>

		<div class="div_head">
            <span>
                <span style="float:left">当前位置是：教务中心-》考试-》新增</span>
                <span style="float:right;margin-right: 8px;font-weight: bold">
                    <a style="text-decoration: none" href="javascript:history.back();">【返回】</a>
                </span>
            </span>
        </div>
</div>
<div class="cztable">
	<form action="/power/role/edit" method="post">
<table border="1" width="100%" class="table_a">
                <tr  width="120px;">
                    <td width="120px">角色名：<span style="color:red">*</span>：</td>
                    <td>
                        <input type="hidden" name="oldmenus" value="${role.menus}">
                        <input type="hidden" name="roleid" value="${role.roleid}">
						<input type="text"  name="f_goods_image" value="${role.rolename}" />
					</td>
                </tr>

                <tr  width="120px;">
                    <td>菜单资源<span style="color:red">*</span>：</td>
                    <td>
                        <ul>
                            <c:forEach items="${menus}" var="menu"  varStatus="sta">
                            <li>

                                <input type="checkbox" name="menuid" class="top${menu.menuid}" value="${menu.menuid}" onclick="cout(${menu.menuid})"
                                <c:forEach items="${role.menus}" var="rm">
                                    ${rm.menuid==menu.menuid?'checked':""}
                                </c:forEach>
                            />${menu.menuname}

                                <ul>

                                    <c:forEach items="${menu.menus}" var="twomenu" varStatus="cla">
                                        <li>&nbsp;&nbsp;&nbsp;&nbsp

                                            <input type="checkbox" class="down${menu.menuid}" name="menuid" value="${twomenu.menuid}" onclick="check(${menu.menuid})"
                                            <c:forEach items="${role.menus}" var="rm">
                                                    <c:forEach items="${rm.menus}" var="um">
                                                ${um.menuid==twomenu.menuid?'checked':""}
                                                    </c:forEach>
                                            </c:forEach>
                                            >${twomenu.menuname}

                                            </li>

                                    </c:forEach>
                                </ul>
                            </li>
                            </c:forEach>
                        </ul>
                    </td>
                </tr>

    <tr>
        <td>启用状态<span style="color:red">*</span>：</td>
        <td>
            <input type="radio" name="rolestate" checked value="1" ${role.rolestate==1?'checked':""}/>启用 <input type="radio" name="rolestate" value="0" ${role.rolestate==0?'checked':""}/>禁用
        </td>
    </tr>
				
				
				<tr width="120px">
					<td colspan="2" align="center">
						<input type="button" value="修改" onclick="edit()"/>
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
