package com.mtsmda.souvenir.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mtsmda.souvenir.model.Captcha;
import com.mtsmda.souvenir.service.CaptchaService;

import static com.mtsmda.souvenir.restController.constants.CaptchaRestConstants.*;

@RestController
public class CaptchaRestController {
	
	@Autowired
	@Qualifier("captchaService")
	private CaptchaService captchaService;

	@RequestMapping(value = UPDATE_CAPTCHA_PIECE_URL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Captcha getRandomCaptcha(@RequestBody Captcha captchaFromClient) {
		if (captchaFromClient != null && captchaFromClient.getCaptchaId() == null) {
			captchaFromClient.setCaptchaId(new Double(Math.random() * captchaService.getMaxIdCaptcha()).intValue());
		}
		Captcha randomCaptcha = captchaService.getRandomCaptcha(captchaFromClient);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return randomCaptcha;
	}

	@RequestMapping(value = CHECK_CAPTCHA_PIECE_URL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean getCheckCaptcha(@RequestBody Captcha captchaFromClient) {
		if (captchaFromClient == null) {
			return false;
		}
		return captchaService.checkCaptcha(captchaFromClient);
	}

}