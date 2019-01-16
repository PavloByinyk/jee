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
        case 'Manage Products':
            $('#manageProducts').addClass('active');
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
                    data: 'quantity',
                    mRender : function(data, type, row) {
                        if(data < 1){
                            return '<span style="color:red">Out of Stock!</span>'
                        }
                        return '&#8377; ' + data
                    }
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

                        if (row.quantity < 1) {
                            str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"><strike>Add to Cart</strike></span></a>';
                        } else {

                            str += '<a href="'
                                + window.contextRoot
                                + '/cart/add/'
                                + data
                                + '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart">Add to Cart</span></a>';
                        }



                        return str;
                    }
                }
            ]
        });
    }


    /*------*/
    /* for fading out the alert message after 3 seconds */
    $alert = $('.alert');
    if($alert.length) {
        setTimeout(function() {
                $alert.fadeOut('slow');
            }, 3000
        );
    }


    $('.switch input[type="checkbox"]').on('change' , function() {
        var dText = (this.checked) ? 'You want to activate the Product?' : 'You want to de-activate the Product?';
        var checked = this.checked;
        var checkbox = $(this);
        debugger;
        bootbox.confirm({
            size: 'medium',
            title: 'Product Activation/Deactivation',
            message: dText,
            callback: function (confirmed) {
                if (confirmed) {
                    $.ajax({
                        type: 'GET',
                        url: window.contextRoot + '/manage/product/' + checkbox.prop('value') + '/activation',
                        timeout: 100000,
                        success: function (data) {
                            bootbox.alert(data);
                        },
                        error: function (e) {
                            bootbox.alert('ERROR: ' + e.message);
                            //display(e);
                        }
                    });
                } else {
                    checkbox.prop('checked', !checked);
                }
            }

        });
    });



    // list of all products for admin
    var $productsTable = $('#productsTable');


    if($productsTable.length) {

        var jsonUrl = window.contextRoot + '/json/data/admin/all/products';
        console.log(jsonUrl);

        $productsTable.DataTable({
            lengthMenu : [ [ 10, 30, 50, -1 ], [ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
            pageLength : 30,
            ajax : {
                url : jsonUrl,
                dataSrc : ''
            },
            columns : [
                {
                    data: 'id'
                },


                {
                    data: 'code',
                    bSortable: false,
                    mRender: function(data,type,row) {
                        return '<img src="' + window.contextRoot
                            + '/assets/images/' + data
                            + '.jpg" class="dataTableImg"/>';
                    }
                },
                {
                    data : 'name'
                },
                {
                    data : 'brand'
                },
                {
                    data : 'quantity',
                    mRender : function(data, type, row) {

                        if (data < 1) {
                            return '<span style="color:red">Out of Stock!</span>';
                        }

                        return data;

                    }
                },
                {
                    data : 'unitPrice',
                    mRender : function(data, type, row) {
                        return '&#8377; ' + data
                    }
                },
                {
                    data : 'active',
                    bSortable : false,
                    mRender : function(data, type, row) {
                        var str = '';
                        if(data) {
                            str += '<label class="switch"> <input type="checkbox" value="'+row.id+'" checked="checked">  <div class="slider round"> </div></label>';

                        }else {
                            str += '<label class="switch"> <input type="checkbox" value="'+row.id+'">  <div class="slider round"> </div></label>';
                        }

                        return str;
                    }
                },
                {
                    data : 'id',
                    bSortable : false,
                    mRender : function(data, type, row) {

                        var str = '';
                        str += '<a href="'
                            + window.contextRoot
                            + '/manage/'
                            + data
                            + '/product" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';

                        return str;
                    }
                }
            ],


            initComplete: function () {
                var api = this.api();
                api.$('.switch input[type="checkbox"]').on('change' , function() {
                    var dText = (this.checked)? 'You want to activate the Product?': 'You want to de-activate the Product?';
                    var checked = this.checked;
                    var checkbox = $(this);
                    debugger;
                    bootbox.confirm({
                        size: 'medium',
                        title: 'Product Activation/Deactivation',
                        message: dText,
                        callback: function (confirmed) {
                            if (confirmed) {
                                $.ajax({
                                    type: 'GET',
                                    url: window.contextRoot + '/manage/product/'+checkbox.prop('value')+'/activation',
                                    timeout : 100000,
                                    success : function(data) {
                                        bootbox.alert(data);
                                    },
                                    error : function(e) {
                                        bootbox.alert('ERROR: '+ e);
                                        //display(e);
                                    }
                                });
                            }
                            else {
                                checkbox.prop('checked', !checked);
                            }
                        }
                    });
                });

            }
        });
    }


// validating the product form element
    // fetch the form element
    var $categoryForm = $('#categoryForm');

    if($categoryForm.length) {

        $categoryForm.validate({
                rules: {
                    name: {
                        required: true,
                        minlength: 3
                    },
                    description: {
                        required: true,
                        minlength: 3
                    }
                },
                messages: {
                    name: {
                        required: 'Please enter product name!',
                        minlength: 'Please enter atleast five characters'
                    },
                    description: {
                        required: 'Please enter product name!',
                        minlength: 'Please enter atleast five characters'
                    }
                },
                errorElement : "em",
                errorPlacement : function(error, element) {
                    errorPlacement(error, element);
                }
            }

        );

    }

    function errorPlacement(error, element) {
        // Add the 'help-block' class to the error element
        error.addClass("help-block");

        // add the error label after the input element
        error.insertAfter(element);


        // add the has-feedback class to the
        // parent div.validate in order to add icons to inputs
        element.parents(".validate").addClass("has-feedback");

    }



});