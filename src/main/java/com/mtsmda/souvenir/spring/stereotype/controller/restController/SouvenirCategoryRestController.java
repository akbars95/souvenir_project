package com.mtsmda.souvenir.spring.stereotype.controller.restController;

import com.mtsmda.souvenir.spring.stereotype.controller.constants.StaticPageConstants;
import com.mtsmda.souvenir.spring.stereotype.object.request.SouvenirCategoryDTO;
import com.mtsmda.souvenir.model.SouvenirCategory;
import com.mtsmda.souvenir.spring.stereotype.controller.restController.constants.SouvenirCategoryRestConstants;
import com.mtsmda.souvenir.spring.stereotype.service.SouvenirCategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;;

@RestController
@RequestMapping(value = StaticPageConstants.REST_PATH_URL)
public class SouvenirCategoryRestController {

    @Autowired
    @Qualifier("souvenirCategoryService")
    private SouvenirCategoryService souvenirCategoryService;

    @RequestMapping(value = SouvenirCategoryRestConstants.GET_ALL_SOUVENIR_CATEGORIES_PIECE)
    public List<SouvenirCategory> getAllSouvenirCategory() {
        List<SouvenirCategory> categories = null;
        categories = souvenirCategoryService.getAllSouvenirCategories();
        return categories;
    }

    @RequestMapping(value = SouvenirCategoryRestConstants.INSERT_SOUVENIR_CATEGORIES_PIECE_URL)
    public boolean insertSouvenirCategory(@RequestBody SouvenirCategoryDTO souvenirCategoryDTO) {
        if (souvenirCategoryDTO != null && StringUtils.isNotBlank(souvenirCategoryDTO.getSouvenirCategory())) {
            return souvenirCategoryService.insertSouvenirCategory(souvenirCategoryDTO.convertToSouvenirCategory());
        }
        return false;
    }

}