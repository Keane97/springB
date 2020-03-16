<%-- 
    Document   : priceUpdate
    Created on : 14 Mar 2020, 16:02:56
    Author     : Keane
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="label.Priceupdate" /></title>
    </head>
    <body>
    <form:form method="POST" action="/TasteLimerickBeersB/Beers/UpdateBeerPrice/" modelAttribute="priceIncrease">

        <table border="1">
            <tr>
                <td><form:label path="priceIncrease"><spring:message code="label.percentage" /></form:label></td>
            <td><form:input path="priceIncrease"/></td>
            <td style="color:red"><form:errors path="increase"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="<spring:message code="submit.button" />"/></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
