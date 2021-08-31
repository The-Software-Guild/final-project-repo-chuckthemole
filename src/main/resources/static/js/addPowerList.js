$(document).ready(function(e){
    var banner = '<h1>Choose a Power to Add</h1>';
    var div = $('#banner');
    div.html("");
    div.append(banner);
    
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8081/api/superhero/getPowers',
        success: function(powerArray) {
            var displayAllDiv = $('#displayAll');
            displayAllDiv.html("");

            $.each(powerArray, function(index, power) {
                var superInfo = '<p>';
                superInfo += 'Name: ' + power.name + '<br>';
                superInfo += 'Description: ' + power.description + '<br>';
                superInfo += '<form method="POST" action="/superhero/addPower/' + power.id + '" th:action="@{/superhero/addPower/}" th:object="${power}">';
                superInfo += '<button type="submit" name="submit" value="value" class="btn btn-info">Add</button><br></form>';
                superInfo += '</p><hr>';
                
                displayAllDiv.append(superInfo);
            })
        },
        error: function() {
            alert('FAILURE!');
        }
    })
});