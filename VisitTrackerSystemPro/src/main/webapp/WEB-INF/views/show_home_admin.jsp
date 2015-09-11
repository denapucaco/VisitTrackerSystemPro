<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<h2><spring:message code="header.home"/></h2>
<table width="100%" align="center" cellpadding="4" cellspacing="1" id="outerTable">
	<tbody>
	<tr>
		<td>
		<table border="0" width="45%" align="center" id="maintbl" cellpadding="4" cellspacing="0" class="text">
			<tr>
				<td><a href="<c:url value="/admin/report.do"/>">Generate Report</a></td>
			</tr>
			<tr>
				<td><a href="<c:url value="/admin/addemployee.do"/>">Add Employee</a></td>
			</tr>
			<tr>
				<td><a href="<c:url value="/admin/showupload.do"/>">Add Employees - Upload CSV File</a></td>
			</tr>
		</table>  
		</td>
	</tr>
	</tbody>
</table>
<%@ include file="/WEB-INF/views/footer.jsp" %>