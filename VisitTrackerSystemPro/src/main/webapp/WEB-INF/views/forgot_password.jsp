<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<script type="text/javascript">

	function validateForm() {
		var visitorName=document.forms["forgtPasswdFrm"]["visitorName"].value;
		if (visitorName==null || visitorName=="") {
			alert("Please Enter Visitor Name!");
			document.forms["forgtPasswdFrm"]["visitorName"].focus();
			return false;
		}
		
		var alpha = /^[A-Za-z ]+$/;
		if(!visitorName.match(alpha)) {  
			alert("Please Enter a valid Visitor Name!");
			document.forms["forgtPasswdFrm"]["visitorName"].focus();
			return false;
		}
		
		var representing=document.forms["forgtPasswdFrm"]["representing"].value;
		if (representing==null || representing=="") {
			alert("Please Enter Representing!");
			document.forms["forgtPasswdFrm"]["representing"].focus();
			return false;
		}
		
		if(!representing.match(alpha)) {  
			alert("Please Enter a valid Representing!");
			document.forms["forgtPasswdFrm"]["representing"].focus();
			return false;
		}

		var mobileNumber=document.forms["forgtPasswdFrm"]["mobileNumber"].value;
		if (mobileNumber==null || mobileNumber=="") {
			alert("Please Enter Mobile Number!");
			document.forms["forgtPasswdFrm"]["mobileNumber"].focus();
			return false;
		}

		var numbers = /^[0-9]+$/;
		if(mobileNumber.length != 10 || !mobileNumber.match(numbers)) {  
			alert("Please Enter a valid Mobile Number!");
			document.forms["forgtPasswdFrm"]["mobileNumber"].focus();
			return false;
		}
		
		var purpose=document.forms["forgtPasswdFrm"]["purpose"].value;
		if (purpose==null || purpose=="") {
			alert("Please Enter Purpose!");
			document.forms["forgtPasswdFrm"]["purpose"].focus();
			return false;
		}
		if(!purpose.match(alpha)) {  
			alert("Please Enter a valid Purpose!");
			document.forms["forgtPasswdFrm"]["purpose"].focus();
			return false;
		}
		return true;
	}
</script> 

<h2><spring:message code="header.forgotPassword"/></h2>
<form:form name="forgtPasswdFrm" method="post" action="forgotpasswordsuccess.do" commandName="login" onsubmit="return validateForm1()">
	<table width="100%" align="center" cellpadding="4" cellspacing="1" id="outerTable">
		<tbody>
		<tr>
			<td>
			<table border="0" width="45%" align="center" id="maintbl" cellpadding="4" cellspacing="0" class="text">
				<tr>
			        <td class="textbold"><form:label path="userName"><spring:message code="label.userName"/></form:label></td>
			        <td class="text"><form:input path="userName" size="15" maxlength="15" cssClass="text"/></td>				
				
			    </tr>
			</table>
			</td>
		</tr>
		<tr>
	        <td colspan="4" align="center">
	            <input type="submit" value="<spring:message code="button.forgotPassword"/>" class="btn"/>
	        </td>
	    </tr></tbody>
	</table>
</form:form>

<script>
	document.forms["forgtPasswdFrm"]["userName"].focus();
</script>
<%@ include file="/WEB-INF/views/footer.jsp" %>