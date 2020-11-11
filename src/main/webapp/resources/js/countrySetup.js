/**
 * Created by nzepa on 10/11/2020.
 */

countrySetup = (function () {
    "use strict";
    var form = $('#countrySetupForm');

    function _baseURL() {
        return 'countrySetup/';
    }

    function save() {
        $('.countrySetupForm').validate({
            submitHandler: function (form) {
                //handleCheckboxBeforeSave(form);
                var url = _baseURL() + 'countrySaveDetail';
                $.ajax({
                    url: url,
                    type: 'POST',
                    data: $(form).serializeArray(),
                    success: function (res) {
                        if (res.status == 1) {
                            $('#countryId').val('');//give value to modal
                            $('#countryName').val('');//give value to modal
                            successMsg(res.text);
                            getCountryName();
                            $('#companyDetailModal').modal('hide');
                        }
                    }
                });
            }
        });
    }

    function getCountryName() {
        $.ajax({
            url: _baseURL() + 'getCountryName',
            type: 'GET',
            success: function (res) {
                var columnDef = [
                    {
                        "mRender": function (data, type, row, meta) {
                            return meta.row + 1;
                        }
                    },

                    {data: 'id', class: 'countryId'},
                    {data: 'countryName', class: 'countryName'},
                    {
                        "data": "null",
                        "mRender": function () {
                            return '<a href="#" id="btnDelete" class="btn btn-danger btn-sm ml-3 d-none d-sm-inline-block">delete</a>' +
                                '<a href="#" id="btnEdit" class="btn btn-primary btn-sm ml-3 d-none d-sm-inline-block">Edit</a>';


                        }
                    }

                ];
                $('#countryListTableId').DataTable({
                    data: res
                    , columns: columnDef
                    , destroy: true
                    , bSort: false
                    , "auto-width": true
                });
            }
        });

    }

    function deleteCountryName() {
        $('#countryListTableId tbody').on('click', 'tr #btnDelete', function () {
            var row = $(this).closest('tr');
            var countryId = row.find('.countryId').text();
            var countryName = row.find('.countryName').text();

            swal({
                title: "Are you sure to delete country " + countryName + "?",
                text: "You will not be able to recover!",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "Confirm",
                closeOnConfirm: false
            }, function (isConfirm) {
                if (!isConfirm) return;
                $.ajax({
                    url: _baseURL() + 'deleteCountryId',
                    type: 'POST',
                    data: {countryId: countryId},
                    success: function (res) {
                        if (res.status == 1) {
                            successMsg(res.text);
                            getCountryName();
                        }
                    }
                });
            });
        })
    }

    function editCountryName() {
        $('#countryListTableId tbody').on('click', 'tr #btnEdit', function () {
            var row = $(this).closest('tr');
            var countryId = row.find('.countryId').text();
            var countryName = row.find('.countryName').text();

            $('#countryId').val(countryId);//give value to modal
            $('#countryName').val(countryName);//give value to modal
            $('#companyDetailModal').modal('show');
        })
    }

    function reportCountryList() {
        $('#btnMyReport').on('click', function () {

            $.ajax({
                url: _baseURL() + 'reportCountryList',
                type: 'GET',
                success: function (res) {
                    window.open(ttplGlobal.baseReportLocation() + res.dto.reportName, '_blank');
                }
            });
        })
    }


    return {
        save: save,
        getCountryName: getCountryName,
        deleteCountryName: deleteCountryName,
        editCountryName: editCountryName,
        reportCountryList: reportCountryList
    }
})();

$(document).ready(function () {
    countrySetup.save();
    countrySetup.getCountryName();
    countrySetup.deleteCountryName();
    countrySetup.editCountryName();
    countrySetup.reportCountryList();

});


