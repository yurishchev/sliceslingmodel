<%@page session="false" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@include file="/apps/sliceslingmodel/global.jsp" %>

<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="content-type" content="text/html; charset=UTF-8" />

    <!--[if IE 8]>
    <script src="//oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="//oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <script>
        if (typeof console === "undefined" || typeof console.log === "undefined") {
            console = {};
            console.log = function() {};
        }
    </script>
    <![endif]-->

    <cq:include script="/apps/sliceslingmodel/init.jsp" />

    <cq:includeClientLib css="sliceslingmodel.bootstrap" />
    <cq:includeClientLib css="sliceslingmodel.master.all" />
</head>
