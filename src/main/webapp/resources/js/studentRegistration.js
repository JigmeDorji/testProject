/**
 * Created by nzepa on 10/11/2020.
 */

/**
 * Created by jigme.dorji on 24-Apr-2020.
 */
studentRegistration = (function () {
    "use strict";
    var form = $('#studentRegistrationForm');

    function _baseURL() {
        return 'studentRegistration/';
    }

    function save() {
        $('.studentRegistrationForm').validate({
            submitHandler: function (form) {
                var url = _baseURL() + 'save';
                $.ajax({
                    url: url,
                    type: 'POST',
                    data: $(form).serializeArray(),
                    success: function (res) {
                        if (res.status === 1) {
                            $('#studentName').val('');
                            $('#studentId').val('');
                            successMsg(res.text);
                            $('#companyDetailModal').modal('hide');
                            getStudentList();
                        }
                    }
                });
            }
        });
    }

    var sumTotalOfId = 0;

    function calculateTotalOfId() {
        $('#studentTableGrid tbody').find('tr').each(function () {
            var selectedRow = $(this).closest('tr');
            sumTotalOfId += parseInt(selectedRow.find('.studentId').text());
        });
        $('#sumTotal').val(sumTotalOfId);
    }

    /*
    Fetch detail of students
     */
    function getStudentList() {
        $.ajax({
            url: _baseURL() + 'getStudentList',
            type: 'GET',
            success: function (res) {
                var columnDef = [
                    {
                        "mRender": function (data, type, row, meta) {
                            return meta.row + 1;
                        }
                    },
                    {
                        data: 'studentId', class: 'studentId'
                    },
                    {
                        data: 'studentName', class: 'studentName'
                    },
                    {
                        "data": "null",
                        "mRender": function () {
                            return '<a href="#" id="btnDelete" class="btn btn-danger btn-sm ml-3 d-none d-sm-inline-block" >Delete</a><a href="#" id="btnEdit" class="btn btn-primary btn-sm ml-3 d-none d-sm-inline-block" >Edit</a>';
                        }
                    }

                ];
                $('#studentTableGrid').DataTable({
                    data: res
                    , columns: columnDef
                    , destroy: true
                    , bSort: false
                    , "auto-width": true
                });
                calculateTotalOfId();
            }
        });
    }

    function deleteStudentInfo() {
        $('#studentTableGrid tbody').on('click', 'tr #btnDelete', function () {
            var row = $(this).closest('tr');
            var studentId = row.find('.studentId').text();
            swal({
                title: "Are you sure to delete user " + row.find('.studentName').text() + "?",
                text: "You will not be able to recover!",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "Confirm",
                closeOnConfirm: false
            }, function (isConfirm) {
                if (!isConfirm) return;
                $.ajax({
                    url: _baseURL() + 'deleteStudentInfoByStudentId',
                    type: 'POST',
                    data: {studentId: studentId},
                    success: function (res) {
                        if (res.status === 1) {
                            successMsg(res.text);
                            $('#companyDetailModal').modal('hide');
                            getStudentList();
                        } else {
                            errorMsg(res.text);
                        }
                    }
                });
            })
        })
    }

    function editStudentInfo() {
        $('#studentTableGrid tbody').on('click', 'tr #btnEdit', function () {
            var row = $(this).closest('tr');
            var studentId = row.find('.studentId').text();
            var studentName = row.find('.studentName').text();
            $('#studentName').val(studentName);
            $('#studentId').val(studentId);
            $('#companyDetailModal').modal('show');

        })
    }

    function generateReport() {
        $('#generateReportBtn').on('click', function () {
            $.ajax({
                url: _baseURL() + 'generateReport',
                type: 'GET',
                success: function (res) {
                    window.open(ttplGlobal.baseReportLocation() + res.dto.reportName, '_blank');
                }
            });
        })
    }


    return {
        generateReport:generateReport
    }
})();

$(document).ready(function () {
    studentRegistration.generateReport();
});

