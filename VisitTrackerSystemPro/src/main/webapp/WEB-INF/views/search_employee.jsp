<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<h2><spring:message code="header.searchEmp"/></h2>
<form:form name="employeeFrm" method="post" action="create.do" commandName="employee" onsubmit="return validateForm()">
	<table width="100%" cellpadding="4" cellspacing="1" border="0" id="outerTable">
		<tbody>
		<tr>
			<td>
			<table border="0" width="30%" id="maintbl" cellpadding="4" cellspacing="1">
			    <tr>
			        <td align="right" class="textbold"><form:label path="employeeNumber"><spring:message code="label.employeeNumber"/></form:label>
			        <%-- <form:errors path="employeeNumber" cssClass="errors"/> --%></td>
			        <td><form:input path="employeeNumber" size="10" maxlength="10" cssClass="text"/></td>
			    </tr>
			</table>  
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" name="AddVisit" value="<spring:message code="button.addVisit"/>" class="btn"/>
				<input type="submit" name="ManageVisit" value="<spring:message code="button.manageVisit"/>" class="btn" onclick="submitForm('ManageVisit')"/>
				<input type="reset" value="<spring:message code="button.reset"/>" class="btn"/>
			</td>
		</tr>
		</tbody>
	</table>
</form:form>

<script type="text/javascript">

	function submitForm(action) {
		if(action=="ManageVisit") {
			document.forms['employeeFrm'].action='showvisitstomanage.do';
		    document.forms['employeeFrm'].submit();
		}
	} 

	function validateForm() {
		var employeeNumber=document.forms["employeeFrm"]["employeeNumber"].value;
		if (employeeNumber==null || employeeNumber=="") {
			alert("Employee Number can not be Empty!");
			document.forms["employeeFrm"]["employeeNumber"].focus();
			return false;
		}
		
		var numbers = /^[0-9]+$/;
		if(!employeeNumber.match(numbers)) {  
			alert("Employee Number must be Numeric!");
			document.forms["employeeFrm"]["employeeNumber"].focus();
			return false;
		}
		return true;
	}
</script>
<script>
	document.forms["employeeFrm"]["employeeNumber"].focus();
</script>
<%@ include file="/WEB-INF/views/footer.jsp" %>