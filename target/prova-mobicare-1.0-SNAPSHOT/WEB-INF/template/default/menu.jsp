<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='sec'
	uri='http://www.springframework.org/security/tags'%>



<div class="navbar-custom navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" rel="home" href="#"
				title="Buy Sell Rent Everyting"> <img
				style="max-width: 40px; margin-top: -7px;"
				src="<c:url value='/resources/img/logo.png'/>">
			</a> <a class="navbar-brand" href="/prova-mobicare/"><spring:message
					code="projeto.nome" /></a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="<c:url value='/paciente/pacientes'/>"><spring:message
							code='menu.paciente' /></a></li>
				<li><a href="<c:url value='/plano/planos' />"><spring:message
							code='menu.plano' /></a></li>
				<li><a href="<c:url value='/medicamento/medicamentos' />"><spring:message
							code='menu.medicamento' /></a></li>
				<li><a href="<c:url value='/servico/servicos' />"><spring:message
							code='menu.servico' /></a></li>
				<li class="dropdown"><a href="#" data-toggle="dropdown"
					class="dropdown-toggle"><spring:message code="menu.relatorio" />
						<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value='/downloadCSVPaciente'/>"><spring:message
									code="menu.relatorio.cliente" /></a></li>
						<li><a href="<c:url value='/downloadCSVMedicamento'/>"><spring:message
									code="menu.relatorio.medicamento" /></a></li>
						<li><a href="<c:url value='/downloadCSVPlano'/>"><spring:message
									code="menu.relatorio.plano" /></a></li>
						<li class="divider"></li>
						<li><a href="<c:url value='/downloadCSVServico'/>"><spring:message
									code="menu.relatorio.servico" /></a></li>
					</ul></li>
				<li><sec:authorize access="hasRole('ROLE_ADMIN')">
						<a href="/prova-mobicare/empregado/criarEmpregado"><spring:message
								code='menu.plano' /></a>
					</sec:authorize></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="<c:url value='/logout'/>"> Sair</a></li>
			</ul>
		</div>
	</div>
</div>