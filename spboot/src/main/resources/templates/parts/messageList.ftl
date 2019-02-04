<#include "security.ftl">

<div class="card-columns">
    <#list  messages as message>
        <div class="card my-3">
            <#if message.filename??>
                <img class="card-img-top" src="/img/${message.filename}">
            </#if>
            <div class="m-2">
                <#--<b>${message.id}</b>-->
                <span>${message.text}</span>
                <i>${message.tag}</i>
            </div>
            <div class="card-footer text-muted">
                <a href="/user-messages/${message.user.id}"> ${message.userName}</a>
                <#if message.user.id == currentUserId>
                <a class="btn btn-primary" href="/user-messages/${message.user.id}?message=${message.id}">
                    Edit message
                </a>
                </#if>
            </div>
        </div>
    <#else>
        No messages
    </#list>
</div>