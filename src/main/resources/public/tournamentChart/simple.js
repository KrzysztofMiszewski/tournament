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
            $(".game").on("click", function (e) {
                //your code here..
                console.log($(this)[0].attributes.getNamedItem("data-game").nodeValue);
                console.log($(this)[0].attributes.getNamedItem("data-round").nodeValue);
                alert("round: " + $(this)[0].attributes.getNamedItem("data-round").nodeValue + " game: "
                    + $(this)[0].attributes.getNamedItem("data-game").nodeValue);
                e.preventDefault(); //to prevent any other unwanted behavior clicking the div might cause
            });
        }
    });
}
