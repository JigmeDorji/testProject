<%--
  Created by IntelliJ IDEA.
  User: Yangkhor
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Item - Group</title>
</head>
<body>
<div class="page">
    <div class="content">
        <div class="container-xl">
            <div class="card card-sm">
                <div class="card-body">
                    <div class="page-header">
                        <div class="row align-items-center">
                            <div class="col-auto">

                                <h3 class="text-dark">
                                    Item Groups
                                </h3>
                            </div>
                            <!-- Page title actions -->

                        </div>
                    </div>
                    <div class="card">
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table card-table text-nowrap table-bordered col-md-12"
                                       id="itemGroupGrid">
                                    <thead>
                                    <tr>
                                        <th class="text-muted">Sl No</th>
                                        <th class="text-muted">Item Group</th>
                                        <th class="text-muted">Item Group Description</th>
                                        <th class="text-muted">Is Mandatory</th>
                                        <th class="text-muted">Action</th>
                                    </tr>
                                    <tbody>
                                    </tbody>
                                </table>
                                <div class="col-auto ml-auto d-print-none">
                                    <a href="#" data-toggle="modal" data-target="#itemGroupModal"
                                       class="btn btn-primary btn-sm ml-3 d-none d-sm-inline-block"
                                       id="btnAddNew">
                                        New Item Group
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="modal modal-blur fade" id="itemGroupModal" tabindex="-1"
                         role="dialog" aria-hidden="true" data-backdrop="static" data-keyboard="false">
                        <div class="modal-dialog modal-xl" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title newCompany">
                                        Item Group Detail
                                    </h5>
                                    <h5 class="modal-title viewCompany hidden">
                                        Item Group
                                    </h5>

                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-label="Close">
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <div class="card">
                                        <div class="card-body">
                                            <form id="itemGroupForm" action="<c:url value='/itemGroup/'/>"
                                                  class="form-horizontal globalForm itemGroupForm">
                                                <div class="form-group mb-3 row">
                                                    <label class="col-sm-2 col-form-label text-right">Item Group Name</label>
                                                    <div class="col-4">
                                                        <input type="text" name="item_group_name"
                                                               id="item_group_name" class="form-control field"
                                                               required="true">
                                                    </div>
                                                </div>

                                                <div class="form-group mb-3 row">
                                                    <label class="col-sm-2 col-form-label text-right required">Item Group Description
                                                    </label>

                                                    <div class="col-4">
                                                        <input type="text" name="item_group_description"
                                                               id="item_group_description" class="form-control field"
                                                               required="true">
                                                    </div>
                                                </div>

                                                <div class="form-group mb-3 row">
                                                    <div class="col-6">
                                                        <label class=" col-form-label text-right required">Mandatory</label>
                                                        <input type="radio" name="mandatory_item_group" id="yes"  value="yes"> <label>Yes</label>
                                                        <input type="radio" name="mandatory_item_group" id="no"  value="no"><label>No</label>
                                                    </div>
                                                </div>

                                                <div class="form-group row offset-2">
                                                    <div class="col-4">
                                                        <input type="submit"
                                                               id="btnSave" class="btn btn-primary"
                                                               value="Save">

                                                    </div>
                                                    <div class="col-4">
                                                        <input type="button"
                                                               id="btnCancel" class="btn btn-primary"
                                                               value="Cancel">
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
