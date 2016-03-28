package com.mtsmda.souvenir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;

import static com.mtsmda.souvenir.controller.constants.AdminPieceConstants.*;

@Controller
@RequestMapping(value = { ADMIN_PIECE_PIECE_URL }, method = RequestMethod.GET)
public class AdminController {

	/*@Deprecated
	@RequestMapping(value = SOUVENIR_PIECE_OP_INSERT_URL, method = RequestMethod.GET)
	public String insertNewSouvenir() {
		return SOUVENIR_PIECE_INSERT_INTERNAL_URL;
	}*/

	@RequestMapping(value = INDEX_PIECE_URL, method = RequestMethod.GET)
	public String indexMessage() {
		return ADMIN_INDEX_INTERNAL_URL;
	}

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

	public static void main(String[] args) {
		String s = new AdminController().getClass().getResource("").getFile();
		System.out.println(s);
		File file = new File(s + "/file.txt");
		System.out.println("ex - " + file.exists());
		System.out.println(file.getAbsoluteFile().getAbsolutePath());

		ClassLoader classLoader = new AdminController().getClass().getClassLoader();
		File file2 = new File(classLoader.getResource("log4j.properties").getFile());

		System.out.println(file2.exists());
	}


}