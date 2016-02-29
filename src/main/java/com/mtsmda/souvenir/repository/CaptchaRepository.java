package com.mtsmda.souvenir.repository;

import java.util.List;

import com.mtsmda.souvenir.model.Captcha;

public interface CaptchaRepository {
	
	public boolean insertCaptcha(Captcha captcha);
	public boolean updateCaptcha(Captcha captcha);
	public boolean deleteCaptcha(Captcha captcha);
	public Captcha getCaptchaById(Integer idCaptcha);
	public List<Captcha> getAllCaptcha();
	public Captcha getRandomCaptcha(Captcha captchaUser);
	
	public Integer getMaxIdCaptcha();
	public boolean checkCaptcha(Captcha captcha);
	
}
