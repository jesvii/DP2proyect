<%--
- form.jsp
-
- Copyright (C) 2012-2025 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="http://acme-framework.org/"%>

<acme:form>
	<acme:input-moment code="flightCrewMember.activityLog.form.label.registrationMoment" readonly="true" path="registrationMoment"/>	
	<acme:input-textbox code="flightCrewMember.activityLog.form.label.typeOfIncident" path="typeOfIncident"/>	
	<acme:input-textbox code="flightCrewMember.activityLog.form.label.description" path="description"/>	
	<acme:input-integer code="flightCrewMember.activityLog.form.label.severityLevel" path="severityLevel"/>
	
		
	<jstl:choose>
		<jstl:when test="${acme:anyOf(_command, 'show|update|delete|publish') && draftMode == true }">
			<acme:submit code="flightCrewMember.activityLog.form.button.update" action="/flight-crew-member/activity-log/update"/>
			<acme:submit code="flightCrewMember.activityLog.form.button.delete" action="/flight-crew-member/activity-log/delete"/>
			<jstl:if test="${!fadf}">
				<acme:submit code="flightCrewMember.activityLog.form.button.publish" action="/flight-crew-member/activity-log/publish"/>
			</jstl:if>
		</jstl:when>
		
		<jstl:when test="${_command == 'create'}">
			<acme:submit code="flightCrewMember.activityLog.form.button.create" action="/flight-crew-member/activity-log/create?masterId=${masterId}"/>
		</jstl:when>	
	
	</jstl:choose>
</acme:form>