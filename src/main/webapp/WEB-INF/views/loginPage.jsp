<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in with your account</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
<div align="center">
    <h1>Log in</h1>


    <spring:url value="" var="userActionUrl"/>
    <span style="color: green">${message}</span>
    <span style="color: red">${error}</span>

    <form:form method="POST" modelAttribute="credentials" action="logintopage">
        <table cellpadding="5">
                <tr>
                    <td> Username</td>
                    <td><form:input type="text" path="username" placeholder="Username"
                                    autofocus="true"/></td>
                </tr>

                <tr>
                    <td> Password</td>
                    <td><form:input type="password" path="password" placeholder="Password"
                                    autofocus="true"></form:input></td>

                </tr>
            <tr>
                    <%--                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
                <td colspan="2" align="center">
                    <input type="submit" value="LOG IN" class="mybutton"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <a href="/registration" align="center" style="color: dodgerblue; font-weight: bold;  text-decoration: none">Create an account</a>
                </td>
            </tr>
            <tr><td colspan="2" align="center">
                <a href="/users" align="center" style="color: darkred; font-weight: bold;  text-decoration: none">Return to contacts view</a>
            </td></tr>
        </table>
    </form:form>

</div>
</body>
</html>
