/**
 * Created by nzepa on 10/11/2020.
 */

employeeRegistration = (function () {
    "use strict";
    var form = $('#employeeRegistrationForm');

    function _baseURL() {
        return 'employeeRegistration/';
    }

    function savedd() {
        $('#btnSave').on('click', function () {
            $.validator.setDefaults({
                submitHandler: function () {
                    $('#btnSave').attr('disabled', true);
                    //var data = $('#studentRegistrationForm').serializeArray();
                    var data = new FormData($('.employeeRegistrationForm')[0]);
                    var url = _baseURL() + 'save';
                    $.ajax({
                        url: url,
                        type: 'post',
                        data: data,
                        processData: false,
                        success: function (res) {
                            if (res.status == 1) {
                                successMsg(res.text);
                                $('#employeeModal').modal('hide');
                                $('#btnSave').attr("disabled", false);
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
                            successMsg(res.text);

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
                    {data: 'employeeName'},
                    {data: 'employeeDesignation'},
                    {data: 'employeeDepartment'},
                    {data: 'employeeContactNumber'},
                    {
                        data: 'employeeDateOfBirth',
                        render: function (data) {
                            return formatAsDate(data)
                        }
                    },

                    {
                        "data": "null",
                        "mRender": function () {
                            return '<a href="#" id="btnDelete" class="btn btn-danger btn-sm ml-3 d-none d-sm-inline-block">Delete</a>';
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
            }
        });
    }

    function deleteEmployee() {
        $('#employeeListTableId tbody').on('click', 'tr #btnDelete', function () {
            var row = $(this).closest('tr');
            var employeeId = row.find('.employeeId').text();
            var url = _baseURL() + 'deleteEmployeeByEmployeeId';

            swal({
                title: "Are you sure to delete user " + employeeId + "?",
                text: "You will not be able to recover!",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "Confirm",
                closeOnConfirm: false
            }, function (isConfirm) {
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

    return {
        save: save,
        getEmployeeList: getEmployeeList,
        deleteEmployee: deleteEmployee
    }

})();

$(document).ready(function () {
    employeeRegistration.save();
    employeeRegistration.getEmployeeList();
    employeeRegistration.deleteEmployee();

});