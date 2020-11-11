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
    <title>Bank Account Creation</title>
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
                                    Account List
                                </h3>

                            </div>
                            <!-- Page title actions -->
                            <div class="col-auto ml-auto d-print-none">
                                <a href="#" data-toggle="modal" data-target="#companyDetailModal"
                                   class="btn btn-primary btn-sm ml-3 d-none d-sm-inline-block"
                                   id="btnAddNew">
                                    Create New Account
                                </a>
                            </div>
                        </div>
                    </div>

                    <div class="card">
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table card-table text-nowrap table-bordered col-md-12"
                                       id="bankaccountTableId">
                                    <thead>
                                    <tr>
                                        <th class="text-muted">Sl.no</th>
                                        <th class="text-muted">Account Holder Name</th>
                                        <th class="text-muted">Citizenship No</th>
                                        <th class="text-muted">Mobile No</th>
                                        <th class="text-muted">Email</th>
                                        <th class="text-muted">Dzongkhag</th>
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
                                        Account Details
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
                                            <form id="bankaccountRegistrationForm"
                                                  action="<c:url value='/bankaccountRegistration'/>"
                                                  class="form-horizontal globalForm bankaccountRegistrationForm">
                                                <!--Account Holder Name-->
                                                <div class="form-group mb-3 row">
                                                    <label class="col-sm-2 col-form-label text-right required">Account
                                                        Holder Name</label>


                                                    <div class="col-4">
                                                        <input type="text" name="bankaccountName"
                                                               id="bankaccountName" class="form-control field"
                                                               required="true">
                                                    </div>

                                                </div>
                                                <!--Account Holder Name-->
                                                <!--CID No-->
                                                <div class="form-group mb-3 row">
                                                    <label class="col-sm-2 col-form-label text-right required">CID
                                                        No</label>
                                                    <div class="col-4">
                                                        <input type="text" name="cidNo"
                                                               id="cidNo" class="form-control field"
                                                               required="true">
                                                    </div>

                                                </div>
                                                <!--CID No-->
                                                <!--Mobile No-->
                                                <div class="form-group mb-3 row">
                                                    <label class="col-sm-2 col-form-label text-right required">Mobile
                                                        No</label>
                                                    <div class="col-4">
                                                        <input type="text" name="mobileNo"
                                                               id="mobileNo" class="form-control field"
                                                               required="true">
                                                    </div>

                                                </div>
                                                <!--Mobile No-->

                                                <!--Email-->
                                                <label class="col-sm-2 col-form-label required text-right">Email</label>

                                                <div class="col-4">
                                                    <input type="text" name="emailId" id="email"
                                                           class="form-control field" required="true">
                                                </div>
                                                <!--Email-->

                                                <!--Dzongkhag-->
                                                <div class="form-group mb-3 row">
                                                    <label class="col-sm-2 col-form-label text-right required">Dzongkhag</label>
                                                    <div class="col-4">
                                                        <input type="text" name="dzongkhagId"
                                                               id="dzongkhagId" class="form-control dropdown field"
                                                               required="true">
                                                    </div>

                                                </div>
                                                <!--Dzongkhag-->


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
