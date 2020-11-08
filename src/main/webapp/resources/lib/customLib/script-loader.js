$(document).ready(function () {

    if (document.URL.search("studentRegistration") > 1)
        scriptLoader("resources/js/studentRegistration.js");

     if (document.URL.search("countrySetup") > 1)
        scriptLoader("resources/js/countrySetup.js");
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



