<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="footer">
	<div class="row">
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
			<p class="text-left">
				<spring:url value="/home" var="homeUrl" htmlEscape="true" />
				<a href="${homeUrl}"><spring:message code="menu.home.title" /></a>
			</p>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
			<p class="text-right">
				&copy;
				<spring:message code="footer.siteName.text" />
				-
				<script type="text/javascript">
					window.document.write(new Date().getFullYear());
				</script>
			</p>
		</div>
	</div>
</div>