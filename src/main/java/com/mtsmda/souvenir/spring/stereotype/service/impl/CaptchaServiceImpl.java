package com.mtsmda.souvenir.spring.stereotype.service.impl;

import java.util.List;

import com.mtsmda.souvenir.spring.stereotype.object.request.CaptchaUpdateRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mtsmda.souvenir.model.Captcha;
import com.mtsmda.souvenir.spring.stereotype.repository.CaptchaRepository;
import com.mtsmda.souvenir.spring.stereotype.service.CaptchaService;

@Service("captchaService")
public class CaptchaServiceImpl implements CaptchaService {

	@Autowired
	@Qualifier("captchaRepositoryImplSPJavaStandard")
	private CaptchaRepository captchaRepository;

	@Override
	public boolean insertCaptcha(Captcha captcha) {
		return captchaRepository.insertCaptcha(captcha);
	}

	@Override
	public boolean updateCaptcha(Captcha captcha) {
		return captchaRepository.updateCaptcha(captcha);
	}

	@Override
	public boolean deleteCaptcha(Captcha captcha) {
		return captchaRepository.deleteCaptcha(captcha);
	}

	@Override
	public Captcha getCaptchaById(Integer idCaptcha) {
		return captchaRepository.getCaptchaById(idCaptcha);
	}

	@Override
	public List<Captcha> getAllCaptcha() {
		return captchaRepository.getAllCaptcha();
	}

	@Override
	public Captcha getRandomCaptcha(CaptchaUpdateRO captchaUpdateRO) {
		return captchaRepository.getRandomCaptcha(captchaUpdateRO);
	}

	@Override
	public Captcha getRandomCaptcha(Captcha captchaUser) {
		return captchaRepository.getRandomCaptcha(captchaUser);
	}

	@Override
	public Integer getMaxIdCaptcha() {
		return captchaRepository.getMaxIdCaptcha();
	}

	@Override
	public Captcha checkCaptcha(Captcha captcha) {
		return captchaRepository.checkCaptcha(captcha);
	}

}