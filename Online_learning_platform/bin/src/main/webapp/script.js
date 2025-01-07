function showAdminLogin() {
    document.getElementById("adminLoginForm").style.display = "block";
}

function showInstructorLogin() {
    document.getElementById("instructorLoginForm").style.display = "block";
}

function showLearnerLogin() {
    document.getElementById("learnerLoginForm").style.display = "block";
}

function showInstructorSignup() {
    document.getElementById("instructorSignupForm").style.display = "block";
}

function showLearnerSignup() {
    document.getElementById("learnerSignupForm").style.display = "block";
}

function closeLoginPopup(popupId) {
    document.getElementById(popupId).style.display = "none";
}

function adminLogin() {
    const adminEmail = document.getElementById("adminEmail").value;
    const adminPassword = document.getElementById("adminPassword").value;

    if (adminEmail === "" || adminPassword === "") {
        alert("Please enter both email and password.");
        return;
    }
    if (adminEmail === "admin" && adminPassword === "admin@123") { 
        alert("Admin Login Successful!");
        goToAdminDashboard(); 
    } else {
        alert("Invalid email or password.");
    }
}

function instructorLogin() {
    const instructorEmail = document.getElementById("instructorEmail").value;
    const instructorPassword = document.getElementById("instructorPassword").value;

    if (instructorEmail === "" || instructorPassword === "") {
        alert("Please enter both email and password.");
        return;
    }

    if (instructorEmail === "instructor@example.com" && instructorPassword === "instructor123") { 
        alert("Instructor Login Successful!");
        goToInstructorDashboard(); 
    } else {
        alert("Invalid email or password.");
    }
}

function learnerLogin() {
    const learnerEmail = document.getElementById("learnerEmail").value;
    const learnerPassword = document.getElementById("learnerPassword").value;

    if (learnerEmail === "" || learnerPassword === "") {
        alert("Please enter both email and password.");
        return;
    }
    if (learnerEmail === "learner@example.com" && learnerPassword === "learner123") { 
        alert("Learner Login Successful!");
        goToLearnerDashboard(); 
    } else {
        alert("Invalid email or password.");
    }
}

function instructorSignup() {
    const instructorSignupEmail = document.getElementById("instructorSignupEmail").value;
    const instructorSignupPassword = document.getElementById("instructorSignupPassword").value;

    if (instructorSignupEmail === "" || instructorSignupPassword === "") {
        alert("Please enter both email and password.");
        return;
    }

    alert("Instructor Signup Successful!");
    goToInstructorDashboard();
    closeLoginPopup('instructorSignupForm'); 
}

function learnerSignup() {
    const learnerSignupEmail = document.getElementById("learnerSignupEmail").value;
    const learnerSignupPassword = document.getElementById("learnerSignupPassword").value;

    if (learnerSignupEmail === "" || learnerSignupPassword === "") {
        alert("Please enter both email and password.");
        return;
    }

    alert("Learner Signup Successful!");
    goToInstructorDashboard();
    closeLoginPopup('learnerSignupForm'); 
}

function goToAdminDashboard() {
    transitionToPage("admin_dashboard.html"); 
}

function goToInstructorDashboard() {
    transitionToPage("instructor_dashboard.html"); 
}

function goToLearnerDashboard() {
    transitionToPage("learner_dashboard.html"); 
}

function goToManageUsers() {
    transitionToPage("admin_manage_users.html"); 
}

function goToManageContent() {
    transitionToPage("admin_manage_content.html"); 
}

function goToAddadmin() {
    transitionToPage("admin_add.html"); 
}

function goToCreateLesson() {
    transitionToPage("instructor_create_lesson.html"); 
}

function goToViewFeedback() {
    transitionToPage("instructor_view_feedback.html"); 
}

function goToTrackLearnerProgress() {
    transitionToPage("instructor_track_progress.html"); 
}

function goToManageTestCases() {
    transitionToPage("instructor_manage_test_cases.html"); 
}

function startLesson(lessonId) {
    transitionToPage("lesson_view.html?id=" + lessonId); 
}

function viewProgress() {
    transitionToPage("learner_progress.html"); 
}

function goToForum() {
    transitionToPage("learner_forum.html"); 
}

function goToProfile() {
    transitionToPage("learner_profile.html"); 
}

function takeTest() {
    transitionToPage("learner_take_test.html"); 
}

function goBackToDashboard() {
    window.location.href = "index.html"; // Redirect to the index.html page on logout
}

function transitionToPage(url) {
    setTimeout(() => {
        window.location.href = url;
    }, 200); 
}function showInstructorSignupForm() {
    document.getElementById('instructorSignupForm').style.display = 'block';
}

function showLearnerSignupForm() {
    document.getElementById('learnerSignupForm').style.display = 'block';
}
function gotosearch(){
    transitionToPage("search_result.html");
}