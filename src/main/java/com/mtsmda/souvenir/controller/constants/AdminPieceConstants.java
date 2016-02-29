package com.mtsmda.souvenir.controller.constants;

import static com.mtsmda.souvenir.controller.constants.StaticPageConstants.*;

public class AdminPieceConstants {

	public static final String ADMIN_PIECE_PIECE = "adminPiece";
	public static final String SOUVENIR_PIECE = "souvenir";
	public static final String SOUVENIR_PIECE_OP_INSERT = "insert";
	public static final String ADMIN_SOUVENIR_PIECE_INTERNAL_FILE = "admin_souvenir";

	public static final String SOUVENIR_PIECE_INTERNAL_FOLDER = "adminPiece";
	public static final String SOUVENIR_PIECE_INTERNAL_FILE = "insert_souvenir";

	public static final String ADMIN_PIECE_PIECE_URL = ROOT + ADMIN_PIECE_PIECE;
	public static final String SOUVENIR_PIECE_OP_INSERT_URL = ROOT + SOUVENIR_PIECE + ROOT + SOUVENIR_PIECE_OP_INSERT;
	public static final String SOUVENIR_PIECE_INSERT_INTERNAL_URL = SOUVENIR_PIECE_INTERNAL_FOLDER + ROOT
			+ SOUVENIR_PIECE_INTERNAL_FILE;

	public static final String ADMIN_SOUVENIR_PIECE_URL = ROOT + SOUVENIR_PIECE;
	public static final String ADMIN_SOUVENIR_INTERNAL_URL = SOUVENIR_PIECE_INTERNAL_FOLDER + ROOT
			+ ADMIN_SOUVENIR_PIECE_INTERNAL_FILE;

}