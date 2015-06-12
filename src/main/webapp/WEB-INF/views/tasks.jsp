<%@ include file="partials/header.jsp" %>
<c:set var="pageTitle" scope="request" value="Tasks"/>
<body>
<h1>All Tasks</h1>

<c:forEach var="task" items="${taskList}">
    <li>(${task.taskId}) ${task.description} - ${task.duration}</li>
</c:forEach>

<h2>Add Task</h2>

<div class="timer"></div>

<form:form id="addTask" action="" method="POST" modelAttribute="task">

    <div>
        <form:label path="description">Description:</form:label>
        <form:input id="taskDescription" path="description"/>
    </div>

    <div>
        <form:label path="duration">Duration:</form:label>
        <form:input id="taskDuration" path="duration"/>
    </div>

    <form:button class="button" id="taskSubmitButton" type="submit" value="Submit">Submit</form:button>

</form:form>

</body>

<%@ include file="partials/footer.jsp" %>
