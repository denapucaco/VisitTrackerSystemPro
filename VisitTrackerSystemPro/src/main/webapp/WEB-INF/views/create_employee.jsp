<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<script type="text/javascript">
jQuery(document).ready(function(){
	jQuery("#idCreateEmpFrm").validationEngine('attach');
});
</script>
<h2><spring:message code="header.addEmployee"/></h2>
<form:form method="post" action="addemployeeconfirm.do" commandName="employee" id="idCreateEmpFrm">
	<table width="100%" align="center" cellpadding="4" cellspacing="1" id="outerTable">
		<tbody>
		<tr>
			<td>
			<table border="0" width="45%" align="center" id="maintbl" cellpadding="4" cellspacing="0" class="text">
			    <tr>
			        <td class="textbold"><form:label path="employeeNumber"><spring:message code="label.employeeNumber"/></form:label></td>
			        <td class="text"><form:input path="employeeNumber" size="10" maxlength="10" cssClass="validate[required,custom[integer]] text"/></td>
			    </tr>
			    <tr>
			        <td class="textbold"><form:label path="firstName"><spring:message code="label.firstName"/></form:label></td>
			        <td class="text"><form:input path="firstName" size="20" maxlength="50" cssClass="validate[required,custom[onlyLetterSp]] text"/></td>
			    </tr>
			    <tr>
			        <td class="textbold"><form:label path="lastName"><spring:message code="label.lastName"/></form:label></td>
			        <td class="text"><form:input path="lastName" size="20" maxlength="50" cssClass="validate[required,custom[onlyLetterSp]] text"/></td>
			    </tr>
			    <tr>
			        <td class="textbold"><form:label path="email"><spring:message code="label.email"/></form:label></td>
			        <td class="text"><form:input path="email" size="30" maxlength="50" cssClass="validate[required,custom[email]] text"/></td>
			    </tr>
			    <tr>
			        <td class="textbold"><form:label path="mobileNumber"><spring:message code="label.mobileNumber"/></form:label></td>
			        <td class="text"><form:input path="mobileNumber" size="10" maxlength="10" cssClass="validate[required,custom[integer]] text"/></td>
			    </tr>
			</table>
			</td>
		</tr>
		<tr>
	        <td colspan="4" align="center">
	            <input type="submit" value="<spring:message code="button.addEmployee"/>" class="btn"/>
				<input type="reset" value="<spring:message code="button.reset"/>" class="btn"/>
				<A href="<c:url value="/home.do"/>"><input type="button" value="<spring:message code="button.cancel"/>" class="btn"/></A>
	        </td>
	    </tr></tbody>
	</table>
</form:form>
<script>
	document.forms["idCreateEmpFrm"]["employeeNumber"].focus();
</script>
<%@ include file="/WEB-INF/views/footer.jsp" %>