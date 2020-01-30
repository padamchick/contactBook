<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Contact Book</title>
</head>
<body>
<div align="center">
    <h1>Contact book</h1>
    <button><a href="/users/new" style="text-decoration: none; color: black; font-weight: bold">Create New Contact</a>
    </button>
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
    <br/>
    <button><a href="/logout" style="text-decoration: none; color: black; font-weight: bold">Log out</a>
    </button>
</div>
</body>
</html>