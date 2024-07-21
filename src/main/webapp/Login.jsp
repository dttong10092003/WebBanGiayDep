<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">

<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.11.2/css/all.css" />
<!-- Google Fonts Roboto -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" />
<!-- MDB -->
<link rel="stylesheet" href="css/mdb.min.css" />
<!-- Custom styles -->
<link rel="stylesheet" href="css/style.css" />
<!-- Roboto Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700&display=swap">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://mdbootstrap.com/previews/ecommerce-demo/css/bootstrap.min.css">
<!-- Material Design Bootstrap -->
<link rel="stylesheet"
	href="https://mdbootstrap.com/previews/ecommerce-demo/css/mdb-pro.min.css">
<!-- Material Design Bootstrap Ecommerce -->
<link rel="stylesheet"
	href="https://mdbootstrap.com/previews/ecommerce-demo/css/mdb.ecommerce.min.css">
<!-- Your custom styles (optional) -->

<link href="css/login.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<style>
.forgotPass {
	float: right;
}
</style>

<title>Login Form</title>

</head>

<body class="skin-light">
	<jsp:include page="Menu.jsp"></jsp:include>
	<div id="logreg-forms">
		<c:if test="${error eq 'Username already exists'}">
			<script>
	       		$(document).ready(function() {
	            $('#logreg-forms .form-signin').hide();
	            $('#logreg-forms .form-signup').show();
	       		});
    		</script>
		</c:if>
	
		<c:if test="${error eq 'Passwords do not match'}">
			<script>
	       		$(document).ready(function() {
	            $('#logreg-forms .form-signin').hide();
	            $('#logreg-forms .form-signup').show();
	       		});
    		</script>
		</c:if>
		
		<c:if test="${error eq 'Email must end with @gmail.com or @email.com'}">
			<script>
	       		$(document).ready(function() {
	            $('#logreg-forms .form-signin').hide();
	            $('#logreg-forms .form-signup').show();
	       		});
    		</script>
		</c:if>
		
		<c:if test="${error eq 'Cannot be empty'}">
			<script>
	       		$(document).ready(function() {
	            $('#logreg-forms .form-signin').hide();
	            $('#logreg-forms .form-signup').show();
	       		});
    		</script>
		</c:if>
	
		<c:if test="${error!=null }">
			<div id="errorAlert" class="alert alert-danger" role="alert">${error}</div>
		</c:if>
		<c:if test="${mess!=null }">
			<div id="messAlert" class="alert alert-success" role="alert">${mess}</div>
		</c:if>
		<form class="form-signin" action="login" method="post">
			<h1 class="h3 mb-3 font-weight-normal" style="text-align: center">
				Sign in</h1>
			<label for="user">Username</label> <input name="user"
				value="${username }" type="text" id="inputEmail"
				class="form-control" placeholder="Username" required="" autofocus="">
			<label for="pass">Password</label> <input name="pass"
				value="${password }" type="password" id="inputPassword"
				class="form-control" placeholder="Password" required="">

			<div class="form-group form-check">
				<input name="remember" value="1" type="checkbox"
					class="form-check-input" id="exampleCheck1"> <label
					class="form-check-label" for="exampleCheck1">Remember me</label> <a
					class="forgotPass" href="forgotPassword">Forgot Password</a>
			</div>
			<div></div>

			<button class="btn btn-success btn-block" type="submit">
				<i class="fas fa-sign-in-alt"></i> Sign in
			</button>
			<hr>
			<button class="btn btn-primary btn-block" type="button"
				id="btn-signup">
				<i class="fas fa-user-plus"></i> Sign up New Account
			</button>
		</form>

		<form action="signup" method="post" class="form-signup">
			<h1 class="h3 mb-3 font-weight-normal" style="text-align: center">
				Sign up</h1>
			<label for="user">Username</label> <input name="user" type="text"
				id="user-name" class="form-control" placeholder="User name"
				required="" autofocus="" value="${signupUsername}"> <label
				for="pass">Password</label> <input name="pass" type="password"
				id="user-pass" class="form-control" placeholder="Password" required
				autofocus=""> <label for="repass">Repeat Password</label> <input
				name="repass" type="password" id="user-repeatpass"
				class="form-control" placeholder="Repeat Password" required
				autofocus=""> <label for="email">Email</label> <input
				name="email" type="email" id="email" class="form-control"
				placeholder="Email" required="" autofocus="" value="${signupEmail}">
			<button class="btn btn-primary btn-block" type="submit">
				<i class="fas fa-user-plus"></i> Sign Up
			</button>
			<a href="#" id="cancel_signup"><i class="fas fa-angle-left"></i>
				Back</a>
		</form>
		<br>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script>
	function toggleResetPswd(e) {
        e.preventDefault();
        $('#logreg-forms .form-signin').toggle() // display:block or none
        $('#logreg-forms .form-reset').toggle() // display:block or none
    }
	
	function toggleSignUp(e) {
        e.preventDefault();
        $('#logreg-forms .form-signin').toggle(); // display:block or none
        $('#logreg-forms .form-signup').toggle(); // display:block or none
    }
	
	$(() => {
        // Login Register Form
        $('#logreg-forms #forgot_pswd').click(toggleResetPswd);
        $('#logreg-forms #cancel_reset').click(toggleResetPswd);
        $('#logreg-forms #btn-signup').click(toggleSignUp);
        $('#logreg-forms #cancel_signup').click(toggleSignUp);
    })
    
    window.addEventListener("load",function loadAmountCart(){
                        	 $.ajax({
                                 url: "/WebBanGiayDep/loadAllAmountCart",
                                 type: "get", //send it through get method
                                 data: {
                                     
                                 },
                                 success: function (responseData) {
                                     document.getElementById("amountCart").innerHTML = responseData;
                                 }
                             });
                        },false);  
    
    setTimeout(function() {
        var errorAlert = document.getElementById('errorAlert');
        if (errorAlert) {
            errorAlert.style.display = 'none';
        }
    }, 3000);
    
    setTimeout(function() {
        var messAlert = document.getElementById('messAlert');
        if (messAlert) {
        	messAlert.style.display = 'none';
        }
    }, 3000);
	</script>
</body>
</html>
