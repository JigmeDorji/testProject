/**
 * Created by nzepa on 10/11/2020.
 */

chiwogRegistration = (function () {
    "use strict";
    var form =$('#studentRegistrationForm');
    function _baseURL() {
        return 'chiwogRegistration/';
    }

    function savedd() {
        $('#btnSave').on('click', function () {
            $.validator.setDefaults({
                submitHandler: function () {
                    $('#btnSave').attr('disabled', true);
                    //var data = $('#studentRegistrationForm').serializeArray();
                    var data = new FormData($('.studentRegistrationForm')[0]);
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
        $('.chiwogRegistrationForm').validate({
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

    return {
        save: save
    }
})();

$(document).ready(function () {
    alert('hi')
    chiwogRegistration .save();
});/**
 * Created by jigme.dorji on 11/8/2020.
 */
