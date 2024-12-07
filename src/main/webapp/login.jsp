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
            justify-content: space-between;
            margin-bottom: 20px;
        }

        .role-selection button {
            position: relative;
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
            border-color: #007bff;
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
        button[type="button"] {
    width: 100%;
    padding: 12px;
    background-color: #007bff; 
    border: none;
    border-radius: 5px;
    color: #fff;
    font-size: 16px;
    cursor: pointer;
    transition: background-color 0.3s;
}
button[type="button"] a{
    text-decoration: none;
    color:#fff
}

button[type="button"]:hover {
    background-color: #0056b3; 
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
            <h2>Login</h2>
              <h4 align="center" style="color:red; font-size:24px">
	  			<c:out value="${message}"></c:out>
	  		  </h4>
            <div class="role-selection">
                <button id="studentBtn" class="active" onclick="showForm('studentForm')">
                    <img src="images/student.png" alt="Student">
                </button>
                <button id="placementofficerBtn" onclick="showForm('placementofficerForm')">
                    <img src="images/placement_officer.png" alt="Placement Officer">
                </button>
                <button id="recruiterBtn" onclick="showForm('recruiterForm')">
                    <img src="images/recruiter.png" alt="Recruiter">
                </button>
            </div>

            
            <form id="studentForm" class="role-form active" method="post" action="checkstudentlogin">
                <div class="form-group">
                    <label for="studentEmail">Email *</label>
                    <input type="email" name="email" placeholder="Enter your email" required>
                </div>
                <div class="form-group">
                    <label for="studentPassword">Password *</label>
                    <input type="password" name="password" placeholder="Enter your password" required>
                </div>
                <button type="submit">Login as Student</button>
                <br></br>
                <button type="button"><a href="adminlogin">Admin Login</a></button>
                <br></br>
                <a class="forgot-password">Forgot Password?</a>
            </form>

             
            <form id="placementofficerForm" class="role-form" method="post" action="checkofficerlogin">
                <div class="form-group">
                    <label for="placementofficerEmail">Email *</label>
                    <input type="email" name="email" placeholder="Enter your email" required>
                </div>
                <div class="form-group">
                    <label for="placementofficerPassword">Password *</label>
                    <input type="password" name="password" placeholder="Enter your password" required>
                </div>
                <button type="submit">Login as Placement Officer</button>
                <br></br>
                <button type="button"><a href="adminlogin">Admin Login</a></button>
                <br></br>
                <a class="forgot-password">Forgot Password?</a>
            </form>

            <!-- Recruiter Form -->
            <form id="recruiterForm" class="role-form" method="post" action="checkrecruiterlogin">
                <div class="form-group">
                    <label for="recruiterEmail">Email *</label>
                    <input type="email" name="email" placeholder="Enter your email" required>
                </div>
                <div class="form-group">
                    <label for="recruiterPassword">Password *</label>
                    <input type="password" name="password" placeholder="Enter your password" required>
                </div>
                <button type="submit">Login as Recruiter</button>
                <br></br>
                <button type="button"><a href="adminlogin">Admin Login</a></button>
                <br></br>
                <a class="forgot-password">Forgot Password?</a>

            </form>

            <div class="register-link">
                Don't have an account? <a href="signup.html">Register</a>
            </div>
        </div>
    </div>

    <script>
        function showForm(formId) {
            
            document.getElementById('studentForm').classList.remove('active');
            document.getElementById('placementofficerForm').classList.remove('active');
            document.getElementById('recruiterForm').classList.remove('active');
            document.getElementById('studentBtn').classList.remove('active');
            document.getElementById('placementofficerBtn').classList.remove('active');
            document.getElementById('recruiterBtn').classList.remove('active');
    
            
            document.getElementById(formId).classList.add('active');
    
         
            if (formId === 'studentForm') {
                document.getElementById('studentBtn').classList.add('active');
            } else if (formId === 'placementofficerForm') {
                document.getElementById('placementofficerBtn').classList.add('active');
            } else {
                document.getElementById('recruiterBtn').classList.add('active');
            }
        }
    </script>
    
</body>
</html>

