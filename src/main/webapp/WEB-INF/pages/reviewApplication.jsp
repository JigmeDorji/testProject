<%--
  Created by IntelliJ IDEA.
  User: nzepa
  Date: 10/2/2020
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Review Application</title>
</head>
<body>
<div class="page">
    <div class="content">
        <div class="container-xl">
            <div class="page-header">
                <div class="row align-items-center">
                    <div class="col-auto">
                        <h2 class="page-title">
                            Review Application
                        </h2>
                    </div>
                </div>
            </div>
            <div class="card" id="newApplicationFormCard">
                <div class="card-body">
                    <div class="card-body">
                        <div class="form-group mb-2 row">
                            <label class="form-label col-2 col-form-label text-right">Application No</label>

                            <div class="col">
                                <input type="text" id="aplic" class="form-control">
                            </div>
                            <label class="form-label col-2 col-form-label text-right">Company</label>

                            <div class="col">
                                <select class="form-select">
                                    <option value="">--Select--</option>
                                    <option value="1">Bank of Bhutan</option>
                                    <option value="2">Thimphu TechPark</option>
                                    <option value="3">Bangk of Bhutan</option>
                                    <option value="4">Bhutan Telecom Ltd</option>
                                    <option value="5">Bhutan Power Corporation</option>
                                    <option value="6">DGPC</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group mb-2 row">

                            <label class="form-label col-2 col-form-label text-right">Status</label>

                            <div class="col">
                                <select class="form-select">
                                    <option value="">--Select--</option>
                                    <option value="1">New</option>
                                    <option value="2">Approved</option>
                                    <option value="3">Rejected</option>
                                </select>
                            </div>
                            <label class="form-label col-2 col-form-label"></label>

                            <div class="col">
                                <input type="button" id="btnSearch" class="btn btn-primary" value="Search">
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table card-table table-vcenter text-nowrap table-bordered"
                                           id="applicationListTableId">
                                        <thead>
                                        <tr>
                                            <th>SL</th>
                                            <th>Status</th>
                                            <th>Application No</th>
                                            <th>Subject</th>
                                            <th>description</th>
                                            <th>acreage</th>
                                            <th>Application Date</th>
                                            <th>Action</th>
                                        </tr>
                                        </thead>
                                        <tbody></tbody>
                                    </table>
                                    <div class="modal modal-blur fade" id="applicationDetailModal" tabindex="-1"
                                         role="dialog" aria-hidden="true">
                                        <div class="modal-dialog modal-xl" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title">Application No: <span
                                                            class="applicationNoText"></span></h5>
                                                    <button type="button" class="close" data-dismiss="modal"
                                                            aria-label="Close">
                                                        <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24"
                                                             height="24" viewBox="0 0 24 24" stroke-width="2"
                                                             stroke="currentColor" fill="none" stroke-linecap="round"
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
                                                            <form id="reviewApplicationForm"
                                                                  action="<c:url value='/reviewApplication'/>"
                                                                  class="form-horizontal globalForm reviewApplicationForm"
                                                                  enctype="multipart/form-data">
                                                                <input type="hidden" name="applicationNo"
                                                                       id="applicationNo" class="applicationNo">
                                                                <input type="hidden" value="${currentUserId}"
                                                                       id="currentUserId" class="currentUserId">
                                                                <div class="form-group mb-3 row">
                                                                    <label class="col-lg-2 mb-3 form-label text-right">Company</label>

                                                                    <div class="col-lg-4">
                                                                        <form:select required="true" path="companyList"
                                                                                     class="form-control form-select field"
                                                                                     id="companyId" name="companyId"
                                                                                     disabled="true">
                                                                            <form:option
                                                                                    value="">---Please Select---</form:option>
                                                                            <form:options items="${companyList}"
                                                                                          itemValue="valueInteger"
                                                                                          itemLabel="text"/>
                                                                        </form:select>
                                                                    </div>
                                                                </div>

                                                                <div class="form-group mb-3 row">
                                                                    <label class="col-sm-2 form-label text-right">Subject</label>

                                                                    <div class="col-sm-4">
                                                                        <input type="text" class="form-control field"
                                                                               name="subject" id="subject" readonly>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group mb-3 row">
                                                                    <label class="col-sm-2 form-label text-right">Description</label>

                                                                    <div class="col-sm-4">
                                                        <textarea class="form-control field" name="description"
                                                                  id="description" readonly></textarea>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group mb-3 row">
                                                                    <label class="col-sm-2 form-label text-right">Area</label>

                                                                    <div class="col-sm-4">
                                                                        <input type="text" class="form-control field"
                                                                               name="acreage" id="acreage" readonly>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group mb-3 row">
                                                                    <label class="col-sm-2 form-label text-right">Amount(Nu.)</label>

                                                                    <div class="col-sm-4">
                                                                        <input type="text" class="form-control field"
                                                                               name="amount" id="amount" readonly>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group mb-3 row">
                                                                    <label class="col-sm-2 form-label text-right">Document</label>

                                                                    <div class="col-sm-4">
                                                                        <div class="table-responsive">
                                                                            <table id="documentTableId"
                                                                                   class="table text-nowrap table-bordered">
                                                                                <tbody>
                                                                                </tbody>
                                                                            </table>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group mb-3 row">
                                                                    <label class="col-sm-2 form-label text-right">Application
                                                                        Date</label>

                                                                    <div class="col-sm-4">
                                                                        <input type="text"
                                                                               class="form-control datepicker field"
                                                                               name="applicationDate" readonly
                                                                               id="applicationDate">
                                                                    </div>
                                                                </div>
                                                                <%--<div class="form-group mb-3 row">--%>
                                                                <%--<label class="col-sm-2 form-label required">Finalized Document</label>--%>

                                                                <%--<div class="col-sm-4">--%>
                                                                <%--<input type="file" class="form-control field" name="document"--%>
                                                                <%--id="file" required="true">--%>
                                                                <%--</div>--%>
                                                                <%--</div>--%>
                                                                <div class="form-group mb-3 row">
                                                                    <label class="col-sm-2 form-label text-right">Comments</label>

                                                                    <div class="col-sm-4">
                                                        <textarea class="form-control field" name="comments"
                                                                  id="comments" aria-describedby="comments-error"
                                                                  aria-invalid="true" title></textarea>
                                                                        <span id="comments-error"
                                                                              class="error invalid-feedback">This field is required.</span>
                                                                    </div>
                                                                </div>
                                                                <div class="card">
                                                                    <div class="card-header">
                                                                        <span id="commentCount" class="badge bg-danger">
                                                                        </span>
                                                                        <h3 class="card-title">Comments</h3>
                                                                        <i class="fa fa-chevron-down expandComments ml-auto cursor-pointer"
                                                                           title="Click to expand"></i>
                                                                        <i class="fa fa-chevron-up contract ml-auto cursor-pointer hidden"
                                                                           title="Click to hide"></i>
                                                                    </div>
                                                                    <div class="card-body commentCard hidden">
                                                                        <ul class="list list-timeline list-timeline-simple"
                                                                            id="commentList">
                                                                        </ul>
                                                                    </div>
                                                                </div>

                                                                <div class="form-group mb-3 row">
                                                                    <div class="col-md-2 offset-2">
                                                                        <input type="button"
                                                                               class="btn btn-xs btn-info btn-block"
                                                                               value="Approve" id="btnApprove">
                                                                    </div>
                                                                    <div class="col-md-2">
                                                                        <input type="button"
                                                                               class="btn btn-xs btn-danger btn-block"
                                                                               value="Reject" id="btnReject">
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
            </div>
        </div>
    </div>
</div>
</body>
</html>



