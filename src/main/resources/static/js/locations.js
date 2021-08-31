$("#locations_btn").click(function(e) {
   $.ajax({
        type: 'GET',
        url: 'http://localhost:8081/api/superhero/getHerosAndVillains',
        success: function(contactArray) {
            var contactsDiv = $('#allContacts');

            $.each(contactArray, function(index, contact) {
                var contactInfo = '<p>';
                contactInfo += 'Name: ' + contact.name + '<br>';
                contactInfo += 'Company: ' + contact.isHero + '<br>';
                contactInfo += '</p><hr>';

                contactsDiv.append(contactInfo);
            })
        },
        error: function() {
            alert('FAILURE!');
        }
    })
});

