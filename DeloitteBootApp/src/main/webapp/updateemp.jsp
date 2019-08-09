<jsp:include page="header.jsp"/>
 <h3 class="center-align"> Update Employee</h3>
	
  <div class="container" style="border:2px;padding:5%">
    <form class="col s12" action="update" method="post">
      <div class="row">
        <div class="input-field col s12">
          <input  name="empId" type="text" class="validate" value="${empl.empId}" hidden >
          
        </div>
       </div><div class="row">
        <div class="input-field col s12">
          <input  name="empName" type="text" class="validate" value="${empl.empName}">
          <label for="first_name">Employee Name</label>
        </div>
       </div>
       <div class="row">
        <div class="input-field col s12">
          <input  name="Dob" type="date" class="validate" value="${empl.dob}">
          <label for="first_name">Date</label>
        </div>
       </div>
       <div class="row">
        <div class="input-field col s12">
          <input placeholder="Enter updated Salary" name="sal" type="text" class="validate" value="${empl.sal}">
          <label for="first_name">Basic Salary</label>
        </div>
       </div>
     
      <input class="waves-effect waves-light btn" type="submit"></input>
    </form>
  </div>
<jsp:include page="footer.jsp"/>