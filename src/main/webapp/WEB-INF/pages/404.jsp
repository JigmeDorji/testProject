<%--
  Created by IntelliJ IDEA.
  User: nzepa
  Date: 7/12/2020
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>404 - Not Found</title>
    <link rel="shortcut icon" href="<c:url value='/resources/images/dhifavicon.png' />"/>
    <jsp:include page="../../layout/include/css.jsp"/>
    <jsp:include page="../../layout/include/js.jsp"/>
</head>
<body class="antialiased border-top-wide border-primary d-flex flex-column">
<div class="flex-fill d-flex align-items-center justify-content-center">
    <div class="container-tight py-6">
        <div class="empty">
            <div class="empty-icon">
                <div class="display-4">404</div>
            </div>
            <p class="empty-title h3">Oops… You just found an error page</p>
            <p class="empty-subtitle text-muted">
                We are sorry but the page you are looking for was not found
            </p>
            <div class="empty-action">
                <a href="./." class="btn btn-primary">
                    <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z"/><line x1="5" y1="12" x2="19" y2="12" /><line x1="5" y1="12" x2="11" y2="18" /><line x1="5" y1="12" x2="11" y2="6" /></svg>
                    Take me home
                </a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
