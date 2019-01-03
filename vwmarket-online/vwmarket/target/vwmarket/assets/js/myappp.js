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

    var $table = $('#productListTable');

    if($table.length){

        var jsonUrl = '';
        if(window.categoryId == ''){
            jsonUrl = window.contextRoot + '/json/data/all/products';
        } else {
            jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId +'/products';
        }


        console.log('Inside table');
        $table.DataTable({
            lengthMenu: [[3,5,10,-1], ['3 Records', '5 Records', '10 Records', 'All']],
            pageLength: 5,
            ajax: {
                url: jsonUrl,
                dataSrc: ''
            },
            columns: [
                {
                    data: 'code',
                    mRender : function (data, type, row) {
                        return '<img src="' + window.contextRoot
                            + '/assets/images/' + data
                            + '.jpg" class="dataTableImg"/>';
                    }
                },
                {
                    data: 'name'
                },
                {
                    data: 'brand'
                },
                {
                    data: 'unitPrice',
                    mRender : function(data, type, row) {
                        return '&#8377; ' + data
                    }
                },
                {
                    data: 'quantity'
                },
                {
                    data : 'id',
                    bSortable : false,
                    mRender : function(data, type, row) {

                        var str = '';
                        str += '<a href="'
                            + window.contextRoot
                            + '/show/'
                            + data
                            + '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open">View</span></a> &#160;';

                        str += '<a href="'
                            + window.contextRoot
                            + '/cart/add/'
                            + data
                            + '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart">Add to Cart</span></a>';

                        return str;
                    }
                }
            ]
        });
    }
});