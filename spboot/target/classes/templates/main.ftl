<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<body>

    <#--<div>-->
        <#--<form action="/logout" method="post">-->
            <#--<input type="hidden" name="_csrf" value="{{_csrf.token}}"/>-->
            <#--<input type="submit" value="Sign Out"/>-->
        <#--</form>-->
    <#--</div>-->
    <@l.logout "/logout"/>
    <span><a href="/user">User list</a></span>
    <div>
        <form method="post" action="/add" enctype="multipart/form-data">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input type="text" name="text" placeholder="Put message here">
            <input type="text" name="tag" placeholder="Tag">
            <input type="file" name="file">
            <button type="submit">Add</button>
        </form>
    </div>

    <div>List of messages</div>

    <form method="get" action="/main">
        <#--<input type="hidden" name="_csrf" value="${_csrf.token}"/>-->
        <input type="text" name="filter"  <#if filter??> value="${filter}"</#if>
>
        <button type="submit">Find</button>
    </form>

   <#list  messages as message>
    <div>
        <b>${message.id}</b>
        <span>${message.text}</span>
        <i>${message.tag}</i>
        <strong>${message.userName}</strong>
       <div>
           <#if message.filename??>
               <img src="/img/${message.filename}">
           </#if>
       </div>
    </div>
    <#else> No messages
</#list>


</body>
</html>
</@c.page>
