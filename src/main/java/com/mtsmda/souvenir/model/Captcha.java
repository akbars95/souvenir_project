package com.mtsmda.souvenir.model;

import java.io.Serializable;

import com.mtsmda.souvenir.annotation.ModelClassInfo;
import com.mtsmda.souvenir.spring.validation.validators.constraints.ImagePathConstraint;
import com.mtsmda.souvenir.spring.validation.validators.sequence.FirstSequence;
import com.mtsmda.souvenir.spring.validation.validators.sequence.SecondSequence;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by c-DMITMINZ on 04.02.2016.
 */
@ModelClassInfo(tableName = "CAPTCHA")
public class Captcha implements Serializable {

	private Integer captchaId;

	@NotNull
	@Size(min = 5, max = 10, groups = {FirstSequence.class})
	private String captchaValue;

	@NotNull
	@Size(min = 10, max = 255, groups = {FirstSequence.class})
	@ImagePathConstraint(groups = {SecondSequence.class})
	private String captchaUrlFile;

	public Captcha() {

	}

	public Captcha(String captchaValue, String captchaUrlFile) {
		this.setCaptchaUrlFile(captchaUrlFile);
		this.setCaptchaValue(captchaValue);
	}

	public Integer getCaptchaId() {
		return captchaId;
	}

	public void setCaptchaId(Integer captchaId) {
		this.captchaId = captchaId;
	}

	public String getCaptchaValue() {
		return captchaValue;
	}

	public void setCaptchaValue(String captchaValue) {
		this.captchaValue = captchaValue;
	}

	public String getCaptchaUrlFile() {
		return captchaUrlFile;
	}

	public void setCaptchaUrlFile(String captchaUrlFile) {
		this.captchaUrlFile = captchaUrlFile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((captchaId == null) ? 0 : captchaId.hashCode());
		result = prime * result + ((captchaUrlFile == null) ? 0 : captchaUrlFile.hashCode());
		result = prime * result + ((captchaValue == null) ? 0 : captchaValue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Captcha other = (Captcha) obj;
		if (captchaId == null) {
			if (other.captchaId != null)
				return false;
		} else if (!captchaId.equals(other.captchaId))
			return false;
		if (captchaUrlFile == null) {
			if (other.captchaUrlFile != null)
				return false;
		} else if (!captchaUrlFile.equals(other.captchaUrlFile))
			return false;
		if (captchaValue == null) {
			if (other.captchaValue != null)
				return false;
		} else if (!captchaValue.equals(other.captchaValue))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Captcha [captchaId=" + captchaId + ", captchaValue=" + captchaValue + ", captchaUrlFile="
				+ captchaUrlFile + "]";
	}

}