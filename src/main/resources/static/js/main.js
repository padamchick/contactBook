
$('document').ready(function() {

    $('.table .btn-info').on('click',function(event){

        event.preventDefault();

        var href= $(this).attr('href');

        $.get(href, function(contact, status){
            $('#id').val(contact.id);
            $('#first-name').val(contact.firstName);
            $('#last-name').val(contact.lastName);
            $('#email').val(contact.email);
            $('#birth-date').val(contact.birthDay);
            $('#phone-number').val(contact.phoneNumber);
            $('#category').val(contact.category);
        });

        $('#editModal').modal();
    });
});