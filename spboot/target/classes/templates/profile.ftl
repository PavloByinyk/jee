<#import "parts/common.ftl" as c>

<@c.page>
    Profile page ${username}
    ${message?if_exists}

    <form method="post">

            <div class="form-group row">
                <label for="staticPass" class="col-sm-2 col-form-label"> Password: </label>
                <div class="col-sm-6">
                    <input type="password" class="form-control" id="inputPassword" placeholder="Password" name="password">
                </div>
            </div>
                <div class="form-group row">
                    <label for="staticPass" class="col-sm-2 col-form-label"> Email: </label>
                    <div class="col-sm-6">
                        <input type="email" class="form-control" placeholder="some@some.com" name="email" <#if email??>value="${email}</#if>">
                    </div>
                </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button class="btn btn-primary mb-2" type="submit">Save</button>
    </form>


</@c.page>