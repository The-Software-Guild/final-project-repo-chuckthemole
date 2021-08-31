$(document).ready(function(e){
    var banner = '<h1>Choose an organization</h1>';
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
                var superInfo = '<p>';
                superInfo += 'Name: ' + organization.name + '<br>';
                superInfo += '<form method="POST" action="/superhero/addOrganization/' + organization.id + '" th:action="@{/superhero/addOrganization/}" th:object="${organization}">';
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