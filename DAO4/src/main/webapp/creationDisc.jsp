<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<h3>Disciplines</h3>
	<c:forEach items="${requestScope.Disciplines}" var="sp">
		<h5>${sp.intitule}</h5>
		<h6>-----</h6>
	</c:forEach>
	
<form action="CreationSportifServlet" method="post">
 <p> <table border="0">
 <tr>
  <td>Nom de la discipline</td> <td><input name="nom"> </td> 
 </tr>
 

 </table></p> 
 <input type="select" multiple="oui"> 
    <libellé>A quel sport la discipline est associée ?</libellé>
    <c:forEach items="${requestScope.yo}" var="yop">
   	 <option  name="choix" valeur="${yop.intitule}">${yop.intitule}</option>
 	</c:forEach>
 </input>
 <input type="submit" name="action" value="creerS">
 </form>