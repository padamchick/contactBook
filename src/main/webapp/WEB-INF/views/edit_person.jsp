<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/styles.css">
    <title>Edit contact</title>

        <style>
            .error {color:red}
        </style>
</head>
<body>
<div align="center">
    <h1>Edit Contact</h1>

    <spring:url value="/users/save" var="userActionUrl"/>

    <form:form method="POST" modelAttribute="person" action="${userActionUrl}">
        <table border="0" cellpadding="10">
            <spring:bind path="id">
                <tr>
<%--                    <td>Contact ID</td>--%>
                    <td><form:input type="hidden" path="id" readonly="true"/></td>
                </tr>
            </spring:bind>


            <spring:bind path="firstName">
                <tr>
                    <td> First name</td>
                    <td><form:input type="text" path="firstName" placeholder="First name"
                                    autofocus="true"/></td>
                </tr>

            </spring:bind>
            <spring:bind path="lastName">
                <tr>
                    <td> Last name</td>
                    <td><form:input type="text" path="lastName" placeholder="Last name"
                                    autofocus="true"></form:input></td>
                </tr>
            </spring:bind>
            <spring:bind path="email">
                <tr>
                    <td> Email</td>
                    <td><form:input type="text" path="email" placeholder="Email"
                                    autofocus="true"></form:input></td>
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
                    <td> Phone number</td>
                    <td><form:input type="text" path="phoneNumber" placeholder="Phone number"
                                    autofocus="true"></form:input></td>
                </tr>
            </spring:bind>
            <spring:bind path="birthDate">
                <tr>
                    <td> Birth date</td>
                    <td><form:input type="text" path="birthDate" placeholder="01.01.2000"
                                    autofocus="true"></form:input></td>
                </tr>
            </spring:bind>
            <tr>

                <td colspan="2" align="center">
                    <button type="submit"
                            style="font-weight: bold;background-color: dodgerblue ;width: 315px; height: 40px">SAVE
                    </button>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <a href="/users/showcontact/${person.id}" style="font-weight: bold; color: brown; text-decoration: none">Return</a>
                </td>
            </tr>

        </table>
    </form:form>
</div>
</body>
</html>
