
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<br />
		<!-- Cadastro de PACIENTE -->
		<div id="cadastro" class="tab-pane fade active in">
			<div class="row">
				<c:if test="${not empty message}">
					<div class="col-sm-6 col-md-6">
						<div class="alert alert-success">
							<button type="button" class="close" data-dismiss="alert"
								aria-hidden="true">X</button>
							<strong>${message}</strong>
						</div>
					</div>
				</c:if>
				<c:if test="${not empty errorMessage}">
					<div class="col-sm-6 col-md-6">
						<div class="alert alert-danger">
							<button type="button" class="close" data-dismiss="alert"
								aria-hidden="true">X</button>
							<strong> ${errorMessage} </strong>
						</div>
					</div>
				</c:if>
			</div>
			<br />
			<!-- Formulario de cadastro de Paciente -->
			<form:form method="POST" commandName="paciente"
				action="${pageContext.request.contextPath}/paciente/editar/${paciente.idPaciente}.html">
				<div class="col-lg-6">
					<!-- Campo nome empregado -->
					<div class="form-group">
						<label for="idPaciente"><spring:message
								code="label.idPaciente" /></label>
						<div class="input-group">
							<form:input path="idPaciente" cssClass="form-control"
								maxlength="50" disabled="true" />
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-ok form-control-feedback"></i></span>
						</div>
						
						<spring:message code="placeholder.nome" var="plhnome" />
						<label for="nome"><spring:message code="label.nomePac" /></label>
						<div class="input-group">
							<form:input path="nome" cssClass="form-control"
								placeholder="${plhnome}" maxlength="50" />
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-ok form-control-feedback"></i></span>
						</div>
					</div>
					<!-- Campo email paciente -->
					<div class="form-group">
						<spring:message code="placeholder.email" var="plhemail" />
						<label for="email"><spring:message code="label.email" /></label>
						<div class="input-group">
							<form:input path="email" cssClass="form-control"
								placeholder="${plhemail}" maxlength="30" />
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-ok form-control-feedback"></i></span>
						</div>
					</div>
					<!-- Campo telefone paciente -->
					<div class="form-group">
						<spring:message code="placeholder.telefone" var="plh.telefone" />
						<label for="telefone"><spring:message
								code="label.telefone" /></label>
						<div class="input-group">
							<form:input path="telefone" cssClass="form-control"
								placeholder="${plh.telefone}" data-mask="(99)9-9999-9999" />
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-ok form-control-feedback"></i></span>
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<label class="checkbox" for="ativo"><spring:message
									code="label.ativo" /> <form:checkbox path="ativo" /> </label>
						</div>
						<label for="dataNascimento"><spring:message
								code="label.dataNascimento" /></label>
						<div id="datetimepicker4" class="input-append">
							<spring:message code="placeholder.dataNascimento"
								var="plhdataNascimento" />
							<fmt:formatDate value="${paciente.dataNascimento}" var="fmtDate"
								pattern="dd/MM/yyyy" />
							<form:input path="dataNascimento" value="${fmtDate}"
								placeholder="${plhdataNascimento}" data-mask="99/99/9999"
								maxlength="10" />
						</div>
						<br/>
						<input type="submit" value="<spring:message code="botao.editar"/>"> 
						
					</div>
				</div>
			</form:form>

		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
