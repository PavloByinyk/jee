
<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Message Editor
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
                <input type="hidden" name="id" class="custom-file-input" value="<#if message??>${message.id}</#if>">
                <label class="custom-file-label" for="customFile">Choose file</label>
            </div>
            <button type="submit" class="btn btn-primary">Save message</button>
        </form>
    </div>
</div>