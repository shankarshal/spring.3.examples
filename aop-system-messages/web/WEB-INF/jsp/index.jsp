<%@ taglib prefix="tag" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<head>
  <meta charset="utf-8">
  <title>APO Message Handler</title>
  <style>
  	.ok{color:#5E7C5A;}
  	.error{color:#830200;}
  	.info{color:#587384;}
  </style>
</head>
<body>
<h2>Aop system messages examples</h2>
<c:if test="${not empty systemMessages}">
	<c:forEach items="${systemMessages}" var="message">
		<div class="message ${fn:toLowerCase(message.type)}">
			${message.message}
		</div>	
	</c:forEach>
</c:if>


<ol>
<li><a href="<tag:url value="/ok" />">Test OK message</a></li>
<li><a href="<tag:url value="/error" />">Test ERROR message</a></li>
<li><a href="<tag:url value="/info" />">Test INFO message</a></li>
<li><a href="<tag:url value="/now" />">Show instant message</a></li>
</ol>

</body>

</html>