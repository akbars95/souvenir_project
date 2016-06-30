package com.mtsmda.souvenir.spring.stereotype.object.DTOresponse;

import java.util.List;

/**
 * Created by dminzat on 6/27/2016.
 */
public class CaptchaDTOResponse {

    private List<String> captchaImageName;
    private String pathWhereCaptchaImage;
    private String currentCaptchaImageName;

    public CaptchaDTOResponse() {

    }

    public CaptchaDTOResponse(List<String> captchaImageName, String pathWhereCaptchaImage) {
        this.captchaImageName = captchaImageName;
        this.pathWhereCaptchaImage = pathWhereCaptchaImage;
    }

    public List<String> getCaptchaImageName() {
        return captchaImageName;
    }

    public void setCaptchaImageName(List<String> captchaImageName) {
        this.captchaImageName = captchaImageName;
    }

    public String getPathWhereCaptchaImage() {
        return pathWhereCaptchaImage;
    }

    public void setPathWhereCaptchaImage(String pathWhereCaptchaImage) {
        this.pathWhereCaptchaImage = pathWhereCaptchaImage;
    }

    public String getCurrentCaptchaImageName() {
        return currentCaptchaImageName;
    }

    public void setCurrentCaptchaImageName(String currentCaptchaImageName) {
        this.currentCaptchaImageName = currentCaptchaImageName;
    }
}