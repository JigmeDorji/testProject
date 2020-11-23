$(document).ready(function () {

    if (document.URL.search("itemGroup") > 1)
        scriptLoader("resources/js/itemGroup.js");
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






