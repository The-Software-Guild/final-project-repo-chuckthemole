$(document).ready(function(e){
    var banner = '<h1>Choose a Sighting to Edit</h1>';
    var div = $('#banner');
    div.html("");
    div.append(banner);
    
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8081/api/superhero/getSightings',
        success: function(array) {
            var displayAllDiv = $('#displayAll');
            displayAllDiv.html("");

            $.each(array, function(index, sighting) {
                var superInfo = '<p>';
                superInfo += 'Name: ' + sighting.heroVillain.name + '<br>';
                superInfo += 'Latitude: ' + sighting.location.latitude + '<br>';
                superInfo += 'Longitude: ' + sighting.location.longitude + '<br>';
                superInfo += '<form method="GET" action="/superhero/editSighting/' + sighting.id + '" th:action="@{/superhero/editsighting/}" th:object="${sighting}">';
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