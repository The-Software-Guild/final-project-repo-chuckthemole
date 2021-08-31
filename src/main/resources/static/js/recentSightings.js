$(document).ready(function(e){
    var banner = '<h1>10 Most Recent Sightings</h1>';
    var div = $('#recentBanner');
    div.html("");
    div.append(banner);
    
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8081/api/superhero/getRecentSightings',
        success: function(array) {
            var displayAllDiv = $('#recent');
            displayAllDiv.html("");

            $.each(array, function(index, sighting) {
                var sightingInfo = '<p>' + (index + 1) + '.<br>';
                sightingInfo += 'Hero/Villain Name: ' + sighting.heroVillain.name + '<br>';
                sightingInfo += 'Location ID: ' + sighting.location.id + '<br>';
                sightingInfo += 'Latitude: ' + sighting.location.latitude + '<br>';
                sightingInfo += 'Longitude: ' + sighting.location.longitude + '<br>';
                sightingInfo += '</p><hr>';

                displayAllDiv.append(sightingInfo);
            })
        },
        error: function() {
            alert('FAILURE!');
        }
    })
});