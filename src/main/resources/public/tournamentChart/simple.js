function getWithAjax() {

    $.ajax({
        type : "GET",
        url : "http://localhost:8080/api/tournaments/getTest",
        dataType : 'json',
        success: function(json) {
            console.log(json);
            new Treant(json);
        }
    });
}