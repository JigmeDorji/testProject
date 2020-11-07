/**
 * Created by nzepa on 7/2/2020.
 */
$(document).ready(function () {
    //scriptLoader("/resources/js/landingPage.js");
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

