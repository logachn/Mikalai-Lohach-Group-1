<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Insert title here</title>
</head>
<body>
<form method="post" action="PupilController">
    <label>Pupil id:</label><input type="text" readonly="readonly" name="id"
                                   value="<c:out value="${pupil.id}" />"/><br/>
    <label>Name:</label><input type="text" name="name" value="<c:out value="${pupil.name}" />"/><br/>
    <label>Surname:</label><input type="text" name="surname" value="<c:out value="${pupil.surname}" />"/><br/>
    <label>GPA:</label><input type="text" name="gpa"
                              value="<fmt:formatNumber type="number" maxIntegerDigits="2" value="${pupil.gpa}"/>"/><br/>
    <label>Phone:</label><input type="text" name="phone" value="<c:out value="${pupil.phone}" />"/><br/>
    <input type="submit" value="Save"/>
</form>
<br/>
<br/>
<br/>
<br/>
<form method="post" action="PupilController">
    <select name="listbox">
        <c:forEach items="${pupils}" var="pupil">
            <option value="<c:out value="${pupil.id}" />"><c:out value="${pupil.name}"/> <c:out
                    value="${pupil.surname}"/></option>
        </c:forEach>
    </select>
    <input type="submit" value="Filter"/>
</form>
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
            <td><a href="PupilController?action=edit&id=<c:out value="${pupil.id}"/>">Update</a></td>
            <td><a href="PupilController?action=delete&id=<c:out value="${pupil.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>