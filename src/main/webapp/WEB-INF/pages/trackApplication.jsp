<%--
  Created by IntelliJ IDEA.
  User: nzepa
  Date: 10/5/2020
  Time: 4:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Track Application</title>
</head>
<body>
<div class="page">
    <div class="content">
        <div class="container-xl">
            <div class="page-header">
                <div class="row align-items-center">
                    <div class="col-auto">

                        <h2 class="page-title">
                            Track Application
                        </h2>
                    </div>
                </div>
            </div>
            <div class="card" id="newApplicationFormCard">
                <div class="card-body">
                    <div class="card-body">
                        <div class="form-group mb-2 row">
                            <label class="form-label col-2 col-form-label">Application No</label>

                            <div class="col">
                                <input type="text" id="aplic" class="form-control">
                            </div>
                            <label class="form-label col-2 col-form-label">Company</label>

                            <div class="col">
                                <select class="form-select">
                                    <option value="2">Thimphu TechPark Ltd</option>
                                    <option value="3">Bangk of Bhutan</option>
                                    <option value="4">Bhutan Telecom Ltd</option>
                                    <option value="5">Bhutan Power Corporation</option>
                                    <option value="6">DGPC</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group mb-2 row">

                            <label class="form-label col-2 col-form-label">Status</label>

                            <div class="col">
                                <select class="form-select">
                                    <option value="1">Submitted</option>
                                    <option value="2">Approved</option>
                                    <option value="3">Rejected</option>
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
                                        <th>Application No</th>
                                        <th>Company</th>
                                        <th>Subject</th>
                                        <th>Application Date</th>
                                        <th>Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td><i class='status-icon bg-yellow'></i>New</td>
                                        <td>0001</td>
                                        <td>Thimphu TechPark Ltd</td>
                                        <td>Purchase of New Land</td>
                                        <td>01/08/2020</td>
                                        <td>
                                            <a href="#" class="btn btn-info btn-sm"
                                               data-toggle="modal" data-target="#applicationDetailModal">View</a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td><i class='status-icon bg-success'></i>Approved</td>
                                        <td>0002</td>
                                        <td>Bank of Bhutan</td>
                                        <td>New Land at Babesa</td>
                                        <td>01/01/2020</td>
                                        <td>
                                            <a href="#" class="btn btn-info btn-sm"
                                               data-toggle="modal" data-target="#applicationDetailModal">View</a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>3</td>
                                        <td><i class='status-icon bg-danger'></i>Rejected</td>
                                        <td>0003</td>
                                        <td>Bhutan Telecom Ltd</td>
                                        <td>Acre Land Required</td>
                                        <td>01/06/2020</td>
                                        <td>
                                            <a href="#" class="btn btn-info btn-sm"
                                               data-toggle="modal" data-target="#applicationDetailModal">View</a>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="modal modal-blur fade" id="applicationDetailModal" tabindex="-1" role="dialog"
                                 aria-hidden="true">
                                <div class="modal-dialog modal-xl" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title">Application No: 0001 </h5>
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
                                                <div class="steps steps-green">
                                                    <a href="#" class="step-item">
                                                        Step 1
                                                    </a>
                                                    <a href="#" class="step-item">
                                                        Step 2
                                                    </a>
                                                    <a href="#" class="step-item active">
                                                        Step 3
                                                    </a>
  <span href="#" class="step-item">
    Step 4
  </span>
                                                </div>
                                                <div class="steps steps-red">
                                                    <a href="#" class="step-item">
                                                        Step 1
                                                    </a>
                                                    <a href="#" class="step-item" title="Land Focal Person">
                                                        Step 2
                                                    </a>
                                                    <a href="#" class="step-item active">
                                                        Step 3
                                                    </a>
  <span href="#" class="step-item">
    Step 4
  </span>
                                                </div>
                                                <div class="form-group  mb-3 row">
                                                    <label class="col-lg-2 mb-3 form-label">Status</label>

                                                    <div class="col-lg-4">
                                                        <i class='status-icon bg-danger'></i>Pending
                                                    </div>
                                                </div>
                                                <div class="form-group mb-3 row">
                                                    <label class="col-lg-2 mb-3 form-label">Company</label>

                                                    <div class="col-lg-4">
                                                        <select name="company" id="company" class="form-select"
                                                                disabled>
                                                            <option value="2">Thimphu TechPark</option>
                                                        </select>
                                                    </div>
                                                </div>

                                                <div class="form-group mb-3 row">
                                                    <label class="col-sm-2 form-label">Subject</label>

                                                    <div class="col-sm-4">
                                                        <input type="text" class="form-control field" name="subject"
                                                               id="subject" value="Purchase of New Land" readonly>
                                                    </div>
                                                </div>
                                                <div class="form-group mb-3 row">
                                                    <label class="col-sm-2 form-label">Description</label>

                                                    <div class="col-sm-4">
                                                        <textarea class="form-control field" name="description"
                                                                  id="description" readonly>Located at the top of Buddha Point
                                                            </textarea>
                                                    </div>
                                                </div>
                                                <div class="form-group mb-3 row">
                                                    <label class="col-sm-2 form-label">Area</label>

                                                    <div class="col-sm-4">
                                                        <input type="text" class="form-control field" name="acreage"
                                                               id="acreage" value="34,000" readonly>
                                                    </div>
                                                </div>
                                                <div class="form-group mb-3 row">
                                                    <label class="col-sm-2 form-label">Amount(Nu.)</label>

                                                    <div class="col-sm-4">
                                                        <input type="text" class="form-control field" name="amount"
                                                               id="amount" value="94,093" readonly>
                                                    </div>
                                                </div>
                                                <div class="form-group mb-3 row">
                                                    <label class="col-sm-2 form-label">Document</label>

                                                    <div class="col-sm-4">
                                                        <%--<input type="file" class="form-control field" name="document"--%>
                                                        <%--id="file">--%>
                                                        <table class="table card-table table-vcenter text-nowrap table-bordered">
                                                            <tr>
                                                                <td>1</td>
                                                                <td>Lag Thram.PNG</td>
                                                                <td><i class="fa fa-download" style="color:green"></i>
                                                                    Download
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td>2</td>
                                                                <td>Agreement.PNG</td>
                                                                <td><i class="fa fa-download" style="color:green"></i>
                                                                    Download
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>
                                                <div class="form-group mb-3 row">
                                                    <label class="col-sm-2 form-label">Application Date</label>

                                                    <div class="col-sm-4">
                                                        <input type="text" class="form-control datepicker field"
                                                               name="applicationDate" value="01/08/2020" readonly
                                                               id="applicationDate">
                                                    </div>
                                                </div>
                                                <div class="form-group mb-3 row">
                                                    <label class="col-sm-2 form-label">Comments</label>

                                                    <div class="col-sm-4">
                                                        <textarea class="form-control field" name="comments"
                                                                  id="comments"></textarea>
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
