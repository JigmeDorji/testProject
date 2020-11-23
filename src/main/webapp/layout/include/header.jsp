<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page session="true" %>

<c:url value="/logout" var="logoutUrl"/>
<form action="${logoutUrl}" method="get" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

<header class="navbar navbar-expand-md navbar-light navbar fixed-top">
    <div class="container-xl">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-menu">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a href="." class="navbar-brand navbar-brand-autodark d-none-navbar-horizontal pr-0 pr-md-3">
            <img src="<c:url value='/resources/images/' />" alt="Inventory" class="navbar-brand-image">

            <%--<h3 class="organization-name mt-4 ml-3 text-nowrap">Test Project</h3>--%>
        </a>

        <div class="navbar-nav flex-row order-md-last">
            <div class="nav-item dropdown d-none d-md-flex mr-3">
                <a href="#" class="nav-link px-0" data-toggle="dropdown" tabindex="-1">
                    <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewBox="0 0 24 24"
                         stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round"
                         stroke-linejoin="round">
                        <path stroke="none" d="M0 0h24v24H0z"/>
                        <path d="M10 5a2 2 0 0 1 4 0a7 7 0 0 1 4 6v3a4 4 0 0 0 2 3h-16a4 4 0 0 0 2 -3v-3a7 7 0 0 1 4 -6"/>
                        <path d="M9 17v1a3 3 0 0 0 6 0v-1"/>
                    </svg>
                    <span class="badge bg-red"></span>
                </a>

                <div class="dropdown-menu dropdown-menu-right dropdown-menu-card">
                    <div class="card">
                        <div class="card-body">
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus ad amet consectetur
                            exercitationem fugiat in ipsa ipsum, natus odio quidem quod repudiandae sapiente. Amet
                            debitis et magni maxime necessitatibus ullam.
                        </div>
                    </div>
                </div>
            </div>
            <div class="nav-item dropdown">
                <a href="#" class="nav-link d-flex lh-1 text-reset p-0" data-toggle="dropdown">
                    <span class="avatar" style="background-image: url(../../resources/images/user.png)"></span>

                    <div class="d-none d-xl-block pl-2">
                        <div>${currentUser.txtUserName}</div>
                        <div class="mt-1 small text-muted">${currentUser.companyName}</div>
                    </div>

                </a>

                <div class="dropdown-menu dropdown-menu-right">

                    <a class="dropdown-item" href="#">
                        <svg xmlns="http://www.w3.org/2000/svg" class="icon dropdown-item-icon" width="24" height="24"
                             viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none"
                             stroke-linecap="round" stroke-linejoin="round">
                            <path stroke="none" d="M0 0h24v24H0z"/>
                            <path d="M9 7 h-3a2 2 0 0 0 -2 2v9a2 2 0 0 0 2 2h9a2 2 0 0 0 2 -2v-3"/>
                            <path d="M9 15h3l8.5 -8.5a1.5 1.5 0 0 0 -3 -3l-8.5 8.5v3"/>
                            <line x1="16" y1="5" x2="19" y2="8"/>
                        </svg>
                        Change Password
                    </a>

                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="javascript:$('#logoutForm').submit();">

                        <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-md" width="24" height="24"
                             viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none"
                             stroke-linecap="round" stroke-linejoin="round">
                            <path stroke="none" d="M0 0h24v24H0z"></path>
                            <path d="M14 8v-2a2 2 0 0 0 -2 -2h-7a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h7a2 2 0 0 0 2 -2v-2"></path>
                            <path d="M7 12h14l-3 -3m0 6l3 -3"></path>
                        </svg>
                        Logout</a>
                </div>
            </div>
        </div>
    </div>
</header>