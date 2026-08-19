package com.example.quizapp.dao;

import com.example.quizapp.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ScoreDAO {

    public void saveScore(String playerName,
                          int score,
                          int totalQuestions) {

        String sql = """
                INSERT INTO scores
                (player_name, score, total_questions)
                VALUES (?, ?, ?)
                """;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(1, playerName);
            statement.setInt(2, score);
            statement.setInt(3, totalQuestions);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
