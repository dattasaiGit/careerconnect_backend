<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login with Roles</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f8f9fa;
        }
        .card {
            display: flex;
            max-width: 900px;
            margin: 50px auto;
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            height: 600px;
        }
        .form-section, .photo-section {
            width: 55%;
            padding: 30px;
            box-sizing: border-box;
        }
        .form-section {
            background-color: #f8f9fa;
        }
        .photo-section {
            flex: 1;
            padding: 0;
            background-color: #f0f0f0;
        }

        .photo-section img {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }
        
        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        .role-selection {
            display: flex;
            justify-content: center;
            margin-bottom: 20px;
        }

        .role-selection button {
            position: center;
            width: 30%;
            height: 120px;
            padding: 0;
            cursor: pointer;
            background: none;
            border: 3px solid transparent;
            border-radius: 10px;
            transition: border-color 0.3s;
        }

        .role-selection button img {
            width: 100%;
            height: 100%;
            object-fit: cover;
            border-radius: 10px;
        }

        .role-selection button.active {
            border-color: #000;
        }

        .role-form {
            display: none;
        }

        .role-form.active {
            display: block;
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

        .forgot-password {
            display: block;
            margin-top: 10px;
            text-align: center;
            color: #007bff;
            cursor: pointer;
            transition: color 0.3s;
        }

        .forgot-password:hover {
            color: #0056b3;
            text-decoration: underline;
        }

        .register-link {
            text-align: center;
            margin-top: 20px;
        }

        .register-link a {
            color: #007bff;
            cursor: pointer;
            transition: color 0.3s;
        }

        .register-link a:hover {
            color: #0056b3;
            text-decoration: underline;
        }

        @media (max-width: 768px) {
            .card {
                flex-direction: column;
                height: auto;
            }
            .form-section, .photo-section {
                width: 100%;
                padding: 20px;
            }
            .photo-section img {
                height: auto;
                object-fit: contain;
            }
            .role-selection button {
                height: 100px;
            }
        }
    </style>
</head>
<body>
    <div class="card">
      
        <div class="photo-section">
            <img src="images/reg.jpeg" alt="Login Image">
        </div>	  	
        <div class="form-section">
            <h2> Admin Login</h2>
            <div class="role-selection">
                <button id="adminBtn" class="active">
                    <img src="images/admin.png" alt="admin">
                </button>
            </div>
            <h4 align="center" style="color:red; font-size:24px">
	  		<c:out value="${message}"></c:out>
	  		</h4>
            <form id="studentForm" class="role-form active" action="checkadminlogin" method="post">
                <div class="form-group">
                    <label for="studentEmail">Email *</label>
                    <input type="text" name="email" placeholder="Enter your email" required>
                </div>
                <div class="form-group">
                    <label for="studentPassword">Password *</label>
                    <input type="password" name="password" placeholder="Enter your password" required>
                </div>
                <button type="submit">Login as Admin</button>
                <br></br>
                <a class="forgot-password">Forgot Password?</a>
            </form>
        </div>

    
</body>
</html>
