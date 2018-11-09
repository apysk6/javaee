<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Privacy policy</title>
</head>
<body>
<form action="index">
    <h1>If you want to enter the shop, you have to accept privacy policy.</h1>
    <h3>Compulsory fields</h3>
     <label for="rodo">I accept RODO-1.</label>
    <input type="checkbox" name="rodo" id="rodo" required="required"><br>
    <label for="rodo2">I accept RODO-2.</label>
    <input type="checkbox" name="rodo2" id="rodo2" required="required"><br>
    <h3>Optional fields</h3>
    <label for="rodo3">I accept RODO-3.</label>
    <input type="checkbox" name="rodo3" id="rodo3"><br><br>
     <input type="submit" value="Enter">
</form>

</body>
</html>