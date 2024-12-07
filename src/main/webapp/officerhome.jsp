<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Placement Officer Dashboard</title>
  <!-- Google Fonts -->
  <link rel="stylesheet"
    href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
  <!-- External CSS -->
  <link rel="stylesheet" href="officer.css" />
</head>
<body>
  <aside class="sidebar">
    <div class="sidebar-header">
      <img src="images/logo.png" alt="logo" />
      <h2>Career Connect</h2>
    </div>
    <ul class="sidebar-links">
      <h4>
        <span>Main Menu</span>
        <div class="menu-separator"></div>
      </h4>
      <li>
        <a href="#">
          <span class="material-symbols-outlined"> dashboard </span>Dashboard
        </a>
      </li>
      <li>
        <a href="#">
          <span class="material-symbols-outlined"> assessment </span>Progress Overview
        </a>
      </li>
      <li>
        <a href="#">
          <span class="material-symbols-outlined"> monitoring </span>Reports
        </a>
      </li>
      <h4>
        <span>Student Management</span>
        <div class="menu-separator"></div>
      </h4>
      <li class="dropdown">
        <a href="javascript:void(0);" class="dropdown-btn" onclick="toggleDropdown(event)">
          <span class="material-symbols-outlined"> group </span>Students
          <span class="material-symbols-outlined dropdown-icon"> expand_more </span>
        </a>
        <ul class="dropdown-menu">
          <li><a href="addStudent"><span class="material-symbols-outlined"> person_add </span>Add Student</a></li>
          <li><a href="#"><span class="material-symbols-outlined"> visibility </span>View Students</a></li>
          <li><a href="#"><span class="material-symbols-outlined"> delete </span>Remove Student</a></li>
          <li><a href="#"><span class="material-symbols-outlined"> progress_activity </span>Track Progress</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a href="javascript:void(0);" class="dropdown-btn" onclick="toggleDropdown(event)">
          <span class="material-symbols-outlined"> event </span>Workshops
          <span class="material-symbols-outlined dropdown-icon"> expand_more </span>
        </a>
        <ul class="dropdown-menu">
          <li><a href="#"><span class="material-symbols-outlined"> add </span>Add Workshop</a></li>
          <li><a href="#"><span class="material-symbols-outlined"> visibility </span>View Workshops</a></li>
        </ul>
      </li>
    </ul>
  </aside>

  <div class="main-content">
    <header class="user-account">
      <ul>
        <li>
          <a href="#"><span class="material-symbols-outlined"> notifications_active </span>Notifications</a>
        </li>
        <li>
          <a href="#"><span class="material-symbols-outlined"> account_circle </span>Profile</a>
        </li>
        <li>
          <a href="login.html"><span class="material-symbols-outlined"> logout </span>Logout</a>
        </li>
      </ul>
    </header>

    <!-- Main Dashboard Section -->
    <section class="dashboard">
      <h1>Welcome, Placement Officer</h1>
      <div class="dashboard-cards">
        <div class="card">
          <span class="material-symbols-outlined"> group </span>
          <h3>Total Students</h3>
          <p>150</p>
        </div>
        <div class="card">
          <span class="material-symbols-outlined"> assessment </span>
          <h3>Reports Generated</h3>
          <p>35</p>
        </div>
        <div class="card">
          <span class="material-symbols-outlined"> event </span>
          <h3>Upcoming Workshops</h3>
          <p>5</p>
        </div>
      </div>

      <!-- New Section: Detailed Analytics -->
      <section class="progress-overview">
        <h2>Progress Analytics</h2>
        <div class="progress-cards">
          <div class="progress-card">
            <h3>Top Performing Students</h3>
            <ul>
              <li>John Doe - 90%</li>
              <li>Jane Smith - 88%</li>
              <li>Mike Ross - 85%</li>
            </ul>
          </div>
          <div class="progress-card">
            <h3>Recent Reports</h3>
            <ul>
              <li>Report 1: Student Performance Overview</li>
              <li>Report 2: Workshop Attendance</li>
              <li>Report 3: Placement Success Rate</li>
            </ul>
          </div>
        </div>
      </section>

      <!-- New Section: Recent Activities -->
      <section class="recent-activities">
        <h2>Recent Activities</h2>
        <ul>
          <li>Student John Doe registered for Workshop "AI Trends 2024"</li>
          <li>Report "Placement Success Rate" generated on 2024-10-02</li>
          <li>New Student Jane Smith added</li>
        </ul>
      </section>

      <!-- New Section: Upcoming Events -->
      <section class="upcoming-events">
        <h2>Upcoming Events</h2>
        <ul>
          <li>Workshop: "Data Science Bootcamp" on 2024-10-10</li>
          <li>Mock Interview Session on 2024-10-12</li>
          <li>Company Visit: "Tech Innovations Ltd." on 2024-10-20</li>
        </ul>
      </section>

      <!-- New Section: Announcements -->
      <section class="announcements">
        <h2>Announcements</h2>
        <p>No new announcements at this time.</p>
      </section>
    </section>
 
  </section>
</div>

<!-- JavaScript for dropdown -->
<script>
  function toggleDropdown(event) {
    const allDropdowns = document.querySelectorAll('.dropdown-menu');
    const currentDropdown = event.currentTarget.nextElementSibling;
    allDropdowns.forEach(dropdown => {
      if (dropdown !== currentDropdown) {
        dropdown.classList.remove('active');
      }
    });
    currentDropdown.classList.toggle('active');
  }
</script>
</body>
</html>
