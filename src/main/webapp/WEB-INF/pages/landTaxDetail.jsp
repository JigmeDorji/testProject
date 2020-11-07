<%--
  Created by IntelliJ IDEA.
  User: nzepa
  Date: 10/2/2020
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tax Detail</title>
</head>
<body>
<div class="page">
    <div class="content">
        <div class="container-xl">
            <div class="page-header">
                <div class="row align-items-center">
                    <div class="col-auto">

                        <h2 class="page-title">
                            Tax Detail
                        </h2>
                    </div>
                </div>
            </div>
            <div class="card" id="newApplicationFormCard">
                <div class="card-body">
                    <div class="card-body">
                        <div class="form-group mb-2 row">
                            <label class="form-label col-2 col-form-label">Thram No</label>

                            <div class="col">
                                <input type="text" id="aplic" class="form-control">
                            </div>
                            <label class="form-label col-2 col-form-label">Year</label>

                            <div class="col">
                                <select class="form-select">
                                    <option value="1">2020</option>
                                    <option value="2">2019</option>
                                    <option value="3">2018</option>
                                    <option value="4">2017</option>
                                    <option value="5">2015</option>
                                    <option value="6">2014</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group mb-2 row">

                            <label class="form-label col-2 col-form-label">Status</label>

                            <div class="col">
                                <select class="form-select">
                                    <option value="1">Pending</option>
                                    <option value="2">Paid</option>
                                </select>
                            </div>
                            <label class="form-label col-2 col-form-label"></label>

                            <div class="col">
                                <input type="button" id="btnSearch" class="btn btn-primary" value="Search">
                            </div>
                        </div>
                        <div class="form-group mb-2 row">
                            <div class="table-responsive">
                                <table class="table card-table table-vcenter text-nowrap table-bordered"
                                       id="operatorsTaskListTableId">
                                    <thead>
                                    <tr>
                                        <th>SL</th>
                                        <th>Status</th>
                                        <th>Year</th>
                                        <th>Thram No</th>
                                        <th>Dzongkhag</th>
                                        <th>Precient</th>
                                        <th>Category</th>
                                        <th>Tax Amount(Nu.)</th>
                                        <%--<th>Payment Date</th>--%>
                                        <th>View</th>
                                        <%--<th>Attachment</th>--%>
                                        <%--<th>Remarks</th>--%>
                                        <%--<th>Action</th>--%>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td><i class='status-icon bg-danger'></i>Pending</td>
                                        <td>2020</td>
                                        <td>T-0001</td>
                                        <td>Thimphu</td>
                                        <td>2</td>
                                        <td>Chuzing</td>
                                        <td>23,000</td>
                                        <td>
                                            <a href="#" class="btn btn-info btn-sm"
                                               data-toggle="modal" data-target="#applicationDetailModal">View</a>
                                        </td>
                                        <%--<td><input type="file"/></td>--%>
                                        <%--<td><input type="text"/></td>--%>
                                        <%--<td>--%>
                                        <%--<a href="#" class="btn btn-info btn-sm" onclick="tableBtnView()">Update</a>--%>
                                        <%--</td>--%>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td><i class='status-icon bg-success'></i>Paid</td>
                                        <td>2020</td>
                                        <td>T-0002</td>
                                        <td>Punakha</td>
                                        <td>5</td>
                                        <td>Kamzing</td>
                                        <td>2,000</td>
                                        <td>
                                            <a href="#" class="btn btn-info btn-sm"
                                               data-toggle="modal" data-target="#applicationDetailModal">View</a>
                                        </td>
                                        <%--<td><input type="text" class="datepicker"/></td>--%>
                                        <%--<td><input type="file"/></td>--%>
                                        <%--<td><input type="text"/></td>--%>
                                        <%--<td>--%>
                                        <%--<a href="#" class="btn btn-info btn-sm" onclick="tableBtnView()">Update</a>--%>
                                        <%--</td>--%>
                                    </tr>
                                    <tr>
                                        <td>3</td>
                                        <td><i class='status-icon bg-yellow'></i>Pending</td>
                                        <td>2020</td>
                                        <td>T-0003</td>
                                        <td>Sarpang</td>
                                        <td>8</td>
                                        <td>Wetland</td>
                                        <td>7,000</td>
                                        <td>
                                            <a href="#" class="btn btn-info btn-sm"
                                               data-toggle="modal" data-target="#applicationDetailModal">View</a>
                                        </td>
                                        <%--<td><input type="text" class="datepicker"/></td>--%>
                                        <%--<td><input type="file"/></td>--%>
                                        <%--<td><input type="text"/></td>--%>
                                        <%--<td>--%>
                                        <%--<a href="#" class="btn btn-info btn-sm" onclick="tableBtnView()">Update</a>--%>
                                        <%--</td>--%>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="modal modal-blur fade" id="applicationDetailModal" tabindex="-1" role="dialog"
                                 aria-hidden="true">
                                <div class="modal-dialog modal-xl" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title">Thram No: T-0001 </h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
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
                                            <form>
                                                <div class="form-group  mb-3 row">
                                                    <label class="col-lg-2 mb-3 form-label">Status</label>

                                                    <div class="col-lg-4">
                                                        <i class='status-icon bg-danger'></i>Pending
                                                    </div>
                                                </div>
                                                <div class="form-group  mb-3 row">
                                                    <label class="col-lg-2 mb-3 form-label">Tax Amount(Nu.)</label>

                                                    <div class="col-lg-4">
                                                        <input type="text" id="taxAmount" class="form-control"
                                                               value="23,000" readonly>
                                                    </div>
                                                </div>

                                                <div class="form-group mb-3 row">
                                                    <label class="col-lg-2 mb-3 form-label">Attachment</label>

                                                    <div class="col-lg-4">
                                                        <input type="file" id="paymentAttachment" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group mb-3 row">
                                                    <label class="col-lg-2 mb-3 form-label">Payment Date</label>

                                                    <div class="col-lg-4">
                                                        <input type="text" id="applicationDate" class="form-control"
                                                               value="01/08/2020" >
                                                    </div>
                                                </div>

                                                <div class="form-group mb-3 row">
                                                    <label class="col-lg-2 mb-3 form-label">Remarks</label>

                                                    <div class="col-lg-4">
                                                        <textarea class="form-control"></textarea>
                                                    </div>
                                                </div>

                                                <div class="form-group row">
                                                    <label class="col-lg-2 form-label"></label>

                                                    <div class="col-lg-1">
                                                        <input type="button" class="btn btn-primary" value="Update">
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


