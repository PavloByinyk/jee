$(function () {

    switch(menu){
        case 'Home':
            $('#home').addClass('active');
            break;
        case 'About Us':
            $('#about').addClass('active');
            break;
        case 'Contact':
            $('#contact').addClass('active');
            break;
        case 'All products':
            // $('#listProducts').addClass('active');
            // break;
        default:
            $('#listProducts').addClass('active');
            $('#a_' + menu).addClass('active');
            break;
    }
});