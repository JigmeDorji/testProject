/**
 * Created by jigme.dorji on 24-Apr-2020.
 */
user = (function () {
    "use strict";
    var form = $('#userFormId');
    var isSubmitted = false;

    function _baseURL() {
        return 'user/';
    }

    function btnView() {
        $('#userListTableId tbody').on('click', 'tr #btnView', function () {
            var row = $(this).closest('tr');
            var selectedRow = row.addClass('selected');
            var userId = selectedRow.find('.userId').text();
            $.ajax({
                url: _baseURL() + 'getUserDetail',
                type: 'GET',
                data: {userId: userId},
                success: function (res) {
                    populate(res);
                    $('.viewUser').removeClass('hidden');
                    $('.newUser').addClass('hidden');
                    $('#btnSave').val('Update');
                    $('#createdDate').val(formatAsDate(res.createdDate));
                    $('#userId').prop('disabled', true);
                    $('#createdDate').attr('readonly', true);
                    $('.field').removeClass('is-invalid');
                    $('#userFullName').focus();
                    selectedRow.removeClass('selected');
                    getUserLog(userId);
                }
            });
        });
    }

    function getUserLog(userId) {
        $.ajax({
            url: _baseURL() + 'getUserLog',
            type: 'GET',
            data: {userId: userId},
            success: function (res) {
                var data = res.dto;
                $('#userLog').empty();
                $('#logCount').text(data.length);
                if (data.length > 0) {
                    $('.log-card').show();
                } else {
                    $('.log-card').hide();
                }
                for (var i = 0; i < data.length; i++) {
                    var createdByFullName = data[i].createdByFullName;
                    var updatedByFullName = data[i].updatedByFullName;
                    var createdTime = data[i].createdTime;
                    var updatedTime = data[i].updatedTime;
                    var cmdFlag = data[i].cmdFlag;
                    var userAuditId = data[i].userAuditId;
                    var li = '';
                    if (cmdFlag == 'C') {
                        li = '<li class="user-li">' +
                        '<div class="list-timeline-icon bg-teal">' +
                        '<svg xmlns="http://www.w3.org/2000/svg" class="icon icon-md" width="24" height="24" viewBox="0 ' +
                        '0 24 24" stroke-width="2"' +
                        'stroke="currentColor" fill="none" stroke-linecap="round"' +
                        'stroke-linejoin="round">' +
                        '<path stroke="none" d="M0 0h24v24H0z"></path>' +
                        '<circle cx="8.5" cy="7" r="4"></circle>' +
                        '<path d="M2 21v-2a4 4 0 0 1 4 -4h5a4 4 0 0 1 4 4v2"></path>' +
                        '<line x1="16" y1="11" x2="22" y2="11"></line>' +
                        '<line x1="19" y1="8" x2="19" y2="14"></line>' +
                        '</svg>' +
                        '</div>' +
                        '<div class="list-timeline-content">' +
                        '<div class="list-timeline-time">' + createdTime + '</div>' +
                        '<p class="list-timeline-title cursor-pointer"><input type="hidden" class="userAuditId" value="' + userAuditId + '">Created</p>' +
                        '<p class="text-muted"> by ' + createdByFullName + '</p>' +
                        '</div>' +
                        '</li>';
                    } else {
                        li = '<li class="user-li">' +
                        '<div class="list-timeline-icon bg-twitter">' +
                        '<svg xmlns="http://www.w3.org/2000/svg" class="icon icon-md" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z"></path><circle cx="8.5" cy="7" r="4"></circle><path d="M2 21v-2a4 4 0 0 1 4 -4h5a4 4 0 0 1 4 4v2"></path><path d="M16 11l2 2l4 -4"></path></svg>' +
                        '</div>' +
                        '<div class="list-timeline-content">' +
                        '<div class="list-timeline-time">' + updatedTime + '</div>' +
                        '<p class="list-timeline-title cursor-pointer" title="Click to view changes"><input type="hidden" class="userAuditId" value="' + userAuditId + '">Updated</p>' +
                        '<p class="text-muted"> by ' + updatedByFullName + '</p>' +
                        '</div>' +
                        '</li>';
                    }
                    $('#userLog').append(li);
                }
            }
        });
    }

    function getUserLogDetail() {
        $('.logCard ul').on('click', 'li .list-timeline-title', function () {
            var userAuditId = $(this).closest('#userLog .user-li').find('.userAuditId').val();
            $.ajax({
                url: _baseURL() + 'getUserLogDetail',
                type: 'GET',
                data: {userAuditId: userAuditId},
                success: function (res) {
                    if (res.status == 1) {
                        $('#userId').val(res.dto.userId);
                        $('#userFullName').val(res.dto.userFullName);
                        $('#userMobileNo').val(res.dto.userMobileNo);
                        $('#userRoleTypeId').val(res.dto.userRoleTypeId);
                        $('#userStatus').val(res.dto.userStatus);
                        $('#companyId').val(res.dto.companyId);
                        $('#createdDate').val(formatAsDate(res.dto.createdDate));
                        $('#emailId').val(res.dto.emailId);
                    }
                }
            });
        });
    }

    /**
     * to add new user
     */
    function addUser() {
        $('#btnSave').on('click', function () {
            $.validator.setDefaults({
                submitHandler: function (form) {
                    isSubmitted = true;
                    $('#userId').prop('disabled', false);
                    $('#btnSave').attr('disabled', true);
                    var data = new FormData($('.userFormId')[0]);
                    $.ajax({
                        url: _baseURL() + 'addUser',
                        type: 'POST',
                        data: data,
                        processData: false,
                        contentType: false,
                        success: function (res) {
                            if (res.status == 1) {
                                successMsg(res.text);
                                $('#userDetailModal').modal('hide');
                                $('#userId').val('');
                                $('#userFullName').val('');
                                $('#userPassword').val('');
                                $('#txtConfirmPassword').val('');
                                $('#btnSave').attr("disabled", false);
                                getUserList();
                            } else {
                                $('#btnSave').attr("disabled", false);
                                warningMsg(res.text);
                            }
                        }, complete: function (res) {

                            $('#btnSave').attr("disabled", false);
                            warningMsg(res.text);
                        }
                    });
                }
            });
            form.validate({
                errorElement: 'span',
                errorPlacement: function (error, element) {
                    error.addClass('invalid-feedback');
                    element.closest('.col-4').append(error);
                },
                highlight: function (element, errorClass, validClass) {
                    $(element).addClass('is-invalid');
                },
                unhighlight: function (element, errorClass, validClass) {
                    $(element).removeClass('is-invalid');
                }
            });
        });
    }


    //to validate that similar login id doesnt exists
    function checkIfExist() {
        $('#userId').on('blur', function () {
            var userId = $('#userId').val();
            if (userId == "") {
            } else {
                $.ajax({
                    url: _baseURL() + 'isLoginIdAlreadyExists',
                    type: 'GET',
                    data: {
                        loginValue: userId
                    },
                    success: function (res) {
                        if (res.status == 0) {
                            warningMsg(res.text);
                            $('#userId').val('');
                        } else {

                        }
                    }
                });
            }
        });
    }

    function getUserList() {
        var statusActive = $('#statusActive').val();
        var statusInactive = $('#statusInactive').val();
        $.ajax({
            url: _baseURL() + 'getUserList',
            type: 'GET',
            success: function (res) {
                var columnDef = [
                    {
                        "mRender": function (data, type, row, meta) {
                            return meta.row + 1;
                        }
                    },
                    {
                        data: 'userStatus',
                        render: function (data) {
                            var status = null;
                            if (data === statusActive) {
                                status = "<i class='status-icon bg-success spinner-grow'></i>" + "Active";
                            }
                            if (data === statusInactive) {
                                status = "<i class='status-icon bg-danger'></i>" + "Inactive";
                            }
                            return status;
                        }
                    },
                    {data: 'userId', class: "userId align-middle"},
                    {data: 'userFullName'},
                    {data: 'companyName'},
                    {data: 'userMobileNo'},
                    {
                        data: 'createdDate',
                        render: function (data) {
                            return formatAsDate(data)
                        }
                    },
                    {data: 'userRoleTypeName'},
                    {
                        "data": "null",
                        "mRender": function () {
                            return '<a href="#" id="btnView" class="btn btn-primary btn-sm ml-3 d-none d-sm-inline-block" data-toggle="modal" data-target="#userDetailModal">View</a>';
                        }
                    }
                ];
                $('#userListTableId').DataTable({
                    data: res
                    , columns: columnDef
                    , destroy: true
                    , bSort: false
                    , "auto-width": true
                });
            }
        });
    }

    //To validate that the password entered is same
    function checkPasswordMatching() {
        $('#txtConfirmPassword').on('change', function () {
            var password = $('#userPassword').val();
            var confirmPassword = $('#txtConfirmPassword').val();
            if (password != confirmPassword) {
                swal({
                    title: "Your password doesn't match, Please type again",
                    text: "Click OK to exit",
                    type: "warning"
                });
                $('#txtConfirmPassword').val('');
            }
        });
    }

    function btnDelete() {
        $('#btnDelete').on('click', function () {
            var userId = $('#userId').val();
            swal({
                title: "Are you sure to delete user " + userId + "?",
                text: "You will not be able to recover!",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "Confirm",
                closeOnConfirm: false
            }, function (isConfirm) {
                if (!isConfirm) return;
                $.ajax({
                    url: _baseURL() + 'deleteUser',
                    type: 'GET',
                    data: {userId: userId},
                    success: function (res) {
                        if (res.status == 1) {
                            successMsg(res.text);
                        }
                    },
                    error: function (xhr, ajaxOptions, thrownError) {
                        swal("Error deleting!", "Please try again", "error");
                    }
                });
            });
        })
    }

    function btnAddUser() {
        $('#btnAddUser').on('click', function () {
            $('#btnSave').val('Add');
            $('.newUser').removeClass('hidden');
            $('.viewUser').addClass('hidden');
            $('.log-card').hide();
            $('#userId').prop('disabled', false);
            $('.field').val('').removeClass('is-invalid');
        });
    }

    function isEmailValid() {
        $('#email').on('blur', function () {
            if ($(this).val() != '') {
                if (!isEmail($(this).val())) {
                    $(this).val('');
                    errorMsg("Invalid email Id. please check");
                }
            }
        });
    }

    function toggleLogCard() {
        $('.expand').on('click', function () {
            $('.logCard').show(500);
            $('.contract').removeClass('hidden');
            $('.expand').addClass('hidden');
        });
        $('.contract').on('click', function () {
            $('.logCard').hide(500);
            $('.expand').removeClass('hidden');
            $('.contract').addClass('hidden');
        });
    }

    return {
        btnAddUser: btnAddUser,
        addUser: addUser,
        checkIfExist: checkIfExist,
        getUserList: getUserList,
        btnView: btnView,
        btnDelete: btnDelete,
        isEmailValid: isEmailValid,
        checkPasswordMatching: checkPasswordMatching,
        toggleLogCard: toggleLogCard,
        getUserLogDetail: getUserLogDetail
    }
})();

$(document).ready(function () {
    user.btnAddUser();
    user.addUser();
    user.checkIfExist();
    user.getUserList();
    user.btnView();
    user.btnDelete();
    user.isEmailValid();
    user.checkPasswordMatching();
    user.toggleLogCard();
    user.getUserLogDetail();
});