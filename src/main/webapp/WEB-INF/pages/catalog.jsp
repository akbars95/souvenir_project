<%--
  Created by IntelliJ IDEA.
  User: MTSMDA
  Date: 02.02.2016
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="title">
		<spring:message code="page.catalog.title" />
	</tiles:putAttribute>
	<tiles:putAttribute name="content">
		<div class="catalogPageBody" ng-controller="catalogCtrl">

			<div class="row">
				<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
					<span><spring:message code="page.catalog.sort.label" />:</span>
					<button ng-click="changeSortType('souvenirName')"
						class="btn btn-default">
						<span><spring:message
								code="page.catalog.sort.by_name.label" /></span>
					</button>
					<span ng-class="checkSortType()"
						ng-show="currentFieldName == 'souvenirName'"></span>

					<button ng-click="changeSortType('souvenirPrice')"
						class="btn btn-default">
						<span><spring:message
								code="page.catalog.sort.by_price.label" /></span>
					</button>
					<span ng-class="checkSortType()"
						ng-show="currentFieldName == 'souvenirPrice'"></span>

					<button ng-click="changeSortType('souvenirCountOfDaysForOrder')"
						class="btn btn-default">
						<span><spring:message
								code="page.catalog.sort.by_order_day.label" /></span>
					</button>
					<span ng-class="checkSortType()"
						ng-show="currentFieldName == 'souvenirCountOfDaysForOrder'"></span>

					<button ng-click="changeSortType('souvenirAudit.createdDatetime')"
						class="btn btn-default">
						<span><spring:message
								code="page.catalog.sort.by_created_date.label" /></span>
					</button>
					<span ng-class="checkSortType()"
						ng-show="currentFieldName == 'souvenirAudit.createdDatetime'"></span>

					<button
						ng-click="changeSortType('souvenirAudit.lastUpdateDatetime')"
						class="btn btn-default">
						<span><spring:message
								code="page.catalog.sort.by_updated_date.label" /></span>
					</button>
					<span ng-class="checkSortType()"
						ng-show="currentFieldName == 'souvenirAudit.lastUpdateDatetime'"></span>

				</div>
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
					<spring:message code="page.catalog.view.label" />
					<select ng-model="currentCountValue"
						ng-change="changeCountPerPage()"
						ng-options="currentPP.name for currentPP in countPerPage">
					</select>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 text-center"
					ng-repeat="souvenir in souvenirs | orderBy:currentFieldName: currentSortType">
					<h1>
						<spring:url value="get_souvenir_by_id/souvenir/" var="homeUrl"
							htmlEscape="true" />
						<a href="${homeUrl}{{souvenir.souvenirId}}">{{souvenir.souvenirName}}</a>
					</h1>
					<p></p>
					<img ng-src="souvenir.souvenirPath">
					price = {{souvenir.souvenirPrice}} order day :
					{{souvenir.souvenirCountOfDaysForOrder}}
					category = {{souvenir.souvenirCategory.souvenirCategory}}
					created - {{souvenir.souvenirAudit.createdDatetime}}
				</div>
			</div>
			<div class="text-center">
				<ul class="pagination pagination-lg" ng-show="showPagination()">
					<li ng-show="countOfPage.length > 1"><a href="#"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
					<!-- <li ng-repeat="currentCountOfPage in countOfPage track by $index"><a href="#">{{$index}}</a>
					</li> -->
					<li ng-show="countOfPage.length > 1"><a href="#"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</div>

		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>