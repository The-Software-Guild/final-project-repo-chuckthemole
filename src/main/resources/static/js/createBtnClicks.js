//$(document).ready(function(){
$("#heroesVillains_btn").click(function(e) {
    var banner = '<h1>Create Heroes/Villains</h1>';
    var div = $('#createBanner');
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
                superInfo += '</p><hr>';

                displayAllDiv.append(superInfo);
            })
        },
        error: function() {
            alert('FAILURE!');
        }
    })
});

$("#locations_btn").click(function(e) {
    var banner = '<h1>All Locations</h1>';
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
                var locInfo = '<p>';
                locInfo += 'Location ID: ' + location.id + '<br>';
                locInfo += 'Latitude: ' + location.latitude + '<br>';
                locInfo += 'Longitude: ' + location.longitude + '<br>';
                locInfo += '</p><hr>';

                displayAllDiv.append(locInfo);
            })
        },
        error: function() {
            alert('FAILURE!');
        }
    })
});

$("#organizations_btn").click(function(e) {
    var banner = '<h1>All Organizations</h1>';
    var div = $('#banner');
    div.html("");
    div.append(banner);
    
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8081/api/superhero/getOrganizations',
        success: function(array) {
            var displayAllDiv = $('#displayAll');
            displayAllDiv.html("");

            $.each(array, function(index, organization) {
                var organizationInfo = '<p>';
                organizationInfo += 'Name: ' + organization.name + '<br>';
                organizationInfo += 'Is For Hero: ' + organization.isForHero + '<br>';
                
                organizationInfo += '</p><hr>';

                displayAllDiv.append(organizationInfo);
            })
        },
        error: function() {
            alert('FAILURE!');
        }
    })
});

$("#powers_btn").click(function(e) {
    var banner = '<h1>All Powers</h1>';
    var div = $('#banner');
    div.html("");
    div.append(banner);
    
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8081/api/superhero/getPowers',
        success: function(array) {
            var displayAllDiv = $('#displayAll');
            displayAllDiv.html("");

            $.each(array, function(index, power) {
                var powerInfo = '<p>';
                powerInfo += 'Name: ' + power.name + '<br>';
                powerInfo += 'Description: ' + power.description + '<br>';
                powerInfo += '</p><hr>';

                displayAllDiv.append(powerInfo);
            })
        },
        error: function() {
            alert('FAILURE!');
        }
    })
});

$("#sightings_btn").click(function(e) {
    var banner = '<h1>All Sightings</h1>';
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
                var sightingInfo = '<p>';
                sightingInfo += 'Sighting ID: ' + sighting.id + '<br>';
                sightingInfo += 'Hero/Villain Name: ' + sighting.heroVillain.name + '<br>';
                sightingInfo += 'Location ID: ' + sighting.location.id + '<br>';
                sightingInfo += '</p><hr>';

                displayAllDiv.append(sightingInfo);
            })
        },
        error: function() {
            alert('FAILURE!');
        }
    })
});