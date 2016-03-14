package com.mtsmda.souvenir.controller.constants;

import static com.mtsmda.souvenir.controller.constants.StaticPageConstants.*;

public class AdminPieceConstants {

	public static final String ADMIN_PIECE_PIECE = "adminPiece";
	public static final String SOUVENIR_PIECE = "souvenir";
	public static final String SOUVENIR_CATEGORY_PIECE = "souvenirCategory";
	public static final String MESSAGE_PIECE = "message";
	public static final String INDEX_PIECE = "index";
	public static final String ADMIN_MAIN_PAGE_PIECE = "admin_main_page";
	public static final String SOUVENIR_PIECE_OP_INSERT = "insert";

	public static final String ADMIN_SOUVENIR_PIECE_INTERNAL_FILE = "admin_souvenir";
	public static final String ADMIN_SOUVENIR_CATEGORY_PIECE_INTERNAL_FILE = "admin_souvenir_category";
	public static final String ADMIN_MESSAGE_PIECE_INTERNAL_FILE = "admin_message";
	public static final String ADMIN_INDEX_PIECE_INTERNAL_FILE = "admin_index";
	public static final String ADMIN_MAIN_PAGE_PIECE_INTERNAL_FILE = "admin_main_page";

	public static final String SOUVENIR_PIECE_INTERNAL_FOLDER = "adminPiece";
	public static final String SOUVENIR_PIECE_INTERNAL_FILE = "insert_souvenir";

	public static final String ADMIN_PIECE_PIECE_URL = ROOT + ADMIN_PIECE_PIECE;
	public static final String SOUVENIR_PIECE_OP_INSERT_URL = ROOT + SOUVENIR_PIECE + ROOT + SOUVENIR_PIECE_OP_INSERT;
	public static final String SOUVENIR_PIECE_INSERT_INTERNAL_URL = SOUVENIR_PIECE_INTERNAL_FOLDER + ROOT
			+ SOUVENIR_PIECE_INTERNAL_FILE;

	public static final String ADMIN_SOUVENIR_PIECE_URL = ROOT + SOUVENIR_PIECE;
	public static final String SOUVENIR_CATEGORY_PIECE_URL = ROOT + SOUVENIR_CATEGORY_PIECE;
	public static final String MESSAGE_PIECE_URL = ROOT + MESSAGE_PIECE;
	public static final String INDEX_PIECE_URL = ROOT + INDEX_PIECE;
	public static final String ADMIN_MAIN_PAGE_PIECE_URL = ROOT + ADMIN_MAIN_PAGE_PIECE;
	public static final String ADMIN_SOUVENIR_INTERNAL_URL = SOUVENIR_PIECE_INTERNAL_FOLDER + ROOT
			+ ADMIN_SOUVENIR_PIECE_INTERNAL_FILE;
	public static final String ADMIN_SOUVENIR_CATEGORY_INTERNAL_URL = SOUVENIR_PIECE_INTERNAL_FOLDER + ROOT
			+ ADMIN_SOUVENIR_CATEGORY_PIECE_INTERNAL_FILE;
	public static final String ADMIN_MESSAGE_INTERNAL_URL = SOUVENIR_PIECE_INTERNAL_FOLDER + ROOT
			+ ADMIN_MESSAGE_PIECE_INTERNAL_FILE;
	public static final String ADMIN_INDEX_INTERNAL_URL = SOUVENIR_PIECE_INTERNAL_FOLDER + ROOT
			+ ADMIN_INDEX_PIECE_INTERNAL_FILE;
	public static final String ADMIN_MAIN_PAGE_PIECE_INTERNAL_URL = SOUVENIR_PIECE_INTERNAL_FOLDER + ROOT
			+ ADMIN_MAIN_PAGE_PIECE_INTERNAL_FILE;

}