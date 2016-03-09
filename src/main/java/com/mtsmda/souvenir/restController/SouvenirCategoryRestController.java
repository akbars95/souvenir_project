package com.mtsmda.souvenir.restController;

import java.util.List;

import static com.mtsmda.souvenir.restController.constants.SouvenirCategoryRestConstants.*;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtsmda.souvenir.model.SouvenirCategory;
import com.mtsmda.souvenir.service.SouvenirCategoryService;

@RestController
public class SouvenirCategoryRestController {

    @Autowired
    @Qualifier("souvenirCategoryService")
    private SouvenirCategoryService souvenirCategoryService;

    @RequestMapping(value = GET_ALL_SOUVENIR_CATEGORIES_PIECE)
    public List<SouvenirCategory> getAllSouvenirCategory() {
        List<SouvenirCategory> categories = null;
        categories = souvenirCategoryService.getAllSouvenirCategories();
        return categories;
    }

    @RequestMapping(value = INSERT_SOUVENIR_CATEGORIES_PIECE_URL)
    public boolean insertSouvenirCategory(@RequestBody SouvenirCategory souvenirCategory) {
        if (souvenirCategory != null && StringUtils.isNotBlank(souvenirCategory.getSouvenirCategory())) {
            return souvenirCategoryService.insertSouvenirCategory(souvenirCategory);
        }
        return false;
    }

}