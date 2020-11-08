$(document).ready(function () {

    if (document.URL.search("studentRegistration") > 1)
        scriptLoader("resources/js/studentRegistration.js");

    if (document.URL.search("gewogRegistration") > 1)
        scriptLoader("resources/js/gewogRegistration.js");

    if (document.URL.search("dzongkhagRegistration") > 1)
        scriptLoader("resources/js/dzongkhagRegistration.js");


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



