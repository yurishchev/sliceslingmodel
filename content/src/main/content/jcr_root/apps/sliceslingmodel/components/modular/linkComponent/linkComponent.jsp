<%@page session="false" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@include file="/apps/sliceslingmodel/global.jsp" %>

<c:choose>
    <c:when test="${param.mode eq 'slice'}">
        <slice:lookup var="model" type="<%=com.yurishchev.aem.components.model.slice.CustomLinkModelImpl.class%>"/>
        <jsp:useBean id="model" type="com.yurishchev.aem.components.model.slice.CustomLinkModelImpl"/>
    </c:when>
    <c:otherwise>
        <sling:adaptTo var="model" adaptable="${resource}"
                       adaptTo="com.yurishchev.aem.components.model.slingmodel.CustomLinkModelImpl" />
    </c:otherwise>
</c:choose>

<h2>CustomLinkModel Data</h2>

<p>title: ${model.title}</p>

<p>path: ${model.path}</p>

<p>tooltip: ${model.tooltip}</p>

<p>alignment: ${model.alignment}</p>

<p>css: ${model.css}</p>

