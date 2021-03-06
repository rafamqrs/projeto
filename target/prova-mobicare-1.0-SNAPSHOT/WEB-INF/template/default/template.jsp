<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="title.home" /></title>
<link href="<c:url value='/resources/css/bootstrap.min.css'  />"
	rel="stylesheet" />
<link href="<c:url value='/resources/css/bootstrap.css'  />"
	rel="stylesheet" />
<link
	href="<c:url value='/resources/css/bootstrap-responsive.min.css'  />"
	rel="stylesheet" />
<link href="<c:url value='/resources/css/myapp.css'  />"
	rel="stylesheet" />
<link href="<c:url value='/resources/css/bootstrap-multiselect.css'  />"
	rel="stylesheet" />
<link
	href="<c:url value='/resources/fonts/glyphicons-halflings-regular.eot'  />"
	rel="stylesheet" />
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css"
	rel="stylesheet">
</head>
<body>
	<div class="page">
		<tiles:insertAttribute name="menu" />
		<br /> <br /> <br />
		<div class="container">
			<tiles:insertAttribute name="body" />
		</div>
		<script src="<c:url value='/resources/js/jquery.min.js' />"></script>
		<script src="<c:url value='/resources/js/jquery.js' />"></script>
		<script src="<c:url value='/resources/js/bootstrap.js' />"></script>
		<script src="<c:url value='/resources/js/myapp.js' />"></script>
		<script src="<c:url value='/resources/js/bootstrap-multiselect.js' />"></script>
		<script src="<c:url value='/resources/js/jasny-bootstrap.min.js' />"></script>
		<script type="text/javascript">
			$(document).on(
					'click',
					'.panel-heading span.clickable',
					function(e) {
						var $this = $(this);
						if (!$this.hasClass('panel-collapsed')) {
							$this.parents('.panel').find('.panel-body')
									.slideUp();
							$this.addClass('panel-collapsed');
							$this.find('i').removeClass('glyphicon-chevron-up')
									.addClass('glyphicon-chevron-down');
						} else {
							$this.parents('.panel').find('.panel-body')
									.slideDown();
							$this.removeClass('panel-collapsed');
							$this.find('i').removeClass(
									'glyphicon-chevron-down').addClass(
									'glyphicon-chevron-up');
						}
					});
		</script>
	</div>
	<tiles:insertAttribute name="footer" />
</body>
</html>