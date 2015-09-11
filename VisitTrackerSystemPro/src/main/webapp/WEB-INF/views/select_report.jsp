<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<script type="text/javascript">

$(document).ready(function(){
    $("#fromDate").datepicker({
    	changeMonth: true,
		changeYear: true,
		showOtherMonths: true,
		showOn: "button",
		buttonImage: "/VTSPro/images/calendar.gif",
		buttonImageOnly: true,
        numberOfMonths: 1,
        maxDate: 0,
        onSelect: function(selected) {
          $("#toDate").datepicker("option","minDate", selected)
        }
    });
    $("#toDate").datepicker({
        changeMonth: true,
		changeYear: true,
		showOtherMonths: true,
		showOn: "button",
		buttonImage: "/VTSPro/images/calendar.gif",
		buttonImageOnly: true,
        numberOfMonths: 1,
        maxDate: 0,
        onSelect: function(selected) {
           $("#fromDate").datepicker("option","maxDate", selected)
        }
    });  
});
</script>
    
<script type="text/javascript">
jQuery(document).ready(function(){
	jQuery("#idReportFrm").validationEngine('attach');
});
</script>
		
<h2><spring:message code="header.generateReport"/></h2>
<form:form id="idReportFrm" commandName="report">
	<table width="100%" align="center" cellpadding="4" cellspacing="1" id="outerTable">
		<tbody><tr>
			<td>
				<table border="0" width="30%" align="center" id="maintbl" cellpadding="4" cellspacing="0" class="text">
				    <tr>
						<td class="textbold" nowrap="nowrap"><form:label path="fromDate"><spring:message code="label.fromDate"/></form:label></td>
						<td><form:input path="fromDate" size="10" maxlength="10" readonly="true" cssClass="validate[required]"/></td>
						<td class="textbold" nowrap="nowrap"><form:label path="toDate"><spring:message code="label.toDate"/></form:label></td>
						<td><form:input path="toDate" size="10" maxlength="10" readonly="true" cssClass="validate[required]"/></td>
				    </tr>
					<tr>
						<td class="textbold" nowrap="nowrap"><form:label path="employeeNumber"><spring:message code="label.employeeNumber"/></form:label></td>
						<td><form:input path="employeeNumber" size="5" maxlength="5" cssClass="validate[custom[integer]] text"/></td>
						<td class="textbold" nowrap="nowrap"><form:label path="departmentName"><spring:message code="label.department"/></form:label></td>
						<td><form:input path="departmentName" size="30" maxlength="50" cssClass="validate[custom[onlyLetterSp]] text"/></td>				    	
				    </tr>
				    <tr>
						<td class="textbold" nowrap="nowrap"><form:label path="employeeFirstName"><spring:message code="label.firstName"/></form:label></td>
						<td><form:input path="employeeFirstName" size="30" maxlength="50" cssClass="validate[custom[onlyLetterSp]] text"/></td>
						<td class="textbold" nowrap="nowrap"><form:label path="employeeLastName"><spring:message code="label.lastName"/></form:label></td>
						<td><form:input path="employeeLastName" size="30" maxlength="50" cssClass="validate[custom[onlyLetterSp]] text"/></td>				    	
				    </tr>
				    <tr>
						<td class="textbold" nowrap="nowrap"><form:label path="visitorName"><spring:message code="label.visitorName"/></form:label></td>
						<td><form:input path="visitorName" size="30" maxlength="50" cssClass="validate[custom[onlyLetterSp]] text"/></td>
						<td class="textbold" nowrap="nowrap"><form:label path="visitorRepresenting"><spring:message code="label.representing"/></form:label></td>
						<td><form:input path="visitorRepresenting" size="30" maxlength="50" cssClass="validate[custom[onlyLetterSp]] text"/></td>				    	
				    </tr>
				</table>
			</td>
		</tr>
		<tr>
	        <td colspan="4" align="center">
	            <input type="submit" value="<spring:message code="button.generateReport"/>" class="btn"/>
	        </td>
	    </tr>
		</tbody>
	</table>
</form:form>
<%@ include file="/WEB-INF/views/footer.jsp" %>