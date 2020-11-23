/**
 * Created by Yangkhor
 */

itemGroup = (function () {
    "use strict";
    var form = $('#itemGroupForm');

    function _baseURL() {
        return 'itemGroup/';
    }

    function save() {
        $('.itemGroupForm').validate({
            submitHandler: function (form) {
                var url = _baseURL() + 'saveItemGroup';
                $.ajax({
                    url: url,
                    type: 'POST',
                    data: $(form).serializeArray(),
                    success: function (res) {
                        if (res.status === 1) {
                            // $('#itemGroupModal').modal('show');
                            $('#item_group_name').val('');
                            $('#item_group_description').val('');
                            $('#mandatory_item_group').val('');
                            successMsg(res.text);
                            // getItemGroup();
                            $('#itemGroupModal').modal('hide');
                        }
                    }
                });
            }
        });
    }

    // function getItemGroup() {
    //     var url = 'itemGroup/getItemGroup';
    //     $.ajax({
    //         url: url,
    //         type: 'GET',
    //         success: function (res) {
    //             var dataColumn = [
    //                 {
    //                     "mRender": function (data, type, row, meta) {
    //                         return meta.row + 1;
    //                     }
    //                 },
    //
    //                 {
    //                     data: 'item_group_name', class: "item_group_name"
    //                 },
    //                 {
    //                     data: 'item_group_description', class: "item_group_description"
    //                 },
    //                 {
    //                     data: 'mandatory_item_group', class: "mandatory_item_group"
    //                 },
    //                 {
    //                     "data": "null",
    //                     "mRender": function () {
    //                         return '<a href="#" id="btnDelete" class="btn btn-danger btn-sm ml-3 d-none d-sm-inline-block" data-toggle="modal" data-target="#userDetailModal">Delete</a><a href="#" id="btnEdit" class="btn btn-primary btn-sm ml-3 d-none d-sm-inline-block" data-toggle="modal" data-target="#userDetailModal">Edit</a>';
    //                     }
    //                 }
    //             ];
    //             $('#itemGroupGrid').DataTable({
    //                 data: res
    //                 , columns: dataColumn
    //                 , destroy: true
    //                 , bSort: false
    //                 , "auto-width": true
    //             });
    //         }
    //     });
    //
    // }
    //
    // function deleteItemGroup() {
    //     $('#itemGroupGrid tbody').on('click', 'tr #btnDelete', function () {
    //         var row = $(this).closest('tr');
    //         var itemgroup_id = row.find('.itemgroup_id').text();
    //         swal({
    //             title: "Are you sure to delete user " + row.find('.item_group_name').text() + "?",
    //             text: "You will not be able to recover!",
    //             type: "warning",
    //             showCancelButton: true,
    //             confirmButtonColor: "#DD6B55",
    //             confirmButtonText: "Confirm",
    //             closeOnConfirm: false
    //         }, function (isConfirm) {
    //             if (!isConfirm) return;
    //             $.ajax({
    //                 url: 'itemGroup/deleteItemGroup',
    //                 type: 'POST',
    //                 data: {itemgroup_id: itemgroup_id },
    //                 success: function (res) {
    //                     if (res.status === 1) {
    //                         successMsg(res.text);
    //                         getItemGroup();
    //                         $('#itemGroupModal').modal('hide');
    //
    //                     }
    //                 }
    //             });
    //         })
    //
    //     })
    //
    //
    // }
    //
    // function editItemGroup() {
    //     $('#itemGroupGrid tbody').on('click', 'tr #btnEdit', function () {
    //         var row = $(this).closest('tr');
    //         var itemgroup_id = row.find('.itemgroup_id').text();
    //         var item_group_name = row.find('.item_group_name').text();
    //         var item_group_description = row.find('.item_group_description').text();
    //         var mandatory_item_group = row.find('.mandatory_item_group').text();
    //         $('#itemgroup_id').val(itemgroup_id);
    //         $('#item_group_name').val(item_group_name);
    //         $('#item_group_description').val(item_group_description);
    //         $('#mandatory_item_group').val(mandatory_item_group);
    //         $('#itemGroupModal').modal('show');
    //
    //     })
    //
    // }

    return {
        save: save
        // getItemGroup:getItemGroup,
        // deleteItemGroup:deleteItemGroup,
        // editItemGroup: editItemGroup

    }
})();

$(document).ready(function () {

    alert("asdf")
    itemGroup.save();

    // itemGroup.getItemGroup();
    // itemGroup.deleteItemGroup();
    // itemGroup.editItemGroup();

});