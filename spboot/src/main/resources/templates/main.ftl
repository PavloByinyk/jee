<#import "parts/common.ftl" as c>
<#--<#import "parts/login.ftl" as l>-->

<@c.page>
<#--<div>-->
<#--<form action="/logout" method="post">-->
<#--<input type="hidden" name="_csrf" value="{{_csrf.token}}"/>-->
<#--<input type="submit" value="Sign Out"/>-->
<#--</form>-->
<#--</div>-->
<#--<span><a href="/user">User list</a></span>-->

    <div class="form-row">
         <form method="get" action="/main" class="form-inline">
            <input class="form-control" type="text" name="filter"   <#if filter??> value="${filter}"</#if> placeholder="Search by tag">
            <button type="submit" class="btn btn-primary ml-2">Search by tag</button>
        </form>
    </div>

    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Add new message
    </a>

    <div class="collapse <#if message??>show</#if>" id="collapseExample">
         <div class="form-group">
                <form method="post" action="/add" enctype="multipart/form-data">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <input type="text" name="text" placeholder="Put message here"
                           value="<#if message??>${message.text}</#if>" class="form-control ${(textError??)?string('is-invalid', '')}">
                    <#if textError??>
                        <div class="invalid-feedback">
                            ${textError}
                        </div>
                    </#if>
                    <input type="text" name="tag" placeholder="Tag"
                            value="<#if message??>${message.tag}</#if>" class="form-control ${(textError??)?string('is-invalid', '')}">
                    <#if tagError??>
                        <div class="invalid-feedback">
                        ${tagError}
                        </div>
                    </#if>
                    <div class="custom-file">
                        <input type="file" name="file" class="custom-file-input" id="customFile">
                        <label class="custom-file-label" for="customFile">Choose file</label>
                    </div>
                        <button type="submit" class="btn btn-primary">Add</button>
                </form>
          </div>
    </div>

<#--<div>List of messages</div>-->

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

</@c.page>
