<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Admin</title>
  <!-- Linking Google Font Link For Icons -->
  <link rel="stylesheet"
    href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
  <!-- Linking external CSS file -->
  <link rel="stylesheet" href="AdminStyle.css" />
</head>
<body>
  <aside class="sidebar">
    <div class="sidebar-header">
      <img src="images/logo.png" alt="logo" />
      <h2>Career Connects</h2>
    </div>
    <ul class="sidebar-links">
      <h4>
        <span>Main Menu</span>
        <div class="menu-separator"></div>
      </h4>
      <li>
        <a href="Adminhome.html">
          <span class="material-symbols-outlined"> dashboard </span>Dashboard
        </a>
      </li>
      <li>
        <a href="adminreports.html">
          <span class="material-symbols-outlined"> monitoring </span>Reports
        </a>
      </li>
      <li>
        <a href="adminverify.html">
          <span class="material-symbols-outlined"> verified </span>Verify Users
        </a>
      </li>
      <h4>
        <span>Users</span>
        <div class="menu-separator"></div>
      </h4>
      <li class="dropdown">
        <a href="javascript:void(0);" class="dropdown-btn" onclick="toggleDropdown(event)">
          <span class="material-symbols-outlined"> person </span>Student
          <span class="material-symbols-outlined dropdown-icon"> expand_more </span>
        </a>
        <ul class="dropdown-menu">
          <li><a href="adminstudents.html"><span class="material-symbols-outlined"> visibility </span>View Students</a></li>
          <li><a href="adminstudentsdelete.html"><span class="material-symbols-outlined"> delete </span>Delete Students</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a href="javascript:void(0);" class="dropdown-btn" onclick="toggleDropdown(event)">
          <span class="material-symbols-outlined"> person </span>Placement Officer
          <span class="material-symbols-outlined dropdown-icon"> expand_more </span>
        </a>
        <ul class="dropdown-menu">
          <li><a href="#"><span class="material-symbols-outlined"> visibility </span>View Placement Officers</a></li>
          <li><a href="#"><span class="material-symbols-outlined"> delete </span>Delete Placement Officers</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a href="javascript:void(0);" class="dropdown-btn" onclick="toggleDropdown(event)">
          <span class="material-symbols-outlined"> person </span>Recruiter
          <span class="material-symbols-outlined dropdown-icon"> expand_more </span>
        </a>
        <ul class="dropdown-menu">
          <li><a href="#"><span class="material-symbols-outlined"> visibility </span>View Recruiters</a></li>
          <li><a href="#"><span class="material-symbols-outlined"> delete </span>Delete Recruiters</a></li>
        </ul>
      </li>
    </ul>
  </aside>

  <div class="user-account">
    <ul>
      <li>
        <a href="#"><span class="material-symbols-outlined"> notifications_active </span>Notifications</a>
      </li>
      <li>
        <a href="#"><span class="material-symbols-outlined"> account_circle </span>Profile</a>
      </li>
      <li>
        <a href="adminlogin"><span class="material-symbols-outlined"> logout </span>Logout</a>
      </li>
    </ul>
  </div>

  <div class="dashboard-container">
    <!-- Total Number of Students Registered -->
    <div class="card">
      <span class="material-symbols-outlined card-icon">school</span>
      <div class="card-title">Total Students Registered</div>
      <div class="card-number">2,450</div>
    </div>

    <div class="card">
      <span class="material-symbols-outlined card-icon">business</span>
      <div class="card-title">Total Companies Registered</div>
      <div class="card-number">180</div>
    </div>

    <div class="card">
      <span class="material-symbols-outlined card-icon">work</span>
      <div class="card-title">Active Placements</div>
      <div class="card-number">12</div>
    </div>

    <div class="card">
      <span class="material-symbols-outlined card-icon">event</span>
      <div class="card-title">Upcoming Placement Drives</div>
      <div class="card-number">5</div>
    </div>

    <div class="card">
      <span class="material-symbols-outlined card-icon">emoji_events</span>
      <div class="card-title">Placed Students</div>
      <div class="card-number">1,320</div>
    </div>

    <div class="card">
      <span class="material-symbols-outlined card-icon">pending</span>
      <div class="card-title">Pending Applications</div>
      <div class="card-number">340</div>
    </div>
  </div>

  <script>
    function toggleDropdown(event) {
      // Prevents the dropdown from collapsing when clicking on the already open menu
      const allDropdowns = document.querySelectorAll('.dropdown-menu');
      const currentDropdown = event.currentTarget.nextElementSibling;

      // Close all other dropdowns
      allDropdowns.forEach(dropdown => {
        if (dropdown !== currentDropdown) {
          dropdown.classList.remove('active');
        }
      });

      // Toggle the current dropdown
      currentDropdown.classList.toggle('active');
    }
  </script>
</body>
</html>
