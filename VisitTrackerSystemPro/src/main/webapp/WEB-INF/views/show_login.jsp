<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<script type="text/javascript">
jQuery(document).ready(function(){
	jQuery("#idLoginFrm").validationEngine('attach');
});
</script>

<h2><spring:message code="header.login"/></h2>
<span class="warning">${error}</span>
<form action="<c:url value="/j_spring_security_check"/>" method="post" id="idLoginFrm">
	<table align="center" width="100%" cellpadding="4" cellspacing="1" border="0" id="outerTable">
		<tbody>
		<tr>
			<td>
			<table align="center" border="0" id="maintbl" cellpadding="40" cellspacing="1">
			    <tr>
			        <td align="right" class="textbold">
			        	<label for="j_username"><spring:message code="label.userName"/></label>
			        </td>
			        <td>
			        	<input id="j_username" name="j_username" type="text" size="15" maxlength="15" class="validate[required,custom[onlyLetterSp]] text"/>
			        </td>
			    </tr>
			    <tr>
			        <td align="right" class="textbold">
			        	<label for="j_password"><spring:message code="label.password"/></label>
			        </td>
			        <td>
			        	<input id="j_password" name="j_password" type="password" size="15" maxlength="15" class="validate[required,custom[onlyLetterNumber],minSize[4]] text"/>
					</td>
			    </tr>
			</table>  
			</td>
		</tr>
		<tr>
			<td colspan="3" align="center">
				<input type="submit" name="Login" value="<spring:message code="button.login"/>" class="btn"/>
				<input type="reset" value="<spring:message code="button.reset"/>" class="btn"/>
			</td>
		</tr>
		<tr>
			<td colspan="3" align="center">
				<span class="menuText"><a href="<c:url value="/auth/forgotpassword.do"/>">Forgot password?</a></span>
			</td>
		</tr>
		</tbody>
	</table>
</form>

<script>
	document.forms["idLoginFrm"]["j_username"].focus();
</script>
<%@ include file="/WEB-INF/views/footer.jsp" %>