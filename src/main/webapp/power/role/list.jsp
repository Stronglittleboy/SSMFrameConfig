<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="pg" uri="http://java.sun.com/jsp/my/pageutil" %>
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
	function del(roleid){
		if(confirm("确认删除？")){
		    location.href="/power/role/deleterole?roleid="+roleid;
        }
	}

</script>
</head>
<body>

   

<div class="div_head" style="width: 100%;text-align:center;">
		<span> <span style="float:left">当前位置是：权限管理-》角色管理</span> <span
			style="float:right;margin-right: 8px;font-weight: bold">
			<a style="text-decoration: none;" href="/power/user/add">【新增角色】</a>&nbsp;&nbsp;&nbsp;&nbsp;
		</span>
		</span>
	</div>

<div class="morebt">
 
</div>





 <div class="cztable">
        
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
                <tr style="height: 25px" align="center">
                	<th><input type="checkbox"/></th>
                    <th scope="col">
                        序号
                    </th>
                    
                    <th scope="col">
                        角色名称
                    </th>
                    <th scope="col">
                        状态
                    </th>
                    <th scope="col" width="300px">
                        操作
                    </th>
                </tr>
                
               
                <c:forEach items="${pi.list}" var="role" varStatus="sta">
                <tr align="center">
                    <th><input type="checkbox"/></th>
                    <td>
                        ${sta.count}
                    </td>
                    <td>
                       ${role.rolename}
                    </td>                    
                    <td>&nbsp;
                        ${role.rolestate==1?启用:未启用}
                    </td>
                    
                    <td>&nbsp;
                        <c:if test="${role.rolestate}!=1">
                            <a href="javascript:alert('操作成功！');">启用</a>
                        </c:if>

                        <a href="/power/role/details?roleid=${role.roleid}">详情</a>
                        <a href="/power/role/toedit?roleid=${role.roleid}">修改</a>
						<a href="javascript:void(0)" onclick="del(${role.roleid});return false" class="tablelink"> 删除</a>
                    </td>
                </tr>
                </c:forEach>
               
                
            </tbody>
        </table>
          <div class='MainStyle'>
              <div class=''>
                  <pg:pageUtil url="/power/role/getlist" pageInfo="${pi}"></pg:pageUtil>
              </div>
              <div class='SearchStyle'>
                  <input type='text' id='john_Page_Search' onkeydown="if(event.keyCode == 13){page_searchIndex();}"/></div><div class=''>
              <input type='button' value='Go' onclick="page_searchIndex()"/></div></div>
                <script>    function page_searchIndex(){        var searchText = document.getElementById('john_Page_Search');        var searchIndex = searchText != null && searchText.value != '' ? parseInt(searchText.value) : 0;        if(searchIndex > 0 && searchIndex <= 3) {             window.location='StudentMaterial.aspx?page=' + searchIndex;        }        else        {            alert('需要跳转的页码不能超出范围！');        }    }</script>
        </div>
    </div>

    </div>
</body>
</html>