<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<meta name="decorator" content="/layout/login-layout.jsp"/>
<header class="navbar navbar-expand-md navbar-light">
    <div class="container-xl">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-menu">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a href="." class="navbar-brand navbar-brand-autodark d-none-navbar-horizontal pr-0 pr-md-3">
            <img src="<c:url value='/resources/images/' />" alt="TEST PROJECT" class="navbar-brand-image">
            <%--<h3 class="organization-name mt-4 ml-3 text-nowrap">Test Project</h3>--%>
        </a>


    </div>
</header>
<div class="flex-fill d-flex flex-column justify-content-center">
    <div class="container-tight py-5">
        <%--<div class="text-center mb-4">--%>
            <%--<img src="<c:url value='/resources/images/company_logo.png' />" alt="" height="36">--%>
        <%--</div>--%>
        <form class="card card-md" action="<c:url value='/auth'/>" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <div class="card-body">
                <h2 class="mb-2 text-center">Login to your account</h2>

                <div class="mb-1">
                    <label class="form-label">Username</label>
                    <input type="text" name="username" class="form-control" required="true" autocomplete="off">
                </div>
                <div class="mb-1">
                    <label class="form-label"> Password </label>

                    <div class="input-group input-group-flat">
                        <input type="password" name="password" id="inputPassword" class="form-control" required="true">
                    </div>
                </div>
                <div class="mb-1">
                    <label class="form-label">
                        <input type="checkbox" class="form-check-input" onclick="showPasswordFn()"/>
                        <span class="form-check-label">Show password</span>
                        <span class="form-label-description">
                  <a href="./forgot-password.html">I forgot password</a>
                </span>
                    </label>

                </div>
                <div class="form-footer">
                    <button type="submit" class="btn btn-primary btn-block">Sign in</button>
                </div>
                <div>
                    <c:if test="${not empty error}">
                        <label style="color: red"><spring:message code="${error}"/></label>
                    </c:if>
                </div>
            </div>
        </form>
        <%--<div class="text-center text-muted">--%>
            <%--Don't have account yet? <a href="./sign-up.html" tabindex="-1">Sign up</a>--%>
        <%--</div>--%>
    </div>
</div>

<footer class="footer">
    <div class="container">
        <div class="row align-items-center flex-row-reverse">
            <div class="col-auto ml-lg-auto">
                <div class="row align-items-center">
                    <div class="col-auto">
                        <ul class="list-inline list-inline-dots mb-0">
                            <li class="list-inline-item">System developed and maintained by <a href="/">Thimphu TechPark Ltd</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-12 col-lg-auto mt-3 mt-lg-0 text-center">
                Copyright © 2020 <a href=".">Druk Holding and Investment.</a> All rights reserved.
            </div>
        </div>
    </div>
</footer>

<script>
    function showPasswordFn() {
        var x = document.getElementById("inputPassword");
        if (x.type === "password") {
            x.type = "text";
        } else {
            x.type = "password";
        }
    }
</script>