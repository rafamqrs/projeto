<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value='/resources/css/bootstrap.min.css'  />"
	rel="stylesheet" />
<link href="<c:url value='/resources/css/bootstrap.css'  />"
	rel="stylesheet" />
<link
	href="<c:url value='/resources/css/bootstrap-responsive.min.css'  />"
	rel="stylesheet" />
<link href="<c:url value='/resources/css/myapp.css'  />"
	rel="stylesheet" />
<link href="<c:url value='/resources/css/login.css'  />"
	rel="stylesheet" />
</head>
<div class="container">
	<div class="login-container">
		<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
		      <font color="red">
		        Credenciais inválidas tente novamente ou entre em contato com o ADM. <br/><br/>
		      </font>
		</c:if>
		<div id="output"></div>
		<div class="avatar"></div>
		<div class="form-box">
			<form action="<c:url value='j_spring_security_check' />"
				method="POST">
				<input name="username" type="text" placeholder="Email"> <input
					name="password" type="password" placeholder="Senha">
				<button class="btn btn-info btn-block login" type="submit">Acessar</button>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
		</div>
	</div>

</div>
<script type="text/javascript">
(function(){
	var textfield = $("input[name=user]");
	            $('button[type="submit"]').click(function(e) {
	                e.preventDefault();
	                //little validation just to check username
	                if (textfield.val() != "") {
	                    //$("body").scrollTo("#output");
	                    $("#output").addClass("alert alert-success animated fadeInUp").html("Welcome back " + "<span style='text-transform:uppercase'>" + textfield.val() + "</span>");
	                    $("#output").removeClass(' alert-danger');
	                    $("input").css({
	                    "height":"0",
	                    "padding":"0",
	                    "margin":"0",
	                    "opacity":"0"
	                    });
	                    //change button text 
	                    $('button[type="submit"]').html("continue")
	                    .removeClass("btn-info")
	                    .addClass("btn-default").click(function(){
	                    $("input").css({
	                    "height":"auto",
	                    "padding":"10px",
	                    "opacity":"1"
	                    }).val("");
	                    });
	                    
	                    //show avatar
	                    $(".avatar").css({
	                        "background-image": "url('http://api.randomuser.me/0.3.2/portraits/women/35.jpg')"
	                    });
	                } else {
	                    //remove success mesage replaced with error message
	                    $("#output").removeClass(' alert alert-success');
	                    $("#output").addClass("alert alert-danger animated fadeInUp").html("sorry enter a username ");
	                }
	                console.log(textfield.val());

	            });
	});
</script>
</html>

