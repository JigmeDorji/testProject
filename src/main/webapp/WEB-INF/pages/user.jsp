<%--
  Created by IntelliJ IDEA.
  User: nzepa
  Date: 10/5/2020
  Time: 10:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<%--<script src="<c:url value="/resources/js/user.js"/>"></script>--%>
<div class="page">
    <div class="content">
        <div class="container-xl">
            <div class="card card-sm">
                <div class="card-body">
                    <div class="page-header">

                        <div class="row align-items-center">
                            <div class="col-auto">

                                <h3 class="text-dark">
                                    Users
                                </h3>
                            </div>
                            <!-- Page title actions -->
                            <div class="col-auto ml-auto d-print-none">
                                <a href="#" data-toggle="modal" data-target="#userDetailModal"
                                   class="btn btn-primary btn-sm ml-3 d-none d-sm-inline-block"
                                   id="btnAddUser">
                                    <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-md"
                                         width="24" height="24" viewBox="0 0 24 24" stroke-width="2"
                                         stroke="currentColor" fill="none" stroke-linecap="round"
                                         stroke-linejoin="round">
                                        <path stroke="none" d="M0 0h24v24H0z"></path>
                                        <circle cx="8.5" cy="7" r="4"></circle>
                                        <path d="M2 21v-2a4 4 0 0 1 4 -4h5a4 4 0 0 1 4 4v2"></path>
                                        <line x1="16" y1="11" x2="22" y2="11"></line>
                                        <line x1="19" y1="8" x2="19" y2="14"></line>
                                    </svg>
                                    Add New
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table card-table text-nowrap table-bordered col-md-12"
                                       id="userListTableId">
                                    <thead>
                                    <tr>
                                        <th class="text-muted">Sl No.</th>
                                        <th class="text-muted">Status</th>
                                        <th class="text-muted">Username</th>
                                        <th class="text-muted">Full Name</th>
                                        <th class="text-muted">Company</th>
                                        <th class="text-muted">Mobile No</th>
                                        <th class="text-muted">Creation Date</th>
                                        <th class="text-muted">Role</th>
                                        <th class="text-muted">Action</th>
                                    </tr>
                                    <tbody>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="modal modal-blur fade" id="userDetailModal" tabindex="-1"
                         role="dialog" aria-hidden="true" data-backdrop="static" data-keyboard="false">
                        <div class="modal-dialog modal-xl" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title newUser">
                                        <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-md"
                                             width="24" height="24" viewBox="0 0 24 24" stroke-width="2"
                                             stroke="currentColor" fill="none" stroke-linecap="round"
                                             stroke-linejoin="round">
                                            <path stroke="none" d="M0 0h24v24H0z"></path>
                                            <circle cx="8.5" cy="7" r="4"></circle>
                                            <path d="M2 21v-2a4 4 0 0 1 4 -4h5a4 4 0 0 1 4 4v2"></path>
                                            <line x1="16" y1="11" x2="22" y2="11"></line>
                                            <line x1="19" y1="8" x2="19" y2="14"></line>
                                        </svg>
                                        New User
                                    </h5>
                                    <h5 class="modal-title viewUser hidden">
                                        <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-md"
                                             width="24" height="24" viewBox="0 0 24 24" stroke-width="2"
                                             stroke="currentColor" fill="none" stroke-linecap="round"
                                             stroke-linejoin="round">
                                            <path stroke="none" d="M0 0h24v24H0z"></path>
                                            <circle cx="12" cy="7" r="4"></circle>
                                            <path d="M5.5 21v-2a4 4 0 0 1 4 -4h5a4 4 0 0 1 4 4v2"></path>
                                        </svg>
                                        User
                                    </h5>
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-label="Close">
                                        <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24"
                                             height="24"
                                             viewBox="0 0 24 24"
                                             stroke-width="2" stroke="currentColor" fill="none"
                                             stroke-linecap="round"
                                             stroke-linejoin="round">
                                            <path stroke="none" d="M0 0h24v24H0z"/>
                                            <line x1="18" y1="6" x2="6" y2="18"/>
                                            <line x1="6" y1="6" x2="18" y2="18"/>
                                        </svg>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <div class="card">
                                        <div class="card-body">
                                            <form id="userFormId" action="<c:url value='/user'/>"
                                                  class="form-horizontal globalForm userFormId">
                                                <input type="hidden" id="statusActive"
                                                       value="${statusActive}">
                                                <input type="hidden" id="statusInactive"
                                                       value="${statusInactive}">

                                                <div class="form-group mb-3 row">
                                                    <label class="col-sm-2 col-form-label text-right required">Username</label>

                                                    <div class="col-4">
                                                        <input type="text" name="userId" id="userId"
                                                               class="form-control field" required="true">
                                                    </div>
                                                    <label class="col-sm-2 col-form-label text-right required">Full
                                                        Name</label>

                                                    <div class="col-4">
                                                        <input type="text" name="userFullName"
                                                               id="userFullName" class="form-control field"
                                                               required="true">
                                                    </div>
                                                </div>
                                                <div class="form-group mb-3 row">
                                                    <label class="col-sm-2 col-form-label text-right">Password</label>

                                                    <div class="col-4">
                                                        <input type="password" name="userPassword"
                                                               id="userPassword" class="form-control field">
                                                    </div>
                                                    <label class="col-sm-2 col-form-label text-right">Confirm
                                                        Password</label>

                                                    <div class="col-4">
                                                        <input type="password" name="txtConfirmPassword"
                                                               id="txtConfirmPassword"
                                                               class="form-control field">
                                                    </div>
                                                </div>
                                                <div class="form-group mb-3 row">
                                                    <label class="col-sm-2 col-form-label text-right">Mobile
                                                        No</label>

                                                    <div class="col-4">
                                                        <input type="text" name="userMobileNo"
                                                               class="form-control numeric field"
                                                               id="userMobileNo">
                                                    </div>

                                                    <label class="col-sm-2 col-form-label text-right required">User
                                                        Role</label>

                                                    <div class="col-4">
                                                        <form:select required="true" path="userRoleList"
                                                                     class="form-control form-select field"
                                                                     id="userRoleTypeId"
                                                                     name="userRoleTypeId">
                                                            <form:option
                                                                    value="">---Please Select---</form:option>
                                                            <form:options items="${userRoleList}"
                                                                          itemValue="valueInteger"
                                                                          itemLabel="text"/>
                                                        </form:select>
                                                    </div>
                                                </div>
                                                <div class="form-group mb-3 row">
                                                    <label class="col-sm-2 col-form-label text-right required">Status</label>

                                                    <div class="col-4">
                                                        <form:select required="true" path="statusList"
                                                                     class="form-control form-select field"
                                                                     id="userStatus" name="userStatus">
                                                            <form:option
                                                                    value="">---Please Select---</form:option>
                                                            <form:options items="${statusList}"
                                                                          itemValue="valueChar"
                                                                          itemLabel="text"/>
                                                        </form:select>
                                                    </div>
                                                    <label class="col-sm-2 col-form-label text-right required">Select
                                                        Company</label>

                                                    <div class="col-4">
                                                        <form:select required="true" path="companyList"
                                                                     class="form-control form-select field"
                                                                     id="companyId" name="companyId">
                                                            <form:option
                                                                    value="">---Please Select---</form:option>
                                                            <form:options items="${companyList}"
                                                                          itemValue="valueInteger"
                                                                          itemLabel="text"/>
                                                        </form:select>
                                                    </div>
                                                </div>

                                                <div class="form-group mb-3 row">

                                                    <label class="col-sm-2 col-form-label text-right">Creation
                                                        Date</label>

                                                    <div class="col-4">
                                                        <input type="text" value="${currentDate}"
                                                               readonly="readonly" name="createdDate"
                                                               id="createdDate" class="form-control">
                                                    </div>

                                                    <label class="col-sm-2 col-form-label required text-right">Email</label>

                                                    <div class="col-4">
                                                        <input type="text" name="emailId" id="email"
                                                               class="form-control field" required="true">
                                                    </div>
                                                </div>
                                                <div class="form-group mb-3 row">
                                                    <div class="col-2"></div>
                                                    <%--<sec:authorize access="hasAuthority('1-ADD')">--%>
                                                    <div class="col-2">
                                                        <input type="submit" class="btn btn-primary col-12"
                                                               value="Add" id="btnSave">
                                                    </div>
                                                    <%--</sec:authorize>--%>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                    <div class="card log-card">
                                        <div class="card-header">
                                            <span id="logCount" class="badge bg-danger"></span>

                                            &nbsp;&nbsp;&nbsp;&nbsp;
                                            <h3 class="card-title">Log</h3>
                                            <i class="fa fa-chevron-down expand ml-auto cursor-pointer"
                                               title="Click to expand"></i>
                                            <i class="fa fa-chevron-up contract ml-auto cursor-pointer hidden"
                                               title="Click to hide"></i>
                                        </div>
                                        <div class="card-body logCard hidden">
                                            <ul class="list list-timeline" id="userLog">
                                            </ul>
                                        </div>
                                    </div>
                                </div>
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



