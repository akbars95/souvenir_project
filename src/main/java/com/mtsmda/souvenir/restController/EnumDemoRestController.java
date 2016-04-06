package com.mtsmda.souvenir.restController;

import com.mtsmda.souvenir.toggleFeature.My3Feature;
import com.mtsmda.souvenir.toggleFeature.MyEnum;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dminzat on 4/4/2016.
 */
@RestController
@RequestMapping("/enum-demo")
public class EnumDemoRestController {

    @RequestMapping(value = "/set", method = RequestMethod.PUT)
    public void set(@RequestBody MyEnum myEnum) {
        myEnum.setStatus(!myEnum.getStatus());
    }

    @RequestMapping(value = "/get")
    public MyEnum get() {
        return MyEnum.FIRST;
    }
}