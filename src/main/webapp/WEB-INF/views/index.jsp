<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
<h1>${message}</h1>
<ul>
    <c:forEach var="person" items="${persons}">
        <li>${person.firstname} ${person.lastname}</li>
    </c:forEach>
</ul>
</body>

</html>
