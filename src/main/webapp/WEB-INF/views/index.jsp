<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Contacts Book</title>
</head>
<body>
<div align="center">
    <h1>Contacts book</h1>
    <a href="/new">Create New Contact</a>
    <br/><br/>
    <table border="1" cellpadding="10">
        <thead>
        <tr>
            <th>Contact number</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Email</th>
            <th>Actions</th>
        </tr>
        </thead>

        <c:forEach items="${listPerson}" var="person">
            <tr>
                <td><c:out value="${person.id}"/></td>
                <td><c:out value="${person.firstName}"/></td>
                <td><c:out value="${person.lastName}"/></td>
                <td><c:out value="${person.email}"/></td>
                <td>
                    <button type="submit"><a href="/edit/ + ${person.id}" style="text-decoration: none; color:black">Edit</a>
                    </button>

                    <button type="submit"><a href="/delete/ + ${person.id}" style="text-decoration: none; color:black"
                                             onclick="return confirm('Are you sure you want to delete this item?')">Delete</a>
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>