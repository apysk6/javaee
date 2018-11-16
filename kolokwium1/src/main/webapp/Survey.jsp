<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Survey</title>
</head>
<body>

<h1>Fill in the questionnaire:</h1>
<form action="data-survey">
    <label for="from">Using product from:</label>
    <input type="text" name="dateFrom" id="dateFrom" required="required" value="${session_survey.dateFrom}"><br>

    <label for="to">Using product to:</label>
    <input type="text" name="dateTo" id="dateTo" required="required" value="${session_survey.dateTo}"><br>

    <br><label>Frequency:</label><br>
    <input type="radio" name="frequency" required="required" value="daily">Daily<br>
    <input type="radio" name="frequency" required="required" value="weekly">Weekly<br>
    <input type="radio" name="frequency" required="required" value="monthly">Monthly<br>

    <br><label>Comments:</label><br>
    <input type="checkbox" name="comment" value="quality">I am satisfied with quality.<br>
    <input type="checkbox" name="comment" value="expensive">Too expensive.<br>
    <input type="checkbox" name="comment" value="products">Not enough products.<br><br>

    <input type="submit" value="Done">
</form>

</body>
</html>