<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit contact</title>

    <%--    <style>--%>
    <%--        .error {color:red}--%>
    <%--    </style>--%>
</head>
<body>
<div align="center">
    <h1>Edit Contact</h1>
    <br/>

    <spring:url value="/welcome/save" var="userActionUrl"/>

    <form:form method="POST" modelAttribute="person" action="${userActionUrl}">
        <table border="0" cellpadding="10">
            <spring:bind path="id">
                <tr>
                    <td>Contact ID</td>
                    <td><form:input type="text" path="id"  readonly="true"/></td>
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
