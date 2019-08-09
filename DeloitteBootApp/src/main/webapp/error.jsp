<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h3 class="center-align">Failure!</h3>
<h2 class="center-align">${errormsg}</h2>

<jsp:include page="footer.jsp"/>
</body>
</html>