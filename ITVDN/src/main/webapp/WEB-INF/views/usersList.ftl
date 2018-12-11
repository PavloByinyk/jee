<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1>users list</h1>
    <br>

    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Age</th>
            <th>Email</th>
        </tr>

        <#list users as user>
        <tr>
            <td><a href="user/${user.id}">${user.id}</a></td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.email}</td>
            <td><a href="update/${user.id}">Update</a></td>
            <td><a href="delete/${user.id}">Delete</a></td>
        </tr>
        </#list>

    </table>

    <a href="addUser">Add user</a>


</body>
</html>