package com.mtsmda.souvenir.spring.stereotype.controller.restController;

import com.mtsmda.souvenir.model.Souvenir;
import com.mtsmda.souvenir.spring.stereotype.controller.response.ResponseCode;
import com.mtsmda.souvenir.spring.stereotype.controller.response.SouvenirResponseObject;
import com.mtsmda.souvenir.spring.stereotype.service.SouvenirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.mtsmda.souvenir.spring.stereotype.controller.restController.constants.CatalogRestControllerConstants.GET_ALL_SOUVENIRS_PIECE_URL;

@RestController
public class CatalogRestController {

    @Autowired
    @Qualifier("souvenirService")
    private SouvenirService souvenirService;

    @RequestMapping(value = GET_ALL_SOUVENIRS_PIECE_URL, method = RequestMethod.GET)
    public SouvenirResponseObject getAllSouvenirs() {
        SouvenirResponseObject souvenirResponseObject = new SouvenirResponseObject();
        try {
            List<Souvenir> souvenirs = null;
            souvenirs = souvenirService.getAllSouvenirWithCategoryAndAudit(true);
            souvenirResponseObject.setResponseCode(ResponseCode.RESPONSE_GET_OK_CODE);
            souvenirResponseObject.setObject(souvenirs);
        } catch (Exception e) {
            souvenirResponseObject.setResponseCode(ResponseCode.RESPONSE_GET_ERROR_CODE);
            souvenirResponseObject.setObject(e.getMessage());
        }
        return souvenirResponseObject;
    }

}