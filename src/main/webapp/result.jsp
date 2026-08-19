<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>

<head>
    <title>Quiz Result</title>
</head>

<body>

<h1>Quiz Result</h1>

<h2>
    Congratulations,
    ${playerName}!
</h2>

<h2>
    Your Score:
    ${score} / ${total}
</h2>

<br>

<a href="${pageContext.request.contextPath}/">
    Play Again
</a>

</body>

</html>
