<%--
  Created by IntelliJ IDEA.
  User: MTSMDA
  Date: 03.02.2016
  Time: 7:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<tiles:insertDefinition name="defaultAdminTemplate">
    <tiles:putAttribute name="title">
        <spring:message code="page.about_us.title"/>
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
                    <div class="text-center" ng-class="addNewSouvenirBootstrapClass"
                         ng-show="souvenirs.length > 0">
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
                                                    code="page.admin.souvenir.add.new.modal_view.title"/>
                                        </h4>
                                    </div>
                                    <!-- body -->
                                    <div class="modal-body">
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                                    <label for="souvenirName" class="control-label"> <spring:message
                                                            code="page.admin.souvenir.add.new.modal_view.form.souvenirName.title"/>
                                                    </label>
                                                </div>
                                                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                                    <input class="form-control" type="text" name="souvenirName"
                                                           id="souvenirName">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                                    <label for="souvenirDescription" class="control-label">
                                                        <spring:message
                                                                code="page.admin.souvenir.add.new.modal_view.form.souvenirDescription.title"/>
                                                    </label>
                                                </div>
                                                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
													<textarea class="form-control" rows="5" cols="25"
                                                              id="souvenirDescription"
                                                              name="souvenirDescription"></textarea>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                                    <label for="souvenirShow" class="control-label"> <spring:message
                                                            code="page.admin.souvenir.add.new.modal_view.form.souvenirShow.title"/>
                                                    </label>
                                                </div>
                                                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                                    <input type="checkbox"
                                                           name="souvenirShow" id="souvenirShow">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                                    <label for="souvenirPrice" class="control-label"> <spring:message
                                                            code="page.admin.souvenir.add.new.modal_view.form.souvenirPrice.title"/>
                                                    </label>
                                                </div>
                                                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                                    <input class="form-control" type="number"
                                                           name="souvenirPrice" id="souvenirPrice">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                                    <label for="souvenirCountOfDaysForOrder"
                                                           class="control-label"> <spring:message
                                                            code="page.admin.souvenir.add.new.modal_view.form.souvenirCountOfDaysForOrder.title"/>
                                                    </label>
                                                </div>
                                                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                                    <input class="form-control" type="number"
                                                           name="souvenirCountOfDaysForOrder"
                                                           id="souvenirCountOfDaysForOrder">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                                    <label for="souvenirCategory" class="control-label">
                                                        <spring:message
                                                                code="page.admin.souvenir.add.new.modal_view.form.souvenirCategory.souvenirCategory.title"/>
                                                    </label>
                                                </div>
                                                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                                    <select id="souvenirCategory">
                                                        <option value="currentSouvenirCategory.souvenirCategoryId"
                                                                ng-repeat="currentSouvenirCategory in souvenirCategories">
                                                            {{currentSouvenirCategory.souvenirCategory}}
                                                        </option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default"
                                                data-dismiss="modal">
                                            <spring:message
                                                    code="page.admin.souvenir.add.new.modal_view.close_btn.title"/>
                                        </button>
                                        <button type="button" class="btn btn-primary">
                                            <spring:message
                                                    code="page.admin.souvenir.add.new.modal_view.save_btn.title"/>
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