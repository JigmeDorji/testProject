/**
 * Created by Bikash Rai on 11/8/2020.
 */

customerSetup = (function () {
    "use strict";
    var form =$('#customerSetupForm');

    function _baseURL() {
        return 'customerSetup/';
    }

    function save() {
        $('.customerSetupForm').validate({
            submitHandler: function (form) {
                var url = _baseURL() + 'saveCustomerSetup';
                $.ajax({
                    url: url,
                    type: 'POST',
                    data: $(form).serializeArray(),
                    success: function (res) {
                        if (res.status === 1) {
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
    studentRegistration.save();
});