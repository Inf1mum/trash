<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>User List</title>
    <link rel="stylesheet" type="text/css" href="Style/Style.css">
</head>
<body bgcolor="#B0E0E6">


<div align="center" id="block3" >
    <h1 align="center">User List</h1>
     <a href="PreAdd" > <input value="Create user" id="block10" ></a>
    <table border="1" cellspacing="1" width=80%>
        <tr>
            <th>Num</th>
            <th>Email</th>
            <th>First Name</th>
            <th>Last Name</th>
        </tr>
        <c:forEach items="${A}" var="task">
          <tr><td>${A.indexOf(task)+1}</td><td><a href="PreEdit?id=${task.getId()}"> ${task.getEmail()}</a></td>
              <td>${task.getFName()}</td><td>${task.getLName()}</td>
          </tr>
        </c:forEach>
    </table>
    <br>

</div>


</body>
</html>
