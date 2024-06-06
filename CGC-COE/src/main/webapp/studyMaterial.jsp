<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Study Materials</title>
    <link rel="stylesheet" href="sts/helpdesk.css">
</head>
<body>

<jsp:include page="navBar.jsp" />
    <h2 style="margin-top: 10%">Study Materials</h2>
    <a href="<%=request.getContextPath()%>/StudyMaterialServlet?re=studyMaterial.jsp"
				class="btn btn-success" style="margin-top: 6%; margin-left:35%; text-decoration: auto; color: fuchsia;">IMPORTANT NOTIFICATION</a>
    <c:if test="${not empty listMaterials}">
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Description</th>
                    <th>File Path</th>
                    <th>Upload Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="material" items="${listMaterials}">
                    <tr>
                        <td><c:out value="${material.id}"/></td>
                        <td><c:out value="${material.title}"/></td>
                        <td><c:out value="${material.description}"/></td>
                        <td><c:out value="${material.filePath}"/></td>
                        <td><c:out value="${material.uploadDate}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</body>
</html>
