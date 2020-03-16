<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
    <head>
        <title><spring:message code="Search.title"/></title>
    </head>


    <form:form method="POST" action="/TasteLimerickBeersB/Beers/SearchBeer/" modelAttribute="Beers">

        <table border="1">
            <tr>
                <td><form:label path="name"><spring:message code="label.name" /></form:label></td>
                <td><form:input path="name"/></td>
                <td style="color:red"><form:errors path="name"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="<spring:message code="Search.title" />"/></td>
            </tr>
        </table>
            <table>
                <tr>
                <button><a href="http://localhost:8080/TasteLimerickBeersB/Beers/Search?language=en">English</a></button>
                <button><a href="http://localhost:8080/TasteLimerickBeersB/Beers/Search?language=ga">Gaeilge</a></button>
                </tr>
            </table>
    </form:form>


</html>