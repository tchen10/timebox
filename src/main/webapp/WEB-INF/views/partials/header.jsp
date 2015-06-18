<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>${pageTitle}</title>

    <link rel="stylesheet" href="<c:url value='/resources/css/main.css'/>" type="text/css"/>
    <link rel="stylesheet" href="<c:url value='/resources/css/TimeCircles.css' />" type="text/css"/>
    <script type="text/javascript" src="<c:url value='/resources/js/jquery-1.11.3.min.js' />"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/TimeCircles.js' />"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/timer.js' />"></script>
</head>

