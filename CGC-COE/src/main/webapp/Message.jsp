<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>Display PDF</title>
</head>
<body>
    <embed src="data:application/pdf;base64,${base64Pdf}" type="application/pdf" width="100%" height="600px" />
</body>
</html>
