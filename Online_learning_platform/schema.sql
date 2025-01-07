use olp;
CREATE TABLE admins (
    admin_id INT AUTO_INCREMENT PRIMARY KEY,
    u_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    passwrd VARCHAR(255) NOT NULL
);
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role ENUM('Instructor', 'Learner') NOT NULL
);
CREATE TABLE lessons (
    lesson_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    instructor_id INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (instructor_id) REFERENCES users(user_id) ON DELETE CASCADE
);
CREATE TABLE progress (
    progress_id INT AUTO_INCREMENT PRIMARY KEY,
    learner_id INT NOT NULL,
    lesson_id INT NOT NULL,
    progress_percentage DECIMAL(5, 2) DEFAULT 0,
    completed BOOLEAN DEFAULT FALSE,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (learner_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (lesson_id) REFERENCES lessons(lesson_id) ON DELETE CASCADE
);