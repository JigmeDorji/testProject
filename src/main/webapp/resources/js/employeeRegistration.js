/**
 * Created by nzepa on 10/11/2020.
 */

employeeRegistration = (function () {
    "use strict";
    var form = $('#employeeRegistrationForm');

    function _baseURL() {
        return 'employeeRegistration/';
    }

    function save() {
        $('.employeeRegistrationForm').validate({
            submitHandler: function (form) {
                //handleCheckboxBeforeSave(form);
                var url = _baseURL() + 'save';
                $.ajax({
                    url: url,
                    type: 'POST',
                    data: $(form).serializeArray(),
                    success: function (res) {
                        if (res.status == 1) {

                            $("#employeeId").val('');
                            $("#employeeName").val('');
                            $("#employeeDesignation").val('');
                            $("#employeeDepartment").val('');
                            $("#employeeContactNumber").val('');
                            $("#employeeDateOfBirth").val('');

                            successMsg(res.text);
                            $('#employeeModal').modal('hide');
                            $('#btnSave').attr("disabled", false);

                            $("#btnSave").val("Save");

                            getEmployeeList();
                        }
                    }
                });
            }
        });
    }

    function getEmployeeList() {
        $.ajax({
            url: _baseURL() + 'getEmployeeList',
            type: 'GET',
            success: function (res) {
                var columnDef = [
                    {data: 'id', class: "employeeId align-middle"},
                    {data: 'employeeName', class: "employeeName align-middle"},
                    {data: 'employeeDesignation', class: "employeeDesignation align-middle"},
                    {data: 'employeeDepartment', class: "employeeDepartment align-middle"},
                    {data: 'employeeContactNumber', class: "employeeContactNumber align-middle"},
                    {
                        data: 'employeeDateOfBirth', class: "employeeDateOfBirth align-middle",
                        render: function (data) {
                            return formatAsDate(data)
                        }
                    },
                    {data: 'employeeDzongkhagId', class: "employeeDzongkhagId align-middle hidden"},
                    {data: 'employeeGewogId', class: "employeeGewogId align-middle hidden"},

                    {data: 'dzongkhagName', class: "dzongkhagName align-middle"},
                    {data: 'geogName', class: "geogName align-middle"},

                    {
                        "data": "null",
                        "mRender": function () {
                            return '<a href="#" id="btnDelete" class="btn btn-danger btn-sm ml-3 d-none d-sm-inline-block">Delete</a>' +
                                '<a href="#" id="btnEdit" class="btn btn-primary btn-sm ml-3 d-none d-sm-inline-block">Edit</a>';
                        }
                    }

                ];
                $('#employeeListTableId').DataTable({
                    data: res
                    , columns: columnDef
                    , destroy: true
                    , bSort: false
                    , "auto-width": true
                });

               calculateSumTotal();
            }
        });
    }

    function deleteEmployee() {
        $('#employeeListTableId tbody').on('click', 'tr #btnDelete', function () {
            var row = $(this).closest('tr');
            var employeeId = row.find('.employeeId').text();
            var employeeName = row.find('.employeeName').text();
            var url = _baseURL() + 'deleteEmployeeByEmployeeId';

            swal({
                title: "Are you sure to delete this employee " + employeeName + "?",
                text: "You will not be able to recover!",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "Confirm",
                closeOnConfirm: false
            }, function (isConfirm) {
                if (!isConfirm) return;
                $.ajax({
                    url: url,
                    type: 'POST',
                    data: {employeeId: employeeId},
                    success: function (res) {
                        if (res.status == 1) {
                            successMsg(res.text);

                            getEmployeeList();
                        } else {
                            errorMsg(res.text)
                        }
                    }
                });
            });
        })
    }

    function EditEmployee() {
        $('#employeeListTableId tbody').on('click', 'tr #btnEdit', function () {
            var row = $(this).closest('tr');
            var employeeId = row.find('.employeeId').text();
            var employeeName = row.find('.employeeName').text();
            var employeeDesignation = row.find('.employeeDesignation').text();
            var employeeDepartment = row.find('.employeeDepartment').text();
            var employeeContactNumber = row.find('.employeeContactNumber').text();
            var employeeDateOfBirth = row.find('.employeeDateOfBirth').text();

            var employeeDzongkhagId = row.find('.employeeDzongkhagId').text();
            var employeeGewogId = row.find('.employeeGewogId').text();

            $("#employeeId").val(employeeId);
            $("#employeeName").val(employeeName);
            $("#employeeDesignation").val(employeeDesignation);
            $("#employeeDepartment").val(employeeDepartment);
            $("#employeeContactNumber").val(employeeContactNumber);
            $("#employeeDateOfBirth").val(employeeDateOfBirth);

            $("#employeeDzongkhagId").val(employeeDzongkhagId);
            $("#employeeGewogId").val(employeeGewogId);

            $('#employeeModal').modal('show');

            $("#btnSave").val("Update");

        });
    }

    function generateReport() {
        alert("here");
        $('#generateReportBtn').on('click', function () {
            $.ajax({
                url: _baseURL() + 'generateReport',
                type: 'GET',
                success: function (res) {
                    window.open(GlobalFun.baseReportLocation() + res.dto.reportName, '_blank');
                }
            });
        })
    }

    var sumTotalOfId = 0;
    function calculateSumTotal(){
        $('#employeeListTableId tbody').find('tr').each(function(){
            var SelectedRow = $(this).closest('tr');
            sumTotalOfId += parseInt(SelectedRow.find('.employeeId').text());
        });

        $('#sumTotal').val(sumTotalOfId);

    }

    return {
        save: save,
        getEmployeeList: getEmployeeList,
        deleteEmployee: deleteEmployee,
        EditEmployee: EditEmployee,
        calculateSumTotal: calculateSumTotal,
        generateReport: generateReport,
    }

})();

$(document).ready(function () {
    employeeRegistration.save();
    employeeRegistration.getEmployeeList();
    employeeRegistration.deleteEmployee();
    employeeRegistration.EditEmployee();
    employeeRegistration.calculateSumTotal();
    employeeRegistration.generateReporta();

});