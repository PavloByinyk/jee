<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create user</title>
</head>
<body>

    <form name="user" action="updateUser" method="post">
        Id
        <input title="id" type="text" name="id" value="${user.id}">
        Name
        <input title="name" type="text" name="name" value="${user.name}">
        Age
        <input title="age" type="text" name="age" value="${user.age}">
        Email
        <input title="email" type="text" name="email" value="${user.email}">
        <input type="submit" value="Ok">

    </form>

</body>
</html>