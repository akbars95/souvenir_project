<%--
  Created by IntelliJ IDEA.
  User: MTSMDA
  Date: 03.02.2016
  Time: 7:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="title">
		<spring:message code="page.about_us.title" />
	</tiles:putAttribute>
	<tiles:putAttribute name="content">
		<div class="" ng-controller="aboutUsCtrl">
			<div>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
					Maecenas facilisis cursus enim et mattis. Aenean eget erat
					sagittis, mattis eros quis, vulputate lorem. Nunc suscipit suscipit
					arcu. Duis euismod, velit non blandit fermentum, massa elit laoreet
					eros, sed rutrum tellus orci sed nulla. Ut viverra orci nec cursus
					posuere. Ut pretium arcu elit, quis scelerisque mi cursus eu. Sed
					eget blandit tellus. Praesent ultricies ut leo quis volutpat.
					Phasellus volutpat, libero ac congue placerat, leo mi ornare felis,
					eu volutpat lacus massa eu nisl.</p>
				<p>Nam erat quam, tincidunt quis porta quis, interdum et enim.
					Cras vitae magna leo. Praesent rhoncus tempus dui, sit amet posuere
					est vulputate sit amet. Nam accumsan neque sapien. Praesent a nulla
					vel arcu viverra cursus id quis dui. Donec id rutrum risus.
					Vestibulum hendrerit nulla nec rutrum convallis. Suspendisse
					suscipit pulvinar dictum. Nam eget ex eget ante euismod gravida.
					Aliquam congue euismod augue in rutrum. Aenean sit amet sodales
					neque. Pellentesque habitant morbi tristique senectus et netus et
					malesuada fames ac turpis egestas. Quisque feugiat libero quis
					justo ornare dignissim. Praesent blandit est non commodo dignissim.
					Sed vel diam quis nibh scelerisque pellentesque id non nulla.</p>
				<p>Donec vitae quam non sapien sagittis laoreet ac vel orci.
					Nunc vel justo maximus, semper libero quis, mattis ipsum. Donec id
					nisi lacus. Pellentesque ipsum libero, pellentesque id malesuada
					nec, pellentesque sed lorem. Curabitur elit ipsum, mattis ac nulla
					et, tincidunt porttitor elit. Mauris leo diam, finibus egestas
					condimentum id, luctus a purus. Nulla viverra elementum libero id
					ullamcorper. Nunc maximus, erat nec pulvinar convallis, nunc lorem
					eleifend leo, id fermentum sapien mauris ac odio. Praesent eu
					sollicitudin ipsum. Cras non erat purus.</p>
				<p>Cras rutrum commodo eleifend. Pellentesque felis dui, luctus
					non magna eget, pellentesque tincidunt nisi. Nulla facilisi.
					Maecenas a purus non ante posuere mattis ut vel augue. Quisque quis
					ipsum consequat, elementum quam sed, tristique urna. Vivamus metus
					libero, accumsan sit amet velit non, pulvinar facilisis enim.
					Pellentesque interdum aliquam tempor. Pellentesque eget egestas
					augue. Curabitur suscipit consectetur augue in vulputate. Morbi a
					velit ullamcorper, ullamcorper nisl a, tempor nulla.</p>
				<p>Quisque fringilla sed leo quis accumsan. Vivamus a neque ut
					tortor dictum venenatis. Donec eleifend orci nec dui varius
					scelerisque. Suspendisse in tellus magna. Nam ornare elit sit amet
					cursus bibendum. Maecenas mauris sapien, venenatis ut pharetra sed,
					mattis at purus. Aenean in ex ipsum.</p>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>