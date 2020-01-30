<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in with your account</title>

        <style>
            .error {color:red}
        </style>
</head>
<body>
<div align="center">
    <h1>Log in</h1>


    <spring:url value="/logintopage" var="userActionUrl"/>

    <form:form method="POST" modelAttribute="credentials" action="${userActionUrl}">
        <table border="0" cellpadding="10">
            <spring:bind path="username">
                <tr>
                    <td> Username</td>
                    <td><form:input type="text" path="username" placeholder="Username"
                                    autofocus="true"/></td>
                    <td><form:errors path="username" cssClass="error"/></td>
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
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <tr>
                <td colspan="2">
                    <button type="submit" style="font-weight: bold;background-color: dodgerblue ;width: 250px; height: 40px">LOG IN</button>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                   <a href="/registration" align="center" style="color: dodgerblue; font-weight: bold;  text-decoration: none">Create an account</a>
                </td>

            </tr>
            <tr><td colspan="2" align="center">
                <a href="/" align="center" style="color: darkred; font-weight: bold;  text-decoration: none">Return to contacts view</a>
            </td></tr>
        </table>
    </form:form>

</div>
</body>
</html>
