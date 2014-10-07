<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags' %> 



<div class="navbar-custom navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/prova-mobicare/"><spring:message
					code="projeto.nome" /></a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="<c:url value='/departamento/departamentos' />"><spring:message
							code='menu.departamento' /></a></li>
				<li><a href="<c:url value='/empregado/criarEmpregado'/>"><spring:message
							code='menu.empregado' /></a></li>
				<li><a href="<c:url value='/paciente/pacientes'/>"><spring:message
							code='menu.paciente' /></a></li>
				<li><a href="<c:url value='/plano/planos' />"><spring:message
							code='menu.plano' /></a></li>
				<li><a href="<c:url value='/medicamento/medicamentos' />"><spring:message
							code='menu.medicamento' /></a></li>
				<li>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<a href="/prova-mobicare/empregado/criarEmpregado"><spring:message
								code='menu.plano' /></a>
					</sec:authorize>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li>
					<a href="<c:url value='/logout'/>" > Sair</a>
			    </li>
			</ul>
		</div>
	</div>
</div>