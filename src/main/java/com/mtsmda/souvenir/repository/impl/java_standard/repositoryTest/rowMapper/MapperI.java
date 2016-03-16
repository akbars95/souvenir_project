package com.mtsmda.souvenir.repository.impl.java_standard.repositoryTest.rowMapper;

import java.sql.ResultSet;

public interface MapperI<T> {

	public T mapRow(ResultSet rs);

}