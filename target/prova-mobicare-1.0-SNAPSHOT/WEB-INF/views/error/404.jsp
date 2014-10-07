<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<style type="text/css">
.center {
	text-align: center;
	margin-left: auto;
	margin-right: auto;
	margin-bottom: auto;
	margin-top: auto;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link href="/prova-mobicare/resources/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="/prova-mobicare/resources/css/bootstrap-responsive.min.css"
	rel="stylesheet" />
<script src="/prova-mobicare/resources/js/jquery-1.10.2.min.js"></script>
</head>
<div class="container">
	<div class="row">
		<div class="span12">
			<div class="jumbotron center">
				<h1>
					<spring:message code="label.notfound" />
					<br/>
					<small><font face="Tahoma" color="red">Codigo:
							404</font></small>
				</h1>
				<br />
				<p>
					<spring:message code="label.infoerro"/>					
				</p>
				<a href="/prova-mobicare/" class="btn btn-large btn-info"><i
					class="icon-home icon-white"></i> <spring:message code="label.paginainicial"/> </a>
			</div>
			<br />

		</div>
	</div>
</div>	
</html>