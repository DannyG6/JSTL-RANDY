<%-- 
    Document   : user
    Created on : Nov 24, 2017, 11:08:06 AM
    Author     : DannyG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User</title>
    </head>
    <body>
        <a href="UserController?gender=male"><button>MALE</button></a>
        <a href="UserController?gender=female"><button>FEMALE</button></a>
        <a href="UserController?gender="><button>ALL</button></a>

        <table border="1">
            <tr><td>ID</td><td>Name</td><td>Gender</td></tr>
            <c:forEach items="${listUser}" var="user">
                <tr>
                    <c:if test = "${gender eq user.gender}">
                        <td><c:out value="${user.id}" /> </td>
                        <td><c:out value="${user.name}" /></td>     
                        <td> <c:out value="${user.gender}" /> </td>
                    </c:if>
                   <c:if test = "${gender eq null}">
                        <td><c:out value="${user.id}" /> </td>
                        <td><c:out value="${user.name}" /></td>     
                        <td> <c:out value="${user.gender}" /> </td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>


    </body>
</html>
