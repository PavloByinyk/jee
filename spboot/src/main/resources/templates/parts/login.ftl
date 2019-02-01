<#macro login path isRegisterForm>
    <form action="${path}" method="post">
<#--<div class="form-group">-->
<#--<label for="staticEmail" class="col-sm-2 col-form-label"> User Name : </label>-->
<#--<div class="col-sm-10">-->
<#--<input id="staticEmail" class="form-control" type="text" name="username"/>-->
<#--</div>-->
<#--</div>-->

<div class="form-group row">
    <label for="staticEmail" class="col-sm-2 col-form-label">User Name :</label>
    <div class="col-sm-6">
        <input type="text" class="form-control-plaintext" id="staticEmail" placeholder="User name" name="username">
    </div>
</div>
<div class="form-group row">
    <label for="staticPass" class="col-sm-2 col-form-label"> Password: </label>
    <div class="col-sm-6">
        <input type="password" class="form-control" id="inputPassword" placeholder="Password" name="password">
    </div>
</div>
<#if !isRegisterForm >
<div class="form-group row">
    <label for="staticPass" class="col-sm-2 col-form-label"> Email: </label>
    <div class="col-sm-6">
        <input type="email" class="form-control" placeholder="some@some.com" name="email">
    </div>
</div>
</#if>
<input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <#if !isRegisterForm >
        <a href="/registration">Add new user</a>
    </#if>
    <button class="btn btn-primary mb-2" type="submit">
        <#if isRegisterForm >Sign up <#else >Sign in</#if>
    </button>
    </form>
</#macro>

<#macro logout path>
    <div>
    <form action="${path}" method="post">
<input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button class="btn btn-primary mb-2" type="submit">Sign out</button>
    </form>
    </div>
</#macro>