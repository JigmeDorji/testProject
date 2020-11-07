/**
 * Created by nzepa on 10/13/2020.
 */

application = (function () {
    "use strict";
    var form = $('#applicationFormId');
    var isSubmitted = false;

    function _baseURL() {
        return 'application/';
    }

    function btnSubmit() {
        $('#btnSubmit').on('click', function () {
            $.validator.setDefaults({
                submitHandler: function () {
                    isSubmitted = true;
                    $('#btnSubmit').attr('disabled', true);
                    var data = new FormData($('.applicationFormId')[0]);
                    var url = _baseURL() + 'submitApplication';
                    $.ajax({
                        url: url,
                        type: 'post',
                        data: data,
                        enctype: 'multipart/form-data',
                        contentType: false,
                        processData: false,
                        success: function (res) {
                            if (res.status == 1) {
                                successMsg(res.text);
                                $('.field').val('');
                                $('#btnSubmit').attr("disabled", false);
                            } else {
                                $('#btnSubmit').attr("disabled", false);
                                warningMsg(res.text);
                            }
                        }, complete: function (res) {
                            $('#btnSubmit').attr("disabled", false);
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

    return {
        btnSubmit: btnSubmit
    }
})();

$(document).ready(function () {
    application.btnSubmit();
});