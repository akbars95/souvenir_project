<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<input type="text" ng-model = "number">
<button ng-click="square();">Click</button>
<p>Result: {{result}}</p>

<div class=""><%-- ng-controller="adminSouvenirCtrl"--%>
    <div id="allSouvenirs">
        <div class="row">
            <div
                    ng-class-odd="classForSouvenirOdd"
                    ng-class-even="classForSouvenirEven" class="text-center"
                    ng-repeat="souvenirCurrent in souvenirs" id="souvenirNumber{{$index}}">
                <div style="display: inline-block;" ng-mouseenter="showOrHideButtons($index)"
                     ng-mouseleave=showOrHideButtons(-1)>
                    <a href="" class="adminSouvenirs" data-toggle="modal" data-target="#newOrEditOrViewSouvenirModalView"
                    ng-click="reviewSouvenirButtonClick($index);"><h1
                            class="text-center">{{souvenirCurrent.souvenirName}}</h1>
                    </a>
                    <span style="cursor: pointer;" ng-click="hideSouvenir($index);" ng-show="currentHoverIndex == $index && souvenirCurrent.souvenirShow" data-toggle="tooltip" data-placement="top" title='<spring:message code="page.admin.souvenir.hide.button.tooltip"/>'>
                    <img ng-src="<spring:url value="/resources/images/visible.png" htmlEscape="true"/>"/></span>
                    <span style="cursor: pointer;" ng-click="showSouvenir($index);" ng-show="currentHoverIndex == $index && !souvenirCurrent.souvenirShow" data-toggle="tooltip" data-placement="top" title='<spring:message code="page.admin.souvenir.show.button.tooltip"/>'><img
                            ng-src="<spring:url value="/resources/images/invisible.png" htmlEscape="true"/>"/></span>
                    <span data-toggle="tooltip" data-placement="top" title='<spring:message code="page.admin.souvenir.edit.button.tooltip"/>'>
                    <span ng-show="currentHoverIndex == $index" ng-click="editSouvenir($index);" data-toggle="modal" data-target="#newOrEditOrViewSouvenirModalView"
                          class="glyphicon glyphicon-edit iconForRemoveOrEdit">
                          </span>
                          </span>
                    <span ng-show="currentHoverIndex == $index"
                          ng-click="prepareForRemoveSouvenir($index, souvenirCurrent.souvenirName);"
                          class="glyphicon glyphicon-remove iconForRemoveOrEdit" data-toggle="modal"
                          data-target=".bs-example-modal-lg" data-toggle="tooltip" data-placement="top" title='<spring:message code="page.admin.souvenir.remove.button.tooltip"/>'>
                          </span>
                </div>

            </div>

            <!-- Small modal for remove souvenir -->
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
                        data-toggle="modal" data-target="#newOrEditOrViewSouvenirModalView"
                        ng-mouseenter="eventMouseEnterNew()"
                        ng-mouseleave="eventMouseLeaveNew()" ng-click="addNewSouvenirButtonClick();">
							<span class="glyphicon"
                                  ng-class="styleClassesForInsertNewSouvenir"></span>
                </button>

                <%--modal begin for new souvenir--%>
                <div class="modal fade" id="newOrEditOrViewSouvenirModalView" tabindex="-1"
                     role="dialog" aria-labelledby="gridSystemModalLabel">
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"
                                        aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                                <h4 class="modal-title" id="gridSystemModalLabel">
                                    <span ng-show="currentModalView == 1"><spring:message
                                            code="page.admin.souvenir.add.new.modal_view.title"/></span>
                                    <span ng-show="currentModalView == 0">
                                    <spring:message code="page.admin.souvenir.edit.modal_view.title"/></span>
                                    <span ng-show="currentModalView == 9">
                                    <spring:message code="page.admin.souvenir.view.modal_view.title"/></span>
                                </h4>
                            </div>
                            <!-- body -->
                            <div class="modal-body">
								<div ng-hide="currentModalView == 9">
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                            <label for="souvenirName" class="control-label"> <spring:message
                                                    code="page.admin.souvenir.add.new.modal_view.form.souvenirName.title"/>
                                            </label>
                                        </div>
                                        <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                            <input ng-show="currentModalView == 1" class="form-control" type="text" name="souvenirName"
                                                   id="souvenirName" ng-model="souvenirName">
                                                   <input ng-show="currentModalView == 0" class="form-control" type="text" name="souvenirName"
                                                                                                      id="souvenirName" ng-model="currentSouvenirForEdit.souvenirName">
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
													<textarea ng-show="currentModalView == 1" class="form-control" rows="5" cols="25"
                                                              id="souvenirDescription" name="souvenirDescription"
                                                              ng-model="souvenirDescription"></textarea>
                                                      <textarea ng-show="currentModalView == 0" class="form-control" rows="5" cols="25"
                                                            id="souvenirDescription" name="souvenirDescription"
                                                            ng-model="currentSouvenirForEdit.souvenirDescription"></textarea>
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
                                            <input ng-show="currentModalView == 1" type="checkbox" name="souvenirShow"
                                                   id="souvenirShow" ng-model="souvenirShow">
                                           <input ng-show="currentModalView == 0" type="checkbox" name="souvenirShow"
                                                                              id="souvenirShow" ng-model="currentSouvenirForEdit.souvenirShow">
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
                                            <input ng-show="currentModalView == 1" class="form-control" type="number"
                                                   name="souvenirPrice" id="souvenirPrice"
                                                   ng-model="souvenirPrice">
                                           <input ng-show="currentModalView == 0" class="form-control" type="number"
                                                                                              name="souvenirPrice" id="souvenirPrice"
                                                                                              ng-model="currentSouvenirForEdit.souvenirPrice">
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
                                            <input ng-show="currentModalView == 1" class="form-control" type="number"
                                                   name="souvenirCountOfDaysForOrder"
                                                   id="souvenirCountOfDaysForOrder"
                                                   ng-model="souvenirCountOfDaysForOrder">
                                           <input ng-show="currentModalView == 0" class="form-control" type="number"
                                                  name="souvenirCountOfDaysForOrder"
                                                  id="souvenirCountOfDaysForOrder"
                                                  ng-model="currentSouvenirForEdit.souvenirCountOfDaysForOrder">
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
                                            <select ng-show="currentModalView == 1" id="souvenirCategory" ng-model="currentSouvenirCategoryId">
                                                <option selected value="-"> -</option>
                                                <option
                                                        ng-repeat="currentSouvenirCategory in souvenirCategories"
                                                        value="{{currentSouvenirCategory.souvenirCategoryId}}">
                                                    {{currentSouvenirCategory.souvenirCategory}}
                                                </option>
                                            </select>
                                            <span ng-show="currentModalView == 0 && !editSouvenirCategoryStatus" ng-click="editSouvenirCategory();">{{currentSouvenirForEdit.souvenirCategory.souvenirCategory}}</span>
                                            <select ng-blur="editSouvenirCategory();" ng-show="currentModalView == 0 && editSouvenirCategoryStatus" id="souvenirCategory" ng-model="currentSouvenirForEdit.souvenirCategory.souvenirCategoryId">
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
                                           <div id="progress_bar"><div class="progress">0%</div></div>
                                           <button ng-click="abortFiles();">Cancel read</button>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group" ng-show="souvenirFiles.length > 0">
                                    <div class="row">
                                        <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1">#/main photo</div>
                                        <div class="col-xs-6 col-sm-5 col-md-4 col-lg-4">File name</div>
                                        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">File size / File type</div>
                                        <div class="col-xs-2 col-sm-3 col-md-4 col-lg-4"></div>
                                    </div>
                                    <div class="row" ng-repeat="currentFile in souvenirFiles">
                                        <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1">
                                            <label>
                                                <input type="radio" ng-click="changeMainPhoto($index)" name="mainPhotoAdd">
                                                {{$index + 1}}
                                            </label>
                                        </div>
                                        <div class="col-xs-6 col-sm-5 col-md-4 col-lg-4">{{currentFile.name}}</div>
                                        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">{{currentFile.size}} / {{currentFile.type}}</div>
                                        <div class="col-xs-1 col-sm-2 col-md-3 col-lg-3"></div>
                                    </div>
                                    <img id="output">
                                </div>
								</div>

								<div ng-show="currentModalView == 9">
									<div class="row">
									    <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
									        <spring:message code="page.admin.souvenir.review.modal_view.author.title"/>: admin
									    </div>
									    <div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
                                            <spring:message code="page.admin.souvenir.review.modal_view.createdDateTime.title"/> - {{currentSouvenirForReview.souvenirAudit.createdDatetime}}
                                        </div>
                                        <div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
                                            <spring:message code="page.admin.souvenir.review.modal_view.lastUpdatedDateTime.title"/> - {{currentSouvenirForReview.souvenirAudit.lastUpdateDatetime}}
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="text-center col-xs-10 col-xs-offset-1 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1">
                                            <h1>{{currentSouvenirForReview.souvenirName}}</h1>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="text-left col-xs-10 col-xs-offset-1 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1">
                                            <p><spring:message code="page.admin.souvenir.review.modal_view.description.title"/></p>
                                            <p>{{currentSouvenirForReview.souvenirDescription}}</p>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                                            <p><spring:message code="page.admin.souvenir.review.modal_view.showInSite.title"/> - <span class="glyphicon {{currentSouvenirForReview.souvenirShow == true ? 'glyphicon-ok' : 'glyphicon-remove'}}" aria-hidden="true"></span></p>
                                        </div>
                                        <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                                            <p><spring:message code="page.admin.souvenir.review.modal_view.countOfDaysForOrder.title"/> - {{currentSouvenirForReview.souvenirCountOfDaysForOrder}}</p>
                                        </div>
                                        <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                                            <p><spring:message code="page.admin.souvenir.review.modal_view.category.title"/> - {{currentSouvenirForReview.souvenirCategory.souvenirCategory}}</p>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                            <p>
                                                <img class="imgSouvenirPhoto" src="{{hostConst}}{{currentSouvenirForReview.souvenirMainPhotoId.souvenirPhotoPath}}">
                                            </p>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                            <p ng-repeat="currentSouvenirPhoto in currentSouvenirForReview.souvenirPhotos">
                                                <img class="imgSouvenirPhoto" src="{{hostConst}}{{currentSouvenirPhoto.souvenirPhotoPath}}">
                                            </p>
                                        </div>
                                    </div>
								</div>
                            </div>
                            <div class="modal-footer">
                                <button ng-show="currentModalView == 9" type="button" class="btn btn-info"
                                ng-click="editSouvenir(currentModalView);">
                                    <spring:message
                                            code="page.admin.souvenir.add.new.modal_view.modify.title"/>
                                </button>
                                <button type="button" class="btn btn-default"
                                        data-dismiss="modal">
                                    <spring:message
                                            code="page.admin.souvenir.add.new.modal_view.close_btn.title"/>
                                </button>
                                <button ng-hide="currentModalView == 9" type="reset" class="btn btn-danger" ng-click="resetForm(currentModalView);">
                                    <spring:message
                                            code="page.admin.souvenir.add.new.modal_view.reset_btn.title"/>
                                </button>
                                <button ng-hide="currentModalView == 9" type="button" class="btn btn-success"
                                        ng-click="saveSouvenir(currentModalView);">
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