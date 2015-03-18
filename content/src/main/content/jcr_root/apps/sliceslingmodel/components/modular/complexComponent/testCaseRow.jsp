<%@page session="false" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@include file="/apps/sliceslingmodel/global.jsp" %>

<c:set var="statusMessage" value="Passed" scope="request"/>
<c:choose>
    <c:when test="${not empty statusParam}">
        <tr class="success">
    </c:when>
    <c:otherwise>
        <tr class="error">
        <c:set var="statusMessage" value="Failed" scope="request"/>
    </c:otherwise>
</c:choose>
<td>${descParam}</td>
<td>${snippetParam}</td>
<td>${statusMessage}</td>
</tr>
