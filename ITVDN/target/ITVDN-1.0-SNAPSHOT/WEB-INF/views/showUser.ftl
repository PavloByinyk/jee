<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User info</title>
</head>
<body>
<h1 style="text-align: center">User Info</h1>

    <table>
        <tr>
            <td>Id</td>
            <td>${user.id}</td>
        </tr>
        <tr>
            <td>Name</td>
            <td>${user.name}</td>
        </tr>
        <tr>
            <td>Age</td>
            <td>${user.age}</td>
        </tr><tr>
            <td>Email</td>
            <td>${user.email}</td>
        </tr>
    </table>

<br>
<a href="users">Back</a>
</body>
</html>