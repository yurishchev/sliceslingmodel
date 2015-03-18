<%@page session="false" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@include file="/apps/sliceslingmodel/global.jsp" %>


<!-- Navbar
================================================== -->
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="active">
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>

<div class="jumbotron masthead">
    <div class="container">
        <h1>Slice versus Sling Model</h1>

        <p>Compares 'ORM' frameworks for Apache Sling: 'Slice' and 'Sling Models'.</p>
        <ul class="nav">To see results using:
            <li>
                - Slice mapping: add request parameter 'mode=slice', i.e. '/content/sliceslingmodel/en.html?mode=slice'
            </li>
            <li>
                - Sling Models mapping: add request parameter 'mode=slingmodel', i.e. '/content/sliceslingmodel/en.html?mode=slingmodel'
            </li>
        </ul>
    </div>
</div>


<div class="container">
    <div class="marketing">
        <cq:include path="complexComponent" resourceType="sliceslingmodel/components/modular/complexComponent"/>
    </div>
</div>
