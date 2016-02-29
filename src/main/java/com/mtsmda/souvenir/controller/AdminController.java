package com.mtsmda.souvenir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.mtsmda.souvenir.controller.constants.AdminPieceConstants.*;

@Controller
@RequestMapping(value = { ADMIN_PIECE_PIECE_URL }, method = RequestMethod.GET)
public class AdminController {

	@RequestMapping(value = SOUVENIR_PIECE_OP_INSERT_URL, method = RequestMethod.GET)
	public String insertNewSouvenir() {
		return SOUVENIR_PIECE_INSERT_INTERNAL_URL;
	}

	@RequestMapping(value = ADMIN_SOUVENIR_PIECE_URL, method = RequestMethod.GET)
	public String adminSouvenir() {
		return ADMIN_SOUVENIR_INTERNAL_URL;
	}

}