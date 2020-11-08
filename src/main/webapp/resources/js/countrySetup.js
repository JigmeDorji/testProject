/**
 * Created by nzepa on 10/11/2020.
 */

countrySetup = (function () {
    "use strict";
    var form =$('#countrySetupForm');
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
    countrySetup.save();
});