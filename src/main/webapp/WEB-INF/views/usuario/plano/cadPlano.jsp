<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<tiles:insertDefinition name="defaultTemplate">
<tiles:putAttribute name="body">
		<br />
		<div class="bs-example bs-example-tabs">
			<ul class="nav nav-tabs" id="myTab">
				<li class="active"><a data-toggle="tab" href="#cadastro">Cadastrar</a></li>
				<li class=""><a data-toggle="tab" href="#consultaPlano">Consultar
						Plano</a></li>
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

					<!-- Formulario de cadastro de plano -->
					<form:form method="POST" commandName="plano" id="plano-form"
						action="${pageContext.request.contextPath}/plano/criarPlano.html">
						<div class="col-lg-6">
							<!-- Campo nome paciente -->
							<div class="form-group">
								<spring:message code="placeholder.nomePlano" var="plhnome" />
								<label for="nome"><spring:message code="label.nomePlano" /></label>
								<div class="input-group">
									<form:input path="nome" cssClass="form-control"
										placeholder="${plhnome}" maxlength="50" />
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-ok form-control-feedback"></i></span>
								</div>
							</div>
							<!-- Campo CODIGO ANS -->
							<div class="form-group">
								<spring:message code="placeholder.ans" var="plhans" />
								<label for="ans"><spring:message code="label.ans" /></label>
								<div class="input-group">
									<form:input path="ans" cssClass="form-control"
										placeholder="${plhans}" maxlength="50" />
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-ok form-control-feedback"></i></span>
								</div>
							</div>
							<!-- Campo CODIGO CNPJ -->
							<div class="form-group">
								<spring:message code="placeholder.cnpj" var="plhcnpj" />
								<label for="cnpj"><spring:message code="label.cnpj" /></label>
								<div class="input-group">
									<form:input path="cnpj" cssClass="form-control"
										placeholder="${plhcnpj}" maxlength="50" data-mask="99.999.999/9999-99"/>
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-ok form-control-feedback"></i></span>
								</div>
							</div>
							<!-- Campo data de chegada -->
							<div class="control-group">
								<label for="dataEntrega"><spring:message
										code="label.dataEntrega" /></label>
								<div id="datetimepicker4" class="input-append">
									<spring:message code="placeholder.dataEntrega"
										var="plhdataEntrega" />
									<form:input path="dataEntrega"
										placeholder="${plhdataEntrega}" data-mask="99/99/9999"
										maxlength="10" />
								</div>
								<!-- Campo Desconto -->
								<label for="desconto"><spring:message
										code="label.desconto" /></label>
								<div id="datetimepicker4" class="input-append">
									<spring:message code="placeholder.desconto"
										var="plhdesconto" />
									<form:input path="desconto"
										placeholder="${plhdesconto}" maxlength="13" />
								</div>

								<br /> <input type="submit" name="submit" id="submit"
									value="<spring:message code="botao.cadastrar"/>"
									class="btn btn-info pull-left">
							</div>
						</div>
					</form:form>

				</div>

				<!-- Consulta de Plano -->
				<div id="consultaPlano" class="tab-pane fade ">

					<div class="container">
						<h3>
							<spring:message code="titulo.consplanos" />
						</h3>
						<hr>

						<div class="row">
							<div class="panel panel-primary filterable">
								<div class="panel-heading">
									<h3 class="panel-title">
										<spring:message code="tabela.planos" />
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
											<th><spring:message code="coluna.idPlano" var="idPlano" /> <input
												type="text" class="form-control" placeholder="${idPlano}"
												disabled></th>
											<th><spring:message code="coluna.nomePlano" var="nomePlano" /> <input
												type="text" class="form-control" placeholder="${nomePlano}"
												disabled></th>
											<th><spring:message code="coluna.ans"
													var="ans" /> <input type="text"
												class="form-control" placeholder="${ans}"
												disabled></th>
											<th><spring:message code="coluna.cnpj"
													var="cnpj" /> <input type="text"
												class="form-control" placeholder="${cnpj}"
												disabled></th>
											<th><spring:message code="coluna.dataEntrega" var="dataEntrega" />
												<input type="text" class="form-control"
												placeholder="${dataEntrega}" disabled></th>
											<th><spring:message code="coluna.desconto"
													var="desconto" /> <input type="text"
												class="form-control" placeholder="${desconto}"
												disabled></th>
										</tr>
									</thead>
									<tbody>
										<!-- Populando a tabela -->
										<c:forEach var="plano" items="${listaPlano}">
											<c:url var="deletePlano"
												value="/plano/deletar?idPlano=${plano.idPlano}" />
											<c:url var="updatePlano"
												value="/plano/editar/${plano.idPlano}.html" />
											<tr>
												<td>${plano.nome}</td>
												<td>${plano.ans}</td>
												<td>${plano.cnpj}</td>
												<td>${plano.dataEntrega}</td>
												<td>${plano.desconto}</td>
												<td><spring:message code="botao.acoes"/></td>
												<td><a href="#modal-dialog" class="modal-toggle"
													data-toggle="modal" data-modal-type="confirm"> <img
														width="20" height="20"
														alt="<spring:message code="botao.excluir"/>"
														src="<c:url value='/resources/img/file_delete.png'/>">
												</a></td>
												<td><a href="${updatePlano}"> <img width="20"
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
						<p><spring:message code="mensagem.exclusaoPlano"/></p>
					</div>
					<div class="modal-footer">
						<a href="${deletePlano}" id="btnYes" class="btn confirm">Sim,
							eu quero</a> <a href="#" data-dismiss="modal" aria-hidden="true"
							class="btn secondary"><spring:message code="mensagem.metire"/></a>
					</div>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
