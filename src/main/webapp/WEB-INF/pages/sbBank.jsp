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
    <title>SbBank Account</title>
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
                                    Bank List
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
                                       id="storeTableId">
                                    <thead>
                                    <tr>
                                        <th class="text-muted">SL</th>
                                        <th class="text-muted">ID</th>
                                        <th class="text-muted">Customer Name</th>
                                        <th class="text-muted">CID</th>
                                        <th class="text-muted">Gender</th>
                                        <th class="text-muted">Mobile</th>
                                        <th class="text-muted">dzongkhagId</th>
                                        <th class="text-muted">Email</th>
                                        <th class="text-muted">address</th>
                                        <th class="text-muted">Dzongkhag Name</th>
                                        <th class="text-muted">DoB</th>
                                        <th class="text-muted">Action</th>
                                    </tr>
                                    <tbody>
                                    </tbody>
                                </table>
                                <input type="text" name="sumTotal"
                                       id="sumTotal" class="form-control field"
                                       required="true">
                            </div>
                        </div>
                    </div>

                    <div class="modal modal-blur fade" id="companyDetailModal" tabindex="-1"
                         role="dialog" aria-hidden="true" data-backdrop="static" data-keyboard="false">
                        <div class="modal-dialog modal-xl" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title newCompany">
                                        Store Detail
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
                                            <form id="sbBankForm" action="<c:url value='/sbBank'/>"
                                                  class="form-horizontal globalForm sbBankForm">
                                                <input type="hidden" name="id"
                                                       id="id" class="form-control field"
                                                       required="true">
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
                                                    <label class="col-sm-2 col-form-label text-right required">Cid</label>
                                                    <div class="col-4">
                                                        <input type="text" name="cid"
                                                               id="cid" class="form-control field"
                                                               required="true">
                                                    </div>
                                                </div>

                                                <div class="form-group mb-3 row">
                                                    <label class="col-sm-2 col-form-label text-right required">Mobile</label>
                                                    <div class="col-4">
                                                        <input type="text" name="mobile"
                                                               id="mobile" class="form-control field"
                                                               required="true">
                                                    </div>
                                                </div>

                                                <div class="form-group mb-3 row">
                                                    <label class="col-sm-2 col-form-label text-right required">DzongkhangList</label>
                                                    <div class="col-4">
                                                        <form:select required="true" path="dzongkhagList"
                                                                     class="form-control form-select field"
                                                                     id="dzongkhagId" name="dzongkhagId">
                                                            <form:option
                                                                    value="">--- dzongkhag list---</form:option>
                                                            <form:options items="${dzongkhagList}"
                                                                          itemValue="valueInteger"
                                                                          itemLabel="valueText"/>
                                                        </form:select>
                                                    </div>

                                                </div>

                                                <div class="form-group mb-3 row">
                                                    <label class="col-sm-2 col-form-label text-right required">Email</label>
                                                    <div class="col-4">
                                                        <input type="email" name="email"
                                                               id="email" class="form-control field" required="true">
                                                    </div>

                                                </div>
                                                <div class="form-group mb-3 row">
                                                    <label class="col-sm-2 col-form-label text-right required">Address</label>
                                                    <div class="col-4">
                                                        <input type="text" name="address"
                                                               id="address" class="form-control field" required="true">
                                                    </div>

                                                </div>
                                                <div class="form-group mb-3 row">
                                                    <label class="col-sm-2 col-form-label text-right required">DOB</label>
                                                    <div class="col-4">
                                                        <input type="text" name="dob"
                                                               id="dob" class="form-control datepicker field" required="true">
                                                    </div>

                                                </div>
                                                <div class="form-group mb-3 row">
                                                    <label class="col-sm-2 col-form-label text-right required">Gender</label>
                                                    <div class="col-4">
                                                        <input type="radio" id="male" name="gender" value="M">
                                                        <label for="male">Male</label><br>
                                                        <input type="radio" id="female" name="gender" value="F">
                                                        <label for="female">Female</label><br>
                                                        <input type="radio" id="other" name="gender" value="O">
                                                        <label for="other">Other</label>
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
