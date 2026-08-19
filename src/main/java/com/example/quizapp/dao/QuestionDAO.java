package com.example.quizapp.dao;

import com.example.quizapp.model.Question;
import com.example.quizapp.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {


    // Get random quiz questions
    public List<Question> getQuizQuestions() {

        List<Question> questions = new ArrayList<>();

        String sql = """
                SELECT *
                FROM questions
                ORDER BY RAND()
                LIMIT 10
                """;


        System.out.println("DAO method called");


        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()
        ) {


            while (resultSet.next()) {


                System.out.println(
                        "Question found: "
                                + resultSet.getString("question_text")
                );


                Question question = new Question();


                question.setId(
                        resultSet.getInt("id")
                );


                question.setQuestionText(
                        resultSet.getString("question_text")
                );


                question.setOptionA(
                        resultSet.getString("option_a")
                );


                question.setOptionB(
                        resultSet.getString("option_b")
                );


                question.setOptionC(
                        resultSet.getString("option_c")
                );


                question.setOptionD(
                        resultSet.getString("option_d")
                );


                question.setCorrectOption(
                        resultSet.getString("correct_option")
                );


                question.setCategory(
                        resultSet.getString("category")
                );


                questions.add(question);

            }


        } catch (Exception e) {

            e.printStackTrace();

        }


        System.out.println(
                "Total questions loaded = "
                        + questions.size()
        );


        return questions;
    }





    // Get one question by ID
    public Question getQuestionById(int id) {


        String sql =
                "SELECT * FROM questions WHERE id = ?";


        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {


            statement.setInt(1, id);


            ResultSet resultSet =
                    statement.executeQuery();



            if (resultSet.next()) {


                Question question = new Question();


                question.setId(
                        resultSet.getInt("id")
                );


                question.setQuestionText(
                        resultSet.getString("question_text")
                );


                question.setOptionA(
                        resultSet.getString("option_a")
                );


                question.setOptionB(
                        resultSet.getString("option_b")
                );


                question.setOptionC(
                        resultSet.getString("option_c")
                );


                question.setOptionD(
                        resultSet.getString("option_d")
                );


                question.setCorrectOption(
                        resultSet.getString("correct_option")
                );


                question.setCategory(
                        resultSet.getString("category")
                );


                return question;

            }



        } catch (Exception e) {

            e.printStackTrace();

        }


        return null;

    }

}
