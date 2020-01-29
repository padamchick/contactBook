<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/styles.css">
    <title>New contact</title>

    <%--    <style>--%>
    <%--        .error {color:red}--%>
    <%--    </style>--%>
</head>
<body>
<div align="center">
    <h1>Add Contact</h1>
    <br/>

    <spring:url value="/welcome/save" var="userActionUrl"/>

    <form:form method="POST" modelAttribute="person" action="${userActionUrl}">
        <table border="0" cellpadding="10">
            <spring:bind path="firstName">
                <tr>
                    <td> First name</td>
                    <td><form:input type="text" path="firstName" placeholder="First name" autofocus="true"/></td>
                </tr>
            </spring:bind>
            <spring:bind path="lastName">
                <tr>
                    <td> Last name</td>
                    <td><form:input type="text" path="lastName" placeholder="Last name" autofocus="true"></form:input></td>
                </tr>
            </spring:bind>
            <spring:bind path="email">
                <tr>
                    <td> Email</td>
                    <td><form:input type="text" path="email" placeholder="Email" autofocus="true"></form:input></td>
                </tr>
            </spring:bind>
            <spring:bind path="category">
                <tr>
                    <td> Category</td>
                    <td><form:select type="text" path="category" placeholder="Category" autofocus="true">
                        <form:option value="Business">Business</form:option>
                        <form:option value="Private">Private</form:option>
                        <form:option value="Business">Different</form:option>
                    </form:select></td>
                </tr>
            </spring:bind>
            <spring:bind path="phoneNumber">
                <tr>
                    <td> Phone Number</td>
                    <td><form:input type="text" path="phoneNumber" placeholder="Phone number" autofocus="true"></form:input></td>
                </tr>
            </spring:bind>
            <spring:bind path="birthDate">
                <tr>
                    <td> Birth date</td>
                    <td><form:input type="text" path="birthDate" placeholder="01.01.2000" autofocus="true"></form:input></td>
                </tr>
            </spring:bind>
            <tr>
                <td colspan="2">
                    <button type="submit">Save</button>
                </td>
            </tr>
        </table>
    </form:form>

</div>
</body>
</html>
