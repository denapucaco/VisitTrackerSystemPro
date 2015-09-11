<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<script type="text/javascript">
	$(function(){
		var fromPickerOpts = {
			dateFormat: "dd/mm/yy",
			changeMonth: true,
			changeYear: true,
			showOtherMonths: true,
			showOn: "button",
			buttonImage: "/VTSPro/images/calendar.gif",
			buttonImageOnly: true,
			minDate: 0
		};
		$("#scheduledOn").datepicker(fromPickerOpts );
	});
</script>

<script type="text/javascript">
	function validateFormTest() {
		return true;
	}

	function validateForm() {
		var visitorName=document.forms["createVisitFrm"]["visitorName"].value;
		if (visitorName==null || visitorName=="") {
			alert("Please Enter Visitor Name!");
			document.forms["createVisitFrm"]["visitorName"].focus();
			return false;
		}
		
		var alpha = /^[A-Za-z ]+$/;
		if(!visitorName.match(alpha)) {  
			alert("Please Enter a valid Visitor Name!");
			document.forms["createVisitFrm"]["visitorName"].focus();
			return false;
		}
		
		var representing=document.forms["createVisitFrm"]["representing"].value;
		if (representing==null || representing=="") {
			alert("Please Enter Representing!");
			document.forms["createVisitFrm"]["representing"].focus();
			return false;
		}
		
		if(!representing.match(alpha)) {  
			alert("Please Enter a valid Representing!");
			document.forms["createVisitFrm"]["representing"].focus();
			return false;
		}

		var mobileNumber=document.forms["createVisitFrm"]["mobileNumber"].value;
		if (mobileNumber==null || mobileNumber=="") {
			alert("Please Enter Mobile Number!");
			document.forms["createVisitFrm"]["mobileNumber"].focus();
			return false;
		}

		var numbers = /^[0-9]+$/;
		if(mobileNumber.length != 10 || !mobileNumber.match(numbers)) {  
			alert("Please Enter a valid Mobile Number!");
			document.forms["createVisitFrm"]["mobileNumber"].focus();
			return false;
		}
		
		var purpose=document.forms["createVisitFrm"]["purpose"].value;
		if (purpose==null || purpose=="") {
			alert("Please Enter Purpose!");
			document.forms["createVisitFrm"]["purpose"].focus();
			return false;
		}
		if(!purpose.match(alpha)) {  
			alert("Please Enter a valid Purpose!");
			document.forms["createVisitFrm"]["purpose"].focus();
			return false;
		}
		var scheduledOn=document.forms["createVisitFrm"]["scheduledOn"].value;
		if (scheduledOn==null || scheduledOn=="") {
			alert("Please Enter Scheduled On Date!");
			document.forms["createVisitFrm"]["scheduledOn"].focus();
			return false;
		}
		return true;
	}
</script> 

<script type="text/javascript">
(function($,W,D) {
    var VTSPro = {};
    VTSPro.UTIL = {
        setupFormValidation: function() {
            //form validation rules
            $("#createVisitFrm").validate({
                rules: {
                	visitorName: "required",
                	representing: "required",
                	purpose: "required",
                	scheduledOn: {
                        required: true
                    },
                	mobileNumber: {
                        required: true,
                        minlength: 10
                    }
                },
                messages: {
                	visitorName: "Please enter Visitor Name",
                	representing: "Please enter Representing",
                	purpose: "Please enter Purpose",
                	scheduledOn: "Please enter Scheduled On",
                	mobileNumber: {
                        required: "Please enter Mobile Number",
                        minlength: "Mobile Number must be at least 10 characters long"
                    }
                },
                submitHandler: function(form) {
                    form.submit();
                }
            });
        }
    }
    //when the dom has loaded setup form validation rules
    $(D).ready(function($) {
        VTSPro.UTIL.setupFormValidation();
    });
})(jQuery, window, document);
</script>

<h2><spring:message code="header.addVisit"/></h2>
<form:form name="createVisitFrm" id="createVisitFrm" method="post" action="confirmcreate.do" commandName="visit" onsubmit="return validateFormTest()">
	<table width="100%" align="center" cellpadding="4" cellspacing="1" id="outerTable">
		<tbody>
		<tr>
			<td>
			<table border="0" width="45%" align="center" id="maintbl" cellpadding="4" cellspacing="0" class="text">
				<form:hidden path="employee.employeeNumber" />
				<form:hidden path="employee.employeeId" />
				<form:hidden path="employee.firstName" />
				<form:hidden path="employee.lastName" />
				<form:hidden path="employee.department.name" />
				<form:hidden path="createdOn" />
			
			    <tr>
			        <td class="textbold" nowrap="nowrap"><form:label path="employee.employeeNumber"><spring:message code="label.employeeNumber"/></form:label></td>
			        <td class="text">${visit.employee.employeeNumber}</td>
			        <td class="textbold"><form:label path="createdOn"><spring:message code="label.currentDate"/></form:label></td>
			        <td class="text" nowrap="nowrap"><%-- ${visit.createdOn} --%>
			        <fmt:formatDate value="${visit.createdOn}" pattern="dd/MMM/yyyy"/></td>
			        <%-- <td><form:input path="createdOn" size="10" maxlength="10" cssClass="text" readonly="true"/></td> --%>
			    </tr>
			    <tr>
			        <td class="textbold"><form:label path="employee.firstName"><spring:message code="label.employeeName"/></form:label></td>
			        <td class="text" nowrap="nowrap">${visit.employee.firstName} ${visit.employee.lastName}</td>
			        <td class="textbold"><form:label path="employee.department.name"><spring:message code="label.department"/></form:label></td>
			        <td class="text">${visit.employee.department.name}</td>
			    </tr>
			    <tr>
			        <td class="textbold"><form:label path="visitorName"><spring:message code="label.visitorName"/></form:label></td>
			        <td colspan="3"><form:input path="visitorName" size="50" maxlength="100" cssClass="text"/></td>
			    </tr>
				<tr>
			        <td class="textbold"><form:label path="representing"><spring:message code="label.representing"/></form:label></td>
			        <td colspan="3"><form:input path="representing" size="50" maxlength="100" cssClass="text"/></td>
			    </tr>
			    <tr>
			        <td class="textbold"><form:label path="purpose"><spring:message code="label.purpose"/></form:label></td>
			        <td colspan="3"><form:input path="purpose" size="50" maxlength="100" cssClass="text"/></td>
			    </tr>
			    <tr>
			        <td class="textbold"><form:label path="mobileNumber"><spring:message code="label.mobileNumber"/></form:label></td>
			        <td><form:input path="mobileNumber" size="12" maxlength="10" cssClass="text"/></td>
			        <td class="textbold"><form:label path="scheduledOn"><spring:message code="label.scheduledOn"/></form:label></td>
			        <td><form:input path="scheduledOn" size="10" maxlength="10" cssClass="text" readonly="true"/></td>
			    </tr>
			</table>
			</td>
		</tr>
		<tr>
	        <td colspan="4" align="center">
	            <input type="submit" value="<spring:message code="button.addVisit"/>" class="btn"/>
				<input type="reset" value="<spring:message code="button.reset"/>" class="btn"/>
				<A href="<c:url value="/home.do"/>"><input type="button" value="<spring:message code="button.cancel"/>" class="btn"/></A>
	        </td>
	    </tr></tbody>
	</table>
</form:form>

<script type="text/javascript">
$(document).ready(function() {

	$( "#visitorName" ).autocomplete({
		source: '${pageContext. request. contextPath}/employee/get_visitor_name.do',
		minLength: 4
	});
});
</script>

<script>
	document.forms["createVisitFrm"]["visitorName"].focus();
</script>
<%@ include file="/WEB-INF/views/footer.jsp" %>