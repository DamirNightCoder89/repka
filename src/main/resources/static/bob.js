$(document).ready(function () {
    $.ajax({
        url: 'rest/ready/',
        method: 'GET',
        dataType: "json",
        complete: function (data) {
            let result = JSON.parse(data.responseText);
            if (result.error == null) {
            $("#box").append("<img styly=color:red id='pygi_img' src=" + result.data.images.original.url + "/>");
            } else {
            $("#box").append("<p style=color:red id='pygi_error'>" + result.error + "</p>");
            }
        }
    });

    $('#bob').on("change", function() {
            $.ajax({
                url: 'rest/ready/' + this.value,
                method: 'GET',
                dataType: "json",
                complete: function (data) {
                    $("#pygi_img").detach();
                    $("#pygi_error").detach();
                    let result = JSON.parse(data.responseText);
                    if (result.error == null) {
                    $("#box").append("<img styly=color:red id='pygi_img' src=" + result.data.images.original.url + "/>");
                    } else {
                    $("#box").append("<p style=color:red id='pygi_error'>" + result.error + "</p>");
                    }
                }
            });
    });
});


