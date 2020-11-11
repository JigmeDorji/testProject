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
    <title>Student Registration</title>
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
                                <a href="#" data-toggle="modal" data-target="#companyDetailModal"
                                   class="btn btn-primary btn-sm ml-3 d-none d-sm-inline-block"
                                   id="generateReportBtn">
                                    Generate Report
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
                                        <th class="text-muted">Student Name</th>
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
                                        Student Detail
                                    </h5>
                                    <h5 class="modal-title viewCompany hidden">
                                        <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-md"
                                             width="24" height="24" viewBox="0 0 24 24" stroke-width="2"
                                             stroke="currentColor" fill="none" stroke-linecap="round"
                                             stroke-linejoin="round">
                                            <path stroke="none" d="M0 0h24v24H0z"></path>
                                            <circle cx="12" cy="7" r="4"></circle>
                                            <path d="M5.5 21v-2a4 4 0 0 1 4 -4h5a4 4 0 0 1 4 4v2"></path>
                                        </svg>
                                        Company
                                    </h5>
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-label="Close">
                                        <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24"
                                             height="24" viewBox="0 0 24 24"
                                             stroke-width="2" stroke="currentColor" fill="none"
                                             stroke-linecap="round" stroke-linejoin="round">
                                            <path stroke="none" d="M0 0h24v24H0z"/>
                                            <line x1="18" y1="6" x2="6" y2="18"/>
                                            <line x1="6" y1="6" x2="18" y2="18"/>
                                        </svg>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <div class="card">
                                        <div class="card-body">
                                            <form id="studentRegistrationForm" action="<c:url value='/studentRegistration'/>"
                                                  class="form-horizontal globalForm studentRegistrationForm">
                                                <div class="form-group mb-3 row">
                                                    <label class="col-sm-2 col-form-label text-right required">Student
                                                        Name</label>

                                                    <div class="col-4">
                                                        <input type="text" name="studentName"
                                                               id="studentName" class="form-control field"
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
