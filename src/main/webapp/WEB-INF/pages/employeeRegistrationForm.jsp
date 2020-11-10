<%--
  Created by IntelliJ IDEA.
  User: nzepa
  Date: 10/11/2020
  Time: 9:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<head>
    <title>Employee Registration</title>
</head>
<body>
<%--<script src="<c:url value="/resources/js/studentRegistration.js"/>"></script>--%>
<div class="page">
    <div class="content">
        <div class="container-xl">
            <div class="card card-sm">
                <div class="card-body">
                    <div class="page-header">
                        <div class="row align-items-center">
                            <div class="col-auto">

                                <h3 class="text-dark">
                                    Employee List
                                </h3>
                            </div>
                            <!-- Page title actions -->
                            <div class="col-auto ml-auto d-print-none">
                                <a href="#" data-toggle="modal" data-target="#employeeModal"
                                   class="btn btn-primary btn-sm ml-3 d-none d-sm-inline-block"
                                   id="btnAddNew">
                                    <span class="fa fa-user"></span>
                                    Add New
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table card-table text-nowrap table-bordered col-md-12"
                                       id="employeeListTableId">
                                    <thead>
                                    <tr>
                                        <th class="text-muted">Sl No</th>
                                        <th class="text-muted">Employee Name</th>
                                        <th class="text-muted">Designation Name</th>
                                        <th class="text-muted">Department</th>
                                        <th class="text-muted">Contact Number</th>
                                        <th class="text-muted">Date of Birth</th>
                                        <th class="text-muted">Action</th>
                                    </tr>
                                    <tbody>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="modal modal-blur fade" id="employeeModal" tabindex="-1"
                         role="dialog" aria-hidden="true" data-backdrop="static" data-keyboard="false">
                        <div class="modal-dialog modal-xl" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title newEmployee">
                                        <span class="fa fa-user"></span>
                                        Employee Detail
                                    </h5>

                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-label="Close">
                                        <span class="fa fa-times-circle-o"></span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <div class="card">
                                        <div class="card-body">
                                            <form id="employeeRegistrationForm" action="<c:url value='/employeeRegistration'/>"
                                                  class="form-horizontal globalForm employeeRegistrationForm">

                                                <%--<div class="form-group mb-3 row">
                                                    <label class="col-sm-2 col-form-label text-right required">Employee Id</label>
                                                    <div class="col-4">
                                                        <input type="text" name="employeeId"
                                                               id="employeeId" class="form-control field"
                                                               required="true">
                                                    </div>
                                                </div>--%>

                                                    <input type="hidden" name="id"
                                                           id="employeeId" class="form-control field">

                                                <div class="form-group mb-3 row">
                                                    <label class="col-sm-2 col-form-label text-right required">Employee Name</label>
                                                    <div class="col-4">
                                                        <input type="text" name="employeeName"
                                                               id="employeeName" class="form-control field"
                                                               required="true">
                                                    </div>
                                                </div>

                                                <div class="form-group mb-3 row">
                                                    <label class="col-sm-2 col-form-label text-right required">Employee Designation</label>
                                                    <div class="col-4">
                                                        <input type="text" name="employeeDesignation"
                                                               id="employeeDesignation" class="form-control field"
                                                               required="true">
                                                    </div>
                                                </div>

                                                <div class="form-group mb-3 row">
                                                    <label class="col-sm-2 col-form-label text-right required">Employee Department</label>
                                                    <div class="col-4">
                                                        <input type="text" name="employeeDepartment"
                                                               id="employeeDepartment" class="form-control field"
                                                               required="true">
                                                    </div>
                                                </div>

                                                <div class="form-group mb-3 row">
                                                    <label class="col-sm-2 col-form-label text-right required">Employee Contact No.</label>
                                                    <div class="col-4">
                                                        <input type="text" name="employeeContactNumber"
                                                               id="employeeContactNumber" class="form-control field"
                                                               required="true">
                                                    </div>
                                                </div>

                                                <div class="form-group mb-3 row">
                                                    <label class="col-sm-2 col-form-label text-right required">Date of Birth</label>
                                                    <div class="col-4">
                                                        <input type="text" name="employeeDateOfBirth"
                                                               id="employeeDateOfBirth" class="form-control field datepicker"
                                                               required="true" placeholder="YYYY-MM-DD">
                                                    </div>
                                                </div>



                                                <div class="form-group row offset-2">
                                                    <div class="col-4">
                                                        <input type="submit"
                                                               id="btnSave" class="btn btn-primary"
                                                               value="Save">
                                                    </div>
                                                </div>
                                            </form>
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
