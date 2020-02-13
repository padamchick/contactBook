<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration page</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/styles.css">

</head>
<body>
<div align="center">
    <h1>Registration form</h1>

    <form:form method="POST" modelAttribute="credentials" action="/registration/save">
        <table cellpadding="5">

                <tr>
                    <td> Username</td>
                    <td><form:input type="text" path="username" placeholder="Username"
                                    autofocus="true"/></td>
                    <td><form:errors path="username" cssClass="error"/></td>
                </tr>

                <tr>
                    <td> Email</td>
                    <td><form:input type="text" path="email" placeholder="Email"
                                    autofocus="true"/></td>
                    <td><form:errors path="email" cssClass="error"/></td>
                </tr>

                <tr>
                    <td> Password</td>
                    <td><form:input type="password" path="password" placeholder="Password"
                                    autofocus="true"/></td>
                    <td><form:errors path="password" cssClass="error"/></td>
                </tr>

                <tr>
                    <td> Confirm password</td>
                    <td><form:input type="password" path="confPassword" placeholder="Password confirmation"
                                    autofocus="true"/></td>
                    <td><form:errors path="confPassword" cssClass="error"/></td>
                </tr>

            <tr>
                <td colspan="2" align="center">
                    <button type="submit" class="mybutton">REGISTER</button>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <a href="${pageContext.request.contextPath}/login" style="font-weight: bold; color: brown; text-decoration: none">Return</a>
                </td>
            </tr>
        </table>
    </form:form>

</div>
</body>
</html>
