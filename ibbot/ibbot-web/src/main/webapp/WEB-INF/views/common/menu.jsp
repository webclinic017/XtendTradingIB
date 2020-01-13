<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<c:url value="/" var="homeUrl"/>
<c:url value="user" var="userUrl"/>
<c:url value="admin" var="adminUrl"/>
<c:url value="logout" var="logoutUrl"/>

<div class="menu">
	<ul>
		<li><a href="${homeUrl}">Home</a></li>
		<li><a href="${userUrl}">User</a></li>
		
		<li><a href="${adminUrl}">Admin</a></li>
		
		<li><a href="${logoutUrl}">Logout</a></li>
	</ul>
	<span id="menu-username">TEST</span>
	<br style="clear:left"/>
</div>