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
				<li class=""><a data-toggle="tab" href="#consultaEmpregado">Consultar
						Empregado</a></li>
			</ul>
			<div class="tab-content" id="myTabContent">
				<!-- Cadastro de Empregado -->
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
									aria-hidden="true">×</button>
								<strong>${infoMessage}</strong>
							</div>
						</div>
						</c:if>
					</div>
					<br />

					<!-- Formulario de cadastro de empregado -->
					<form:form method="POST" commandName="empregado" id="empregado-form"
						action="${pageContext.request.contextPath}/empregado/criarEmpregado.html">
						<div class="col-lg-6">
							<!-- Campo nome empregado -->
							<div class="form-group">
								<spring:message code="placeholder.nome" var="plhnome" />
								<label for="nome"><spring:message code="label.nomeEmp" /></label>
								<div class="input-group">
									<form:input path="nome" cssClass="form-control"
										placeholder="${plhnome}" maxlength="50" />
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-ok form-control-feedback"></i></span>
								</div>
							</div>
							<!-- Campo funcao empregado -->
							<div class="form-group">
								<spring:message code="placeholder.funcao" var="plhfuncao" />
								<label for="funcao"><spring:message code="label.funcao" /></label>
								<div class="input-group">
									<form:input path="funcao" cssClass="form-control"
										placeholder="${plhfuncao}" maxlength="30" />
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-ok form-control-feedback"></i></span>
								</div>
							</div>
							<!-- Campo salario empregado -->
							<div class="form-group">
								<spring:message code="placeholder.salario" var="plh.salario" />
								<label for="salario"><spring:message
										code="label.salario" /></label>
								<div class="input-group">
									<form:input path="salario" cssClass="form-control"
										placeholder="${plhsalario}" class="form-control"
										data-mask="9.99999" />
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
									<form:input path="dataNascimento"
										placeholder="${plhdataNascimento}" data-mask="99/99/9999"
										maxlength="10" />
								</div>
								<label for="departamento"><spring:message
										code="label.departamento" /></label>
								<form:select path="departamento" cssClass="form-control">
									<form:option value="0" label="--Select--" />
									<form:options items="${listDepartamento}"
										itemValue="idDepartamento" itemLabel="descricao" />
								</form:select>
								<br /> <input type="submit" name="submit" id="submit"
									value="<spring:message code="botao.cadastrar"/>"
									class="btn btn-info pull-left">
							</div>
						</div>
					</form:form>

				</div>

				<!-- Consulta de Empregado -->
				<div id="consultaEmpregado" class="tab-pane fade ">

					<div class="container">
						<h3>
							<spring:message code="titulo.consempregados" />
						</h3>
						<hr>

						<div class="row">
							<div class="panel panel-primary filterable">
								<div class="panel-heading">
									<h3 class="panel-title">
										<spring:message code="tabela.empregado" />
									</h3>
									<div class="pull-right">
										<button class="btn btn-default btn-xs btn-filter">
											<img width="20" height="20" alt="Filtrar" src="<c:url value='/resources/img/file_filter.png'/>">
											<spring:message code="titulo.filtrar"/>
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
											<th><spring:message code="coluna.ativo" var="ativo" /> <input
												type="text" class="form-control" placeholder="${ativo}"
												disabled></th>
											<th><spring:message code="coluna.funcao" var="funcao" />
												<input type="text" class="form-control"
												placeholder="${funcao}" disabled></th>
											<th><spring:message code="coluna.departamento"
													var="departamento" /> <input type="text"
												class="form-control" placeholder="${departamento}" disabled>
											</th>
											<th><spring:message code="coluna.salario" var="salario" />
												<input type="text" class="form-control"
												placeholder="${salario}" disabled></th>
											<th><spring:message code="coluna.acao" /></th>
										</tr>
									</thead>
									<tbody>
										<!-- Populando a tabela -->
										<c:forEach var="empregado" items="${listaEmpregados}">
											<c:url var="deleteEmpregado"
												value="/empregado/deletar?idEmpregado=${empregado.idEmpregado}" />
											<c:url var="updateEmpregado"
												value="/empregado/editar/${empregado.idEmpregado}.html" />
											<tr>
												<td>${empregado.nome}</td>
												<td>${empregado.dataNascimento}</td>
												<td><input type="checkbox"
													${empregado.ativo ? 'checked' : ''} disabled="disabled"></td>
												<td>${empregado.funcao}</td>
												<td>${empregado.departamento.descricao}</td>
												<td>${empregado.salario}</td>
												<td><a href="#modal-dialog" class="modal-toggle"
													data-toggle="modal" data-modal-type="confirm">
														<img width="20" height="20" alt="<spring:message code="botao.excluir"/>" src="<c:url value='/resources/img/file_delete.png'/>">
												    </a>
												</td>
												<td>
													<a href="${updateEmpregado}">
														<img width="20" height="20" alt="<spring:message code="botao.editar"/>" src="<c:url value='/resources/img/file_edit.png'/>">
													</a>
												</td>
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
						<a href="${deleteEmpregado}" id="btnYes" class="btn confirm">Sim, eu
							quero</a> <a href="#" data-dismiss="modal" aria-hidden="true"
							class="btn secondary">Não e me tire daqui</a>
					</div>
				</div>
			</div>
		</div>


	</tiles:putAttribute>
</tiles:insertDefinition>
