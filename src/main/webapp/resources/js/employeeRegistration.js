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
                    {
                        "mRender": function (data, type, row, meta) {
                            return meta.row + 1;
                        }
                    },
                    {data: 'employeeName'},
                    {data: 'employeeDesignation'},
                    {data: 'employeeDepartment'},
                    {data: 'employeeContactNumber'},
                    {data: 'employeeDateOfBirth',
                        render: function (data) {
                        return formatAsDate(data)
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

    return {
        save: save,
        getEmployeeList: getEmployeeList
    }

})();

$(document).ready(function () {
    employeeRegistration.save();
    employeeRegistration.getEmployeeList();

});