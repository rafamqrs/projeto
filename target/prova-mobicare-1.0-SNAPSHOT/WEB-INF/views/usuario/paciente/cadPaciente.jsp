<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<br />
		<div class="bs-example bs-example-tabs">
			<ul class="nav nav-tabs" id="myTab">
				<li class="active"><a data-toggle="tab" href="#cadastro">Cadastrar</a></li>
				<li class=""><a data-toggle="tab" href="#consultaPaciente">Consultar
						Paciente</a></li>
			</ul>
			<div class="tab-content" id="myTabContent">
				<!-- Cadastro de Paciente -->
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
						<c:if test="${not empty infoMessage}">
							<div class="col-sm-6 col-md-6">
								<div class="alert alert-warning">
									<button type="button" class="close" data-dismiss="alert"
										aria-hidden="true">X</button>
									<strong>${infoMessage}</strong>
								</div>
							</div>
						</c:if>
					</div>
					<br />

					<!-- Formulario de cadastro de Paciente -->
					<form:form method="POST" commandName="paciente" id="paciente-form"
						action="${pageContext.request.contextPath}/paciente/criarPaciente.html">
						<div class="col-lg-6">
							<!-- Campo nome paciente -->
							<div class="form-group">
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
								<label for="nome"><spring:message code="label.email" /></label>
								<div class="input-group">
									<form:input path="email" cssClass="form-control"
										placeholder="${plhemail}" maxlength="50" />
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-ok form-control-feedback"></i></span>
								</div>
							</div>
							<!-- Campo datanascimento paciente -->
							<div class="control-group">
								<label for="dataNascimento"><spring:message
										code="label.dataNascimentoPac" /></label>
								<div id="datetimepicker4" class="input-append">
									<spring:message code="placeholder.dataNascimento"
										var="plhdataNascimento" />
									<form:input path="dataNascimento"
										placeholder="${plhdataNascimento}" data-mask="99/99/9999"
										maxlength="10" />
								</div>
								<!-- Campo Telefone -->
								<label for="telefone"><spring:message
										code="label.telefone" /></label>
								<div id="datetimepicker4" class="input-append">
									<spring:message code="placeholder.telefone"
										var="plhTelefone" />
									<form:input path="telefone"
										placeholder="${plhTelefone}" data-mask="(99)9-9999-9999"
										maxlength="13" />
								</div>
								<!-- Campo Ativo -->
								<div class="controls">
									<label class="checkbox" for="ativo"><spring:message
											code="label.ativo" /> <form:checkbox path="ativo" /> </label>
								</div>

								<br /> <input type="submit" name="submit" id="submit"
									value="<spring:message code="botao.cadastrar"/>"
									class="btn btn-info pull-left">
							</div>
						</div>
					</form:form>

				</div>

				<!-- Consulta de Empregado -->
				<div id="consultaPaciente" class="tab-pane fade ">

					<div class="container">
						<h3>
							<spring:message code="titulo.conspacientes" />
						</h3>
						<hr>

						<div class="row">
							<div class="panel panel-primary filterable">
								<div class="panel-heading">
									<h3 class="panel-title">
										<spring:message code="tabela.paciente" />
									</h3>
									<div class="pull-right">
										<button class="btn btn-default btn-xs btn-filter">
											<img width="20" height="20" alt="Filtrar"
												src="<c:url value='/resources/img/file_filter.png'/>">
											<spring:message code="titulo.filtrar" />
										</button>
									</div>
								</div>
								<table class="table">
									<thead>
										<tr class="filters">
											<th><spring:message code="coluna.nome" var="nome" /> <input
												type="text" class="form-control" placeholder="${nome}"
												disabled></th>
											<th><spring:message code="coluna.dataNascimento"
													var="dataNascimento" /> <input type="text"
												class="form-control" placeholder="${dataNascimento}"
												disabled></th>
											<th><spring:message code="coluna.ativo" var="ativo" />
												<input type="text" class="form-control"
												placeholder="${ativo}" disabled></th>
											<th><spring:message code="coluna.telefone"
													var="telefone" /> <input type="text"
												class="form-control" placeholder="${telefone}"
												disabled></th>
										</tr>
									</thead>
									<tbody>
										<!-- Populando a tabela -->
										<c:forEach var="paciente" items="${listaPacientes}">
											<c:url var="deletePaciente"
												value="/paciente/deletar?idPaciente=${paciente.idPaciente}" />
											<c:url var="updateEmpregado"
												value="/paciente/editar/${paciente.idPaciente}.html" />
											<tr>
												<td>${paciente.nome}</td>
												<td>${paciente.dataNascimento}</td>
												<td><input type="checkbox"
													${paciente.ativo ? 'checked' : ''} disabled="disabled"></td>
												<td>${paciente.email}</td>
												<td><a href="#modal-dialog" class="modal-toggle"
													data-toggle="modal" data-modal-type="confirm"> <img
														width="20" height="20"
														alt="<spring:message code="botao.excluir"/>"
														src="<c:url value='/resources/img/file_delete.png'/>">
												</a></td>
												<td><a href="${updateEmpregado}"> <img width="20"
														height="20" alt="<spring:message code="botao.editar"/>"
														src="<c:url value='/resources/img/file_edit.png'/>">
												</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>

		<!-- Confirm dialog -->

		<div id="modal-dialog" class="modal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<a href="#" data-dismiss="modal" aria-hidden="true" class="close">×</a>
						<h3 style="color: red;">VOCE TEM CERTEZA</h3>
					</div>
					<div class="modal-body">
						<p>Que quer excluir o empregado selecionado?</p>
					</div>
					<div class="modal-footer">
						<a href="${deletePaciente}" id="btnYes" class="btn confirm">Sim,
							eu quero</a> <a href="#" data-dismiss="modal" aria-hidden="true"
							class="btn secondary">Não e me tire daqui</a>
					</div>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
