$(document).ready(function () {

    if (document.URL.search("studentRegistration") > 1)
        scriptLoader("resources/js/studentRegistration.js");

    if (document.URL.search("customerSetup") > 1)
        scriptLoader("resources/js/customerSetup.js");

});

var scriptLoader = function (url) {

    $.ajax(
        {
            type: "GET",
            url: url,
            dataType: "script",
            cache: false
        });
};



