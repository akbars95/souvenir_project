package com.mtsmda.souvenir.controller.restController;

import com.mtsmda.souvenir.model.Souvenir;
import com.mtsmda.souvenir.model.SouvenirAudit;
import com.mtsmda.souvenir.model.SouvenirPhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mtsmda.souvenir.model.Captcha;
import com.mtsmda.souvenir.service.CaptchaService;

import java.util.ArrayList;
import java.util.Date;

import static com.mtsmda.souvenir.controller.restController.constants.CaptchaRestConstants.*;

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


	/*TESTING*/
	@RequestMapping(value = UPDATE_CAPTCHA_PIECE_URL, method = RequestMethod.GET)
	public Captcha getTestCaptcha() {
		Captcha captchaFromClient = new Captcha("d", "f00");
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

	@RequestMapping(value = "/test/souvenir", method = RequestMethod.GET)
	public Souvenir getTestSouvenir() {
		Souvenir souvenir = new Souvenir();
		souvenir.setSouvenirId(15);

		SouvenirAudit souvenirAudit = new SouvenirAudit();
		souvenir.setSouvenirAudit(souvenirAudit);
		souvenirAudit.setCreatedDatetime(new Date());
		souvenirAudit.setLastUpdateDatetime(new Date());

		SouvenirPhoto souvenirPhoto = new SouvenirPhoto("path");
		souvenirPhoto.setSouvenirPhotoId(1);

		SouvenirPhoto souvenirPhoto2 = new SouvenirPhoto("path 2");
		souvenirPhoto2.setSouvenirPhotoId(2);

		souvenir.setSouvenirPhotos(new ArrayList<SouvenirPhoto>());
		souvenir.getSouvenirPhotos().add(souvenirPhoto);
		souvenir.getSouvenirPhotos().add(souvenirPhoto2);

		return souvenir;
	}

}