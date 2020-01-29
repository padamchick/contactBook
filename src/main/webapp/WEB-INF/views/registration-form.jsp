<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New contact</title>

        <style>
            .error {color:red}
        </style>

</head>
<body>
<div align="center">
    <h1>Add Contact</h1>
    <br/>

    <spring:url value="/registration/save" var="action"/>

    <form:form method="POST" modelAttribute="credentials" action="${action}">
        <table border="0" cellpadding="10">
            <spring:bind path="email">
                <tr>
                    <td> Email</td>
                    <td><form:input type="text" path="email" placeholder="Email"
                                    autofocus="true"/></td>
                    <td><form:errors path="email" cssClass="error"/></td>
                </tr>
            </spring:bind>

            <spring:bind path="password">
                <tr>
                    <td> Password</td>
                    <td><form:input type="password" path="password" placeholder="Password"
                                    autofocus="true"></form:input></td>
                    <td><form:errors path="password" cssClass="error"/></td>
                </tr>
            </spring:bind>

            <spring:bind path="confPassword">
                <tr>
                    <td> Confirm password</td>
                    <td><form:input type="password" path="confPassword" placeholder="Password confirmation"
                                    autofocus="true"></form:input></td>
                    <td><form:errors path="confPassword" cssClass="error"/></td>
                </tr>
            </spring:bind>
            <tr>
                <td colspan="2">
                    <button type="submit">Register</button>
                </td>
            </tr>
        </table>
    </form:form>

</div>
</body>
</html>
