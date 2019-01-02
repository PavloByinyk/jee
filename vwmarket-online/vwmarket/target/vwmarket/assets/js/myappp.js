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

    var products = [

        ['1', 'ABC'],
        ['2', 'ABCV'],
        ['3', 'ABCB'],
        ['4', 'ABCN'],
        ['5', 'ABCM']
    ];

    var $table = $('#productListTable');

    if($table.length){
        console.log('Inside table');
        $table.DataTable({
            lengthMenu: [[3,5,10,-1], ['3 Records', '5 Records', '10 Records', 'All']],
            pageLength: 5,
            data: products
        });
    }
});