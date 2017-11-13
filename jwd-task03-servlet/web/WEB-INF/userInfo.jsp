<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user-info</title>
    <meta http-equiv="Content-type" content="text/html" charset="UTF-8">
</head>
<body>
<a href="../index.jsp"><p>Back</p></a>
<c:choose>
    <c:when test="${requestScope.userBean!= null}">
        <table border="1">
            <tr>
                <td>name</td>
                <td>surname</td>
                <td>age</td>
                <td>email</td>
                <td>phone number</td>
            </tr>
            <tr>
                <td>${requestScope.userBean.name}</td>
                <td>${requestScope.userBean.surname}</td>
                <td>${requestScope.userBean.age}</td>
                <td>${requestScope.userBean.email}</td>
                <td>${requestScope.userBean.phoneNumber}</td>
            </tr>
        </table>
    </c:when>
    <c:otherwise>
        <h1>There isn't such user!</h1>
    </c:otherwise>
</c:choose>
</body>
</html>
