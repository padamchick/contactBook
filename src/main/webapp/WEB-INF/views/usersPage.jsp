<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<head>
    <meta charset="UTF-8">
    <title>Welcome ${pageContext.request.userPrincipal.name}</title>
</head>
<body>
<div align="center">
    <h1>Contact book</h1>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <button><a href="/users/new" style="text-decoration: none; color: black; font-weight: bold">Create New
            Contact</a></button>
    </c:if>
    <br/><br/>
    <table border="1" cellpadding="10">
        <thead>
        <tr>
            <th>First name</th>
            <th>Last name</th>
            <th>Show more <br/> details</th>
        </tr>
        </thead>

        <c:forEach items="${listPerson}" var="person">
            <tr>
                <td><c:out value="${person.firstName}"/></td>
                <td><c:out value="${person.lastName}"/></td>
                <td align="center">


                    <button type="submit"><a href="/users/showcontact/${person.id}"
                                             style="text-decoration: none; font-weight: bold; color:green">+</a>
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <%--    <button type="submit">--%>

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <button>
            <a onclick="document.forms['logoutForm'].submit()">Logout</a>
        </button>
    </c:if>

    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <br/>
        <button>
            <a href="/login" style="text-decoration: none; color: black; font-weight: bold">Log in</a>
        </button>
    </c:if>
</div>
</body>
</html>