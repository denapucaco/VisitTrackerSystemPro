<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<h2><spring:message code="header.outVisit"/></h2>
<span class="warning">${warning}</span>
<form:form name="outVisitFrm" method="post" action="out_visit.do" commandName="visit" onsubmit="return validateForm()">
	<table width="100%" align="center" cellpadding="4" cellspacing="1" class="text">
		<tbody><tr>
			<td>
				<table border="0" width="45%" align="center" id="maintbl" cellpadding="4" cellspacing="0" class="text">
					<form:hidden path="visitId" />
					<form:hidden path="visitDuration" />
					<form:hidden path="isConfirmed" />
				    <tr>
				        <td class="textbold"><form:label path="employee.employeeNumber"><spring:message code="label.employeeNumber"/></form:label></td>
				        <td>${visit.employee.employeeNumber}</td>
				        <td class="textbold"><form:label path="createdOn"><spring:message code="label.createdOnDate"/></form:label></td>
				        <td><fmt:formatDate value="${visit.createdOn}" pattern="dd/MMM/yyyy"/></td>
				    </tr>
				    <tr>
				        <td class="textbold"><form:label path="employee.firstName"><spring:message code="label.employeeName"/></form:label></td>
				        <td>${visit.employee.firstName} ${visit.employee.lastName}</td>
				        <td class="textbold"><form:label path="inTime"><spring:message code="label.inTime"/></form:label></td>
				        <td><fmt:formatDate value="${visit.inTime}" pattern="dd/MMM/yyyy HH:mm"/></td>
				    </tr>
				    <tr>
				    	<td class="textbold"><form:label path="employee.department.name"><spring:message code="label.department"/></form:label></td>
						<td align="left" class="text">${visit.employee.department.name}</td>
				        <td class="textbold"><form:label path="visitDuration"><spring:message code="label.visitDuration"/></form:label></td>
						<td>${visit.visitDuration}</td>
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
				        <td>${visit.vehicleNumber}</td>
				        <td class="textbold"><form:label path="material"><spring:message code="label.material"/></form:label></td>
				        <td>${visit.material}</td>
					</tr>
				</table>
			</td>
		</tr>
		 <tr>
	        <td colspan="4" align="center">
	            <input type="submit" value="<spring:message code="button.outVisit"/>" class="btn"/>
	            <A href="index.do"><input type="button" value="<spring:message code="button.cancel"/>" class="btn"/></A>
	        </td>
	    </tr></tbody>
	</table>
</form:form>
<script type="text/javascript">
	function validateForm() {
		var isConfirmed=document.forms["outVisitFrm"]["isConfirmed"].value;
		if(isConfirmed=='false'){
			var userInput=confirm("Visit not confirmed.\n Are you sure you want to out the Visitor?");
			if (userInput==false) {
				return false;
			}
		}
		return true;
	}
</script>
<%@ include file="/WEB-INF/views/footer.jsp" %>