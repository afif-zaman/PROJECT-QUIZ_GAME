<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.quizapp.model.Question" %>

<%
    String playerName =
            (String) request.getAttribute("playerName");

    List<Question> questions =
            (List<Question>) request.getAttribute("questions");
%>

<!DOCTYPE html>
<html>

<head>
    <title>Quiz</title>
</head>

<body>

<h1>District Quiz</h1>

<h3>
    Player: <%= playerName %>
</h3>

<form action="<%= request.getContextPath() %>/submit-quiz"
      method="post">

    <input type="hidden"
           name="playerName"
           value="<%= playerName %>">

    <%
        int number = 1;

        for (Question q : questions) {
    %>

    <div>

        <input type="hidden"
               name="questionIds"
               value="<%= q.getId() %>">

        <h3>
            <%= number %>.
            <%= q.getQuestionText() %>
        </h3>

        <p>
            Category:
            <strong>
                <%= q.getCategory() %>
            </strong>
        </p>

        <label>
            <input type="radio"
                   name="answer_<%= q.getId() %>"
                   value="A">
            <%= q.getOptionA() %>
        </label>

        <br>

        <label>
            <input type="radio"
                   name="answer_<%= q.getId() %>"
                   value="B">
            <%= q.getOptionB() %>
        </label>

        <br>

        <label>
            <input type="radio"
                   name="answer_<%= q.getId() %>"
                   value="C">
            <%= q.getOptionC() %>
        </label>

        <br>

        <label>
            <input type="radio"
                   name="answer_<%= q.getId() %>"
                   value="D">
            <%= q.getOptionD() %>
        </label>

    </div>

    <hr>

    <%
            number++;
        }
    %>

    <button type="submit">
        Submit Quiz
    </button>

</form>

</body>

</html>
