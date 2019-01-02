<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">

    <div class="row">


        <%--To display sidebar--%>
        <div class="col-lg-3">

            <%@include file="shared/sidebar.jsp"%>

        </div>

        <%--To display products--%>
        <div class="col-md-9">

            <%--added breadcrumb component--%>
            <div class="row">

                <div class="col-lg-12">

                    <c:if test="${userClickAllProducts == true}">
                    <ol class="breadcrumb">

                        <li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
                        <li class="breadcrumb-item active">All products</li>
                    </ol>
                    </c:if>

                    <c:if test="${userClickCategoryProducts == true}">
                        <ol class="breadcrumb">

                            <li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
                            <li class="breadcrumb-item active">Category</li>
                            <li class="breadcrumb-item active">${category.name}</li>
                        </ol>
                    </c:if>
                </div>
            </div>


                <%--Added data table plugin--%>
            <div class="row">

                <div class="col-xl-12">

                    <table id="productListTable" class="table table-striped table-bordered">

                        <thead>

                        <tr>

                            <th>ID</th>
                            <th>Name</th>

                        </tr>

                        </thead>

                    </table>

                </div>

            </div>
        </div>

    </div>

</div>