<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
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
			<br/><br/>
			<div class="panel panel-primary filterable">
				<div class="panel-heading">
					<h3 class="panel-title">
						<spring:message code="tabela.departamento" />
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
								type="text" class="form-control" placeholder="${nome}" disabled>
							</th>
							<th><spring:message code="coluna.dataCadastro"
									var="dataCadastro" />
								<input type="text" class="form-control"
								placeholder="${dataCadastro}" disabled>
							</th>
							<th><spring:message code="coluna.ativo" var="ativo" /> <input
								type="text" class="form-control" placeholder="${ativo}" disabled>
							</th>
							<th><spring:message code="coluna.acao" /></th>
						</tr>
					</thead>
					<tbody>
						<!-- Populando a tabela -->
						<c:forEach var="departamentos" items="${listaDepartamentos}">
							<c:url var="deleteUrl"
								value="/departamento/deletar?idDepartamento=${departamentos.idDepartamento}" />
							<tr>
								<td>${departamentos.descricao}</td>
								<td>${departamentos.dataCriacao}</td>
								<td><input type="checkbox"
									${departamentos.ativo ? 'checked' : ''} disabled="disabled"></td>
								<td>
									<a href="#modal-dialog" class="modal-toggle"
										data-toggle="modal"
										data-modal-type="confirm">
										<img width="20" height="20" alt="<spring:message code="botao.excluir"/>" 
											 src="<c:url value='/resources/img/file_delete.png'/>">
									</a>
								</td>
							</tr>
						</c:forEach>
						<tfoot>
							<tr> <th ALIGN=LEFT COLSPAN=3><spring:message code="coluna.total"/> ${total}</th>
							</tr>
						</tfoot>
					</tbody>
				</table>
			</div>
		</div>
		<!-- Confirm dialog -->
		
		<div id="modal-dialog" class="modal">
			<div class="modal-dialog">
		      <div class="modal-content">
		        <div class="modal-header">
		            <a href="#" data-dismiss="modal" aria-hidden="true" class="close">×</a>
		             <h3 style="color:red;">Voce tem certeza</h3>
		        </div>
		        <div class="modal-body">
		             <p>Que quer apagar o departamento e todos o empregados associados?</p>
		        </div>
		        <div class="modal-footer">
		          <a href="${deleteUrl}" id="btnYes" class="btn confirm">Sim, eu quero</a>
		          <a href="#" data-dismiss="modal" aria-hidden="true" class="btn secondary">Não e me tire daqui</a>
		        </div>
		      </div>
		    </div>
		</div>
	</tiles:putAttribute>
	
	
	
</tiles:insertDefinition>