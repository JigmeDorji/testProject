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
    <title>Customer setup</title>
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
                                    Student List
                                </h3>
                            </div>
                            <!-- Page title actions -->
                            <div class="col-auto ml-auto d-print-none">
                                <a href="#" data-toggle="modal" data-target="#companyDetailModal"
                                   class="btn btn-primary btn-sm ml-3 d-none d-sm-inline-block"
                                   id="btnAddNew">
                                    Add New
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table card-table text-nowrap table-bordered col-md-12"
                                       id="companyTableId">
                                    <thead>
                                    <tr>
                                        <th class="text-muted">Customer Name</th>
                                    </tr>
                                    <tbody>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="modal modal-blur fade" id="companyDetailModal" tabindex="-1"
                         role="dialog" aria-hidden="true" data-backdrop="static" data-keyboard="false">
                        <div class="modal-dialog modal-xl" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title newCompany">
                                        Student Detail
                                    </h5>
                                    <h5 class="modal-title viewCompany hidden">
                                        Company
                                    </h5>
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-label="Close">
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <div class="card">
                                        <div class="card-body">
                                            <form id="customerSetupForm" action="<c:url value='/customerSetup/'/>"
                                                  class="form-horizontal globalForm customerSetupForm">
                                                <div class="form-group mb-3 row">
                                                    <label class="col-sm-2 col-form-label text-right required">Customer
                                                        Name</label>

                                                    <div class="col-4">
                                                        <input type="text" name="customerName"
                                                               id="customerName" class="form-control field"
                                                               required="true">
                                                    </div>
                                                </div>
                                                <div class="form-group mb-3 row">
                                                    <label class="col-sm-2 col-form-label text-right required">Contact
                                                        No
                                                    </label>

                                                    <div class="col-4">
                                                        <input type="text" name="contactNo"
                                                               id="contactNo" class="form-control field"
                                                               required="true">
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
