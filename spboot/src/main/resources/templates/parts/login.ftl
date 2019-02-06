<#macro login path isRegisterForm>
    <form action="${path}" method="post">
<#--<div class="form-group">-->
<#--<label for="staticEmail" class="col-sm-2 col-form-label"> User Name : </label>-->
<#--<div class="col-sm-10">-->
<#--<input id="staticEmail" class="form-control" type="text" name="username"/>-->
<#--</div>-->
<#--</div>-->

<div class="form-group row">
    <label for="staticName" class="col-sm-2 col-form-label">User Name :</label>
    <div class="col-sm-6">
        <input type="text" class="form-control-plaintext ${(usernameError??)?string('is-invalid', '')}"
               id="staticName" placeholder="User name" name="username" <#if username??> value="${user.username}"</#if>>
        <#if usernameError??>
            <div class="invalid-feedback">
            ${usernameError}
            </div>
        </#if>
    </div>
</div>
<div class="form-group row">
    <label for="staticPass" class="col-sm-2 col-form-label"> Password: </label>
    <div class="col-sm-6">
        <input type="password" class="form-control ${(passwordError??)?string('is-invalid', '')}" id="staticPass" placeholder="Password" name="password">
        <#if passwordError??>
            <div class="invalid-feedback">
            ${passwordError}
            </div>
        </#if>
    </div>
</div>
<#if isRegisterForm >
    <div class="form-group row">
        <label for="staticPass2" class="col-sm-2 col-form-label"> Password: </label>
        <div class="col-sm-6">
            <input type="password" class="form-control ${(password2Error??)?string('is-invalid', '')}" id="staticPass2" placeholder=" Retype Password" name="password2">
            <#if password2Error??>
                <div class="invalid-feedback">
                ${password2Error}
                </div>
            </#if>
        </div>
    </div>

<div class="form-group row">
    <label for="staticPass" class="col-sm-2 col-form-label"> Email: </label>
    <div class="col-sm-6">
        <input type="email" class="form-control ${(emailError??)?string('is-invalid', '')}"
            placeholder="some@some.com" name="email" <#if email??> value="${user.email}"</#if>>
        <#if emailError??>
            <div class="invalid-feedback">
            ${emailError}
            </div>
        </#if>
    </div>
</div>
    <div class="col-sm-6">
        <div class="g-recaptcha" data-sitekey="6LcBC48UAAAAAEDeEok0mJgc-Je4n-72l1gwidKy"></div>
        <#if capchaError??>
            <div class="alert alert-danger" role="alert">
                ${capchaError}
            </div>
        </#if>
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
    <button class="btn btn-primary mb-2" type="submit"><#if user??>Sign out<#else>Log in</#if></button>
    </form>
    </div>
</#macro>