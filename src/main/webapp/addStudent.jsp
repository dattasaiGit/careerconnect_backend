<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Student</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f8f9fa;
        }

        .card {
            display: flex;
            max-width: 500px;
            margin: 50px auto;
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }

        .form-section {
            width: 100%;
            padding: 30px;
            box-sizing: border-box;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
            color: #555;
            font-weight: bold;
        }

        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 14px;
        }

        .form-group input:focus {
            border-color: #007bff;
            outline: none;
        }

        button[type="submit"] {
            width: 100%;
            padding: 12px;
            background-color: #28a745;
            border: none;
            border-radius: 5px;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button[type="submit"]:hover {
            background-color: #218838;
        }

        .register-link {
            text-align: center;
            margin-top: 20px;
        }

        .register-link a {
            color: #007bff;
            text-decoration: underline;
            cursor: pointer;
        }
    </style>
</head>
<body>
	
    <div class="card">
    
        <div class="form-section">
        <h4 align="center" style="color:red; font-size:24px">
	  	<c:out value="${message}"></c:out>
	  	</h4>
            <h2>Add Student</h2>
            <form method="post" action="insertstudent">
                <div class="form-group">
                    <label for="studentId">Student ID *</label>
                    <input type="number" name="id" placeholder="Enter Student ID" required>
                </div>
                <div class="form-group">
                    <label for="studentName">Name *</label>
                    <input type="text" name="name" placeholder="Enter your name" required>
                </div>
                <div class="form-group">
                    <label for="studentGender">Gender *</label>
                    <input type="text" name="gender" placeholder="Enter your gender" required>
                </div>
                <div class="form-group">
                    <label for="studentDOB">Date of Birth *</label>
                    <input type="date" name="dob" required>
                </div>
                <div class="form-group">
                    <label for="studentDepartment">Department *</label>
                    <input type="text" name="department" placeholder="Enter your department" required>
                </div>
                <div class="form-group">
                    <label for="studentEmail">Email *</label>
                    <input type="email" name="email" placeholder="Enter your email" required>
                </div>
                <div class="form-group">
                    <label for="studentPassword">Password *</label>
                    <input type="password" name="password" placeholder="Enter your password" required>
                </div>
                <div class="form-group">
                    <label for="studentContact">Contact *</label>
                    <input type="text" name="contact" placeholder="Enter your contact number" required>
                </div>
                <button type="submit">Add Student</button>
            </form>
        </div>
    </div>

</body>
</html>
