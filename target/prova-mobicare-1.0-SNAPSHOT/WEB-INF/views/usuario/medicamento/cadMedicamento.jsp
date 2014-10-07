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
				<li class=""><a data-toggle="tab" href="#consultaMedicamento">Consultar
						Medicamento</a></li>
			</ul>
			<div class="tab-content" id="myTabContent">
				<!-- Cadastro de Medicamento -->
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

					<!-- Formulario de cadastro de Medicamento -->
					<form:form method="POST" commandName="medicamento" id="medicamento-form"
						action="${pageContext.request.contextPath}/medicamento/criarMedicamento.html">
						<div class="col-lg-6">
							<!-- Campo nome Medicamento -->
							<div class="form-group">
								<spring:message code="placeholder.descricaoMedicamento" var="plhdm" />
								<label for="dm"><spring:message code="label.descricaoMedicamento" /></label>
								<div class="input-group">
									<form:input path="descricao" cssClass="form-control"
										placeholder="${plhdm}" maxlength="50" />
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-ok form-control-feedback"></i></span>
								</div>
							</div>
							<!-- Campo label.indicacaoMedicamento -->
							<div class="form-group">
								<spring:message code="placeholder.indicacaoMedicamento" var="plhindicacaoMedicamento" />
								<label for="indicacaoMedicamento"><spring:message code="label.indicacaoMedicamento" /></label>
								<div class="input-group">
									<form:input path="indicacao" cssClass="form-control"
										placeholder="${plhindicacaoMedicamento}" maxlength="50" />
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-ok form-control-feedback"></i></span>
								</div>
							</div>
							<!-- Campo placeholder.dataValidade -->
							<div class="control-group">
								<label for="dataValidade"><spring:message
										code="label.dataValidade" /></label>
								<div id="datetimepicker4" class="input-append">
									<spring:message code="placeholder.dataValidade"
										var="plhdataValidade" />
									<form:input path="dataValidade"
										placeholder="${plhdataValidade}" data-mask="99/99/9999"
										maxlength="10" />
								</div>
								<!-- Campo preco -->
								<label for="desconto"><spring:message
										code="label.preco" /></label>
								<div id="datetimepicker4" class="input-append">
									<spring:message code="placeholder.preco" var="plhdesconto" />
									<form:input path="preco" placeholder="${plhdesconto}"
										maxlength="13" />
								</div>

								<br /> <input type="submit" name="submit" id="submit"
									value="<spring:message code="botao.cadastrar"/>"
									class="btn btn-info pull-left">
							</div>
						</div>
					</form:form>

				</div>

				<!-- Consulta de Medicamento -->
				<div id="consultaMedicamento" class="tab-pane fade ">

					<div class="container">
						<h3>
							<spring:message code="titulo.consmedicamento" />
						</h3>
						<hr>

						<div class="row">
							<div class="panel panel-primary filterable">
								<div class="panel-heading">
									<h3 class="panel-title">
										<spring:message code="tabela.medicamento" />
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
											<th><spring:message code="coluna.idMedicamento" var="codigo" /> <input
												type="text" class="form-control" placeholder="${codigo}"
												disabled></th>
											<th><spring:message code="coluna.descricaoMedicamento"
													var="descricaoMed" /> <input type="text"
												class="form-control" placeholder="${descricaoMed}"
												disabled></th>
											<th><spring:message code="coluna.indicacaoMedicamento" var="indicacaoMed" />
												<input type="text" class="form-control"
												placeholder="${indicacaoMed}" disabled></th>
											<th><spring:message code="coluna.dataValidade" var="dataValidade" />
												<input type="text" class="form-control"
												placeholder="${dataValidade}" disabled></th>
											<th><spring:message code="coluna.precoMedicamento"
													var="preco" /> <input type="text"
												class="form-control" placeholder="${preco}"
												disabled></th>
											<th><spring:message code="${botao.acoes}"/></th>
										</tr>
									</thead>
									<tbody>
										<!-- Populando a tabela -->
										<c:forEach var="medicamento" items="${listaMedicamentos}">
											<c:url var="deleteMedicamento"
												value="/medicamento/deletar?idMedicamento=${medicamento.idMedicamento}" />
											<c:url var="updateMedicamento"
												value="/medicamento/editar/${medicamento.idMedicamento}.html" />
											<tr>
												<td>${medicamento.idMedicamento}</td>
												<td>${medicamento.descricao}</td>
												<td>${medicamento.indicacao}</td>
												<td>${medicamento.dataValidade}</td>
												<td>${medicamento.preco}</td>
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
						<h3 style="color: red;"><spring:message code="mensagem.certeza"/></h3>
					</div>
					<div class="modal-body">
						<p><spring:message code="mensagem.certeza"/></p>
					</div>
					<div class="modal-footer">
						<a href="${deleteMedicamento}" id="btnYes" class="btn confirm">Sim,
							eu quero</a> <a href="#" data-dismiss="modal" aria-hidden="true"
							class="btn secondary"><spring:message code="mensagem.metire"/></a>
					</div>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
