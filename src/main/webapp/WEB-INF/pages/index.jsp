<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <html>
<head>
<spring:url
	value="/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css"
	var="bootstrapCss" />
<spring:url value="/resources/js/jquery-1.12.0.min.js" var="jqueryJs" />
<spring:url value="/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js"
	var="bootstrapJs" />
<spring:url value="/resources/less/less_style.less" var="myLess" />
<link href="${bootstrapCss}" rel="stylesheet" type="text/css" />

<script src="${jqueryJs}"></script>
<script src="${bootstrapJs}"></script>

<spring:url value="/resources/less/less.min.js" var="lessJS" />
<script src="${lessJS}"></script>
</head>
<body> --%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="title">
		<spring:message code="page.home.title" />
	</tiles:putAttribute>
	<tiles:putAttribute name="content">
		<div class="" ng-controller="indexCtrl">

			<h1>${message}</h1>

			<spring:url value="/adminPiece/souvenir"
				var="adminInsertSouvenirUrl" htmlEscape="true" />
			<a href="${adminInsertSouvenirUrl}">Admin</a>

			<div>Sed malesuada vitae dolor ac semper. Mauris sit amet
				tristique risus, ut vestibulum magna. Quisque commodo urna lacus, et
				semper ex lacinia in. Sed tincidunt neque at turpis convallis
				lobortis. Cras a quam risus. Mauris molestie ultrices elit ac
				consectetur. Aenean id est ac enim eleifend facilisis non eget sem.
				Nam ultrices massa eget enim blandit, tincidunt porttitor mauris
				laoreet. Morbi in orci ante. Proin eu felis quis ligula volutpat
				vehicula non quis velit. Duis pharetra erat volutpat molestie
				sodales. In vel facilisis odio. Interdum et malesuada fames ac ante
				ipsum primis in faucibus. Duis laoreet leo condimentum libero
				sodales sollicitudin. Nam consectetur ornare sapien, sit amet
				aliquet risus condimentum sed. Curabitur odio mi, consequat quis
				erat vel, consequat pharetra felis. Aliquam accumsan, nunc vel
				eleifend varius, nisi enim sodales massa, a accumsan orci eros et
				diam. In auctor dapibus ipsum, eget lobortis mauris. Etiam eget
				dictum risus. Mauris accumsan maximus sem. Curabitur eu rutrum
				lectus. Vestibulum ante ipsum primis in faucibus orci luctus et
				ultrices posuere cubilia Curae; Vestibulum ante ipsum primis in
				faucibus orci luctus et ultrices posuere cubilia Curae; Aliquam
				scelerisque tortor eget nisl congue, venenatis sollicitudin mi
				iaculis. Nullam dapibus fermentum urna. Nam tristique rhoncus lacus,
				at tempor purus facilisis congue. Pellentesque porttitor egestas
				faucibus. Proin suscipit nibh leo, non placerat ex iaculis sed.
				Praesent ut nibh nisi. Aenean ligula velit, pharetra nec est quis,
				ultricies egestas nulla. Suspendisse faucibus pulvinar leo eget
				tristique. Pellentesque aliquam mollis felis et laoreet.
				Pellentesque habitant morbi tristique senectus et netus et malesuada
				fames ac turpis egestas. Mauris rutrum euismod accumsan. Praesent
				bibendum sem id tempus pulvinar. Proin est purus, condimentum et
				iaculis id, egestas sed libero. Fusce tempor imperdiet felis, nec
				condimentum nibh dignissim nec. Pellentesque malesuada venenatis
				ligula pharetra pulvinar. Aliquam libero tortor, elementum lobortis
				auctor in, tristique ut massa. Nulla in egestas urna. Donec laoreet
				felis et turpis consequat, eleifend cursus elit pulvinar. Cras
				ultricies aliquet orci id ullamcorper. Aliquam luctus congue tortor
				et faucibus. Duis accumsan, mi vestibulum iaculis varius, orci lacus
				posuere massa, at aliquam felis sem id nisl. Class aptent taciti
				sociosqu ad litora torquent per conubia nostra, per inceptos
				himenaeos. Sed purus est, tincidunt eget dolor ac, imperdiet mollis
				nisl. Donec aliquet neque eget tortor porttitor commodo. Nullam nec
				orci sed est commodo imperdiet ut vitae sem. Vivamus ullamcorper
				augue id leo tristique congue. Fusce mollis vel dui et hendrerit. Ut
				et sollicitudin magna, ac scelerisque arcu. Nam mollis libero sit
				amet est dapibus tincidunt. Fusce maximus pretium ex at viverra.
				Nullam quis ipsum a lacus ullamcorper varius. Suspendisse
				consectetur diam vitae imperdiet ultrices. Donec id ultricies elit.
				Aenean at faucibus magna. Nulla a tincidunt massa. Nunc fermentum,
				orci non vehicula sollicitudin, tortor tortor facilisis velit, ut
				tincidunt nibh augue at magna. Integer laoreet posuere lacus et
				aliquet. Suspendisse potenti. Vestibulum non semper sem, ut lacinia
				elit. Fusce eleifend elit id sapien sagittis interdum. Curabitur
				condimentum turpis nulla, quis pellentesque lectus fringilla sed.
				Mauris a rutrum diam. Praesent quis nunc sed nisi elementum
				tincidunt. Etiam vel augue odio. Lorem ipsum dolor sit amet,
				consectetur adipiscing elit. Quisque vitae velit sed risus volutpat
				tempus. Suspendisse potenti. Etiam sodales quis nunc eget ultrices.
				Vivamus imperdiet quam non arcu consequat commodo. Vestibulum vel
				ante justo. Interdum et malesuada fames ac ante ipsum primis in
				faucibus. Morbi scelerisque malesuada vulputate. Nam sed ex mauris.
				Morbi feugiat interdum sem, vitae vestibulum ante maximus at.
				Pellentesque rhoncus ac lorem et congue. Donec ut ligula in libero
				porttitor cursus nec a tortor. Fusce luctus mollis metus at rhoncus.
				Vivamus dignissim, lectus vitae aliquam laoreet, massa velit
				hendrerit ligula, sit amet euismod elit tellus sed diam. Nam
				molestie dolor sit amet augue condimentum, ac fermentum eros
				sollicitudin. Ut dictum lacus lacus, ut viverra sapien dapibus at.
				Proin eleifend in odio in viverra. Pellentesque sit amet tellus
				magna. Suspendisse tellus nisl, ultrices sit amet sodales vitae,
				luctus a felis. Duis non rhoncus urna, vel finibus ex. Phasellus non
				mauris dui. Suspendisse laoreet dui ac ex sagittis congue. Duis
				interdum nunc sit amet eleifend ultrices. Nunc accumsan lobortis
				vehicula. Nulla semper eleifend mauris, a molestie ex gravida nec.
				Donec sit amet arcu quis mauris sollicitudin vestibulum eu in ante.
				Donec nec justo mattis, mollis nibh non, condimentum metus. Integer
				blandit urna lacus, at rhoncus nulla commodo dignissim. Duis augue
				neque, suscipit sit amet mauris vitae, eleifend finibus ante.
				Suspendisse tincidunt sagittis arcu. Aliquam feugiat tellus est,
				cursus dapibus nisl vulputate laoreet. Integer mauris diam,
				ultricies quis lacus ut, accumsan convallis enim. Lorem ipsum dolor
				sit amet, consectetur adipiscing elit. Curabitur eu augue lacus. In
				ornare auctor convallis. Proin tristique lacus sed magna placerat,
				vitae varius neque cursus. Nullam iaculis, est sit amet dapibus
				maximus, nisi elit porta sapien, ut varius nibh nibh ac turpis.
				Quisque eget bibendum nisi. In non accumsan ex. Mauris est magna,
				mollis non justo nec, semper lacinia risus. Curabitur id sapien at
				sapien commodo vulputate. Mauris ac ante eget metus consequat
				molestie. Quisque congue turpis at lacus vulputate convallis. In
				ullamcorper, tortor ac suscipit fringilla, libero elit condimentum
				ante, non hendrerit magna purus in elit. Etiam a varius dolor.
				Mauris dapibus ut diam vel placerat. Mauris eu massa eget enim
				tristique dictum id vel massa. Nunc vitae felis justo. Duis sit amet
				consequat elit, eu rutrum velit. Nulla vitae mauris orci. Aliquam
				fermentum ipsum convallis lobortis mattis. Quisque ultrices, nisi
				sed interdum egestas, elit velit aliquet ante, vel molestie dolor
				libero vitae quam.</div>

		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>