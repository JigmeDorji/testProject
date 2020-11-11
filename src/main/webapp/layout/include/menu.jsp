<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="navbar-expand-md">
    <div class="collapse navbar-collapse" id="navbar-menu">
        <div class="navbar navbar-light">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/studentRegistration"/>">
                        <span class="nav-link-icon d-md-none d-lg-inline-block">

                        </span>
                        <span class="nav-link-title">
                            Student Registration
                            </span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/customerSetup"/>">
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
                       Customer Setup
                    </span>
                </a>
            </li>
        </div>

    </div>
</div>
`
</div>`