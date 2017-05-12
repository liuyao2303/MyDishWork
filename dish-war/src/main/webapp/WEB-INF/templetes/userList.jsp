<%--
  Created by IntelliJ IDEA.
  User: xiaoliu
  Date: 2017/5/12
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <link href="/resources/bootstrap/css/bootstrap.css" rel="stylesheet">
</head>
<body>
    <table class="table">
        <thead>
            <tr>
                <th>姓名</th>
                <th>年龄</th>
                <th>地址</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>${user.userName}</td>
                <td>${user.age}</td>
                <td>${user.addr}</td>
            </tr>
        </tbody>
    </table>
</body>
</html>
