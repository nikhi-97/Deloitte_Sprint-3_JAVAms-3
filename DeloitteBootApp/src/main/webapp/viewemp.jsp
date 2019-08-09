<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>
<br><br><br>
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
  
    <tr>
      <td><c:out value="${empl.empId}" /></td>
      <td><c:out value="${empl.empName}" /></td>
      <td><c:out value="${empl.dob}" /></td>
      <td><c:out value="${empl.sal}" /></td>
      <td><a href="/delete?empId=${empl.empId}">Delete</a></td> 
      <td><a href="/updateinit?empId=${empl.empId}">Update</a></td>  
    </tr>

</table>
</div>

<jsp:include page="footer.jsp"/>