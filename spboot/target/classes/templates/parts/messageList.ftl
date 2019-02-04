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
            <div class="card-footer">
                ${message.userName}
            </div>
        </div>
    <#else>
        No messages
    </#list>
</div>