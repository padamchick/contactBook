
$('document').ready(function() {

    $('.table .btn-info').on('click',function(event){

        event.preventDefault();

        var href= $(this).attr('href');

        $.get(href, function(contact){
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

    $('.table #deleteButton').on('click',function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #delRef').attr('href', href);
        $('#deleteModal').modal();

    });
});