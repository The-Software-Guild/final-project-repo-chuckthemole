$(document).ready(function(e){
    var banner = '<h1>Choose a Hero/Villain to add an organization.</h1>';
    var div = $('#banner_organization');
    div.html("");
    div.append(banner);
    
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8081/api/superhero/getHerosAndVillains',
        success: function(array) {
            var displayAllDiv = $('#displayAll_organization');
            displayAllDiv.html("");

            $.each(array, function(index, heroVillain) {
                var superInfo = '<p>';
                superInfo += 'Name: ' + heroVillain.name + '<br>';
                superInfo += '<form method="GET" action="/superhero/addOrganization/' + heroVillain.id + '" th:action="@{/superhero/addOrganization/}" th:object="${heroVillain}">';
                superInfo += '<button type="submit" name="submit" value="value" class="btn btn-info">Add Organization</button><br></form>';
                superInfo += '</p><hr>';
                
                displayAllDiv.append(superInfo);
            })
        },
        error: function() {
            alert('FAILURE!');
        }
    })
});