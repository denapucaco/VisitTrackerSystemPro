<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<h2><spring:message code="header.confirmVisit"/></h2>
<form:form method="post" action="addsuccess.do" commandName="visit">
	<table width="100%" align="center" cellpadding="4" cellspacing="1" class="text">
		<tbody>
		<tr>
			<td>
			<table border="0" width="45%" align="center" id="maintbl" cellpadding="4" cellspacing="0" class="text">
				<form:hidden path="employee.employeeNumber" />
				<form:hidden path="employee.employeeId" />
				<form:hidden path="employee.firstName" />
				<form:hidden path="employee.lastName" />
			
				<form:hidden path="createdOn"/>
				<form:hidden path="scheduledOn"/>
				<form:hidden path="visitorName" />
				<form:hidden path="representing" />
				<form:hidden path="mobileNumber" />
				<form:hidden path="purpose" />
			    <tr>
			        <td align="right" class="textbold"><form:label path="employee.employeeNumber"><spring:message code="label.employeeNumber"/></form:label></td>
			        <td align="left" class="text">${visit.employee.employeeNumber}</td>
			        <td align="right" class="textbold"><form:label path="createdOn"><spring:message code="label.currentDate"/></form:label></td>
			        <td align="left" class="text"><%-- ${visit.createdOn} --%>
			        <fmt:formatDate value="${visit.createdOn}" pattern="dd/MMM/yyyy"/></td>
			    </tr>
			    <tr>
			        <td align="right" class="textbold"><form:label path="employee.firstName"><spring:message code="label.employeeName"/></form:label></td>
			        <td align="left" class="text">${visit.employee.firstName} ${visit.employee.lastName}</td>
			        <td align="right" class="textbold"><form:label path="employee.department.name"><spring:message code="label.department"/></form:label></td>
			        <td align="left" class="text">${visit.employee.department.name}</td>
			    </tr>
			    <tr>
			        <td align="right" class="textbold"><form:label path="visitorName"><spring:message code="label.visitorName"/></form:label></td>
			        <td colspan="3" align="left" class="text">${visit.visitorName}</td>
			    </tr>
				<tr>
			        <td class="textbold"><form:label path="representing"><spring:message code="label.representing"/></form:label></td>
			        <td colspan="3" align="left" class="text">${visit.representing}</td>
			    </tr>
			    <tr>
			        <td class="textbold"><form:label path="purpose"><spring:message code="label.purpose"/></form:label></td>
			        <td colspan="3" align="left" class="text">${visit.purpose}</td>
			    </tr>
			    <tr>
			        <td align="right" class="textbold"><form:label path="mobileNumber"><spring:message code="label.mobileNumber"/></form:label></td>
			        <td align="left" class="text">${visit.mobileNumber}</td>
			        <td class="textbold"><form:label path="scheduledOn"><spring:message code="label.scheduledOn"/></form:label></td>
			        <td align="left" class="text"><fmt:formatDate value="${visit.scheduledOn}" pattern="dd/MMM/yyyy"/></td>
			    </tr>
			</table>
			</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
			    <input type="submit" value="<spring:message code="button.confirmVisit"/>" class="btn"/>
			    <A href="<c:url value="/home.do"/>"><input type="button" value="<spring:message code="button.cancel"/>" class="btn"/></A>
			</td>
	    </tr></tbody>
	</table>
</form:form>
<%@ include file="/WEB-INF/views/footer.jsp" %>