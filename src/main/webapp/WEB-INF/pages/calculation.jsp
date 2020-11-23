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
    <title>Calculation</title>
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
                                    Calculation
                                </h3>
                            </div>
                            <!-- Page title actions -->

                            <div class="form-group mb-3 row">
                                <label class="col-sm-2 col-form-label text-right required">Sum</label>
                                <div class="col-4">
                                    <input type="number" name="sumTotal"
                                           id="sumTotal" class="form-control field">
                                </div>
                                <label class="col-sm-2 col-form-label text-right required">Difference</label>
                                <div class="col-4">
                                    <input type="number" name="differece"
                                           id="differece" class="form-control field">
                                </div>
                                <label class="col-sm-2 col-form-label text-right required">Multiplication</label>
                                <div class="col-4">
                                    <input type="number" name="product"
                                           id="product" class="form-control field">
                                </div>
                                <label class="col-sm-2 col-form-label text-right required">Division</label>
                                <div class="col-4">
                                    <input type="number" name="div"
                                           id="div" class="form-control field">
                                </div>
                            </div>

                        </div>
                    </div>

                    <div class="modal-body">
                        <div class="card">
                            <div class="card-body">
                                <form id="calculationForm" action="<c:url value='/calculation'/>"
                                      class="form-horizontal globalForm calculationForm">
                                    <div class="form-group mb-3 row">
                                        <label class="col-sm-2 col-form-label text-right required">First number</label>
                                        <div class="col-4">
                                            <input type="text" name="firstNum"
                                                   id="firstNum" class="form-control field"
                                                   required="true">
                                        </div>
                                        <label class="col-sm-2 col-form-label text-right required">Second Number</label>
                                        <div class="col-4">
                                            <input type="text" name="secondNum"
                                                   id="secondNum" class="form-control field"
                                                   required="true">
                                        </div>
                                    </div>
                                  <!--  <div class="form-group mb-3 row">
                                        <label class="col-sm-2 col-form-label text-right required">Second Number</label>
                                        <div class="col-4">
                                            <input type="text" name="secondNum"
                                                   id="secondNum" class="form-control field"
                                                   required="true">
                                        </div>
                                    </div>-->
                                    <div class="container-fluid">
                                        <div class="row">
                                    <div class="form-group row offset-2">
                                        <div class="col-md-1">
                                            <input type="button"
                                                   id="btnAdd" class="btn btn-primary"
                                                   value="Add">
                                        </div>
                                        <div class="col-md-1">
                                            <input type="button"
                                                   id="btnSub" class="btn btn-primary"
                                                   value="Subtraction">
                                        </div>
                                        <div class="col-md-1">
                                            <input type="button"
                                                   id="btnMul" class="btn btn-primary"
                                                   value="Multiply">
                                        </div>
                                        <div class="col-md-1">
                                            <input type="button"
                                                   id="btnDiv" class="btn btn-primary"
                                                   value="Divide">
                                        </div>
                                    </div>
                                        </div>
                                    </div>
                                </form>
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
