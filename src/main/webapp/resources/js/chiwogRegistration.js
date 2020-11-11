/**
 * Created by nzepa on 10/11/2020.
 */

chiwogRegistration = (function () {
    "use strict";
    var form = $('#studentRegistrationForm');

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
                            $('#chiwogName').val('');
                            $('#chiwogId').val('');
                            successMsg(res.text);
                            getChiwogList();
                            $('#companyDetailModal').modal('hide');
                        }
                    }
                });
            }
        });
    }

    function getChiwogList() {
        $.ajax({
            url: _baseURL() + 'getChiwogList',
            type: 'GET',
            success: function (res) {
                var columnDef = [
                    {data: 'id', class: 'chiwogId'},
                    {data: 'chiwogName', class: 'chiwogName'},
                    {
                        "data": "null",
                        "mRender": function () {
                            return '<a href="#" id="btnDelete" class="btn btn-danger btn-sm ml-3 d-none d-sm-inline-block" >Delete</a>  <a href="#" id="btnEdit" class="btn btn-primary btn-sm ml-3 d-none d-sm-inline-block" >Edit</a>';
                        }
                    }

                ];
                $('#chiwogTableId').DataTable({
                    data: res
                    , columns: columnDef
                    , destroy: true
                    , bSort: false
                    , "auto-width": true
                });
            }
        });
    }

    function deleteChiwog() {
        $('#chiwogTableId tbody').on('click', 'tr #btnDelete', function () {

            var row = $(this).closest('tr');
            var chiwogId = row.find('.chiwogId').text();
            var chiwogName = row.find('.chiwogName').text();


                $.ajax({
                    url: _baseURL() + 'deleteChiwogInfoByChiwogId',
                    type: 'POST',
                    data: {chiwogId: chiwogId},
                    success: function (res) {
                        if (res.status == 1) {
                            successMsg(res.text);
                            getChiwogList();

                        } else {
                            errorMsg(res.text);
                        }

                    }
                });
                });

    }
    function editChiwog() {
        $('#chiwogTableId tbody').on('click', 'tr #btnEdit', function () {

            var row = $(this).closest('tr');
            var chiwogId = row.find('.chiwogId').text();
            var chiwogName = row.find('.chiwogName').text();

            $('#chiwogName').val(chiwogName);
            $('#chiwogId').val(chiwogId);
            $('#companyDetailModal').modal('show');

        });

    }
function generateReport() {
        $('#btnGenerate').on('click',function () {

            $.ajax({
                url: 'chiwogRegistration/generateReport',
                type: 'GET',
                success: function (res) {
                    window.open(ttplGlobal.baseReportLocation() + res.dto.reportName,'_blank');

                }
            });

    })
}


    return {
        save: save,
        getChiwogList: getChiwogList,
        deleteChiwog: deleteChiwog,
        editChiwog: editChiwog,
        generateReport: generateReport
    }
})();

$(document).ready(function () {
    chiwogRegistration.save();
    chiwogRegistration.getChiwogList()
    chiwogRegistration.deleteChiwog()
    chiwogRegistration.editChiwog()
    chiwogRegistration.generateReport()


});/**
 * Created by jigme.dorji on 11/8/2020.
 */
