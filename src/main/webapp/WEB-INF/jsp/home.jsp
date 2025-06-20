<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 50px;
            text-align: center;
        }
        h1 {
            color: #2c3e50;
        }
        .button-container {
            margin-top: 40px;
        }
        .btn {
            display: block;
            margin: 15px auto;
            padding: 12px 25px;
            width: 200px;
            font-size: 16px;
            cursor: pointer;
            text-decoration: none;
            color: white;
            background-color: #3498db;
            border: none;
            border-radius: 5px;
        }
        .btn:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>

    <h1>Employee Management System</h1>

    <div class="button-container">
        <a href="/add" class="btn">Add Employee</a>
        <a href="/update" class="btn">Update Employee</a>
        <a href="/delete" class="btn">Delete Employee</a>
        <a href="/search" class="btn">Search Employee</a>
    </div>

</body>
</html>
