<!--
	SParsh Tech - Visitor Tracking System
-->
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<link rel="stylesheet" href="<c:url value="/css/styles.css" />" type="text/css" />
	 
	<link rel="stylesheet" href="<c:url value="/css/jquery-ui-1.8.23.custom.css" />" type="text/css" />
	<script type="text/javascript" src="<c:url value="/js/jquery-1.8.0.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery-ui-1.8.23.custom.min.js" />"></script>

	<script type="text/javascript" src="<c:url value="/js/jquery.validate.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/js/additional-methods.min.js" />"></script>

	<link rel="stylesheet" href="<c:url value="/css/validationEngine.jquery.css" />" type="text/css" />
	<script type="text/javascript" src="<c:url value="/js/jquery.validationEngine-en.js" />"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.validationEngine.js" />"></script>


	<title>Visitor Tracking System Pro by SParsh Technologies Pvt Ltd.</title>	
</head>
<body>

<!-- Outer Most Table -->
<table border="0" align="center" cellpadding="0" style="background-color:#FFFFFF;" cellspacing="0" width="900px">
<tbody>
<tr>	<!-- First Row is for Logo (Header)-->
	<td>
		 <table border="0" align="center" class="header" cellpadding="0" cellspacing="0" width="900px">
		 	<tr>
		 		<td width="5" height="60" valign="top" align="left"><img src="<c:url value="/images/header-left.png"/>" width="5" height="25"></td>
				<td valign="bottom"><img src="<c:url value="/images/sparsh_small.png"/>" width="200" height="69"></td>
				<td valign="middle"><img src="<c:url value="/images/new_visit-tracking-system-small.png"/>" width="390"></td>
				<td width="20">&nbsp;</td>
				<td valign="bottom" align="right"><img src="<c:url value="/images/new_minda_logo.gif"/>" width="200" height="56"></td>
				<td width="5" valign="top" align="right"><img src="<c:url value="/images/header-right.png"/>" width="5"></td>
			</tr>
		</table>
	</td>
</tr>
<tr>
	<td>
		<table class="menubar" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<c:choose>
						<c:when test="${pageContext.request.userPrincipal.name!=null}">
						<td align="left">
							<span class="menuText">
								&nbsp;<a href="<c:url value="/home.do"/>">Home</a>&nbsp;|
							</span>
						</td>
						<td align="right">
							<span class="menuText"><%=session.getAttribute("user_name")%>&nbsp;|</span> 
							<span class="menuText"><a href="<c:url value="/auth/changepassword.do"/>">Manage Account</a>&nbsp;|</span>
							<span class="menuText"><a href="<c:url value="/auth/logout.do"/>">Log Out</a>&nbsp;</span>
							
						</td>
						</c:when>
				</c:choose>
			</tr>
		</table>
	</td>
</tr>
<tr> <!-- Second Row is for Actual contents (Body)-->
	<td>
		<table width="95%" height="0%" border="0" align="center" cellpadding="0" cellspacing="0" >
			<tbody><tr>
			  <td width="9" height="18"><img src="<c:url value="/images/left-top.png"/>" width="9" height="18"></td>
			  <td height="18"><img src="<c:url value="/images/top.png"/>" width="100%" height="18" ></td>
			  <td width="9" height="18"><img src="<c:url value="/images/right-top.png"/>" width="9" height="18"></td>
			</tr>
		
			<tr>
			  <td width="9"><img src="<c:url value="/images/left.png"/>" style="height: 100%; width: 9px"></td>
			  <td valign="top" bgcolor="#ffffff">
