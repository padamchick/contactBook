<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<head>
    <meta charset="UTF-8">
    <title>Welcome ${pageContext.request.userPrincipal.name}</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
<div align="center">
    <h1>Contact book</h1>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <input type="button" value="Create New Contact"
               onclick="window.location.href='/users/new'; return false"
               class="mybutton"/>
    </c:if>
    <br/>
    <table border="1" cellpadding="10">
        <thead>
        <tr>
            <th>First name</th>
            <th>Last name</th>
            <th>Show more <br/> details</th>
        </tr>
        </thead>

        <c:forEach items="${listPerson}" var="person">

            <c:url var="contactDetails" value="/users/contact">
                <c:param name="personId" value="${person.id}"/>
            </c:url>


            <tr>
                <td>${person.firstName}</td>
                <td>${person.lastName}</td>
                <td align="center">


                    <button type="submit"><a href="${contactDetails}"
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
            <input type="button" value="Logout"
            onclick="document.forms['logoutForm'].submit()"
            class="mybutton"/>
    </c:if>

    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <br/>
        <button class="mybutton">
            <a href="/login"
               style="text-decoration: none; color: black; font-weight: bold"
            >Log in</a>
        </button>
    </c:if>
</div>
</body>
</html>