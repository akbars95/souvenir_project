package com.mtsmda.souvenir.repository.impl.java_standard.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mtsmda.souvenir.model.Message;

import static com.mtsmda.souvenir.model.sp.MessageSP.*;

public class MessageMapper implements RowMapper<Message>, MapperI<Message> {

	@Override
	public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
		Message message = new Message();
		message.setMessageId(rs.getInt(MESSAGE_ID));
		message.setMessageName(rs.getString(MESSAGE_NAME));
		message.setMessageCaptchaId(rs.getInt(MESSAGE_CAPTCHA_ID));
		message.setMessageEmail(rs.getString(MESSAGE_EMAIL));
		message.setMessageText(rs.getString(MESSAGE_TEXT_M));
		return message;
	}

	@Override
	public Message mapRow(ResultSet rs) {
		Message message = new Message();

		try {
			message.setMessageId(rs.getInt(MESSAGE_ID));
		} catch (SQLException e) {
			message.setMessageId(null);
		}
		try {
			message.setMessageName(rs.getString(MESSAGE_NAME));
		} catch (SQLException e) {
			message.setMessageName(null);
		}
		try {
			message.setMessageCaptchaId(rs.getInt(MESSAGE_CAPTCHA_ID));
		} catch (SQLException e) {
			message.setMessageCaptchaId(null);
		}
		try {
			message.setMessageEmail(rs.getString(MESSAGE_EMAIL));
		} catch (SQLException e) {
			message.setMessageEmail(null);
		}
		try {
			message.setMessageText(rs.getString(MESSAGE_TEXT_M));
		} catch (SQLException e) {
			message.setMessageText(null);
		}

		return message;
	}

}