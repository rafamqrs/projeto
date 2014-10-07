<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<br />
		<!-- Cadastro de Plano -->
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
			<!-- Formulario de cadastro de Plano -->
			<form:form method="POST" commandName="plano"
				action="${pageContext.request.contextPath}/plano/editarPlano/${plano.idPlano}.html">
				<div class="col-lg-6">
					<!-- Campo id plano -->
					<div class="form-group">
						<label for="idPlano"><spring:message code="label.idPlano" /></label>
						<div class="input-group">
							<form:input path="idPlano" cssClass="form-control"
								maxlength="50" disabled="true" />
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-ok form-control-feedback"></i></span>
						</div>

						<spring:message code="placeholder.nomePlano" var="plhnome" />
						<label for="nome"><spring:message code="label.nomePlano" /></label>
						<div class="input-group">
							<form:input path="nome" cssClass="form-control"
								placeholder="${plhnome}" maxlength="50" />
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-ok form-control-feedback"></i></span>
						</div>
					</div>
					<!-- Campo ans -->
					<div class="form-group">
						<spring:message code="placeholder.ans" var="plhans" />
						<label for="ans"><spring:message code="label.ans" /></label>
						<div class="input-group">
							<form:input path="ans" cssClass="form-control"
								placeholder="${plhans}" maxlength="30" />
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
								placeholder="${plhcnpj}" maxlength="50"
								data-mask="99.999.999/9999-99" />
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-ok form-control-feedback"></i></span>
						</div>
					</div>
					<div class="control-group">
						<div class="control-group">
							<label for="dataEntrega"><spring:message
									code="label.dataEntrega" /></label>
							<div id="datetimepicker4" class="input-append">
								<spring:message code="placeholder.dataEntrega"
									var="plhdataEntrega" />
								<form:input path="dataEntrega" placeholder="${plhdataEntrega}"
									data-mask="99/99/9999" maxlength="10" />
							</div>
							<!-- Campo Desconto -->
							<label for="desconto"><spring:message
									code="label.desconto" /></label>
							<div id="datetimepicker4" class="input-append">
								<spring:message code="placeholder.desconto" var="plhdesconto" />
								<form:input path="desconto" placeholder="${plhdesconto}"
									maxlength="13" />
							</div>
							<br /> <input type="submit"
								value="<spring:message code="botao.editar"/>">

						</div>
					</div>
			</form:form>

		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
