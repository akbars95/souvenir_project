package com.mtsmda.souvenir.spring.stereotype.controller.restController;

import com.mtsmda.souvenir.spring.stereotype.controller.constants.StaticPageConstants;
import com.mtsmda.souvenir.spring.stereotype.controller.restController.constants.CaptchaRestConstants;
import com.mtsmda.souvenir.spring.stereotype.object.DTOresponse.CaptchaDTOResponse;
import com.mtsmda.souvenir.spring.stereotype.object.request.CaptchaUpdateRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mtsmda.souvenir.model.Captcha;
import com.mtsmda.souvenir.spring.stereotype.service.CaptchaService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Arrays;
import java.util.List;

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
		/*if (captchaFromClient == null) {*/
			return false;
		/*}
		return captchaService.checkCaptcha(captchaFromClient);*/
	}

	@RequestMapping(value = CaptchaRestConstants.INIT_CAPTCHA_PIECE_URL)
	public CaptchaDTOResponse getInitCaptcha(HttpServletRequest request) {
		CaptchaDTOResponse captchaDTOResponse = new CaptchaDTOResponse();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		captchaDTOResponse.setPathWhereCaptchaImage("//resources//images//captcha//");
		rootDirectory += captchaDTOResponse.getPathWhereCaptchaImage();
		File folder = new File(rootDirectory);
		if(folder.exists() && folder.isDirectory()){
			String[] fileNames = folder.list((dir, name) ->{
				return name.matches("^i[0-9]{1,2}.png$");
			});
			if(fileNames != null && fileNames.length > 0){
				List<String> captchaPath = Arrays.asList(fileNames);
				captchaDTOResponse.setCaptchaImageName(captchaPath);
				captchaDTOResponse.setCurrentCaptchaImageName(fileNames[new Double(Math.random() * (fileNames.length - 1)).intValue()]);
			}
		}
		return captchaDTOResponse;
	}

}