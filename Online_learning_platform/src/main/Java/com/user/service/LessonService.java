package com.user.service;

import com.user.dao.lessonesdao;
import com.user.model.lessons;
import java.sql.SQLException;

public class LessonService {
    private lessonesdao lessonDAO;

    public LessonService() {
        lessonDAO = new lessonesdao(); // Create an instance of LessonDAO
    }

    public void addLesson(lessons lesson) throws SQLException {
        lessonDAO.addLesson(lesson); // Call DAO method to add a lesson
    }

    public void updateLesson(lessons lesson) throws SQLException {
        lessonDAO.updateLesson(lesson); // Call DAO method to update a lesson
    }

    public void deleteLesson(int lessonId) throws SQLException {
        lessonDAO.deleteLesson(lessonId); // Call DAO method to delete a lesson
    }

    public lessons getLessonById(int lessonId) throws SQLException {
        return lessonDAO.getLessonById(lessonId); // Call DAO method to fetch a lesson by ID
    }
}
