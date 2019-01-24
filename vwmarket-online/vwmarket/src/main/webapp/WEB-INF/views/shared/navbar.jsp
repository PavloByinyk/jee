<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="${contextRoot}/home">vwMarket</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li id="home" class="nav-item">
                    <a class="nav-link" href="${contextRoot}/home">Home</a>
                </li>
                <li id="about" class="nav-item">
                    <a class="nav-link" href="${contextRoot}/about">About Us</a>
                </li>
                <li id="listProducts" class="nav-item">
                    <a class="nav-link" href="${contextRoot}/show/all/products">View Products</a>
                </li>
                <li id="contact" class="nav-item">
                    <a class="nav-link" href="${contextRoot}/contact">Contact</a>
                </li>
                <security:authorize access="hasAuthority('ADMIN')">
                    <li id="manageProducts" class="nav-item">
                        <a class="nav-link" href="${contextRoot}/manage/products">Manage Products</a>
                    </li>
                </security:authorize>
            </ul>


            <ul class="nav navbar-nav navbar-right">
                <security:authorize access="isAnonymous()">
                    <li id="register" class="nav-item">
                        <a class="nav-link" href="${contextRoot}/register">Sign up</a>
                    </li>
                    <li id="login">
                        <a class="nav-link" href="${contextRoot}/login">Login</a>
                    </li>
                </security:authorize>

                <%--dropdown menu--%>
                <%--<li class="dropdown">--%>
                    <%--<a href="javascript:void(0)" class="btn btn dropdown-toggle" id="dropdownMenu1" data-togle="dropdown">--%>
                            <%--Full name--%>
                        <%--<span class="dropdown-menu"></span>--%>
                    <%--</a>--%>
                    <%--<ul class="dropdown-menu">--%>
                        <%--<li>--%>
                            <%--<a href="${contextRoot}/cart">--%>
                                <%--<span>Shoping cart</span>--%>
                                <%--<span class="badge">0</span>--%>
                                <%--- &#8377; 0.0--%>
                            <%--</a>--%>
                        <%--</li>--%>
                        <%--<li class="divider" role="separator"></li>--%>
                        <%--<li>--%>
                            <%--<a href="${contextRoot}/logout"></a>--%>
                        <%--</li>--%>
                    <%--</ul>--%>
                <%--</li>--%>

                <security:authorize access="isAuthenticated()">
                <div class="dropdown" id="userCart">
                    <button class="btn-success btn dropdown-toggle" type="button" data-toggle="dropdown">
                        <%--${userModel.fullName}--%>
                    </button>
                    <%--<div class="dropdown-menu">--%>
                        <ul class="dropdown-menu">  </li><li>
                            ${userModel.fullName}
                        </li>

                            <security:authorize access="hasAuthority('USER')">
                                <li>
                                    <a href="${contextRoot}/cart/show">
                                        <span>Shoping cart</span>
                                        <span class="badge">${userModel.cart.cartLines}</span>
                                        - &#8377; ${userModel.cart.grandTotal}
                                    </a>
                                </li>
                            </security:authorize>
                            <li class="divider" role="separator"></li>
                            <li>
                                <a href="${contextRoot}/perform-logout">Logout</a>

                        </ul>
                    <%--</div>--%>
                </div>
                </security:authorize>

            </ul>


        </div>
    </div>
</nav>

<script>
    window.userRole = '${userModel.role}';
</script>
