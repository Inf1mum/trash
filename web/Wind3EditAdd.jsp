<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Form</title>
    <link rel="stylesheet" type="text/css" href="Style/Style.css">
</head>
<body bgcolor="#B0E0E6">
<div  id="block5"  >
    <h1 align="center">User Form</h1>
    <form action="${Status}">
        <pre>      Email         <input   name="Email" value="${Email}"></pre>
        <pre>      Password      <input   type="password" name="Password" value="${Pass}"></pre>
        <pre>      First Name    <input   name="FName" value="${FName}" ></pre>
        <pre>      Last Name     <input   name="LName" value="${LName}"></pre>
        <pre>      Post          <select size="1" name="Post">
                                     <option disabled>Choosing post</option>
                                     <option value="${Admin}">${Admin}</option>
                                     <option value="${User}">${User}</option>
                                 </select></pre>
       <input type="submit" value="Save" id="block11">
             <a href="Del?id=${id}"><input type="button" value="Delete" id="block12" ></a>
             <a href="Cancel"><input type="button" value="Cancel" id="block12"> </a>
        <input type="hidden" name="id" value="${id}">
    </form>

</div>



</body>
</html>
