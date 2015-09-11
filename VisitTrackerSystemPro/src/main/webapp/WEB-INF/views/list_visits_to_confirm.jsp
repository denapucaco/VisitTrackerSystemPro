<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
 
<h2><spring:message code="header.listVisits"/></h2>
<table width="100%" align="center" cellpadding="4" cellspacing="1" border="0">
	<tbody>
	<tr>
		<td>
			<table align="center" cellpadding="4" cellspacing="1" class="grid">
			<tr>
				<th>Employee Details</th>
			    <th>Visitor Details</th>
			    <th>Purpose</th>
			    <th>In Time</th>
			    <th>&nbsp;</th>
			</tr>
			<c:if test="${!empty visitList}">
				<c:forEach items="${visitList}" var="visit" varStatus="loopStatus">
				    <tr class="${loopStatus.index % 2 == 0 ? 'odd' : 'even'}">
				       <td>${visit.employee.employeeNumber}, ${visit.employee.firstName} ${visit.employee.lastName} (${visit.employee.department.name})</td>
			        	<td>${visit.visitorName} (${visit.representing})</td>
				        <td>${visit.purpose}</td>
							<c:choose>
						        <c:when test="${visit.inTime!=null}">
						        	<td><fmt:formatDate value="${visit.inTime}" pattern="dd/MMM/yyyy HH:mm"/></td>
						        	<td><a href="visit_to_confirm.do?visitId=${visit.visitId}" onClick="return confirm('Are you sure to confirm?');">Confirm</a></td>
						        </c:when>
						        <c:otherwise>
						        	<td>- NA -</td>
						        	<td><a href="visit_to_cancel.do?visitId=${visit.visitId}" onClick="return confirm('Are you sure to cancel?');">Cancel</a></td>
						        </c:otherwise>
				        </c:choose>
				    </tr>
				</c:forEach>
			</c:if>
			</table>
		</td>
	</tr></tbody>
</table>
<%@ include file="/WEB-INF/views/footer.jsp" %>