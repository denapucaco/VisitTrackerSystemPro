<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<script type="text/javascript">
jQuery(document).ready(function(){
	jQuery("#idUploadCSVFrm").validationEngine('attach');
});
</script>

<h2><spring:message code="header.uploadFile"/></h2>
<span class="warning">${error}</span>
<form:form method="post" action="saveupload.do" commandName="FileUploadForm" id="idUploadCSVFrm" enctype="multipart/form-data">
	<table align="center" width="100%" cellpadding="4" cellspacing="1" border="0" id="outerTable">
		<tbody>
		<tr>
			<td>
			<table align="center" border="0" id="maintbl" cellpadding="4" cellspacing="1">
			    <tr>
			        <td align="right" class="textbold">
			        	<label for="file"><spring:message code="label.file"/></label>
			        </td>
			        <td>
			        	<form:input type="file" path="file" />
			        </td>
			    </tr>
			</table>  
			</td>
		</tr>
		<tr>
			<td colspan="3" align="center">
				<input type="submit" name="Upload" value="<spring:message code="button.uploadFile"/>" class="btn"/>
				<input type="reset" value="<spring:message code="button.reset"/>" class="btn"/>
			</td>
		</tr>
		</tbody>
	</table>
</form:form>
<%@ include file="/WEB-INF/views/footer.jsp" %>