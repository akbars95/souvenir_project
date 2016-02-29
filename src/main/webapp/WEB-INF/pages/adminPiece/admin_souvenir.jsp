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
		<div class="" ng-controller="adminSouvenirCtrl">
			<div id="allSouvenirs">
				<div class="row">
					<div
						ng-class-odd="'col-xs-10 col-xs-offset-1 col-sm-10 col-sm-offset-1 col-md-5 col-lg-5'"
						ng-class-even="'col-md-5 col-md-offset-1 col-lg-5 col-lg-offset-1'"
						ng-repeat="souvenirCurrent in souvenirs">
						<a href="#/{{souvenirCurrent.souvenirId}}"><h1
								class="text-center">{{souvenirCurrent.souvenirName}}</h1></a>
					</div>
					<div class="text-center" ng-class="addNewSouvenirBootstrapClass">



						<!-- Button trigger modal -->
						<button type="button" class="btn btn-primary btn-lg"
							data-toggle="modal" data-target="#newSouvenirModalView"
							ng-mouseenter="eventMouseEnterNew()"
							ng-mouseleave="eventMouseLeaveNew()">
							<span class="glyphicon"
								ng-class="styleClassesForInsertNewSouvenir"></span>
						</button>

						<div class="modal fade" id="newSouvenirModalView" tabindex="-1"
							role="dialog" aria-labelledby="gridSystemModalLabel">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title" id="gridSystemModalLabel">
											<spring:message
												code="page.admin.souvenir.add.new.modal_view.title" />
										</h4>
									</div>
									<div class="modal-body">
										<div class="row">
											<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
											<label for="souvenirName">
												<spring:message
												code="page.admin.souvenir.add.new.modal_view.form.souvenirName.title" />
											</label>
											</div>
											<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
												<input type="text" name="souvenirName" id="souvenirName">
											</div>
										</div>
										<div class="row">
											<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
												
											</div>
											<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">.col-md-2
												.col-md-offset-4</div>
										</div>
										<div class="row">
											<div class="col-md-6 col-md-offset-3">.col-md-6
												.col-md-offset-3</div>
										</div>
										<div class="row">
											<div class="col-sm-9">
												Level 1: .col-sm-9
												<div class="row">
													<div class="col-xs-8 col-sm-6">Level 2: .col-xs-8
														.col-sm-6</div>
													<div class="col-xs-4 col-sm-6">Level 2: .col-xs-4
														.col-sm-6</div>
												</div>
											</div>
										</div>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">
											<spring:message
												code="page.admin.souvenir.add.new.modal_view.close_btn.title" />
										</button>
										<button type="button" class="btn btn-primary">
											<spring:message
												code="page.admin.souvenir.add.new.modal_view.save_btn.title" />
										</button>
									</div>
								</div>
								<!-- /.modal-content -->
							</div>
							<!-- /.modal-dialog -->
						</div>
						<!-- /.modal -->
					</div>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>