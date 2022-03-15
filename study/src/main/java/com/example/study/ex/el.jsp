<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.example.study.ex.Person" %>
<%
    Person person = new Person();
    request.setAttribute("person", person);
    request.setAttribute("name", "조유강");
    request.setAttribute("list", new java.util.ArrayList());
%>
<html>
<head>
    <title>EL</title>
</head>
<body>
person.getCar().getColor()=<%=person.getCar().getColor()%> <br>
person.getCar().getColor()=${person.getCar().getColor()} <br>
person.getCar().getColor()=${person.car.color} <br>
name=<%=request.getAttribute("name")%> <br>
name=${requestScope.name} <br>
name=${name} <br>
id=<%=request.getParameter("id")%> <br>
id=${pageContext.request.getParameter("id")} <br>
id=${param.id} <br>
"1"+1 = ${"1"+1} <br>
"1"+="1" = ${"1"+="1"} <br>
"2">1 = ${"2">1} <br>
null = ${null}<br>
null+1 = ${null+1} <br>
null+null = ${null+null} <br>
"" + null = ${""+null} <br>
""-1 = ${""-1} <br>
empty null=${empty null} <br>
empty list=${empty list} <br>
null==0 = ${null==0} <br>
null eq 0 = ${null eq 0} <br>
name == "조유강"=${name=="조유강"} <br>
name != "조유강"=${name!="조유강"} <br>
name eq "조유강"=${name eq "조유강"} <br>
name ne "조유강"=${name ne "조유강"} <br>
name.equals("남궁성")=${name.equals("조유강")} <br>
</body>
</html>