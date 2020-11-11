/**
 * Created by nzepa on 10/11/2020.
 */

villageRegistration = (function () {
    "use strict";
    var form =$('#villageRegistrationForm');
    function _baseURL() {
        return 'villageRegistration/';
    }


    function save() {
        $('.villageRegistrationForm').validate({
            submitHandler: function (form) {
                //handleCheckboxBeforeSave(form);
                var url = _baseURL() + 'save';
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
    villageRegistration.save();
});