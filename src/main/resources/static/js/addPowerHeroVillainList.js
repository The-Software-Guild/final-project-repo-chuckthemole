$(document).ready(function(e){
    var banner = '<h1>Choose a Hero/Villain to add a power.</h1>';
    var div = $('#banner_addPower');
    div.html("");
    div.append(banner);
    
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8081/api/superhero/getHerosAndVillains',
        success: function(array) {
            var displayAllDiv = $('#displayAll_addPower');
            displayAllDiv.html("");

            $.each(array, function(index, heroVillain) {
                var superInfo = '<p>';
                superInfo += 'Name: ' + heroVillain.name + '<br>';
                superInfo += '<form method="GET" action="/superhero/addPower/' + heroVillain.id + '" th:action="@{/superhero/addPower/}" th:object="${heroVillain}">';
                superInfo += '<button type="submit" name="submit" value="value" class="btn btn-info">Add Power</button><br></form>';
                superInfo += '</p><hr>';
                
                displayAllDiv.append(superInfo);
            })
        },
        error: function() {
            alert('FAILURE!');
        }
    })
});