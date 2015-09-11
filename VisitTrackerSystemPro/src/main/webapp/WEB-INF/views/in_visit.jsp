<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<script type="text/javascript">

	function validateForm() {

		var vehicleNumber=document.forms["inVisitFrm"]["vehicleNumber"].value;
		if (vehicleNumber==null || vehicleNumber=="") {
			alert("Please Enter Vehicle Number!");
			document.forms["inVisitFrm"]["vehicleNumber"].focus();
			return false;
		}
		
		var material=document.forms["inVisitFrm"]["material"].value;
		if (material==null || material=="") {
			alert("Please Enter Material!");
			document.forms["inVisitFrm"]["material"].focus();
			return false;
		}
		var alpha = /^[A-Za-z ]+$/;
		if(!material.match(alpha)) {  
			alert("Please Enter a valid Material!");
			document.forms["inVisitFrm"]["material"].focus();
			return false;
		}
		return true;
	}
</script>
<h2><spring:message code="header.inVisit"/></h2>
<form:form name="inVisitFrm" method="post" action="in_visit.do" commandName="visit" onsubmit="return validateForm()">
	<table width="100%" align="center" cellpadding="4" cellspacing="1" class="text">
		<tbody><tr>
			<td>
				<table border="0" width="45%" align="center" id="maintbl" cellpadding="4" cellspacing="0" class="text">
					<form:hidden path="visitId" />
				    <tr>
				        <td class="textbold"><form:label path="employee.employeeNumber"><spring:message code="label.employeeNumber"/></form:label></td>
				        <td>${visit.employee.employeeNumber}</td>
				        <td class="textbold"><form:label path="createdOn"><spring:message code="label.currentDate"/></form:label></td>
				        <td><fmt:formatDate value="${visit.createdOn}" pattern="dd/MMM/yyyy"/></td>
				    </tr>
				    <tr>
				        <td class="textbold"><form:label path="employee.firstName"><spring:message code="label.employeeName"/></form:label></td>
				        <td align="left">${visit.employee.firstName} ${visit.employee.lastName}</td>
				        <td class="textbold"><form:label path="employee.department.name"><spring:message code="label.department"/></form:label></td>
			        	<td align="left" class="text">${visit.employee.department.name}</td>
				    </tr>
				    <tr>
				        <td class="textbold"><form:label path="visitorName"><spring:message code="label.visitorName"/></form:label></td>
				        <td colspan="3">${visit.visitorName}</td>
				    </tr>
					<tr>
				        <td class="textbold"><form:label path="representing"><spring:message code="label.representing"/></form:label></td>
				        <td colspan="3">${visit.representing}</td>
				    </tr>
				    <tr>
				        <td class="textbold"><form:label path="mobileNumber"><spring:message code="label.mobileNumber"/></form:label></td>
				        <td colspan="3">${visit.mobileNumber}</td>
				    </tr>
					<tr>
				        <td class="textbold"><form:label path="purpose"><spring:message code="label.purpose"/></form:label></td>
				        <td colspan="3">${visit.purpose}</td>
				    </tr>
					<tr>
				        <td class="textbold"><form:label path="vehicleNumber"><spring:message code="label.vehicleNumber"/></form:label></td>
				        <td class="text"><form:input path="vehicleNumber" size="20" maxlength="20"/></td>
				        <td class="textbold"><form:label path="material"><spring:message code="label.material"/></form:label></td>
				        <td class="text"><form:input path="material" size="30" maxlength="50"/></td>
				    </tr>
				</table>
			</td>
		</tr>
		<tr>
	        <td colspan="4" align="center">
	            <input type="submit" value="<spring:message code="button.inVisit"/>" class="btn"/>
	            <A href="<c:url value="/home.do"/>"><input type="button" value="<spring:message code="button.cancel"/>" class="btn"/></A>
	        </td>
	    </tr></tbody>
	</table>
</form:form>
<%@ include file="/WEB-INF/views/footer.jsp" %>