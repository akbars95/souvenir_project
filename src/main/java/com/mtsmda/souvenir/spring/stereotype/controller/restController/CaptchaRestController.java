package com.mtsmda.souvenir.spring.stereotype.controller.restController;

import com.mtsmda.souvenir.model.Souvenir;
import com.mtsmda.souvenir.model.SouvenirAudit;
import com.mtsmda.souvenir.model.SouvenirPhoto;
import com.mtsmda.souvenir.model.modelI.CaptchaIdI;
import com.mtsmda.souvenir.spring.stereotype.controller.constants.StaticPageConstants;
import com.mtsmda.souvenir.spring.stereotype.controller.restController.constants.CaptchaRestConstants;
import com.mtsmda.souvenir.spring.stereotype.object.request.CaptchaUpdateRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mtsmda.souvenir.model.Captcha;
import com.mtsmda.souvenir.spring.stereotype.service.CaptchaService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping(value = StaticPageConstants.REST_PATH_URL)
public class CaptchaRestController implements CaptchaRestConstants{
	
	@Autowired
	@Qualifier("captchaService")
	private CaptchaService captchaService;

	@RequestMapping(value = UPDATE_CAPTCHA_PIECE_URL, method = RequestMethod.POST)
	public Captcha getRandomCaptcha(@RequestBody CaptchaUpdateRO captchaFromClient) {
		if (captchaFromClient != null && captchaFromClient.getCaptchaId() == null) {
			captchaFromClient.setCaptchaId(new Double(Math.random() * captchaService.getMaxIdCaptcha()).intValue());
		}
		Captcha randomCaptcha = captchaService.getRandomCaptcha(captchaFromClient);
		return randomCaptcha;
	}

	@RequestMapping(value = CaptchaRestConstants.CHECK_CAPTCHA_PIECE_URL, method = RequestMethod.POST)
	public boolean getCheckCaptcha(@RequestBody Captcha captchaFromClient) {
		if (captchaFromClient == null) {
			return false;
		}
		return captchaService.checkCaptcha(captchaFromClient);
	}

	@RequestMapping(value = CaptchaRestConstants.INIT_CAPTCHA_PIECE_URL)
	public String getInitCaptcha(HttpServletRequest request) {
		String captchaPath = null;
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		System.out.println(rootDirectory);
		rootDirectory += "//resources//images//captcha//";
		File folder = new File(rootDirectory);
		if(folder.exists() && folder.isDirectory()){
			String[] fileNames = folder.list((dir, name) ->{
				return name.matches("^i[0-9]{1,2}.png$");
			});
			captchaPath = fileNames[new Double(Math.random() * (fileNames.length - 1)).intValue()];
		}
		return captchaPath;
	}

}