$(document).ready(function(e){
    var banner = '<h1>Choose a Hero/Villain to Delete</h1>';
    var div = $('#banner');
    div.html("");
    div.append(banner);
    
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8081/api/superhero/getHerosAndVillains',
        success: function(array) {
            var displayAllDiv = $('#displayAll');
            displayAllDiv.html("");

            $.each(array, function(index, heroVillain) {
                var superInfo = '<p>';
                superInfo += 'Name: ' + heroVillain.name + '<br>';
                superInfo += 'Is Hero: ' + heroVillain.isHero + '<br>';
                superInfo += '<form method="POST" action="/superhero/deleteHeroVillain/' + heroVillain.id + '" th:action="@{/superhero/deleteHeroVillain/}" th:object="${heroVillain}">';
                superInfo += '<button type="submit" name="submit" value="value" class="btn btn-danger">Delete</button><br></form>';
                superInfo += '</p><hr>';
                
                displayAllDiv.append(superInfo);
            })
        },
        error: function() {
            alert('FAILURE!');
        }
    })
});