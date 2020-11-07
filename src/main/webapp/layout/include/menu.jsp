<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="navbar-expand-md">
    <div class="collapse navbar-collapse" id="navbar-menu">
        <div class="navbar navbar-light">
            <div class="container-xl">

                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="/">
                    <span class="nav-link-icon d-md-none d-lg-inline-block">
                        <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewBox="0 0 24 24"
                             stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round"
                             stroke-linejoin="round">
                            <path stroke="none" d="M0 0h24v24H0z"/>
                            <polyline points="5 12 3 12 12 3 21 12 19 12"/>
                            <path d="M5 12v7a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-7"/>
                            <path d="M9 21v-6a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v6"/>
                        </svg>
                    </span>
                    <span class="nav-link-title">
                      Home
                    </span>
                        </a>
                    </li>
                    <%--<li class="nav-item dropdown">--%>
                        <%--<a class="nav-link dropdown-toggle" href="#navbar-extra" data-toggle="dropdown" role="button"--%>
                           <%--aria-expanded="false">--%>
                    <%--<span class="nav-link-icon d-md-none d-lg-inline-block">--%>
                        <%--<svg xmlns="http://www.w3.org/2000/svg"--%>
                             <%--class="icon icon-md" width="24"--%>
                             <%--height="24" viewBox="0 0 24 24"--%>
                             <%--stroke-width="2" stroke="currentColor"--%>
                             <%--fill="none" stroke-linecap="round"--%>
                             <%--stroke-linejoin="round">--%>
                            <%--<path stroke="none" d="M0 0h24v24H0z"></path>--%>
                            <%--<path d="M7 10h3v-3l-3.5 -3.5a6 6 0 0 1 8 8l6 6a2 2 0 0 1 -3 3l-6-6a6 6 0 0 1 -8 -8l3.5 3.5"></path>--%>
                        <%--</svg>--%>
                    <%--</span>--%>
                    <%--<span class="nav-link-title">--%>
                      <%--Menu--%>
                    <%--</span>--%>
                        <%--</a>--%>
                        <%--<ul class="dropdown-menu">--%>
                            <%--<li>--%>
                                <%--<a class="dropdown-item" href="<c:url value="/company"/>">--%>
                                    <%--<i class="fa fa-plus"></i>&nbsp;&nbsp;&nbsp;Company--%>
                                <%--</a>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                                <%--<a class="dropdown-item" href="<c:url value="/user"/>">--%>
                                    <%--<i class="fa fa-users"></i>&nbsp;&nbsp;&nbsp;Users--%>
                                <%--</a>--%>
                            <%--</li>--%>
                        <%--</ul>--%>
                    <%--</li>--%>

                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/studentRegistration"/>">
                    <span class="nav-link-icon d-md-none d-lg-inline-block">
                        <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24"
                             viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none"
                             stroke-linecap="round" stroke-linejoin="round">
                            <path stroke="none" d="M0 0h24v24H0z"></path>
                            <polyline points="9 11 12 14 20 6"></polyline>
                            <path d="M20 12v6a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h9"></path>
                        </svg>
                    </span>
                    <span class="nav-link-title">
                      Student Registration
                    </span>
                        </a>
                    </li>
                    <%--<li class="nav-item">
                        <a class="nav-link" href="<c:url value="/landTaxDetail"/>">
                    <span class="nav-link-icon d-md-none d-lg-inline-block"><svg xmlns="http://www.w3.org/2000/svg"
                                                                                 class="icon" width="24" height="24"
                                                                                 viewBox="0 0 24 24" stroke-width="2"
                                                                                 stroke="currentColor" fill="none"
                                                                                 stroke-linecap="round"
                                                                                 stroke-linejoin="round">
                        <path stroke="none" d="M0 0h24v24H0z"/>
                        <polyline points="9 11 12 14 20 6"/>
                        <path d="M20 12v6a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h9"/>
                    </svg>
                    </span>
                    <span class="nav-link-title">
                     Tax Detail
                    </span>
                        </a>
                    </li>--%>
                </ul>
            </div>
        </div>
    </div>
</div>