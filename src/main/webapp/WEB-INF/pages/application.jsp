<%--
  Created by IntelliJ IDEA.
  User: nzepa
  Date: 10/2/2020
  Time: 3:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>New Application</title>
</head>
<body>
<%--<script src="<c:url value="/resources/js/application.js"/>"></script>--%>
<div class="page">
    <div class="content">
        <div class="container-xl">
            <div class="page-header">
                <div class="row align-items-center">
                    <div class="col-auto">

                        <h2 class="page-title">
                            New Application
                        </h2>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-body">
                    <div class="card-body">
                        <form id="applicationFormId" action="<c:url value='/application'/>"
                              class="form-horizontal globalForm applicationFormId" enctype="multipart/form-data">

                            <div class="form-group mb-3 row">
                                <label class="col-sm-2 col-form-label text-right required">Subject</label>

                                <div class="col-4">
                                    <input type="text" class="form-control field" name="subject" id="subject"
                                           required="true">
                                </div>
                            </div>
                            <div class="form-group mb-3 row">
                                <label class="col-sm-2 col-form-label text-right required">Description</label>

                                <div class="col-4">
                                    <textarea class="form-control field" name="description" id="description"></textarea>
                                </div>
                            </div>
                            <div class="form-group mb-3 row">
                                <label class="col-sm-2 col-form-label text-right required">Area</label>

                                <div class="col-4">
                                    <input type="text" class="form-control field" name="acreage" id="acreage"
                                           required="true">
                                </div>
                            </div>
                            <div class="form-group mb-3 row">
                                <label class="col-sm-2 col-form-label text-right required">Amount(Nu.)</label>

                                <div class="col-4">
                                    <input type="text" class="form-control field" name="amount" id="amount"
                                           required="true">
                                </div>
                            </div>
                            <div class="form-group mb-3 row">
                                <label class="col-sm-2 col-form-label text-right required">Document</label>

                                <div class="col-4">
                                    <input type="file" class="form-control field" name="attachedFile" id="file" multiple
                                           accept='image/jpeg,image/png,.doc,.docx,.pdf,.xlsx,.xls' required="true">
                                </div>
                            </div>

                            <%--<div class="form-group mb-3 row">--%>
                            <%--<label class="col-sm-2 form-label">Application Date</label>--%>

                            <%--<div class="col-4">--%>
                            <%--<input type="text" class="form-control field" disabled value="${currentDate}">--%>
                            <%--</div>--%>
                            <%--</div>--%>

                            <div class="form-group mb-3 row">
                                <div class="col-2"></div>
                                <%--<sec:authorize access="hasAuthority('1-ADD')">--%>
                                <div class="col-2">
                                    <input type="submit" class="btn btn-primary col-12"
                                           value="Submit Now" id="btnSubmit">
                                </div>
                                <%--</sec:authorize>--%>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
