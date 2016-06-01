package com.mtsmda.souvenir.spring.stereotype.controller.restController;

import com.mtsmda.souvenir.spring.stereotype.controller.response.ResponseCode;
import com.mtsmda.souvenir.spring.stereotype.controller.response.SouvenirResponseObject;
import com.mtsmda.souvenir.spring.stereotype.controller.restController.constants.SouvenirRestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.mtsmda.souvenir.exception.SouvenirRuntimeException;
import com.mtsmda.souvenir.model.Souvenir;
import com.mtsmda.souvenir.model.SouvenirCategory;
import com.mtsmda.souvenir.model.SouvenirPhoto;
import com.mtsmda.souvenir.spring.stereotype.service.SouvenirService;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SouvenirRestController {

	@Autowired
	@Qualifier("souvenirService")
	private SouvenirService souvenirService;

	@RequestMapping(value = SouvenirRestConstants.INSERT_SOUVENIR_PIECE_URL, method = RequestMethod.POST)
	public SouvenirResponseObject insertSouvenir(@RequestParam(SouvenirRestConstants.SOUVENIR_NAME_REQUEST_PARAM) String souvenirName,
												 @RequestParam(SouvenirRestConstants.SOUVENIR_DESCRIPTION_REQUEST_PARAM) String souvenirDescription,
												 @RequestParam(SouvenirRestConstants.SOUVENIR_SHOW_REQUEST_PARAM) Boolean souvenirShow,
												 @RequestParam(SouvenirRestConstants.SOUVENIR_PRICE_REQUEST_PARAM) Double souvenirPrice,
												 @RequestParam(SouvenirRestConstants.SOUVENIR_COUNT_OF_DAYS_FOR_ORDER_REQUEST_PARAM) Integer souvenirCountOfDaysForOrder,
												 @RequestParam(SouvenirRestConstants.SOUVENIR_CATEGORY_ID_REQUEST_PARAM) Integer souvenirCategoryId,
												 @RequestParam(SouvenirRestConstants.SOUVENIR_MAIN_PHOTO_ID_REQUEST_PARAM) Integer souvenirMainPhotoId,
												 @RequestParam(value = SouvenirRestConstants.SOUVENIR_FILES_REQUEST_PARAM, required = false) MultipartFile[] multipartFiles,
												 HttpServletRequest request) {

		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		Souvenir souvenir = new Souvenir();
		if (multipartFiles != null && multipartFiles.length > 0) {
			List<SouvenirPhoto> photos = new ArrayList<>();
			for (int i = 0; i < multipartFiles.length; i++) {
				MultipartFile multipartFile = multipartFiles[i];
				String fileExtension = multipartFile.getOriginalFilename()
						.substring(multipartFile.getOriginalFilename().lastIndexOf("."));
				SouvenirPhoto souvenirPhoto = null;
				if (multipartFile != null && !multipartFile.isEmpty()) {
					try {
						souvenirPhoto = new SouvenirPhoto("\\resources\\images\\souvenirs\\" + souvenirName);
						File file = new File(rootDirectory + souvenirPhoto.getSouvenirPhotoPath());
						if (!file.exists()) {
							file.mkdir();
						}

						souvenirPhoto.setSouvenirPhotoPath(souvenirPhoto.getSouvenirPhotoPath() + "\\photo_" + (i + 1)
								+ "_" + new SimpleDateFormat("ddMMyyyy_HHmmssS").format(new Date()) + fileExtension);
						file = new File(rootDirectory + souvenirPhoto.getSouvenirPhotoPath());
						System.out.println(file.getAbsolutePath());
						if (!file.exists()) {
							file.createNewFile();
						}
						multipartFile.transferTo(file);
						photos.add(souvenirPhoto);
						if(souvenirMainPhotoId != null && souvenirMainPhotoId.equals(i)){
							SouvenirPhoto souvenirPhotoMain = new SouvenirPhoto(souvenirPhoto.getSouvenirPhotoPath());
							souvenir.setSouvenirMainPhotoId(souvenirPhoto);
						}
					} catch (Exception e) {
						throw new SouvenirRuntimeException("Product Image saving failed - " + e.getMessage());
					}
				}
			}
			souvenir.setSouvenirPhotos(photos);
		}

		SouvenirCategory souvenirCategory = new SouvenirCategory();
		souvenirCategory.setSouvenirCategoryId(souvenirCategoryId);
		souvenir.setSouvenirCategory(souvenirCategory);

		souvenir.setSouvenirName(souvenirName);
		souvenir.setSouvenirDescription(souvenirDescription);
		souvenir.setSouvenirShow(souvenirShow);
		souvenir.setSouvenirPrice(souvenirPrice);
		souvenir.setSouvenirCountOfDaysForOrder(souvenirCountOfDaysForOrder);
		souvenir.setSouvenirMainPhotoId(new SouvenirPhoto(souvenirMainPhotoId));

		boolean result = false;

		try {
			result = souvenirService.insertSouvenir(souvenir);
		}
		catch (Exception e){

		}
		if(result){
			return new SouvenirResponseObject(ResponseCode.RESPONSE_INSERT_OK_CODE, null);
		}
		return new SouvenirResponseObject(ResponseCode.RESPONSE_INSERT_ERROR_CODE, null);
	}

	@RequestMapping(value = SouvenirRestConstants.DELETE_SOUVENIR_PIECE_URL, method = RequestMethod.DELETE)
	public boolean deleteSouvenir(@PathVariable(SouvenirRestConstants.SOUVENIR_ID_REQUEST_PARAM) Integer souvenirId){
		Souvenir souvenir = new Souvenir();
		souvenir.setSouvenirId(souvenirId);
		return souvenirService.deleteSouvenir(souvenir);
	}

	@RequestMapping(value = SouvenirRestConstants.SHOW_HIDE_SOUVENIR_PIECE_URL, method = RequestMethod.PUT)
	public boolean showHideSouvenir(@PathVariable(SouvenirRestConstants.SOUVENIR_ID_REQUEST_PARAM) Integer souvenirId){
		Souvenir souvenir = new Souvenir();
		souvenir.setSouvenirId(souvenirId);
		return souvenirService.hideSouvenir(souvenir);
	}

}