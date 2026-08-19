package com.example.quizapp.controller;

import com.example.quizapp.dao.QuestionDAO;
import com.example.quizapp.model.Question;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/quiz")
public class QuizServlet extends HttpServlet {

    private QuestionDAO questionDAO;

    @Override
    public void init() {

        questionDAO = new QuestionDAO();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String playerName =
                request.getParameter("playerName");

        List<Question> questions =
                questionDAO.getQuizQuestions();

        request.setAttribute(
                "playerName",
                playerName
        );

        request.setAttribute(
                "questions",
                questions
        );

        request.getRequestDispatcher("/quiz.jsp")
                .forward(request, response);
    }
}
