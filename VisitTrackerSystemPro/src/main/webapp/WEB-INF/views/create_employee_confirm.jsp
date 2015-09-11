<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<h2><spring:message code="header.confirmEmployee"/></h2>
<form:form name="createEmpConfirmFrm" method="post" action="addemployeesuccess.do" commandName="login" onsubmit="return validateForm1()">
	<table width="100%" align="center" cellpadding="4" cellspacing="1" id="outerTable">
		<tbody>
		<tr>
			<td>
			<table border="0" width="45%" align="center" id="maintbl" cellpadding="4" cellspacing="0" class="text">
				<form:hidden path="userName" />
				<form:hidden path="employee.employeeNumber" />
				<form:hidden path="employee.firstName" />
				<form:hidden path="employee.lastName" />
				<form:hidden path="employee.email" />
				<form:hidden path="employee.mobileNumber" />
				
				<tr>
			        <td class="textbold"><form:label path="userName"><spring:message code="label.userName"/></form:label></td>
			        <td class="text">${login.userName}</td>
			    </tr>
			    <tr>
			        <td class="textbold"><form:label path="employee.employeeNumber"><spring:message code="label.employeeNumber"/></form:label></td>
			        <td class="text">${login.employee.employeeNumber}</td>
			    </tr>
			    <tr>
			        <td class="textbold"><form:label path="employee.firstName"><spring:message code="label.firstName"/></form:label></td>
			        <td class="text">${login.employee.firstName}</td>
			    </tr>
			    <tr>
			        <td class="textbold"><form:label path="employee.lastName"><spring:message code="label.lastName"/></form:label></td>
			        <td class="text">${login.employee.lastName}</td>
			    </tr>
			    <tr>
			        <td class="textbold"><form:label path="employee.email"><spring:message code="label.email"/></form:label></td>
			        <td class="text">${login.employee.email}</td>
			    </tr>
			    <tr>
			        <td class="textbold"><form:label path="employee.mobileNumber"><spring:message code="label.mobileNumber"/></form:label></td>
			        <td class="text">${login.employee.mobileNumber}</td>
			    </tr>
			</table>
			</td>
		</tr>
		<tr>
	        <td colspan="4" align="center">
	            <input type="submit" value="<spring:message code="button.confirmEmployee"/>" class="btn"/>
				<A href="<c:url value="/home.do"/>"><input type="button" value="<spring:message code="button.cancel"/>" class="btn"/></A>
	        </td>
	    </tr></tbody>
	</table>
</form:form>

<script>
	document.forms["createEmpFrm"]["employeeNumber"].focus();
</script>
<%@ include file="/WEB-INF/views/footer.jsp" %>