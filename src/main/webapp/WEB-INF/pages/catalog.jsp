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

			<div class="row text-center">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
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
			</div>
			<div class="row">
				<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
					<spring:message code="page.catalog.countPerRow.view.label"/>
					<select ng-model="currentCountInRowSouvenir.count"
							ng-options="countInRowSouvenir.count as countInRowSouvenir.label for countInRowSouvenir in countInRowSouvenirs"></select>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
					<spring:message code="page.catalog.view.label"/>
					<select ng-model="currentCountValue"
							ng-change="changeCountPerPage()"
							ng-options="currentPP.name for currentPP in countPerPage">
					</select>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                    <spring:message code="page.catalog.currency.label"/>
                    <select ng-model="currentCountValue"
                            ng-change="changeCountPerPage()"
                            ng-options="currentPP.name for currentPP in countPerPage">
                    </select>
                </div>
			</div>

			<div class="row">
				<div class="col-lg-{{currentCountInRowSouvenir.count}} col-md-{{currentCountInRowSouvenir.count}} col-sm-{{currentCountInRowSouvenir.count}} col-xs-{{currentCountInRowSouvenir.count}} text-center catalog-souvenir"
					ng-repeat="souvenir in souvenirs | orderBy:currentFieldName: currentSortType">
					<h1 class="souvenir-name">
						<spring:url value="get_souvenir_by_id/souvenir/" var="homeUrl"
							htmlEscape="true" />
						<a href="${homeUrl}{{souvenir.souvenirId}}">{{souvenir.souvenirName}}</a>
					</h1>
					<div class="row">
						<div class="col-lg-6 col-lg-offset-0 col-md-8 col-md-offset-2 col-sm-12 col-xs-12">
							<span><spring:message code="page.catalog.souvenir.createdTime.title" /></span> - {{souvenir.souvenirAudit.createdDatetime}}
						</div>
						<div class="col-lg-6 col-lg-offset-0 col-md-8 col-md-offset-2 col-sm-12 col-xs-12">
							<span><spring:message code="page.catalog.souvenir.updatedTime.title" /></span> - {{souvenir.souvenirAudit.lastUpdateDatetime}}
						</div>
					</div>
					<spring:url value="resources/" var="resourcesUrl"
								htmlEscape="true" />
					<div class="souvenir-image-wrapper" ng-show="souvenir.souvenirMainPhotoId.souvenirPhotoPath != null">
						<img class="souvenir-image" src="${resourcesUrl}{{souvenir.souvenirMainPhotoId.souvenirPhotoPath}}">
					</div>
					<div class="souvenir-image-wrapper" ng-show="souvenir.souvenirMainPhotoId.souvenirPhotoPath == null">
						<p class="souvenir-no-image">
							<spring:message code="page.catalog.souvenir.noimage.title" />
						</p>
					</div>
					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<span><spring:message code="page.catalog.souvenir.category.title" /></span> - {{souvenir.souvenirCategory.souvenirCategory}}
						</div>
					</div>
					<div class="row">
					    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <span><spring:message code="page.catalog.souvenir.orderCountOfDay.title" /></span> - {{souvenir.souvenirCountOfDaysForOrder}}
                        </div>
					</div>
					<div class="row">
					    <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                            <span><spring:message code="page.catalog.souvenir.price.title" /></span> - {{souvenir.souvenirPrice}}
                        </div>
					    <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                            <span><spring:message code="page.catalog.souvenir.price.title" /></span>

                        </div>
					</div>
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