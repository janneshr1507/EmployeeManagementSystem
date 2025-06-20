<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Employee</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 50px;
            background-color: #f9f9f9;
        }

        h2 {
            color: #2c3e50;
        }

        form {
            background-color: #ffffff;
            padding: 25px;
            width: 400px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="tel"] {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #3498db;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #2980b9;
        }

        a {
            display: inline-block;
            margin-top: 20px;
            text-decoration: none;
            color: #3498db;
        }
    </style>
</head>
<body>

    <h2>Add New Employee</h2>

    <form action="/add" method="post" modelAttribute="employee">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>

        <label for="contact">Contact:</label>
        <input type="tel" id="contact" name="contact" required>

        <label for="role">Role:</label>
        <input type="text" id="role" name="role" required>

        <label for="department">Department:</label>
        <input type="text" id="department" name="department" required>

        <input type="submit" value="Add Employee">
    </form>

    <a href="/">&#8592; Back to Home</a>

</body>
</html>
