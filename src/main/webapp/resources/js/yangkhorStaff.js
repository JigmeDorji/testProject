/**
 * Created by nzepa on 10/11/2020.
 */

yangkhorStaff = (function () {
    "use strict";
    var form =$('#yankhorStaffForm');
    function _baseURL() {
        return 'yangkhorStaff/';
    }

    function save() {
        $('.yankhorStaffForm').validate({
            submitHandler: function (form) {
                //handleCheckboxBeforeSave(form);
                var url = _baseURL() + 'yangkhorSaveDetail';
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
    alert('loading...');
    yankhorStaff.save();
});