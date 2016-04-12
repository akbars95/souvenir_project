package com.mtsmda.souvenir.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mtsmda.souvenir.model.Souvenir;
import com.mtsmda.souvenir.service.SouvenirService;

import static com.mtsmda.souvenir.restController.constants.CatalogRestControllerConstants.*;

@RestController
public class CatalogRestController {

    @Autowired
    @Qualifier("souvenirService")
    private SouvenirService souvenirService;

    @RequestMapping(value = GET_ALL_SOUVENIRS_PIECE_URL, method = RequestMethod.GET)
    public List<Souvenir> getAllSouvenirs() {
        List<Souvenir> souvenirs = null;
        souvenirs = souvenirService.getAllSouvenirWithCategoryAndAudit(true);
        return souvenirs;
    }

}