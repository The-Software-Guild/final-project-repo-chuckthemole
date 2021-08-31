$(document).ready(function(e){
    var banner = '<h1>Choose a Location to Edit</h1>';
    var div = $('#banner');
    div.html("");
    div.append(banner);
    
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8081/api/superhero/getLocations',
        success: function(array) {
            var displayAllDiv = $('#displayAll');
            displayAllDiv.html("");

            $.each(array, function(index, location) {
                var superInfo = '<p>';
                superInfo += 'Latitude: ' + location.latitude + '<br>';
                superInfo += 'Longitude: ' + location.longitude + '<br>';
                superInfo += '<form method="GET" action="/superhero/editLocation/' + location.id + '" th:action="@{/superhero/editLocation/}" th:object="${location}">';
                superInfo += '<button type="submit" name="submit" value="value" class="btn btn-info">Edit</button><br></form>';
                superInfo += '</p><hr>';
                
                displayAllDiv.append(superInfo);
            })
        },
        error: function() {
            alert('FAILURE!');
        }
    })
});