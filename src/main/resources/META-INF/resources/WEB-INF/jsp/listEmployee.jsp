<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<link href="webjars/bootstrap/5.0.2/css/bootstrap.min.css"  rel="stylesheet">
		<title>
			Employee form
		</title>
	</head>
	<body>
		<%@ include file="common/navbar.jspf" %>
		<div class="container">
			<h1>Employee details</h1>
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">EMP ID</th>
			      <th scope="col">First Name</th>
			      <th scope="col">Last Name</th>
			      <th scope="col">Phone Number</th>
			      <th scope="col">City</th>
			      <th scope="col">Gender</th>
			      <th scope="col"></th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach items="${emp }" var="e">
				    <tr>
				      <th scope="row"><a href="update-employee?id=${e.id }" class="fw-normal">${e.id }</a></th>
				      <td>${e.firstname }</td>
				      <td>${e.lastname }</td>
				      <td>${e.phno }</td>
				      <td>${e.city }</td>
				      <td>${e.gender }</td>
				      <td><a href="delete-employee?id=${e.id }" class="btn btn-danger">Delete</a></td>
				    </tr>
			    </c:forEach>
			  </tbody>
			</table>
			<a href="form" class="btn btn-success">Add Employee</a>
		</div>
		<script src="webjars/bootstrap/5.0.2/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>
</html>