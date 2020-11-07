/**
 * Created by jigme.dorji on 24-Apr-2020.
 */
login = (function () {
    var message = $('#message');
    var messageSuccess = $('#messageSuccess');
    var form = $('#resetPasswordFormId');

    function forGotPasswordRetrieve() {
        $('.forgotPassword').on('click', function () {
            $.ajax({
                url: '/lis/resetPassword',
                //url: '/testdca/resetPassword',
                //url: '/resetPassword',
                type: 'GET',
                data: {
                    emailId: $('#emailId').val(),
                    username: $('#usernameReset').val()
                },
                success: function (res) {
                    if (res.status == 0) {
                        message.text(res.text);
                        message.css({color: 'red'});
                    } else {
                        messageSuccess.css({color: '#008000'});
                        messageSuccess.text(res.text);
                        $('.mainModal').hide(1000);
                        $('.subChildModal').attr('hidden', false);
                    }
                }
            });
        });
    }

    $('#forgotPassword').on('click', function () {
        message.text('');
        $('#emailId').val('');
        $('.mainModal').show();
        $('.subChildModal').attr('hidden', true);
    });

    return {
        forGotPasswordRetrieve: forGotPasswordRetrieve
    }

})();

$(document).ready(function () {
    login.forGotPasswordRetrieve();
});