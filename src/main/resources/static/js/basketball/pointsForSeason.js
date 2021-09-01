$(document).ready(function(e){
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8081/api/superhero/getPowers',
        success: function(array) {
            var displayAllDiv = $('#displayAll');
            displayAllDiv.html("");

            $.each(array, function(index, power) {
                var superInfo = '<p>';
                superInfo += 'Name: ' + power.name + '<br>';
                superInfo += 'Description: ' + power.description + '<br>';
                superInfo += '<form method="POST" action="/superhero/deletePower/' + power.id + '" th:action="@{/superhero/deletePower/}" th:object="${power}">';
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