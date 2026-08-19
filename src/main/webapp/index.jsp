<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>

<head>
    <title>District Quiz Game</title>
</head>

<body>

<h1>District Quiz Game</h1>

<p>
    Test your knowledge about History,
    Geography, Famous Places and
    Educational Institutions.
</p>

<form action="${pageContext.request.contextPath}/quiz"
      method="get">

    <label>Enter Your Name:</label>

    <input type="text"
           name="playerName"
           required>

    <br><br>

    <button type="submit">
        Start Quiz
    </button>

</form>

</body>

</html>
