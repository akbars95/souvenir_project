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

<tiles:insertDefinition name="defaultAdminTemplate">
	<tiles:putAttribute name="title">
		<spring:message code="page.about_us.title" />
	</tiles:putAttribute>
	<tiles:putAttribute name="content">
		<div class="" ng-controller="insertSouvenirCtrl">
			<div id="addNewSouvenir">
				<div>
					<form action="/souvenir/souvenirInsert" method="post"
						enctype="multipart/form-data">
						<table>
							<tr>
								<td><label for="souvenirName"><spring:message
											code="page.insert_souvenir.addNewSouvenirForm.souvenir_name.label" /></label></td>
								<td><input type="text" id="souvenirName"
									name="souvenirName" ng-model="souvenirName"></td>
							</tr>
							<tr>
								<td><label for="souvenirDescription"><spring:message
											code="page.insert_souvenir.addNewSouvenirForm.souvenir_description.label" /></label></td>
								<td><textarea id="souvenirDescription" ng-model="souvenirDescription"
										name="souvenirDescription" rows="5" cols="25"></textarea></td>
							</tr>
							<tr>
								<td><label for="souvenirShow"><spring:message
											code="page.insert_souvenir.addNewSouvenirForm.souvenir_show.label" /></label></td>
								<td><input type="checkbox" id="souvenirShow" ng-model="souvenirShow"
									name="souvenirShow"></td>
							</tr>
							<tr>
								<td><label for="souvenirPath"><spring:message
											code="page.insert_souvenir.addNewSouvenirForm.souvenir_path.label" /></label></td>
								<td><input type="file" id="souvenirPath" accept="image/*"
								file-input="files"
									name="souvenirPath"></td>
							</tr>
							<tr>
								<td><label for="souvenirCategoryId"><spring:message
											code="page.insert_souvenir.addNewSouvenirForm.souvenir_category_id.label" /></label></td>
								<td><select id="souvenirCategoryId" ng-model="souvenirCategoryId"
									name="souvenirCategoryId">

								</select></td>
							</tr>
							<tr>
								<td><label for="souvenirPrice"><spring:message
											code="page.insert_souvenir.addNewSouvenirForm.souvenir_price.label" /></label></td>
								<td><input type="text" id="souvenirPrice" ng-model="souvenirPrice"
									name="souvenirPrice"></td>
							</tr>
							<tr>
								<td><input type="reset"
									value="<spring:message code='page.insert_souvenir.addNewSouvenirForm.resetBtn.label' />">
								</td>
								<td><input type="button" ng-click="save()"
									value="<spring:message code='page.insert_souvenir.addNewSouvenirForm.sendBtn.label' />"></td><!-- ng-click="save()" -->
							</tr>
						</table>
					</form>
				</div>
			</div>
			<div id="allSouvenirs"></div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>