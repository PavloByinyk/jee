

<h1 class="my-4">Shop Name</h1>
<div class="list-group">

    <c:forEach items="${list}" var="category">

        <a id="a_${category.name}" href="${contextRoot}/show/category/${category.id}/products" class="list-group-item">${category.name}</a>

    </c:forEach>
</div>