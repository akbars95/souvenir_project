package com.mtsmda.souvenir.model;

import java.io.Serializable;
import java.util.Date;

import com.mtsmda.souvenir.annotation.ModelClassInfo;
import com.mtsmda.souvenir.validation.validators.sequence.FirstSequence;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

/**
 * Created by c-DMITMINZ on 29.01.2016.
 */
@ModelClassInfo(tableName = "SOUVENIRS_AUDIT")
public class SouvenirAudit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Souvenir souvenir;

	@NotNull
	@Past(groups = {FirstSequence.class})
	private Date createdDatetime;

	@NotNull
	@Past(groups = {FirstSequence.class})
	private Date lastUpdateDatetime;

	public SouvenirAudit() {

	}

	public Souvenir getSouvenir() {
		return souvenir;
	}

	public void setSouvenir(Souvenir souvenir) {
		this.souvenir = souvenir;
	}

	public Date getCreatedDatetime() {
		return createdDatetime;
	}

	public void setCreatedDatetime(Date createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	public Date getLastUpdateDatetime() {
		return lastUpdateDatetime;
	}

	public void setLastUpdateDatetime(Date lastUpdateDatetime) {
		this.lastUpdateDatetime = lastUpdateDatetime;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		SouvenirAudit that = (SouvenirAudit) o;

		if (!souvenir.equals(that.souvenir))
			return false;
		if (!createdDatetime.equals(that.createdDatetime))
			return false;
		return lastUpdateDatetime.equals(that.lastUpdateDatetime);

	}

	@Override
	public int hashCode() {
		int result = souvenir == null ? 0 : souvenir.hashCode();
		result = 31 * result + ((createdDatetime == null) ? 0 : createdDatetime.hashCode());
		result = 31 * result + ((lastUpdateDatetime == null) ? 0 : lastUpdateDatetime.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "SouvenirsAudit{" + "souvenir=" + souvenir + ", createdDatetime=" + createdDatetime
				+ ", lastUpdateDatetime=" + lastUpdateDatetime + '}';
	}
}