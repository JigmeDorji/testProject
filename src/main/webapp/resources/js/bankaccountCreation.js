/**
 * Created by nzepa on 10/11/2020.
 */

bankaccountRegistration = (function () {
    "use strict";
    var form = $('#bankaccountRegistrationForm');

    function _baseURL() {
        return 'bankaccountRegistration/';
    }

    function savedd() {
        $('#btnSave').on('click', function () {
            $.validator.setDefaults({
                submitHandler: function () {
                    $('#btnSave').attr('disabled', true);
                    //var data = $('#studentRegistrationForm').serializeArray();
                    var data = new FormData($('.bankaccountRegistration')[0]);
                    var url = _baseURL() + 'save';
                    $.ajax({
                        url: url,
                        type: 'post',
                        data: data,
                        processData: false,
                        success: function (res) {
                            if (res.status == 1) {
                                successMsg(res.text);
                                $('#companyDetailModal').modal('hide');
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

        $('.bankaccountRegistrationForm').validate({
            submitHandler: function (form) {
                //handleCheckboxBeforeSave(form);
                var url = _baseURL() + 'save';
                $.ajax({
                    url: url,
                    type: 'POST',
                    data: $(form).serializeArray(),
                    success: function (res) {
                        if (res.status == 1) {
                            $('#bankaccountName').val('bankaccountName');
                            $('#cidNo').val('cidNo');
                            $('#mobileNo').val('mobileNo');
                            $('#emailId').val('emailId');
                            $('#dzongkhagId').val('dzongkhagId');
                            successMsg(res.text);
                            getBankaccountList();
                            $('#companyDetailModal').modal('hide');
                        }
                    }
                });
            }
        });
    }

    return {
        save: save,
    }
})();

$(document).ready(function () {
    bankaccountRegistration.save();
});/**
 * Created by jigme.dorji on 11/8/2020.
 */
