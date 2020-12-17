<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<title><tiles:getAsString name="title"/></title>

	<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/assets/images/gt_favicon.png">
	
	<link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/font-awesome.min.css">

	<!-- Custom styles for our template -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/bootstrap-theme.css" media="screen" >
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/main.css">

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src="${pageContext.request.contextPath}/resources/assets/js/html5shiv.js"></script>
	<script src="${pageContext.request.contextPath}/resources/assets/js/respond.min.js"></script>
	<![endif]-->

	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/swiper.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/first.css">
	<script src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/swiper.js"></script>
</head>

<body>
	<tiles:insertAttribute name="body"/>
	<tiles:insertAttribute name="footer"/>
	
	<!-- JavaScript libs are placed at the end of the document so the pages load faster -->
	<c:if test="${empty pageCheck}">
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	</c:if>
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/assets/js/headroom.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/assets/js/jQuery.headroom.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/assets/js/template.js"></script>
</body>
</html>