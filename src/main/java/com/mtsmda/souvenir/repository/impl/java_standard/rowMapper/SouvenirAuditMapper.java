package com.mtsmda.souvenir.repository.impl.java_standard.rowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.mtsmda.souvenir.model.SouvenirAudit;
import static com.mtsmda.souvenir.model.sp.SouvenirAuditSP.*;

public class SouvenirAuditMapper implements MapperI<SouvenirAudit> {

	@Override
	public SouvenirAudit mapRow(ResultSet rs) {
		SouvenirAudit souvenirsAudit = new SouvenirAudit();
		try {
			souvenirsAudit.setCreatedDatetime(rs.getDate(CREATED_DATETIME));
		} catch (SQLException e) {
			souvenirsAudit.setCreatedDatetime(null);
		}
		try {
			souvenirsAudit.setLastUpdateDatetime(rs.getDate(LAST_UPDATE_DATETIME));
		} catch (SQLException e) {
			souvenirsAudit.setLastUpdateDatetime(null);
		}
		return souvenirsAudit;
	}

}