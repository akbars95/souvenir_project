<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class=""><%-- ng-controller="adminSouvenirCtrl"--%>
    <div id="allSouvenirs">
        <div class="row">
            <div
                    ng-class-odd="'col-xs-10 col-xs-offset-1 col-sm-10 col-sm-offset-1 col-md-5 col-lg-5'"
                    ng-class-even="'col-md-5 col-md-offset-1 col-lg-5 col-lg-offset-1'"
                    ng-repeat="souvenirCurrent in souvenirs" id="souvenirNumber{{$index}}">
                <div style="display: inline-block;" ng-mouseenter="showOrHideButtons($index)"
                     ng-mouseleave=showOrHideButtons(-1)>
                    <a href="" class="adminSouvenirs"><h1
                            class="text-center">{{souvenirCurrent.souvenirName}}</h1>
                    </a>
                    <span style="cursor: pointer;" ng-click="hideSouvenir($index);" ng-show="currentHoverIndex == $index && souvenirCurrent.souvenirShow"><img
                            ng-src="<spring:url value="/resources/images/visible.png" htmlEscape="true"/>"/></span>
                    <span style="cursor: pointer;" ng-click="showSouvenir($index);" ng-show="currentHoverIndex == $index && !souvenirCurrent.souvenirShow"><img
                            ng-src="<spring:url value="/resources/images/invisible.png" htmlEscape="true"/>"/></span>
                    <span ng-show="currentHoverIndex == $index" ng-click="editSouvenir($index);"
                          class="glyphicon glyphicon-edit iconForRemoveOrEdit"></span>
                    <span ng-show="currentHoverIndex == $index"
                          ng-click="prepareForRemoveSouvenir($index, souvenirCurrent.souvenirName);"
                          class="glyphicon glyphicon-remove iconForRemoveOrEdit" data-toggle="modal"
                          data-target=".bs-example-modal-lg"></span>
                </div>

            </div>

            <!-- Small modal -->
            <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
                <div class="modal-dialog modal-lg removeModelDialog">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <h4 class="modal-title" id="myModalLabel">
                            <spring:message
                                    code="page.admin.souvenir.remove.modal_view.title"/>
                        </h4>
                    </div>
                    <div class="modal-body">
                        <h2 class="text-center" class="currentForRemoveSouvenirQuestion"><spring:message
                                code="page.admin.souvenir.remove.modal_view.remove_question.title"/><span
                                class="currentForRemoveSouvenir">{{currentSouvenirName}}</span>?</h2>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal"><spring:message
                                code="page.admin.souvenir.remove.modal_view.reset_btn.title"/></button>
                        <button type="button" class="btn btn-danger" data-dismiss="modal" ng-click="removeSouvenir();">
                            <spring:message
                                    code="page.admin.souvenir.remove.modal_view.remove_btn.title"/>
                        </button>
                    </div>
                </div>
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

                <%--modal begin--%>
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
                                                   id="souvenirName" ng-model="souvenirName">
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
                                                              id="souvenirDescription" name="souvenirDescription"
                                                              ng-model="souvenirDescription"></textarea>
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
                                            <input type="checkbox" name="souvenirShow"
                                                   id="souvenirShow" ng-model="souvenirShow">
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
                                                   name="souvenirPrice" id="souvenirPrice"
                                                   ng-model="souvenirPrice">
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
                                                   id="souvenirCountOfDaysForOrder"
                                                   ng-model="souvenirCountOfDaysForOrder">
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
                                            <select id="souvenirCategory" ng-model="currentSouvenirCategoryId">
                                                <option selected value="-"> -</option>
                                                <option
                                                        ng-repeat="currentSouvenirCategory in souvenirCategories"
                                                        value="{{currentSouvenirCategory.souvenirCategoryId}}">
                                                    {{currentSouvenirCategory.souvenirCategory}}
                                                </option>
                                            </select>
                                            <button class="btn btn-default btn-margin-top"
                                                    ng-click="showOrHideAddNewSouvenirCategory();">
                                                        <span ng-if="!addNewCategory"><spring:message
                                                                code="page.admin.souvenir.add.new.modal_view.form.souvenirCategory.addNewSouvenirCategory_btn.title"/></span>
                                                        <span ng-if="addNewCategory"><spring:message
                                                                code="page.admin.souvenir.add.new.modal_view.form.souvenirCategory.addNewSouvenirCategory_hide_btn.title"/></span>
                                            </button>
                                        </div>
                                    </div>
                                </div>

                                <form name="addNewSouvenirCategoryForm" id="addNewSouvenirCategoryForm"
                                      novalidate="novalidate">
                                    <div class="form-group" ng-show="addNewCategory">
                                        <div class="row">
                                            <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                                <label for="newSouvenirCategoryName" class="control-label">
                                                    <spring:message
                                                            code="page.admin.souvenir.add.new.modal_view.form.souvenirCategory.newSouvenirCategoryName.title"/>
                                                </label>
                                            </div>
                                            <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                                <input type="text" id="newSouvenirCategoryName"
                                                       name="newSouvenirCategoryName"
                                                       ng-model="souvenirCategory" required ng-minlength="2"
                                                       ng-maxlength="50"
                                                       placeholder="<spring:message code="page.admin.souvenir.add.new.modal_view.form.souvenirCategory.newSouvenirCategoryName_input_text.placeholder"/>">

                                                <p>
                                                        <span ng-show="addNewSouvenirCategoryForm.newSouvenirCategoryName.$valid"><spring:message
                                                                code="page.admin.souvenir.add.new.modal_view.form.souvenirCategory.newSouvenirCategoryName_input_text.count.input.letters"/> {{50 - souvenirCategory.length}} / 50</span>
                                                        <span class="error"
                                                              ng-show="addNewSouvenirCategoryForm.newSouvenirCategoryName.$error.required"> <spring:message
                                                                code="page.admin.souvenir.add.new.modal_view.form.souvenirCategory.newSouvenirCategoryName_input_text.error.required"/></span> <span
                                                        class="error"
                                                        ng-show="addNewSouvenirCategoryForm.newSouvenirCategoryName.$error.minlength"> <spring:message
                                                        code="page.admin.souvenir.add.new.modal_view.form.souvenirCategory.newSouvenirCategoryName_input_text.error.minlength"/></span> <span
                                                        class="error"
                                                        ng-show="addNewSouvenirCategoryForm.newSouvenirCategoryName.$error.maxlength"> <spring:message
                                                        code="page.admin.souvenir.add.new.modal_view.form.souvenirCategory.newSouvenirCategoryName_input_text.error.maxlength"/></span>
                                                </p>
                                                <button class="btn btn-success btn-margin-top"
                                                        ng-click="addNewSouvenirCategory();"
                                                        ng-disabled="addNewSouvenirCategoryForm.$invalid">
                                                    <spring:message
                                                            code="page.admin.souvenir.add.new.modal_view.form.souvenirCategory.newSouvenirCategoryName.title"/></button>
                                            </div>
                                        </div>
                                    </div>
                                </form>

                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                            <label for="souvenirPhotos" class="control-label">
                                                <spring:message
                                                        code="page.admin.souvenir.add.new.modal_view.form.photos.title"/>
                                            </label>
                                        </div>
                                        <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                            <input type="file" accept="image/*" multiple="multiple"
                                                   id="souvenirPhotos" file-model="souvenirFiles"/>
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
                                <button type="reset" class="btn btn-danger" ng-click="resetForm();">
                                    <spring:message
                                            code="page.admin.souvenir.add.new.modal_view.reset_btn.title"/>
                                </button>
                                <button type="button" class="btn btn-success"
                                        ng-click="saveSouvenir();">
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