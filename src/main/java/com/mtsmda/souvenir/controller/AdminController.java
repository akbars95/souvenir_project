package com.mtsmda.souvenir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.mtsmda.souvenir.controller.constants.AdminPieceConstants.*;

@Controller
@RequestMapping(value = { ADMIN_PIECE_PIECE_URL }, method = RequestMethod.GET)
public class AdminController {
/*
	@RequestMapping(value = SOUVENIR_PIECE_OP_INSERT_URL, method = RequestMethod.GET)
	public String insertNewSouvenir() {
		return SOUVENIR_PIECE_INSERT_INTERNAL_URL;
	}*/

	@RequestMapping(value = ADMIN_SOUVENIR_PIECE_URL, method = RequestMethod.GET)
	public String adminSouvenir() {
		return  ADMIN_SOUVENIR_INTERNAL_URL;
	}

	@RequestMapping(value = SOUVENIR_CATEGORY_PIECE_URL, method = RequestMethod.GET)
	public String adminSouvenirCategory() {
		return  ADMIN_SOUVENIR_CATEGORY_INTERNAL_URL;
	}

	@RequestMapping(value = MESSAGE_PIECE_URL, method = RequestMethod.GET)
	public String adminMessage() {
		return ADMIN_MESSAGE_INTERNAL_URL;
	}

	@RequestMapping(value = ADMIN_MAIN_PAGE_PIECE_URL, method = RequestMethod.GET)
	public String adminMainPageTemplateMessage() {
		return ADMIN_MAIN_PAGE_PIECE_INTERNAL_URL;
	}



}