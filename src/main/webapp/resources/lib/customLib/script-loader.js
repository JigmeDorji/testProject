$(document).ready(function () {

    if (document.URL.search("studentRegistration") > 1)
        scriptLoader("resources/js/studentRegistration.js");

    if (document.URL.search("gewogRegistration") > 1)
        scriptLoader("resources/js/gewogRegistration.js");

    if (document.URL.search("chiwogRegistration") > 1)
        scriptLoader("resources/js/chiwogRegistration.js");

    if (document.URL.search("countrySetup") > 1)
        scriptLoader("resources/js/countrySetup.js");

    if (document.URL.search("customerSetup") > 1)
        scriptLoader("resources/js/customerSetup.js");

    if (document.URL.search("dzongkhagRegistration") > 1)
        scriptLoader("resources/js/dzongkhagRegistration.js");

    if (document.URL.search("employeeRegistration") > 1)
        scriptLoader("resources/js/employeeRegistration.js");


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



