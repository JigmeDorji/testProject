/**
 * Created by Bikash Rai on 11/8/2020.
 */

customerSetup = (function () {
    "use strict";
    var form = $('#customerSetupForm');

    function _baseURL() {
        return 'customerSetup/';
    }

    function save() {
        $('.customerSetupForm').validate({
            submitHandler: function (form) {
                var url = 'customerSetup/saveCustomerSetup';
                $.ajax({
                    url: url,
                    type: 'POST',
                    data: $(form).serializeArray(),
                    success: function (res) {
                        if (res.status === 1) {
                            $('#companyDetailModal').modal('show');
                            $('#customerName').val('');
                            $('#contactNo').val('');
                            $('#id').val(id);
                            successMsg(res.text);
                            getCustomerSetup();
                            $('#companyDetailModal').modal('hide');
                        }
                    }
                });
            }
        });
    }

    function getCustomerSetup() {
        var url = 'customerSetup/getCustomerSetup';
        $.ajax({
            url: url,
            type: 'GET',
            success: function (res) {
                var dataColiumn = [
                    {
                        "mRender": function (data, type, row, meta) {
                            return meta.row + 1;
                        }
                    },

                    {data: 'id', class: "id"},
                    {
                        data: 'customerName', class: "customerName"
                    },
                    {
                        data: 'contactNo', class: "contactNo"
                    },
                    {
                        "data": "null",
                        "mRender": function () {
                            return '<a href="#" id="btnDelete" class="btn btn-danger btn-sm ml-3 d-none d-sm-inline-block" data-toggle="modal" data-target="#userDetailModal">Delete</a><a href="#" id="btnEdit" class="btn btn-primary btn-sm ml-3 d-none d-sm-inline-block" data-toggle="modal" data-target="#userDetailModal">Edit</a>';
                        }
                    }
                ];
                $('#customerSetupGrid').DataTable({
                    data: res
                    , columns: dataColiumn
                    , destroy: true
                    , bSort: false
                    , "auto-width": true
                });
                calculateTotalOfId();
            }
        });

    }

    var sumTotalOfId = 0;

    function calculateTotalOfId() {
        $('#customerSetupGrid tbody').find('tr').each(function () {
            var selectedRow = $(this).closest('tr');
            sumTotalOfId += parseInt(selectedRow.find('.id').text());
        });
        $('#sumTotal').val(sumTotalOfId);

    }

    function deleteCustomer() {
        $('#customerSetupGrid tbody').on('click', 'tr #btnDelete', function () {
            var row = $(this).closest('tr');
            var id = row.find('.id').text();
            swal({
                title: "Are you sure to delete user " + row.find('.customerName').text() + "?",
                text: "You will not be able to recover!",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "Confirm",
                closeOnConfirm: false
            }, function (isConfirm) {
                if (!isConfirm) return;
                $.ajax({
                    url: 'customerSetup/delete',
                    type: 'POST',
                    data: {id: id},
                    success: function (res) {
                        if (res.status === 1) {
                            successMsg(res.text);
                            getCustomerSetup();
                            $('#companyDetailModal').modal('hide');

                        }
                    }
                });
            })

        })


    }

    function generateCustomer() {
        $('#btnGenerate').on('click', function () {
                    $.ajax({
                    url: 'customerSetup/generateCustomer',
                    type: 'GET',
                    success: function (res) {
                        window.open(ttplGlobal.baseReportLocation()+res.dto.reportName, '_blank');
                    }
                });
        });
    }

    function editCustomer() {
        $('#customerSetupGrid tbody').on('click', 'tr #btnEdit', function () {
            var row = $(this).closest('tr');
            var id = row.find('.id').text();
            var customerName = row.find('.customerName').text();
            var contactNo = row.find('.contactNo').text();
            $('#companyDetailModal').modal('show');
            $('#customerName').val(customerName);
            $('#contactNo').val(contactNo);
            $('#id').val(id);

        })

    }


    return {
        getCustomerSetup: getCustomerSetup,
        deleteCustomer: deleteCustomer,
        editCustomer: editCustomer,
        generateCustomer: generateCustomer,
        save: save,

    }
})();

$(document).ready(function () {
    customerSetup.getCustomerSetup();
    customerSetup.deleteCustomer();
    customerSetup.editCustomer();
    customerSetup.save();
    customerSetup.generateCustomer();

    customerSetup.sumTotalId();

});