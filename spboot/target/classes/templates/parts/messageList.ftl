<#include "security.ftl">
<#import "pager.ftl" as p>

<@p.pager url page/>

<div class="card-columns">

    <#list  page.content as message>
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
                <a class="col align-self-center" href="/messages/${message.id}/like">
                    <#if message.meLiked>
                        <i class="fas fa-heart"></i>
                    <#else>
                        <i class="far fa-heart"></i>
                    </#if>
                    ${message.likes}
                </a>
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

<@p.pager url page/>
