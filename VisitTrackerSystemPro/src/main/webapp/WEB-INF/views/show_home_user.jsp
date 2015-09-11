<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<h2><spring:message code="header.home"/></h2>
<table width="100%" cellpadding="4" cellspacing="1" border="0" id="outerTable">
	<tbody>
	<tr>
		<td>
		<table border="0" id="maintbl" cellpadding="4" cellspacing="1">
			<tr>
				<td><a href="<c:url value="/employee/addvisit.do"/>">Add Visit</a></td>
			</tr>
			<tr>
				<td><a href="<c:url value="/employee/showvisitstomanage.do"/>">Manage Visit</a></td>
			</tr>
		</table>  
		</td>
	</tr>
	</tbody>
</table>
<%@ include file="/WEB-INF/views/footer.jsp" %>