<%--
  Created by IntelliJ IDEA.
  User: WEBDYNO BHUTAN (MD)
  Date: 11/23/2020
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>ADMIN | USER MANAGEMENT</title>
</head>
<body>
<div class="page">
    <div class="content">
        <div class="container-xl">
            <div class="card card-sm">
                <div class="card-body">
                    <div class="page-header">
                        <div class="row align-items-center">
                            <div class="col-auto">

                                <h3 class="text-dark">
                                    USER MANAGEMENT
                                </h3>
                            </div>
                            <!-- Page title actions -->

                            <!--ADD USER ROLE-->
                            <div class="col-auto ml-auto d-print-none">
                                <a href="#" data-toggle="modal" data-target="#itemGroupModal"
                                   class="btn btn-primary btn-sm ml-3 d-none d-sm-inline-block"
                                   id="btnAddNew" onclick="document.forms[0].action = 'assignUserRole.jsp'; return true;">
                                    ADD USER ROLE
                                </a>
                            </div>
                            <!--ADD USER ROLE-->

                        </div>
                    </div>
                    <div class="card">
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table card-table text-nowrap table-bordered col-md-12"
                                       id="itemGroupGrid">
                                    <thead>
                                    <tr>
                                        <th class="text-muted">Sl No.</th>
                                        <th class="text-muted">USERNAME</th>
                                        <th class="text-muted">USER ROLE</th>
                                        <th class="text-muted">PHONE</th>
                                        <th class="text-muted">Action</th>
                                    </tr>
                                    <tbody>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
