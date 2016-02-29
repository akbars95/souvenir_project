package com.mtsmda.souvenir.repository.impl;

import static com.mtsmda.souvenir.model.sp.MessageSP.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mtsmda.souvenir.exception.SouvenirRuntimeException;
import com.mtsmda.souvenir.helper.ListHelper;
import com.mtsmda.souvenir.helper.MapHelper;
import com.mtsmda.souvenir.model.Message;
import com.mtsmda.souvenir.repository.MessageRepository;
import com.mtsmda.souvenir.sp.SouvenirStoredProcedure;

@Repository("messageRepository")
public class MessageRepositoryImplSP implements MessageRepository {

	@Autowired
	@Qualifier(value = "mySqlDataSource")
	private DataSource dataSource;

	private SouvenirStoredProcedure souvenirStoredProcedure;

	@Override
	public boolean insertMessage(Message message) {
		try {
			List<SqlParameter> sqlParameters = Arrays.asList(MESSAGE_NAME_IN_SP_SQL_PARAM,
					MESSAGE_EMAIL_IN_SP_SQL_PARAM, MESSAGE_TEXT_M_IN_SP_SQL_PARAM, MESSAGE_CAPTCHA_ID_IN_SP_SQL_PARAM);
			souvenirStoredProcedure = new SouvenirStoredProcedure(this.dataSource, INSERT_MESSAGE_SP_NAME,
					sqlParameters);

			List<String> keysList = new ArrayList<>();
			ListHelper.getList(keysList, new String[] { MESSAGE_NAME_IN_SP_PARAM_NAME, MESSAGE_EMAIL_IN_SP_PARAM_NAME,
					MESSAGE_TEXT_M_IN_SP_PARAM_NAME, MESSAGE_CAPTCHA_ID_IN_SP_PARAM_NAME });
			HashMap<String, Object> stringObjectHashMap = new HashMap<>();
			MapHelper.getMap(stringObjectHashMap, keysList, message.getMessageName(), message.getMessageEmail(),
					message.getMessageText(), message.getMessageCaptchaId());
			Map map = souvenirStoredProcedure.executeSP(stringObjectHashMap);
			dataSource.getConnection().commit();
		} catch (Exception e) {
			try {
				dataSource.getConnection().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new SouvenirRuntimeException("Exception when insert new email message - " + e.getMessage());
		}
		return true;
	}

}