package com.mtsmda.souvenir.controller.restController;

import java.util.List;

import com.mtsmda.souvenir.controller.response.ResponseCode;
import com.mtsmda.souvenir.controller.response.SouvenirResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mtsmda.souvenir.model.Souvenir;
import com.mtsmda.souvenir.service.SouvenirService;

import static com.mtsmda.souvenir.controller.restController.constants.CatalogRestControllerConstants.*;

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
            souvenirResponseObject.setResponseCode(ResponseCode.RESPONSE_CODE_OK);
            souvenirResponseObject.setObject(souvenirs);
        } catch (Exception e) {
            souvenirResponseObject.setResponseCode(ResponseCode.RESPONSE_CODE_ERROR);
            souvenirResponseObject.setObject(e.getMessage());
        }
        return souvenirResponseObject;
    }

}