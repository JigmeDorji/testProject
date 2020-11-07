<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<title class="title">User Access Permission</title>

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
                                    User Access Permission
                                </h3>
                            </div>
                        </div>
                    </div>
                    <div class="card">
                        <div class="table-responsive">
                            <form id="userAccessPermissionForm" action="<c:url value='/userAccessPermission'/> "
                                  class="form-horizontal globalForm">
                                <div class="card-body">
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label text-right">User
                                            Roles</label>

                                        <div class="col-5">
                                            <form:select class="form-control form-select" path="userRoleList"
                                                         id="userRoleTypeId" name="userRoleTypeId">
                                                <form:option
                                                        value="">---Please Select---</form:option>
                                                <form:options items="${userRoleList}" itemValue="valueInteger"
                                                              itemLabel="text"/>
                                            </form:select>
                                        </div>
                                    </div>

                                    <div class="card-body">
                                        <table id="userAccessPermissionGrid" class="table table-bordered table-striped">
                                            <thead>
                                            <tr>
                                                <th class="text-muted">Screen Id</th>
                                                <th class="text-muted">Screen Name</th>
                                                <th class="text-muted">View Access</th>
                                                <th class="text-muted">Edit Access</th>
                                                <th class="text-muted">Delete Access</th>
                                                <th class="text-muted">Save Access</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            </tbody>
                                        </table>
                                    </div>
                                    <sec:authorize access="hasAuthority('2-ADD')">
                                        <div class="form-group row">
                                            <div class="col-2"></div>
                                            <div class="col-6">
                                                <input type="submit" class="btn btn-primary col-3" value="Save"
                                                       id="btnSave">
                                            </div>
                                        </div>
                                    </sec:authorize>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

