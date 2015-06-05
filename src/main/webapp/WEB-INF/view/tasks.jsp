<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" scope="request" value="Tasks"/>
<body>
<h1>All Tasks</h1>

<c:forEach var="task" items="${taskList}">
    <li>(${task.taskId}) ${task.description} - ${task.duration}</li>
</c:forEach>
</body>
</html>