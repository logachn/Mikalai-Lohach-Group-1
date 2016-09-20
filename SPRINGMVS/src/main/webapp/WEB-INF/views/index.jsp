<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Insert title here</title>
</head>
<body>
<form:form method="post" action="pupils/savePupil">
    <label>Pupil id:</label><form:input path="id"/><br/>
    <label>Name:</label><form:input path="name"/><br/>
    <label>Surname:</label><form:input path="surname"/><br/>
    <label>GPA:</label><form:input path="gpa"/><br/>
    <label>Phone:</label><form:input path="phone" /><br/>
    <input type="submit" value="Save" name="action"/>
</form:form>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<table border=1>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>GPA</th>
        <th>Phone</th>
        <th colspan=2>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${pupils}" var="pupil">
        <tr>
            <td><c:out value="${pupil.id}"/></td>
            <td><c:out value="${pupil.name}"/></td>
            <td><c:out value="${pupil.surname}"/></td>
            <td><fmt:formatNumber type="number" maxIntegerDigits="2" value="${pupil.gpa}"/></td>
            <td><c:out value="${pupil.phone}"/></td>
            <td><a href="pupils/updatePupil/${pupil.id}">Update</a></td>
            <td><a href="pupils/deletePupil/${pupil.id}"/>Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>