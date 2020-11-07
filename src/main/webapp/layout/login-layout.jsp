<%--
  Created by IntelliJ IDEA.
  User: jigme.dorji
  Date: 24-04-2020
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, viewport-fit=cover"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Sign in</title>
    <link rel="shortcut icon" href="<c:url value='/resources/images/' />"/>
    <link rel="preconnect" href="https://fonts.gstatic.com/" crossorigin>
    <meta name="msapplication-TileColor" content="#206bc4"/>
    <meta name="theme-color" content="#206bc4"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="mobile-web-app-capable" content="yes"/>
    <meta name="HandheldFriendly" content="True"/>
    <meta name="MobileOptimized" content="320"/>
    <meta name="robots" content="noindex,nofollow,noarchive"/>
    <jsp:include page="include/css.jsp"/>
    <style>
        body {
            display: none;
        }
    </style>
</head>
<body class="antialiased border-top-wide border-primary d-flex flex-column">
<sitemesh:write property="body"/>
</body>
<script type="text/javascript" src="<c:url value='/resources/js/login.js'/>"></script>
</html>
