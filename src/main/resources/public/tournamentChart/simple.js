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
                var game = parseInt($(this)[0].attributes.getNamedItem("data-game").nodeValue);
                var round = parseInt($(this)[0].attributes.getNamedItem("data-round").nodeValue);
                var name = $(this)[0].children[0].innerText;
                var xhr = new XMLHttpRequest();
                xhr.open("PUT", "http://localhost:8080/api/game/setWinner", true);
                xhr.setRequestHeader('Content-Type', 'application/json');
                xhr.send(JSON.stringify({
                    name: name,
                    game: game,
                    round: round,
                    tournamentId: id
                }));
                console.log();
                alert("round: " + round + " game: " + game + "\nname: " + name);
                e.preventDefault(); //to prevent any other unwanted behavior clicking the div might cause
            });
        }
    });
}
