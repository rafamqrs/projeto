<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="body">
			<p>
				<spring:message code="projeto.informacoes"/>
			</p>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>