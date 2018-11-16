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
<form action="addSurvey">
    <label for="from">Using product from:</label>
    <input type="text" name="from" id="from" required="required" value="${sess_news.dateFrom}"><br>

    <label for="to">Using product to:</label>
    <input type="text" name="to" id="to" required="required" value="${sess_news.dateTo}"><br>

    <br><label>Frequency:</label><br>
    <input type="radio" name="frequency" value="daily">Daily<br>
    <input type="radio" name="frequency" value="weekly">Weekly<br>
    <input type="radio" name="frequency" value="monthly">Monthly<br>

    <br><label>Comments:</label><br>
    <input type="checkbox" name="subjects" value="quality">I am satisfied with quality.<br>
    <input type="checkbox" name="subjects" value="expensive">Too expensive.<br>
    <input type="checkbox" name="subjects" value="products">Not enough products.<br><br>

    <input type="submit" value="Done">
</form>

</body>
</html>