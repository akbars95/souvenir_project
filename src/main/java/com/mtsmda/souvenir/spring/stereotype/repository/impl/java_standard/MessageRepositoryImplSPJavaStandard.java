package com.mtsmda.souvenir.spring.stereotype.repository.impl.java_standard;

import com.mtsmda.souvenir.exception.SouvenirRuntimeException;
import com.mtsmda.souvenir.helper.ListHelper;
import com.mtsmda.souvenir.helper.MapHelper;
import com.mtsmda.souvenir.helper.SouvenirExceptionHandler;
import com.mtsmda.souvenir.helper.SouvenirStandardSPHelper;
import com.mtsmda.souvenir.model.Message;
import com.mtsmda.souvenir.spring.stereotype.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import static com.mtsmda.souvenir.model.sp.CaptchaSP.CAPTCHA_URL_FILE_IN_SP_PARAM_NAME;
import static com.mtsmda.souvenir.model.sp.CaptchaSP.CAPTCHA_VALUE_IN_SP_PARAM_NAME;
import static com.mtsmda.souvenir.model.sp.MessageSP.*;

/**
 * Created by dminzat on 6/29/2016.
 */
@Repository("messageRepository")
@Transactional(isolation = Isolation.READ_COMMITTED)
public class MessageRepositoryImplSPJavaStandard implements MessageRepository {

    @Autowired
    @Qualifier(value = "mySqlDataSource")
    private DataSource dataSource;

    @Override
    public boolean insertMessage(Message message) {
        if (message == null) {
            throw new SouvenirRuntimeException("insertMessage - message object is NULL");
        }
        List<String> keysList = new ArrayList<>();
        HashMap<String, Object> mapParam = new HashMap<>();
        ListHelper.getList(keysList, MESSAGE_NAME_IN_SP_PARAM_NAME, MESSAGE_EMAIL_IN_SP_PARAM_NAME,
                MESSAGE_TEXT_M_IN_SP_PARAM_NAME, MESSAGE_CAPTCHA_ID_IN_SP_PARAM_NAME);
        MapHelper.getMap(mapParam, keysList, message.getMessageName(), message.getMessageEmail(),
                message.getMessageText(), message.getMessageCaptchaId());

        try (Connection connection = this.dataSource.getConnection();
             CallableStatement callableStatement = SouvenirStandardSPHelper.execute(connection,
                     INSERT_MESSAGE_SP_NAME, mapParam, false);) {
            int count = callableStatement.executeUpdate();
            if (count > 0) {
                return true;
            }
        } catch (SQLException e) {
            SouvenirExceptionHandler.handle("insertMessage", e);
        }
        return false;
    }
}