<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<br />
		<div class="bs-example bs-example-tabs">
			<ul class="nav nav-tabs" id="myTab">
				<li class="active"><a data-toggle="tab" href="#cadastro">Efetuar
						Pedido Servico</a></li>
				<li class=""><a data-toggle="tab" href="#consultaServico">Consultar
						Serviços</a></li>
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
					<form:form method="POST" commandName="servico" id="servico-form"
						action="${pageContext.request.contextPath}/servico/criarServico.html">
						<div class="col-lg-6">
							<!-- Campo nome paciente -->
							<div class="form-group">
								<spring:message code="placeholder.descricaoServico"
									var="plhnome" />
								<label for="nome"><spring:message
										code="label.descricaoServico" /></label>
								<div class="input-group">
									<form:input path="descricao" cssClass="form-control"
										placeholder="${plhnome}" maxlength="50" />
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-ok form-control-feedback"></i></span>
								</div>
							</div>
							<!-- Campo email paciente -->
							<div class="form-group">
								<spring:message code="placeholder.tipoServico" var="plhemail" />
								<label for="nome"><spring:message
										code="label.tipoServico" /></label>
								<div class="input-group">
									<form:input path="tipo" cssClass="form-control"
										placeholder="${plhemail}" maxlength="50" />
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-ok form-control-feedback"></i></span>
								</div>
								<br /> <b>Paciente:</b>
								<c:if test="${empty listaPacientes}">
									<b><font color="red">Não existem Pacientes
											cadastrados</font></b>
								</c:if>
								<c:if test="${not empty listaPacientes}">

									<select id="selectSabor" class="multiselect" name="valorPaciente">
										<c:forEach items="${listaPacientes}" var="valor"
											varStatus="count">
											<option value="${valor.idPaciente}">${ valor.nome }</option>
										</c:forEach>
									</select>
								</c:if>
								<br /> <br />
								<!-- Campo preco -->
								<div id="datetimepicker4" class="input-append">
									<label for="desconto"><spring:message
											code="label.precoTotal" /></label>
									<spring:message code="placeholder.precoTotal" var="plhdesconto" />
									<form:input path="precoTotal" placeholder="${plhdesconto}"
										maxlength="13" />
								</div>
								<br /> <b>Plano:</b>
								<c:if test="${empty listaPlanos}">
									<b><font color="red">Não existem Planos cadastrados</font></b>
								</c:if>
								<c:if test="${not empty listaPlanos}">
									<!-- Build your select: -->
									<select class="select2" style="width: 400px;"
										multiple="multiple" id="mySel4" name="valorPlano">
										<c:forEach items="${listaPlanos}" var="valor"
											varStatus="count">
											<option value="${valor.idPlano}">${ valor.nome }</option>
										</c:forEach>
									</select>

								</c:if>

								<b>Medicamento:</b>
								<c:if test="${empty listaMedicamentos}">
									<b><font color="red">Não existem Medicamentos
											cadastrados</font></b>
									<br />
									<br />
								</c:if>
								<c:if test="${not empty listaMedicamentos}">
									<select class="select2" id="mySel3" style="width: 400px;"
										multiple="multiple" name="valorMedicamento">
										<c:forEach items="${listaMedicamentos}" var="valor"
											varStatus="count">
											<option value="${valor.idMedicamento}">${ valor.descricao }</option>
										</c:forEach>
									</select>
								</c:if>
								<br /> <br /> <input type="submit" name="submit" id="submit"
									value="<spring:message code="botao.cadastrar"/>"
									class="btn btn-info pull-left">
							</div>
						</div>
					</form:form>

				</div>

				<!-- Consulta de Empregado -->
				<div id="consultaServico" class="tab-pane fade ">

					<div class="container">
						<h3>Serviços</h3>
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
