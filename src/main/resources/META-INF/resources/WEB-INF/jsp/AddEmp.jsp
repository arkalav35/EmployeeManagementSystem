<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
			<h1 class="mb-3">Enter Employee details</h1>
			<form:form method="post" modelAttribute="employee">
			<div class="container">
			<div class="mx-auto col-5 col-md-12 col-lg-12">
			  <div class="row">
			  
			    <div class="col">
			      <div class="mb-3">
			  			<div class="form-outline w-50">
						    <label class="form-label">Firstname</label>
						    <form:input type="text" class="form-control" path="firstname" required="required" />
						</div>
			  	  </div>
			    </div>
				  <div class="col">
				    <div class="mb-3">
					  	<div class="form-outline w-50">
						    <label class="form-label">Lastname</label>
						    <form:input type="text" class="form-control" path="lastname" required="required" />
						</div>
				   </div>
				  </div>
			  </div>
			  <div class="row">
			  	<div class="col">
			  		<div class="form-outline mb-3" style="width: 100%; max-width: 22rem">
			  		  <label class="form-label">Phone number with country code</label>
					  <form:input type="text" id="phno" class="form-control" path="phno" required="required" />
					  <div class="fs-6">
					  	<form:errors class="text-danger" path="phno" />
					  </div>
					</div>
			  	</div>
			  	<div class="col">
			  		<div class="mb-3">
						<div class="form-group w-25">
							  <label>City:</label>
							  <form:select class="form-control" id="city" path="city" required="required" >
							  	<form:option type="hidden" value="default">Select your city...</form:option>
							    <form:option value="Hyderabad">Hyderabad</form:option>
							    <form:option value="Mumbai">Mumbai</form:option>
							    <form:option value="Chennai">Chennai</form:option>
							    <form:option value="Delhi">Delhi</form:option>
							  </form:select>
						</div>
					</div>
				</div>
			  </div>
			  <div class="row">
			  	<div class="col">
			  		 <label>Select Gender</label>
			  		<div class="row">
			  			<div class="col">
					  		<div class="form-check">
							  <form:radiobutton class="form-check-input" id="male" path="gender" name="gender" value="Male" />
							  <label class="form-check-label mb-3">Male</label>
							</div>
						</div>
						<div class="col">
							<div class="form-check">
							  <form:radiobutton class="form-check-input" id="female" path="gender" value="Female" />
							  <label class="form-check-label">Female</label>
							</div>
						</div>
			  			<div class="col">
					  		<div class="form-check">
							  <form:radiobutton class="form-check-input" id="other" path="gender" value="Other" />
							  <label class="form-check-label">Other</label>
							</div>
						</div>
					</div>
			  	</div>
			  	<div class="col">
			  		<form:input type="hidden" class="form-control" path="id"/>
			  	</div>
			  </div>
			  <button type="submit" class="btn btn-primary">Submit</button>
			</div>
			</div>
			</div>
			</form:form>
		</div>
		<script src="webjars/bootstrap/5.0.2/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>
</html>