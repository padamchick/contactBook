<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Contacts Book</title>
</head>
<body>
<div align="center">
    <h1>Contacts book</h1>
    <button><a href="/welcome/new" style="text-decoration: none; color: black; font-weight: bold">Create New Contact</a></button>
    <br/><br/>
    <table border="1" cellpadding="10">
        <thead>
        <tr>
            <th>Contact number</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Email</th>
            <th>Category</th>
            <th>Phone number</th>
            <th>Birth day</th>
            <th>Actions</th>
        </tr>
        </thead>

        <c:forEach items="${listPerson}" var="person">
            <tr>
                <td><c:out value="${person.id}"/></td>
                <td><c:out value="${person.firstName}"/></td>
                <td><c:out value="${person.lastName}"/></td>
                <td><c:out value="${person.email}"/></td>
                <td><c:out value="${person.category}"/></td>
                <td><c:out value="${person.phoneNumber}"/></td>
                <td><c:out value="${person.birthDate}"/></td>
                <td>
                    <button type="submit"><a href="/welcome/edit/ + ${person.id}" style="text-decoration: none; color:black">Edit</a>
                    </button>

                    <button type="submit"><a href="/welcome/delete/ + ${person.id}" style="text-decoration: none; color:black"
                                             onclick="return confirm('Are you sure you want to delete this item?')">Delete</a>
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <button><a href="/" style="text-decoration: none; color: black; font-weight: bold">Log out</a></button>
</div>
</body>
</html>