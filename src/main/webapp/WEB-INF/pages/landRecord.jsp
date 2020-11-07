<%--
  Created by IntelliJ IDEA.
  User: nzepa
  Date: 10/2/2020
  Time: 3:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title></title>
</head>
<body class="antialiased">
<div class="page">
    <div class="content">
        <div class="container-xl">
            <div class="page-header">

                <div class="row align-items-center">
                    <div class="col-auto">

                        <h2 class="page-title">
                            Land Registration List
                        </h2>
                    </div>
                    <!-- Page title actions -->
                    <div class="col-auto ml-auto d-print-none">
                        <a href="#" class="btn btn-primary btn-pill btn-pill btn-sm ml-3 d-none d-sm-inline-block"
                           data-toggle="modal"
                           data-target="#modal-report">
                            <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-md" width="24" height="24"
                                 viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none"
                                 stroke-linecap="round" stroke-linejoin="round">
                                <path stroke="none" d="M0 0h24v24H0z"></path>
                                <circle cx="12" cy="12" r="9"></circle>
                                <line x1="9" y1="12" x2="15" y2="12"></line>
                                <line x1="12" y1="9" x2="12" y2="15"></line>
                            </svg>
                            Add New Land
                        </a>
                        <a href="#" class="btn btn-primary btn-pill ml-3 d-sm-none btn-icon" data-toggle="modal"
                           data-target="#modal-report" aria-label="Create new report">
                            <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-md" width="24" height="24"
                                 viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none"
                                 stroke-linecap="round" stroke-linejoin="round">
                                <path stroke="none" d="M0 0h24v24H0z"></path>
                                <path d="M6 4h10l4 4v10a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2"></path>
                                <circle cx="12" cy="14" r="2"></circle>
                                <polyline points="14 4 14 8 8 8 8 4"></polyline>
                            </svg>
                        </a>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <div class="table-responsive">
                            <table class="table table-vcenter card-table table-striped"
                                   id="operatorsTaskListTableId">
                                <thead>
                                <tr>
                                    <th>Dzongkhag</th>
                                    <th>Thromde</th>
                                    <th>Geowg</th>
                                    <th>Village</th>
                                    <th>Land Type</th>
                                    <th>Selection Type</th>
                                    <th>Land Segregation</th>
                                    <th>Tharm No</th>
                                    <th>Action</th>
                                </tr>
                                <tbody>
                                <tr>
                                    <td>Thimphu</td>
                                    <td>Thim Throm</td>
                                    <td>Kawang</td>
                                    <td>Babesa</td>
                                    <td>Institutional</td>
                                    <td>Urban</td>
                                    <td>Commercial</td>
                                    <td>123</td>
                                    <td>
                                        <a href="#" class="btn btn-primary btn-pill btn-pill btn-sm"
                                           data-toggle="modal"
                                           data-target="#modal-report">
                                            <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-md" width="24"
                                                 height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor"
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
                                    <td>Thimphu</td>
                                    <td>Thim Throm</td>
                                    <td>Kawang</td>
                                    <td>Babesa</td>
                                    <td>Institutional</td>
                                    <td>Urban</td>
                                    <td>Commercial</td>
                                    <td>123</td>
                                    <td>
                                        <a href="#" class="btn btn-primary btn-pill btn-pill btn-sm"
                                           data-toggle="modal"
                                           data-target="#modal-report">
                                            <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-md" width="24"
                                                 height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor"
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
                                    <td>Thimphu</td>
                                    <td>Thim Throm</td>
                                    <td>Kawang</td>
                                    <td>Babesa</td>
                                    <td>Institutional</td>
                                    <td>Urban</td>
                                    <td>Commercial</td>
                                    <td>123</td>
                                    <td>
                                        <a href="#" class="btn btn-primary btn-pill btn-pill btn-sm"
                                           data-toggle="modal"
                                           data-target="#modal-report">
                                            <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-md" width="24"
                                                 height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor"
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
                                    <td>Thimphu</td>
                                    <td>Thim Throm</td>
                                    <td>Kawang</td>
                                    <td>Babesa</td>
                                    <td>Institutional</td>
                                    <td>Urban</td>
                                    <td>Commercial</td>
                                    <td>123</td>
                                    <td>
                                        <a href="#" class="btn btn-primary btn-pill btn-pill btn-sm"
                                           data-toggle="modal"
                                           data-target="#modal-report">
                                            <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-md" width="24"
                                                 height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor"
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
                                    <td>Thimphu</td>
                                    <td>Thim Throm</td>
                                    <td>Kawang</td>
                                    <td>Babesa</td>
                                    <td>Institutional</td>
                                    <td>Urban</td>
                                    <td>Commercial</td>
                                    <td>123</td>
                                    <td>
                                        <a href="#" class="btn btn-primary btn-pill btn-pill btn-sm"
                                           data-toggle="modal"
                                           data-target="#modal-report">
                                            <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-md" width="24"
                                                 height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor"
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
            </div>
        </div>
    </div>
</div>
<div class="modal modal-blur fade" id="modal-report" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-xl" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Land Detail</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24"
                         viewBox="0 0 24 24"
                         stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round"
                         stroke-linejoin="round">
                        <path stroke="none" d="M0 0h24v24H0z"/>
                        <line x1="18" y1="6" x2="6" y2="18"/>
                        <line x1="6" y1="6" x2="18" y2="18"/>
                    </svg>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group mb-3 row">
                        <label class="form-label col-2 col-form-label">Dzongkhag</label>

                        <div class="col">
                            <select class="form-select">
                                <option>-- Select --</option>
                            </select>
                        </div>
                        <label class="form-label col-2 col-form-label">Thromde</label>

                        <div class="col">
                            <select class="form-select">
                                <option>-- Select --</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group mb-3 row">
                        <label class="form-label col-2 col-form-label">Geowg</label>

                        <div class="col">
                            <select class="form-select">
                                <option>-- Select --</option>
                            </select>
                        </div>
                        <label class="form-label col-2 col-form-label">Village</label>

                        <div class="col">
                            <select class="form-select">
                                <option>-- Select --</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group mb-3 row">
                        <label class="form-label col-2 col-form-label">Land Type</label>

                        <div class="col">
                            <select class="form-select form-control">
                                <option>-- Select --</option>
                                <option>Institutional</option>
                                <option>Corporation</option>
                                <option>Government</option>
                                <option>Drakthsang</option>
                            </select>
                        </div>
                        <label class="form-label col-2 col-form-label">Selection Type</label>

                        <div class="col">
                            <div class="col">
                                <select class="form-select">
                                    <option>-- Select --</option>
                                    <option>Thromde</option>
                                    <option>Rural</option>
                                    <option>Urban</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-group mb-3 row">
                        <label class="form-label col-2 col-form-label">Thram No.</label>

                        <div class="col-4">
                            <input type="text" class="form-control">
                        </div>
                        <label class="form-label col-2 col-form-label">Land Segregation</label>

                        <div class="col-4">
                            <select class="form-select">
                                <option>-- Select --</option>
                                <option>Commercial</option>
                                <option>No Commercial</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group mb-3 row">
                        <label class="form-label col-2 col-form-label">Attachment</label>

                        <div class="col-4">
                            <input type="file" class="form-control">
                        </div>
                    </div>

                    <div class="modal-header">
                        <h5 class="modal-title">Plot Detail</h5>
                    </div>
                    <table class="table card-table table-vcenter text-nowrap table-bordered"
                           id="plotDetail">
                        <thead>
                        <tr>
                            <th>Urban/Rural Village</th>
                            <th>Location</th>
                            <th>Category</th>
                            <th>Book Value</th>
                            <th>Precinct</th>
                            <th>Plot No</th>
                            <th>Net Area(Sq.ft)</th>
                            <th>Remarks</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Jampelling</td>
                            <td>LAP 1</td>
                            <td>Chuzhing</td>
                            <td>1000</td>
                            <td>Urban Village Periphery</td>
                            <td>GT-1393</td>
                            <td>15454</td>
                            <td></td>
                            <td>
                                <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-md" width="24" height="24"
                                     viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none"
                                     stroke-linecap="round" stroke-linejoin="round" >
                                    <path stroke="none" d="M0 0h24v24H0z"></path>
                                    <line x1="4" y1="7" x2="20" y2="7"></line>
                                    <line x1="10" y1="11" x2="10" y2="17"></line>
                                    <line x1="14" y1="11" x2="14" y2="17"></line>
                                    <path d="M5 7l1 12a2 2 0 0 0 2 2h8a2 2 0 0 0 2 -2l1 -12"></path>
                                    <path d="M9 7v-3a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v3"></path>
                                </svg>

                            </td>
                        </tr>
                        <tr>
                            <td>Jampelling</td>
                            <td>LAP 1</td>
                            <td>Kamzhing</td>
                            <td>1000</td>
                            <td>Urban Village Periphery</td>
                            <td>GT-1393</td>
                            <td>15454</td>
                            <td></td>
                            <td>
                                <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-md" width="24" height="24"
                                     viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none"
                                     stroke-linecap="round" stroke-linejoin="round">
                                    <path stroke="none" d="M0 0h24v24H0z"></path>
                                    <line x1="4" y1="7" x2="20" y2="7"></line>
                                    <line x1="10" y1="11" x2="10" y2="17"></line>
                                    <line x1="14" y1="11" x2="14" y2="17"></line>
                                    <path d="M5 7l1 12a2 2 0 0 0 2 2h8a2 2 0 0 0 2 -2l1 -12"></path>
                                    <path d="M9 7v-3a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v3"></path>
                                </svg>

                            </td>
                        </tr>
                        <tr>
                            <td>Jampelling</td>
                            <td>LAP 1</td>
                            <td>Kamzhing</td>
                            <td>1000</td>
                            <td>Urban Village Periphery</td>
                            <td>GT-1393</td>
                            <td>15454</td>
                            <td></td>
                            <td>
                                <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-md" width="24" height="24"
                                     viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none"
                                     stroke-linecap="round" stroke-linejoin="round">
                                    <path stroke="none" d="M0 0h24v24H0z"></path>
                                    <line x1="4" y1="7" x2="20" y2="7"></line>
                                    <line x1="10" y1="11" x2="10" y2="17"></line>
                                    <line x1="14" y1="11" x2="14" y2="17"></line>
                                    <path d="M5 7l1 12a2 2 0 0 0 2 2h8a2 2 0 0 0 2 -2l1 -12"></path>
                                    <path d="M9 7v-3a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v3"></path>
                                </svg>

                            </td>
                        </tr>
                        <tr>
                            <td><input type="text" class="form-control form-control-sm"></td>
                            <td><input type="text" class="form-control form-control-sm"></td>
                            <td><select type="text" class="form-control form-control-sm">
                                <option>-- select--</option>
                            </select></td>
                            <td><input type="text" class="form-control form-control-sm"></td>
                            <td><input type="text" class="form-control form-control-sm"></td>
                            <td><input type="text" class="form-control form-control-sm"></td>
                            <td><input type="text" class="form-control form-control-sm"></td>
                            <td><input type="text" class="form-control form-control-sm"></td>
                            <td>
                                <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-md" width="24" height="24"
                                     viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none"
                                     stroke-linecap="round" stroke-linejoin="round">
                                    <path stroke="none" d="M0 0h24v24H0z"></path>
                                    <line x1="4" y1="7" x2="20" y2="7"></line>
                                    <line x1="10" y1="11" x2="10" y2="17"></line>
                                    <line x1="14" y1="11" x2="14" y2="17"></line>
                                    <path d="M5 7l1 12a2 2 0 0 0 2 2h8a2 2 0 0 0 2 -2l1 -12"></path>
                                    <path d="M9 7v-3a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v3"></path>
                                </svg>

                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>
                                <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-md" width="24" height="24"
                                     viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none"
                                     stroke-linecap="round" stroke-linejoin="round">
                                    <path stroke="none" d="M0 0h24v24H0z"></path>
                                    <circle cx="12" cy="12" r="9"></circle>
                                    <line x1="9" y1="12" x2="15" y2="12"></line>
                                    <line x1="12" y1="9" x2="12" y2="15"></line>
                                </svg>

                            </td>
                        </tr>
                        </tbody>
                    </table>
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
                    Save
                </a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
