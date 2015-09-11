<%@ include file="/WEB-INF/views/includes.jsp"%>
<%@ include file="/WEB-INF/views/header.jsp"%>

<h2><spring:message code="header.listVisits" /></h2>
<table width="100%" align="center" cellpadding="4" cellspacing="1">
	<tbody>
		<tr>
			<td>
				<table align="center" cellpadding="4" cellspacing="0" class="grid">
					<tr>
						<th>Employee Details</th>
						<th>Visitor Details</th>
						<th>Purpose</th>
						<th>In Time</th>
						<th>Out Time</th>
						<th>Duration</th>
						<th>Is Confirmed</th>
						<th>Is Canceled</th>
					</tr>
					<c:if test="${!empty visitList}">
						<c:forEach items="${visitList}" var="visit" varStatus="loopStatus">
							<tr class="${loopStatus.index % 2 == 0 ? 'odd' : 'even'}">
								<td>${visit.employee.employeeNumber}, ${visit.employee.firstName} ${visit.employee.lastName} (${visit.employee.department.name})</td>
								<td>${visit.visitorName} (${visit.representing})</td>
								<td>${visit.purpose}</td>
								
								<!-- Canceled Visits don't have other details -->
								<c:choose>
									<c:when test="${visit.isCanceled==true}">
										<td>- NA -</td> <!-- In Time -->
										<td>- NA -</td> <!-- Out Time -->
										<td>- NA -</td> <!-- Visit Duration -->
										<td>- NA -</td> <!-- Is Confirmed -->
										<td>Yes</td> 	<!-- Is Canceled -->
									</c:when>
									<c:otherwise>
										<td><!-- Non Canceled Visits have details --> <!-- In Time -->
											<c:choose>
												<c:when test="${visit.inTime==null}">- NA -</c:when>
												<c:otherwise>
													<fmt:formatDate value="${visit.inTime}" pattern="dd/MMM/yy HH:mm" />
												</c:otherwise>
											</c:choose>
										</td>
										<!-- Out Time -->
										<td><c:choose>
												<c:when test="${visit.outTime==null}">- NA -</c:when>
												<c:otherwise>
													<fmt:formatDate value="${visit.outTime}" pattern="dd/MMM/yy HH:mm" />
												</c:otherwise>
											</c:choose>
										</td>
										<!-- Visit Duration -->
										<td>
											<c:choose>
												<c:when test="${visit.outTime==null}">- NA -</c:when>
												<c:otherwise>${visit.visitDuration}</c:otherwise>
											</c:choose>
										</td>
										<!-- Is Confirmed -->
										<td>
											<c:choose>
												<c:when test="${visit.isConfirmed==true}">Yes</c:when>
												<c:otherwise>No</c:otherwise>
											</c:choose>
										</td>
										<!-- Is Canceled -->
										<td>No</td>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
					</c:if>
				</table>
			</td>
		</tr>
	</tbody>
</table>
<%@ include file="/WEB-INF/views/footer.jsp"%>