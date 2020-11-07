/**
 * Created by nzepa on 10/2/2020.
 */

reviewApplication = (function () {

    "use strict";
    let form = $('#reviewApplicationForm');
    let isSubmitted = false;

    function _baseURL() {
        return 'reviewApplication/';
    }

    function getApplicationList() {
        $.ajax({
            url: _baseURL() + 'getApplicationList',
            type: 'GET',
            success: function (res) {
                let columnDef = [
                    {
                        class: "align-middle", "mRender": function (data, type, row, meta) {
                            return meta.row + 1;
                        }
                    },
                    {
                        data: 'status', class: "align-middle",
                        render: function (data) {
                            let status = null;
                            if (data === 'S') {
                                status = "<input type='hidden' id='status' class='status' value='" + data + "'/>" +
                                    "<i class='status-icon bg-yellow'></i>" + "Pending";
                            }
                            if (data === 'A') {
                                status = "<i class='status-icon bg-blue spinner-grow'></i>" + "R Approved";
                            }
                            if (data === 'D') {
                                status = "<i class='status-icon bg-cyan spinner-grow'></i>" + "D Approve";
                            }
                            if (data === 'C') {
                                status = "<i class='status-icon bg-success'></i>" + "Approved";
                            }
                            if (data === 'R') {
                                status = "<i class='status-icon bg-danger'></i>" + "Rejected";
                            }
                            return status;
                        }
                    },
                    {data: 'applicationNo', class: "applicationNo align-middle"},
                    {
                        data: {
                            companyId: "companyId",
                            companyName: "companyName"
                        },
                        render: function (data) {
                            return '<input type="hidden" id="companyId" class="companyId" value="' + data.companyId + '">' + data.companyName;
                        }
                    },
                    {data: 'subject', class: "align-middle"},
                    {data: 'acreage', class: "align-middle"},
                    {
                        "data": "applicationDate", class: "align-middle",
                        "mRender": function (data) {
                            return formatAsDate(data);
                        }
                    },
                    {
                        "data": "null", class: "align-middle",
                        "mRender": function () {
                            return '<a href="#" id="btnViewApplication" class="btn btn-primary btn-sm ml-3 d-none d-sm-inline-block" data-toggle="modal" data-target="#applicationDetailModal">View</a>';
                        }
                    }
                ];
                $('#applicationListTableId').DataTable({
                    data: res.dto
                    , columns: columnDef
                    , destroy: true
                    , bSort: false
                });
            }
        });
    }

    function btnView() {
        $('#applicationListTableId tbody').on('click', 'tr #btnViewApplication', function () {
            let row = $(this).closest('tr');
            let selectedRow = row.addClass('companyId');
            let applicationNo = selectedRow.find('.applicationNo').text();
            $.ajax({
                url: _baseURL() + 'getApplicationDetail',
                type: 'GET',
                data: {applicationNo: applicationNo},
                success: function (res) {
                    $('.applicationNoText').text(applicationNo);
                    $('.applicationNo').val(applicationNo);
                    populate(res.dto);
                    $('#companyId').attr('disabled', true);
                }
            });

            getSubmittedApplicationDocuments(applicationNo);
            getApplicationComments(applicationNo);
        });
    }

    function getSubmittedApplicationDocuments(applicationNo) {
        $.ajax({
            url: _baseURL() + 'getSubmittedApplicationDocuments',
            type: 'GET',
            data: {applicationNo: applicationNo},
            success: function (res) {
                if (res.status === 1) {
                    let data = res.dto;
                    $('#documentTableId tbody').empty();
                    for (let i = 0; i < data.length; i++) {
                        let documentId = data[i].documentId;
                        let documentUrl = data[i].documentUrl;
                        let documentName = data[i].documentName;
                        let row = '<tr>' +
                            '<td>' + parseInt(i + 1) + '</td>' +
                            '<td><input type="hidden" class="documentId" value="' + documentId + '" /> ' +
                            '<input type="hidden" class="documentUrl" value="' + documentUrl + '" />' + documentName + '</td>' +
                            '<td><button class="btn btn-sm btn-success btnDownload" type="button" id="btnDownload"><i class="fa fa-download">Download</i></button></td>' +
                            '</tr>';
                        $('#documentTableId').append(row);
                    }
                }
            }
        });
    }

    function getApplicationComments(applicationNo) {
        $('#commentList').empty();
        $('.expandComments').removeClass('hidden');
        $('.contract').addClass('hidden');
        $('.commentCard').addClass('hidden');
        $.ajax({
            url: _baseURL() + 'getApplicationComments',
            type: 'GET',
            data: {applicationNo: applicationNo},
            success: function (res) {
                if (res.status === 1) {
                    let data = res.dto;
                    $('#commentCount').text(data.length);
                    let li = '';
                    for (let i = 0; i < data.length; i++) {
                        let comments = data[i].comments;
                        let createdBy = data[i].createdBy;
                        let commentedBy = data[i].commentedBy;
                        if (createdBy === $('#currentUserId').val()) {
                            commentedBy = 'You '
                        }
                        let commentedByShortForm = data[i].commentedByShortForm;
                        let commentedDate = data[i].commentedDate;
                        li = '<li>' +
                            '<div class="list-timeline-icon bg-twitter">' + commentedByShortForm + '</div>' +
                            '<div class="list-timeline-content">' +
                            '<p class="list-timeline-title">' + comments + '</p>' +
                            '<p class="text-muted">' +
                            '<span class="text-muted commentedBy">' + commentedBy + ' commented on ' + '</span>' +
                            '<span class="text-muted commentedDate">' + ' ' + commentedDate + '</span>' +
                            '</p>' +
                            '</div>' +
                            '</li>';
                        $('#commentList').append(li);
                    }
                }
            }
        });
    }

    function downloadSubmittedDocument() {
        $('#documentTableId tbody').on('click', 'tr #btnDownload', function () {
            let row = $(this).closest('tr');
            let selectedRow = row.addClass('selected');
            let documentId = selectedRow.find('.documentId').val();
            let url = _baseURL() + 'downloadSubmittedDocument/' + documentId;
            $.ajax({
                url: url,
                type: 'GET',
                data: {documentId: documentId},
                success: function () {
                    window.location.href = url;
                }
            });
        });
    }

    function btnApprove() {
        $('#btnApprove').on('click', function () {
            let applicationNo = $('#applicationNo').val();
            let comments = $('#comments').val();
            $('#btnApprove').attr('disabled', true);
            let url = _baseURL() + 'approveApplication';
            $.ajax({
                url: url,
                type: 'POST',
                data: {applicationNo: applicationNo, comments: comments},
                success: function (res) {
                    if (res.status === 1) {
                        successMsg(res.text);
                        $('#applicationDetailModal').modal('hide');
                        $('#btnApprove').attr("disabled", false);
                    } else {
                        $('#btnApprove').attr("disabled", false);
                        warningMsg(res.text);
                    }
                }, complete: function (res) {
                    $('#btnApprove').attr("disabled", false);
                    warningMsg(res.text);
                }
            });
        });
    }

    function validateComments(comments) {
        let returnValue = true;
        let commentId = $('#comments');
        if (comments === '' || comments == null) {
            commentId.attr('required', true);
            commentId.addClass('is-invalid');
            returnValue = false;
        }
        return returnValue;
    }

    function onChangeComments() {
        $('#comments').on('keyup', function () {
            let commentId = $('#comments');
            if ($(this).val() !== '') {
                commentId.attr('required', false);
                commentId.removeClass('is-invalid');
            }
        });
    }

    function btnReject() {
        $('#btnReject').on('click', function () {
            let applicationNo = $('#applicationNo').val();
            let comments = $('#comments').val();
            if (validateComments(comments)) {
                $('#btnReject').attr('disabled', true);
                let url = _baseURL() + 'rejectApplication';
                $.ajax({
                    url: url,
                    type: 'POST',
                    data: {applicationNo: applicationNo, comments: comments},
                    success: function (res) {
                        if (res.status === 1) {
                            successMsg(res.text);
                            $('#applicationDetailModal').modal('hide');
                            $('#btnReject').attr("disabled", false);
                        } else {
                            $('#btnReject').attr("disabled", false);
                            warningMsg(res.text);
                        }
                    }, complete: function (res) {
                        $('#btnReject').attr("disabled", false);
                        warningMsg(res.text);
                    }
                });
            }
        });
    }

    function toggleCommentCard() {
        $('.expandComments').on('click', function () {
            $('.commentCard').show(500);
            $('.contract').removeClass('hidden');
            $('.expandComments').addClass('hidden');
        });
        $('.contract').on('click', function () {
            $('.commentCard').hide(500);
            $('.expandComments').removeClass('hidden');
            $('.contract').addClass('hidden');
        });
    }

    return {
        getApplicationList: getApplicationList,
        btnView: btnView,
        downloadSubmittedDocument: downloadSubmittedDocument,
        toggleCommentCard: toggleCommentCard,
        btnApprove: btnApprove,
        btnReject: btnReject,
        onChangeComments: onChangeComments
    }
})();

$(document).ready(function () {
    reviewApplication.getApplicationList();
    reviewApplication.btnView();
    reviewApplication.downloadSubmittedDocument();
    reviewApplication.toggleCommentCard();
    reviewApplication.btnApprove();
    reviewApplication.btnReject();
    reviewApplication.onChangeComments();
});