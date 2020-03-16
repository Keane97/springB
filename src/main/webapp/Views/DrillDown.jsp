<%-- 
    Document   : DrillDown
    Created on : 9 Mar 2020, 16:31:02
    Author     : Keane
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <spring:url value="/Beers/Search" var="HomeURL"/>
        <button><a href="${HomeURL}"><spring:message code="label.home" /></a></Button>
        <table border="1">
            <tr>
                <td><spring:message code="label.id" /></td>
                <td><spring:message code="label.name" /></td>
                <td><spring:message code="label.abv" /></td>
                <td><spring:message code="label.Buy" /></td>
                <td><spring:message code="label.Sell" /></td>
                <td><spring:message code="label.LastMod" /></td>
                <td><spring:message code="label.Description" /></td>
                <td><spring:message code="label.image" /></td>
                <td><spring:message code="label.catagory" /></td>
                <td><spring:message code="label.style" /></td>
                <td><spring:message code="label.actions" /></td>
            </tr>
            <c:forEach items="${Beers}" var="Beers"> 
                <tr>
                    <td>${Beers.id}</td>
                    <td>${Beers.name}</td>
                    <td>${Beers.abv}</td>
                    <td>${Beers.buyPrice}</td>
                    <td>${Beers.sellPrice}</td>
                    <td>${Beers.lastMod}</td>
                    <td>${Beers.description}</td>
                    <td><img src="../assets/images/no_image.jpg" alt="<spring:message code="label.image" />"/></td>
                    <td>${Beers.catId}</td>
                    <td>${Beers.styleId}</td>
                    <td>
                <form:form method="POST" action="/TasteLimerickBeersB/Beers/UpdateBeerPrice?id=${Beers.id}" modelAttribute="priceIncrease">
                    <label path="priceIncrease"><spring:message code="label.percentage" /></label>
                    <input path="priceIncrease"/>
                    <input type="submit" value="<spring:message code="submit.button" />"/>
                </form:form>
                
            </td>
        </tr>

    </c:forEach>
</table>

</body>
</html>
