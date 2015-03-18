<%@page session="false" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@include file="/apps/sliceslingmodel/global.jsp" %>

<c:choose>
    <c:when test="${param.mode eq 'slice'}">
        <slice:lookup var="model" type="<%=com.yurishchev.aem.components.model.slice.ComplexComponentModelImpl.class%>"/>
        <jsp:useBean id="model" type="com.yurishchev.aem.components.model.slice.ComplexComponentModelImpl"/>
        <h2>ComplexComponentModel Tests - Slice approach</h2>
    </c:when>
    <c:otherwise>
        <sling:adaptTo var="model" adaptable="${resource}"
                       adaptTo="com.yurishchev.aem.components.model.slingmodel.ComplexComponentModelImpl" />
        <h2>ComplexComponentModel Tests - Sling Models approach</h2>
    </c:otherwise>
</c:choose>

<table class="table table-bordered">
    <thead>
    <tr>
        <td>Feature</td>
        <td>Result</td>
        <td>Status</td>
    </tr>
    </thead>
    <tbody>

    <c:set var="statusParam" value="${model.JCRString}" scope="request"/>
    <c:set var="descParam" value="Map JCR primitives (String)" scope="request"/>
    <c:set var="snippetParam" value="<p><b>Text property=</b>'${model.JCRString}'</p>" scope="request"/>
    <cq:include script="testCaseRow.jsp"/>

    <c:set var="statusParam" value="${model.JCRBoolean}" scope="request"/>
    <c:set var="descParam" value="Map JCR primitives (Boolean)" scope="request"/>
    <c:set var="snippetParam" value="<p><b>Valid property=</b>'${model.JCRBoolean}'</p>" scope="request"/>
    <cq:include script="testCaseRow.jsp"/>

    <c:set var="statusParam" value="${model.JCRMultiProperties}" scope="request"/>
    <c:set var="descParam" value="Map JCR Multi Properties" scope="request"/>
    <c:set var="snippetParam" value="<p><b>Tags property=</b>'${fn:join(model.JCRMultiProperties, ';')}'</p>" scope="request"/>
    <cq:include script="testCaseRow.jsp"/>

    <c:set var="statusParam" value="${model.enumeratedType}" scope="request"/>
    <c:set var="descParam" value="Map Enumerated Type (from String property)" scope="request"/>
    <c:set var="snippetParam" value="<p><b>Alignment property=</b>'${model.enumeratedType}'</p>" scope="request"/>
    <cq:include script="testCaseRow.jsp"/>

    <c:set var="statusParam" value="${model.image}" scope="request"/>
    <c:set var="descParam" value="Map Child Model" scope="request"/>
    <c:set var="snippetParam" value="<h4>Image property</h4>
    <p>
        <b>altText=</b>'${model.image.altText}'<br>
        <b>imagePath=</b>'${model.image.fileReference}'
    </p>" scope="request"/>
    <cq:include script="testCaseRow.jsp"/>

<%--
    <c:set var="statusParam" value="${model.imageViaInterface}" scope="request"/>
    <c:set var="descParam" value="Map Child Model Via Interface" scope="request"/>
    <c:set var="snippetParam" value="<h4>Image property</h4>
    <p>
        <b>altText=</b>'${model.imageViaInterface.altText}'<br>
        <b>imagePath=</b>'${model.imageViaInterface.fileReference}'
    </p>" scope="request"/>
    <cq:include script="testCaseRow.jsp"/>
--%>

    <c:set var="statusParam" value="${model.customLinks}" scope="request"/>
    <c:set var="descParam" value="Map Collection of Child Models" scope="request"/>
    <c:set var="snippetParam" value="" scope="request"/>
    <c:forEach var="link" items="${model.customLinks}" varStatus="status">
        <c:set var="snippetParam" value="${snippetParam}<h4>Custom Link ${status.count}</h4><p>
        path='${link.path}'<br>
        title='${link.title}'<br>
        tooltip='${link.tooltip}'<br>
        alignment='${link.alignment}'<br>
        css='${link.css}'<p>" scope="request"/>
    </c:forEach>
    <cq:include script="testCaseRow.jsp"/>

    <c:set var="statusParam" value="${model.currentResourceName}" scope="request"/>
    <c:set var="descParam" value="Map Current Resource" scope="request"/>
    <c:set var="snippetParam" value="<p><b>JCR Node name=</b>'${model.currentResourceName}'</p>" scope="request"/>
    <cq:include script="testCaseRow.jsp"/>

    <c:set var="statusParam" value="${model.currentPageName}" scope="request"/>
    <c:set var="descParam" value="Map Current Page" scope="request"/>
    <c:set var="snippetParam" value="<p><b>Page name=</b>'${model.currentPageName}'</p>" scope="request"/>
    <cq:include script="testCaseRow.jsp"/>

    <c:set var="statusParam" value="${model.slingRequest}" scope="request"/>
    <c:set var="descParam" value="Map SlingHttpServletRequest" scope="request"/>
    <c:set var="snippetParam" value="<p><b>Request Path Info=</b>'${model.slingRequest.requestPathInfo}'</p>" scope="request"/>
    <cq:include script="testCaseRow.jsp"/>

    <c:set var="statusParam" value="${model.resourceResolver}" scope="request"/>
    <c:set var="descParam" value="Map ResourceResolver" scope="request"/>
    <c:set var="snippetParam" value="" scope="request"/>
    <cq:include script="testCaseRow.jsp"/>

    <c:set var="statusParam" value="${model.postModifiedValue}" scope="request"/>
    <c:set var="descParam" value="Post Modified Value" scope="request"/>
    <c:set var="snippetParam" value="<p><b>Value=</b>'${model.postModifiedValue}'</p>" scope="request"/>
    <cq:include script="testCaseRow.jsp"/>

    <c:set var="statusParam" value="${model.OSGILogServiceStatus}" scope="request"/>
    <c:set var="descParam" value="OSGI Standard (OOB) Service" scope="request"/>
    <c:set var="snippetParam" value="<p><b>OSGI Log Service Status=</b>'${model.OSGILogServiceStatus}'</p>" scope="request"/>
    <cq:include script="testCaseRow.jsp"/>

    <c:set var="statusParam" value="${model.OSGICustomServiceStatus}" scope="request"/>
    <c:set var="descParam" value="OSGI Custom Service" scope="request"/>
    <c:set var="snippetParam" value="<p><b>OSGI SampleConfiguration Service status=</b>'${model.OSGICustomServiceStatus}'</p>" scope="request"/>
    <cq:include script="testCaseRow.jsp"/>

    </tbody>
</table>

<%--
<cq:include path="links" resourceType="foundation/components/parsys"/>
--%>
