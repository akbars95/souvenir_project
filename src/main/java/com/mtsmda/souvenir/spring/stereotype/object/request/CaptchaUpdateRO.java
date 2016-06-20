package com.mtsmda.souvenir.spring.stereotype.object.request;

import com.mtsmda.souvenir.model.modelI.CaptchaIdI;

/**
 * Created by MTSMDA on 18.06.2016.
 */
public class CaptchaUpdateRO implements CaptchaIdI {

    private Integer captchaId;

    public CaptchaUpdateRO() {

    }

    public CaptchaUpdateRO(Integer captchaId) {
        this.captchaId = captchaId;
    }

    @Override
    public Integer getCaptchaId() {
        return this.captchaId;
    }

    @Override
    public void setCaptchaId(Integer captchaId) {
        this.captchaId = captchaId;
    }

    @Override
    public String toString() {
        return "CaptchaUpdateRO{" +
                "captchaId=" + captchaId +
                '}';
    }
}