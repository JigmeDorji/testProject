/**
 * Created by nzepa on 10/11/2020.
 */

dzongkhagRegistration = (function () {
    "use strict";
    var form =$('#dzongkhagRegistrationForm');
    function _baseURL() {
        return 'dzongkhagRegistration/';
    }

    function save() {
        $('.dzongkhagRegistrationForm').validate({
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

    dzongkhagRegistration.save();


});