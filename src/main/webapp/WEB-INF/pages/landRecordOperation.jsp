<%--
  Created by IntelliJ IDEA.
  User: Bikash Rai
  Date: 03/10/2020
  Time: 10:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body class="antialiased">
<div class="page">
    <div class="content">
        <div class="container-xl">
            <div class="row">
                <div class="col-2">
                    <div class="subheader mt-lg-6">Operation</div>
                    <div class="list-group list-group-transparent mb-3">
                        <a class="list-group-item list-group-item-action d-flex align-items-center " href="#">
                            Lease Out
                        </a>
                        <a class="list-group-item list-group-item-action d-flex align-items-center active" href="#">
                            Lease Rent
                        </a>
                        <a class="list-group-item list-group-item-action d-flex align-items-center" href="#">
                            Generate Reports
                        </a>
                    </div>
                </div>
                <div class="col-10">
                    <div class="row">
                        <div class="col-sm-6 col-lg-12">
                            <div class="card card-sm">
                                <div class="card-body">
                                    <div class="col-md-12">
                                        <div class="form-group row">
                                            <label class="form-label col-2 col-form-label">Company</label>

                                            <div class="col  col-md-6">
                                                <select class="form-select">
                                                    <option value="1">-- Select --</option>
                                                    <option value="8f88657d-c6e6-11e4-b574-080027dcfac6"
                                                            selected>
                                                        BOB-Bank of Bhutan
                                                    </option>
                                                    <option value="8f88a92b-c6e6-11e4-b574-080027dcfac6">
                                                        TTPL -Thimphu Techpark
                                                    </option>
                                                    <option value="8f8902aa-c6e6-11e4-b574-080027dcfac6">
                                                        BT -Bhutan Telecom
                                                    </option>
                                                    <option value="8f897032-c6e6-11e4-b574-080027dcfac6">
                                                        NRDCL -(Tharm MPL)
                                                    </option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-6 col-lg-12">
                            <div class="card card-sm">
                                <div class="card-body">
                                    <div class="col-auto">

                                        <h3 class="text-dark">
                                            Lease Rent
                                        </h3>

                                        <form>
                                            <div class="form-group row">
                                                <label class="form-label col-2 col-form-label">Lease
                                                    Amount</label>

                                                <div class="col">
                                                    <input type="text" class="form-control">
                                                </div>

                                                <label class="form-label col-2 col-form-label">Payment
                                                    Year</label>

                                                <div class="col">
                                                    <select class="form-select">
                                                        <option>-- Select --</option>
                                                    </select>
                                                </div>
                                            </div>


                                            <div class="form-group mb-3 row">
                                                <label class="form-label col-2 col-form-label">Payment
                                                    Date</label>

                                                <div class="col">
                                                    <input type="text" class="form-control datepicker">
                                                </div>
                                                <label class="form-label col-2 col-form-label">Status</label>

                                                <div class="col">
                                                    <div class="col">
                                                        <select class="form-select">
                                                            <option>-- Select --</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="form-group mb-3 row">

                                                <label class="form-label col-2 col-form-label">Attachment</label>

                                                <div class="col">
                                                    <input type="file" class="form-control field"
                                                           name="document"
                                                           id="file" required="true">
                                                </div>
                                            </div>

                                            <div class="form-group mb-3 row">
                                                <label class="form-label col-2 col-form-label">Remarks</label>

                                                <div class="col">
                                                    <textarea type="text" class="form-control"></textarea>
                                                </div>
                                            </div>

                                            <div class="form-group mb-3 row">
                                                <label class="col-lg-2 form-label"></label>

                                                <div class="col-lg-4">
                                                    <button type="submit" class="btn btn-primary">Update Lease Rent
                                                    </button>
                                                </div>
                                            </div>

                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <%-- <div class="row">
                         <div class="col-sm-6 col-lg-12">
                             <div class="card card-sm">
                                 <div class="card-body">
                                     <div class="page-header">

                                         <div class="row align-items-center">
                                             <div class="col-auto">

                                                 <h3 class="text-dark">
                                                     Land Lease Record
                                                 </h3>
                                             </div>
                                             <!-- Page title actions -->
                                             <div class="col-auto ml-auto d-print-none">
                                                 <a href="#"
                                                    class="btn btn-primary btn-pill btn-pill btn-sm ml-3 d-none d-sm-inline-block"
                                                    data-toggle="modal"
                                                    data-target="#modal-report">
                                                     <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-md"
                                                          width="24" height="24" viewBox="0 0 24 24" stroke-width="2"
                                                          stroke="currentColor" fill="none" stroke-linecap="round"
                                                          stroke-linejoin="round">
                                                         <path stroke="none" d="M0 0h24v24H0z"></path>
                                                         <circle cx="12" cy="12" r="9"></circle>
                                                         <line x1="9" y1="12" x2="15" y2="12"></line>
                                                         <line x1="12" y1="9" x2="12" y2="15"></line>
                                                     </svg>
                                                     New Lease Out
                                                 </a>
                                             </div>
                                         </div>
                                     </div>
                                     <table class="table card-table table-vcenter text-nowrap table-bordered"
                                            id="leaseOutGrid">
                                         <thead>
                                         <tr>
                                             <th>SL No.</th>
                                             <th>Tharm No.</th>
                                             <th>Land Segregation</th>
                                             <th>Attachment</th>
                                             <th>Start Date</th>
                                             <th>End Date</th>
                                             <th>Status</th>
                                             <th>Action</th>
                                         </tr>

                                         <tbody>
                                         <tr>
                                             <td>1</td>
                                             <td>T001</td>
                                             <td>Commercial</td>
                                             <td>File Attached</td>
                                             <td>2020-01-01</td>
                                             <td>2020-01-01</td>
                                             <td>Lease out</td>
                                             <td>
                                                 <a href="#" class="btn btn-primary btn-pill btn-pill btn-sm"
                                                    data-toggle="modal"
                                                    data-target="#modal-report">
                                                     <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-md"
                                                          width="24"
                                                          height="24" viewBox="0 0 24 24" stroke-width="2"
                                                          stroke="currentColor"
                                                          fill="none" stroke-linecap="round" stroke-linejoin="round">
                                                         <path stroke="none" d="M0 0h24v24H0z"></path>
                                                         <path d="M4 20h4l10.5 -10.5a1.5 1.5 0 0 0 -4 -4l-10.5 10.5v4"></path>
                                                         <line x1="13.5" y1="6.5" x2="17.5" y2="10.5"></line>
                                                     </svg>
                                                     Edit
                                                 </a>
                                             </td>

                                         </tr>
                                         <tr>
                                             <td>2</td>
                                             <td>T002</td>
                                             <td>Non Commercial</td>
                                             <td>File Attached</td>
                                             <td>2020-01-01</td>
                                             <td>2020-01-01</td>
                                             <td>Lease out</td>
                                             <td>
                                                 <a href="#" class="btn btn-primary btn-pill btn-pill btn-sm"
                                                    data-toggle="modal"
                                                    data-target="#modal-report">
                                                     <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-md"
                                                          width="24"
                                                          height="24" viewBox="0 0 24 24" stroke-width="2"
                                                          stroke="currentColor"
                                                          fill="none" stroke-linecap="round" stroke-linejoin="round">
                                                         <path stroke="none" d="M0 0h24v24H0z"></path>
                                                         <path d="M4 20h4l10.5 -10.5a1.5 1.5 0 0 0 -4 -4l-10.5 10.5v4"></path>
                                                         <line x1="13.5" y1="6.5" x2="17.5" y2="10.5"></line>
                                                     </svg>
                                                     Edit
                                                 </a>
                                             </td>

                                         </tr>
                                         <tr>
                                             <td>3</td>
                                             <td>T003</td>
                                             <td>Non Commercial</td>
                                             <td>File Attached</td>
                                             <td>2020-01-01</td>
                                             <td>2020-01-01</td>
                                             <td>Lease out</td>
                                             <td>
                                                 <a href="#" class="btn btn-primary btn-pill btn-pill btn-sm"
                                                    data-toggle="modal"
                                                    data-target="#modal-report">
                                                     <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-md"
                                                          width="24"
                                                          height="24" viewBox="0 0 24 24" stroke-width="2"
                                                          stroke="currentColor"
                                                          fill="none" stroke-linecap="round" stroke-linejoin="round">
                                                         <path stroke="none" d="M0 0h24v24H0z"></path>
                                                         <path d="M4 20h4l10.5 -10.5a1.5 1.5 0 0 0 -4 -4l-10.5 10.5v4"></path>
                                                         <line x1="13.5" y1="6.5" x2="17.5" y2="10.5"></line>
                                                     </svg>
                                                     Edit
                                                 </a>
                                             </td>
                                         </tr>
                                         <tr>
                                             <td>4</td>
                                             <td>T004</td>
                                             <td>Non Commercial</td>
                                             <td>File Attached</td>
                                             <td>2020-01-01</td>
                                             <td>2020-01-01</td>
                                             <td>Lease out</td>
                                             <td>
                                                 <a href="#" class="btn btn-primary btn-pill btn-pill btn-sm"
                                                    data-toggle="modal"
                                                    data-target="#modal-report">
                                                     <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-md"
                                                          width="24"
                                                          height="24" viewBox="0 0 24 24" stroke-width="2"
                                                          stroke="currentColor"
                                                          fill="none" stroke-linecap="round" stroke-linejoin="round">
                                                         <path stroke="none" d="M0 0h24v24H0z"></path>
                                                         <path d="M4 20h4l10.5 -10.5a1.5 1.5 0 0 0 -4 -4l-10.5 10.5v4"></path>
                                                         <line x1="13.5" y1="6.5" x2="17.5" y2="10.5"></line>
                                                     </svg>
                                                     Edit
                                                 </a>
                                             </td>
                                         </tr>
                                         </tbody>
                                     </table>
                                 </div>
                             </div>
                         </div>
                     </div>--%>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal modal-blur fade" id="modal-report" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-xl" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Lease Detail</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24"
                         viewBox="0 0 24 24"
                         stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round"
                         stroke-linejoin="round">
                        <path stroke="none" d="M0 0h24v24H0z"></path>
                        <line x1="18" y1="6" x2="6" y2="18"></line>
                        <line x1="6" y1="6" x2="18" y2="18"></line>
                    </svg>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group mb-3 row">
                        <label class="form-label col-2 col-form-label">Tharm No.</label>

                        <div class="col">
                            <select class="form-select">
                                <option>-- Select --</option>
                            </select>
                        </div>
                        <label class="form-label col-2 col-form-label">Company</label>

                        <div class="col">
                            <input type="text" class="form-control">
                        </div>
                    </div>


                    <div class="form-group mb-3 row">
                        <label class="form-label col-2 col-form-label">Start Date</label>

                        <div class="col">
                            <input type="text" class="form-control datepicker">
                        </div>
                        <label class="form-label col-2 col-form-label">End Date</label>

                        <div class="col">
                            <div class="col">
                                <input type="text" class="form-control">
                            </div>
                        </div>
                    </div>

                    <div class="form-group mb-3 row">
                        <label class="form-label col-2 col-form-label">Lease Value</label>

                        <div class="col">
                            <input type="text" class="form-control">
                        </div>
                        <label class="form-label col-2 col-form-label">Attachment</label>

                        <div class="col">
                            <input type="file" class="form-control field" name="document"
                                   id="file" required="true">
                        </div>
                    </div>

                    <div class="form-group mb-3 row">
                        <label class="form-label col-2 col-form-label">Area (Acreage)</label>

                        <div class="col">
                            <input type="text" class="form-control datepicker">
                        </div>
                        <label class="form-label col-2 col-form-label">Date of Lease out</label>

                        <div class="col">
                            <div class="col">
                                <input type="text" class="form-control">
                            </div>
                        </div>
                    </div>
                    <div class="form-group mb-3 row">
                        <label class="form-label col-2 col-form-label">Remarks</label>

                        <div class="col">
                            <textarea type="text" class="form-control"></textarea>
                        </div>
                    </div>
                </form>
            </div>

            <div class="modal-footer">
                <a href="#" class="btn btn-link link-secondary" data-dismiss="modal">
                    Cancel
                </a>
                <a href="#" class="btn btn-primary btn-pill btn-pill ml-auto" data-dismiss="modal">
                    <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-md" width="24" height="24"
                         viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round"
                         stroke-linejoin="round">
                        <path stroke="none" d="M0 0h24v24H0z"></path>
                        <path d="M6 4h10l4 4v10a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2"></path>
                        <circle cx="12" cy="14" r="2"></circle>
                        <polyline points="14 4 14 8 8 8 8 4"></polyline>
                    </svg>
                    Lease Out
                </a>
            </div>
        </div>
    </div>
</div>

</body>
</html>

