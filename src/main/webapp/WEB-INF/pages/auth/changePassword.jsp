<%--
  Created by IntelliJ IDEA.
  User: Jigme Dorji
  Date: 24-04-2020
--%>

<%--
  Created by IntelliJ IDEA.
  User: nzepa
  Date: 4/6/2020
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Change Password</title>
</head>
<body class="hold-transition sidebar-mini">

<section class="content-header">
    <div class="container-fluid">
        <div class="row mb-2">
            <div class="col-sm-6 offset-6">
                <ol class="breadcrumb float-sm-right">
                    <li class="breadcrumb-item"><a href="#">Common Control</a></li>
                    <li class="breadcrumb-item active">Change Password</li>
                </ol>
            </div>
        </div>
    </div>
</section>

<section class="content">
    <div class="container-fluid">
        <div class="card card-info">
            <form id="changePasswordForm" action="" class="form-horizontal globalForm">
                <div class="card-body">
                    <fieldset>
                        <legend>Enter details</legend>
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label text-sm">Username</label>

                            <div class="col-md-4">
                                <input type="text" class="form-control form-control-sm isEnable" name="userId"
                                       readonly="readonly" value="${userId}">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label text-sm required">Existing Password</label>

                            <div class="col-md-4">
                                <input type="password" class="form-control form-control-sm isEnable" name="oldPassword"
                                       id="oldPassword" maxlength="20" data-rule-required="true">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label text-sm isEnable isDisable required">New
                                Password</label>

                            <div class="col-md-4">
                                <input type="password" class="form-control form-control-sm readonly" id="newPassword"
                                       name="newPassword" maxlength="50" data-rule-required="true">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label text-sm isEnable required">Reconfirm New
                                Password</label>

                            <div class="col-md-4">
                                <input type="password" class="form-control form-control-sm isDisable"
                                       id="confirmPassword" name="confirmPassword" data-rule-required="true">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-md-3"></div>
                            <%--<security:authorize access="hasRole('1012-ADD')">--%>
                            <div class="col-md-2">
                                <input type="submit" id="btnSave" value="Change Now" class="btn btn-primary btn-block"/>
                            </div>
                            <%--</security:authorize>--%>
                            <div class="col-md-2">
                                <input type="reset" id="btnCancel" value="Reset" class="btn btn-primary btn-block"/>
                            </div>
                        </div>
                    </fieldset>
                </div>
            </form>
        </div>
    </div>
</section>
</body>
</html>
