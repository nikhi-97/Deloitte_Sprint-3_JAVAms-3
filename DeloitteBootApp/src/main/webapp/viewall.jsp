<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>
 <h3 class="center-align">All Employees</h3><br><br><br>
<div class="container">
<table class="striped">
<thead>
          <tr>
              <th>Employee ID</th>
              <th>Employee Name</th>
              <th>Date of Birth</th>
              <th>Basic Salary</th>
              <th>Delete</th>
              <th>Update</th>
          </tr>
        </thead>
  <c:forEach items="${emps}" var="empl">
    <tr>
      <td><c:out value="${empl.empId}" /></td>
      <td><c:out value="${empl.empName}" /></td>
      <td><c:out value="${empl.dob}" /></td>
      <td><c:out value="${empl.sal}" /></td>
      <td><a href="/delete?empId=${empl.empId}">Delete</a></td> 
      <td><a href="/updateinit?empId=${empl.empId}">Update</a></td> 
    </tr>
  </c:forEach>
</table>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>