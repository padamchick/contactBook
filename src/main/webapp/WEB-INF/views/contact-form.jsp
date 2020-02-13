<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/styles.css">
    <title>Create new contact</title>


</head>
<body>
<div>
    <h1>Add Contact</h1>

    <form:form method="POST" modelAttribute="person" action="save">
        <form:hidden path="id"/>

        <table cellpadding="5">
            <tbody>
            <tr>
                <td><label>First name</label></td>
                <td><form:input path="firstName" placeholder="First name"/></td>
                <td><form:errors path="firstName" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label>Last name</label></td>
                <td><form:input path="lastName" placeholder="Last name"/></td>
                <td><form:errors path="lastName" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label>Email</label></td>
                <td><form:input path="email" placeholder="Email"/></td>
                <td><form:errors path="email" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label>Category</label></td>
                <td><form:select path="category">
                    <form:option value="Business" >Business</form:option>
                    <form:option value="Private">Private</form:option>
                    <form:option value="Different">Different</form:option>
                </form:select></td>
            </tr>

            <tr>
                <td><label>Phone Number</label></td>
                <td><form:input path="phoneNumber" placeholder="Phone number"/></td>
                <td><form:errors path="phoneNumber" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label>Birth date</label></td>
                <td><form:input type="text" path="birthDate" placeholder="01.01.2000"
                                autofocus="true"/></td>
                <td><form:errors path="birthDate" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save"/></td>
            </tr>

            </tbody>
        </table>
    </form:form>
    <div style="clear: both;">
        <p>
            <a href="${pageContext.request.contextPath}/users"
               style="color: darkred; font-weight: bold;  text-decoration: none">Back to List</a>
        </p>
    </div>

</div>
</body>
</html>
