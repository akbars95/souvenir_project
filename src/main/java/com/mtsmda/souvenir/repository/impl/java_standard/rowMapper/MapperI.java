package com.mtsmda.souvenir.repository.impl.java_standard.rowMapper;

import java.sql.ResultSet;

public interface MapperI<T> {

	public T mapRow(ResultSet rs);

}