<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">  
	<head>  
		<title>
			Employee form
		</title>  
			<meta charset="utf-8">  
	  		<meta name="viewport" content="width=device-width, initial-scale=1">  
	  		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">  
	  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"> </script>  
	  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"> </script>  
	  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"> </script>  
	  		<link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">   
	  		<script src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"> </script>  
   			<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" >  
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
					  		<c:forEach items="${employee }" var="e">
						    	<tr>
							      <th scope="row"><a href="update?id=${e.id }" class="fw-normal">${e.id }</a></th>
							      <td>${e.firstname }</td>
							      <td>${e.lastname }</td>
							      <td>${e.phno }</td>
							      <td>${e.city }</td>
							      <td>${e.gender }</td>
							      <td><a href="remove?id=${e.id }" class="btn btn-danger">Delete</a></td>
						    	</tr>
					   	 </c:forEach>
					  </tbody>
				</table>
				<a href="register" class="btn btn-warning">Add Employee</a>
    		</div>  
    		<form>
			  <label for="myfile">Select a file:</label>
			  <input type="file" id="myfile" name="myfile"><br><br>
			  <input type="submit">
			</form>
			<script>  
				$('table').DataTable();  
			</script>  
		</body>  
</html>  