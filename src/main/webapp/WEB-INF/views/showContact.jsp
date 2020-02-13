<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Contacts Book</title>
</head>
<body>
<div align="center">
    <h1>Contact book</h1>
    <br/>
    <table border="1" cellpadding="10">
        <thead>
        <tr>
            <th>First name</th>
            <th>Last name</th>
            <th>Email</th>
            <th>Category</th>
            <th>Phone number</th>
            <th>Birth day</th>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <th>Actions</th>
            </c:if>
        </tr>
        </thead>

        <c:url var="updateLink" value="/users/edit">
            <c:param name="personId" value="${person.id}"/>
        </c:url>

        <c:url var="deleteLink" value="/users/delete">
            <c:param name="personId" value="${person.id}"/>
        </c:url>
        <%--        <c:forEach items="${listPerson}" var="person">--%>
        <tr>
            <td>${person.firstName}</td>
            <td>${person.lastName}</td>
            <td>${person.email}</td>
            <td>${person.category}</td>
            <td>${person.phoneNumber}</td>
            <td>${person.birthDate}</td>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <td>
                    <button type="submit"><a href="${updateLink}"
                                             style="text-decoration: none; color:black">Edit</a>
                    </button>

                    <button type="submit"><a href="${deleteLink}"
                                             style="text-decoration: none; color:black"
                                             onclick="return confirm('Are you sure you want to delete this item?')">Delete</a>
                    </button>
                </td>
            </c:if>
        </tr>
        <%--        </c:forEach>--%>
    </table>
    <br/>
    <button><a href="/users" style="text-decoration: none; color: black; font-weight: bold">Return</a></button>
</div>
</body>
</html>