package com.mtsmda.souvenir.spring.stereotype.repository;

import java.util.List;

import com.mtsmda.souvenir.model.Captcha;
import com.mtsmda.souvenir.spring.stereotype.object.request.CaptchaUpdateRO;

public interface CaptchaRepository {
	
	public boolean insertCaptcha(Captcha captcha);
	public boolean updateCaptcha(Captcha captcha);
	public boolean deleteCaptcha(Captcha captcha);
	public Captcha getCaptchaById(Integer idCaptcha);
	public List<Captcha> getAllCaptcha();
	public Captcha getRandomCaptcha(Captcha captchaUser);
	public Captcha getRandomCaptcha(CaptchaUpdateRO captchaUpdateRO);

	public Integer getMaxIdCaptcha();
	public Captcha checkCaptcha(Captcha captcha);
	
}
