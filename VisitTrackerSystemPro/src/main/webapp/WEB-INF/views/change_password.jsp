<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>



<h2><spring:message code="header.changePassword"/></h2>
<form:form name="chngPasswdFrm" method="post" action="changepasswordsuccess.do" commandName="login" onsubmit="return validateForm1()">
	<table width="100%" align="center" cellpadding="4" cellspacing="1" id="outerTable">
		<tbody>
		<tr>
			<td>
			<table border="0" width="45%" align="center" id="maintbl" cellpadding="4" cellspacing="0" class="text">
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
			    <tr>
			        <td class="textbold"><form:label path="employee.department.name"><spring:message code="label.department"/></form:label></td>
			        <td class="text">${login.employee.department.name}</td>
			    </tr>
			    <tr>
			        <td class="textbold"><form:label path="password"><spring:message code="label.password"/></form:label></td>
			        <td class="text"><form:password path="password" size="15" maxlength="15" cssClass="text"/></td>
			    </tr>
			    <tr>
			        <td class="textbold"><form:label path="password"><spring:message code="label.confirmPassword"/></form:label></td>
			        <td class="text"><form:password path="password" size="15" maxlength="15" cssClass="text"/></td>
			    </tr>
			</table>
			</td>
		</tr>
		<tr>
	        <td colspan="4" align="center">
	            <input type="submit" value="<spring:message code="button.changePassword"/>" class="btn"/>
				<input type="reset" value="<spring:message code="button.reset"/>" class="btn"/>
				<A href="<c:url value="/home.do"/>"><input type="button" value="<spring:message code="button.cancel"/>" class="btn"/></A>
	        </td>
	    </tr></tbody>
	</table>
</form:form>

<script>
	document.forms["chngPasswdFrm"]["password"].focus();
</script>
<%@ include file="/WEB-INF/views/footer.jsp" %>