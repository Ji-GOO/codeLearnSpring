<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Logout Page</h1>

    <form method="post" action="/customLogout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <button>로그아웃</button>
    </form>
</body>
</html>
