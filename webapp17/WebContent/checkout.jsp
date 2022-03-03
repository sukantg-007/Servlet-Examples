<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
var cart = JSON.parse("${result}");
</script>
</head>
<body>
<json:object>
<json:property name="customerid" value="${cart.custid}"/>
  <json:property name="itemCount" value="${cart.totalq}"/>
  <json:property name="subtotal" value="${cart.totalp}"/>
  <json:array name="items" var="item" items="${cart.allproduct}">
    <json:object>
      <json:property name="title" value="${item.id}"/>
      <json:property name="description" value="${item.name}"/>
      <json:property name="imageUrl" value="${item.summary}"/>
      <json:property name="price" value="${item.price}"/>
      <json:property name="qty" value="${item.quantity}"/>
      <json:property name="qty" value="${item.image}"/>
    </json:object>
  </json:array>
</json:object>
<h1>${customerid}</h1>
</body>
</html>