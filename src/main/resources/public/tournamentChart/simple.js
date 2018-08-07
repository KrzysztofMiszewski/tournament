function getWithAjax(id) {



    $.ajax({
        type : "GET",
        url : "http://localhost:8080/api/tournaments/getTest",
        data: {
            "id" : id
        },
        dataType : 'json',
        success: function(json) {
            console.log(json);
            new Treant(json);
        }
    });
}