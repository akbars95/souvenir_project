<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:importAttribute name="javascripts" />
<tiles:importAttribute name="stylesheets" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" /></title>

<!-- stylesheets -->
<c:forEach var="css" items="${stylesheets}">
	<link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
</c:forEach>
<!-- end stylesheets -->

<!-- scripts -->
<c:forEach var="script" items="${javascripts}">
	<script src="<c:url value="${script}"/>"></script>
</c:forEach>
<!-- end scripts -->

<script type="text/javascript">
	/* google maps api */
	var myCenter=new google.maps.LatLng(47.043318, 28.867029);
	function initialize() {
		var mapProp = {
			center : new google.maps.LatLng(47.043318, 28.867029),
			zoom : 17,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};
		var map = new google.maps.Map(document.getElementById("googleMap"),
				mapProp);
		var marker=new google.maps.Marker({
			  position:myCenter,
			  });
		marker.setMap(map);
		var infowindow = new google.maps.InfoWindow({
			  content:"Souvenir!"
			  });

			infowindow.open(map,marker);
	}
	google.maps.event.addDomListener(window, 'load', initialize);
</script>

</head>
<body style="display: inherit !important;" ng-app="souvenirApp">

	<div class="container">
		<!-- header -->
		<div id="header">
			<tiles:insertAttribute name="header" />
		</div>
		<!-- end header  -->

		<!-- menu -->
		<div id="menu">
			<tiles:insertAttribute name="menu" />
		</div>
		<!-- end menu  -->

		<!-- content -->
		<div id="content">
			<div class="content">
				<tiles:insertAttribute name="content" />
			</div>
		</div>
		<!-- end content -->

		<!-- footer -->
		<div id="footer">
			<tiles:insertAttribute name="footer" />
		</div>
		<!-- end footer -->

	</div>

</body>
</html>