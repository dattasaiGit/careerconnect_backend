<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration with Roles</title>
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
            height: 800px;
        }

        .form-section, .photo-section {
            width: 55%;
            padding: 30px;
            box-sizing: border-box;
        }

        .photo-section {
            flex: 1;
            padding: 0px;
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
            width: 48%;
            height: 120px;
            padding: 0;
            cursor: pointer;
            background: none;
            border: 3px solid transparent;
            border-radius: 10px;
            transition: border-color 0.3s;
        }

        .role-selection button img {
            width: 150px;
            height: 100px;
            object-fit: cover;
            border-radius: 10px;
            align-content: center;
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

        .register-link {
            text-align: center;
            margin-top: 20px;
        }

        .register-link a {
            color: #007bff;
            text-decoration: underline;
            cursor: pointer;
        }

       
        .placement-image-card {
            margin: 20px 0;
            text-align: center;
            height: 800px;
        }

        .placement-image-card img {
            max-width: 100%;
            height: auto;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
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
                height: 200px;
                width: 100px;
            }
        }
    </style>
</head>
<body>

    <div class="card">
        <div class="form-section">
            <h2>Register</h2>
              <h4 align="center" style="color:red; font-size:24px">
	  	<c:out value="${message}"></c:out>
	  	</h4>
            <div class="role-selection">
                <button id="recruiterBtn" class="active" onclick="showForm('recruiterForm')">
                    <img src="images/recruiter.png" alt="Recruiter">
                </button>
                <button id="placementofficerBtn" onclick="showForm('placementofficerForm')">
                    <img src="images/placement_officer.png" alt="Placement Officer">
                </button>
            </div>
            
            <form id="recruiterForm" class="role-form active" method="post" action="insertrecruiter">
                <div class="form-group">
                    <label for="recruiterName">Name *</label>
                    <input type="text" name="rname" placeholder="Enter your name" required>
                </div>
                <div class="form-group">
                    <label for="recruiterCompany">Company</label>
                    <input type="text" name="rcompany" placeholder="Enter your company">
                </div>
                <div class="form-group">
                    <label for="recruiterGender">Gender *</label>
                    <input type="text" name="rgender" placeholder="Enter your Gender" required>
                </div>
                <div class="form-group">
                    <label for="recruiterEmail">Email *</label>
                    <input type="email" name="remail" placeholder="Enter your email" required>
                </div>
                <div class="form-group">
                    <label for="recruiterPassword">Password *</label>
                    <input type="password" name="rpassword" placeholder="Enter your password" required>
                </div>
                <div class="form-group">
                    <label for="recruiterContact">Contact *</label>
                    <input type="text" name="rcontact" placeholder="Enter your contact number" required>
                </div>
                <button type="submit">Register as Recruiter</button>
                <div class="register-link">
                    Already have an account? <a href="login">Login</a>
                </div>
            </form>

            <form id="placementofficerForm" class="role-form" method="post" action="insertofficer">
                <div class="form-group">
                    <label for="placementofficerName">Name *</label>
                    <input type="text" name="pname" placeholder="Enter your name" required>
                </div>
                <div class="form-group">
                    <label for="placementofficerCollegeID">College ID *</label>
                    <input type="text" name="pcollegeid" placeholder="Enter your college ID" required>
                </div>
                  <div class="form-group">
                    <label for="placementofficerCollegeID">Gender *</label>
                    <input type="text" name="pgender" placeholder="Enter your Gender" required>
                </div>
                <div class="form-group">
                    <label for="placementofficerDepartment">Department *</label>
                    <input type="text" name="pdept" placeholder="Enter your department" required>
                </div>
                <div class="form-group">
                    <label for="placementofficerEmail">Email *</label>
                    <input type="email" name="pemail" placeholder="Enter your email" required>
                </div>
                <div class="form-group">
                    <label for="placementofficerPassword">Password *</label>
                    <input type="password" name="ppwd" placeholder="Enter your password" required>
                </div>
                <div class="form-group">
                    <label for="placementofficerContact">Contact *</label>
                    <input type="text" name="pcontact" placeholder="Enter your contact number" required>
                </div>
                <button type="submit">Register as Placement Officer</button>

                <div class="register-link">
                    Already have an account? <a href="login">Login</a>
                </div>
            </form>
        </div>

        <div class="photo-section">
            <img src="images/reg.jpeg" alt="Registration Image">
        </div>
    </div>
    
    <script>
        function showForm(formId) {
            document.getElementById('recruiterForm').classList.remove('active');
            document.getElementById('placementofficerForm').classList.remove('active');
            document.getElementById('recruiterBtn').classList.remove('active');
            document.getElementById('placementofficerBtn').classList.remove('active');

            document.getElementById(formId).classList.add('active');

            if (formId === 'recruiterForm') {
                document.getElementById('recruiterBtn').classList.add('active');
            } else {
                document.getElementById('placementofficerBtn').classList.add('active');
            }
        }
    </script>

</body>
</html>
