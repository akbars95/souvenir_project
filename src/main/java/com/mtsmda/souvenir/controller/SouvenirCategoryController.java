package com.mtsmda.souvenir.controller;

import com.mtsmda.souvenir.model.SouvenirCategory;
import com.mtsmda.souvenir.service.SouvenirCategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by c-DMITMINZ on 29.01.2016.
 */
@Controller
public class SouvenirCategoryController {

	@Autowired
	@Qualifier("souvenirCategoryService")
	private SouvenirCategoryService souvenirCategoryService;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
    public String insertSouvenirCategory(SouvenirCategory souvenirCategory){
    	SouvenirCategory souvenirCategory2 = new SouvenirCategory();
    	souvenirCategory2.setSouvenirCategory("Cat9");
    	souvenirCategoryService.insertSouvenirCategory(souvenirCategory2);
        return "test";
    }

}