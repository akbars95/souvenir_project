package com.mtsmda.souvenir.controller.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.mtsmda.souvenir.exception.SouvenirRuntimeException;
import com.mtsmda.souvenir.model.Souvenir;
import com.mtsmda.souvenir.model.SouvenirCategory;
import com.mtsmda.souvenir.model.SouvenirPhoto;
import com.mtsmda.souvenir.service.SouvenirService;

import static com.mtsmda.souvenir.controller.restController.constants.SouvenirRestConstants.*;

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

	@RequestMapping(value = INSERT_SOUVENIR_PIECE_URL, method = RequestMethod.POST)
	public boolean insertSouvenir(@RequestParam(SOUVENIR_NAME_REQUEST_PARAM) String souvenirName,
			@RequestParam(SOUVENIR_DESCRIPTION_REQUEST_PARAM) String souvenirDescription,
			@RequestParam(SOUVENIR_SHOW_REQUEST_PARAM) Boolean souvenirShow,
			@RequestParam(SOUVENIR_PRICE_REQUEST_PARAM) Double souvenirPrice,
			@RequestParam(SOUVENIR_COUNT_OF_DAYS_FOR_ORDER_REQUEST_PARAM) Integer souvenirCountOfDaysForOrder,
			@RequestParam(SOUVENIR_CATEGORY_ID_REQUEST_PARAM) Integer souvenirCategoryId,
			@RequestParam(value = SOUVENIR_FILES_REQUEST_PARAM, required = false) MultipartFile[] multipartFiles,
			HttpServletRequest request) {

		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		Souvenir souvenir = new Souvenir();
		if (multipartFiles != null && multipartFiles.length > 0) {
			List<SouvenirPhoto> photos = new ArrayList<>();
			for (int i = 0; i < multipartFiles.length; i++) {
				MultipartFile multipartFile = multipartFiles[i];
				String fileExtention = multipartFile.getOriginalFilename()
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
								+ "_" + new SimpleDateFormat("ddMMyyyy_HHmmssS").format(new Date()) + fileExtention);
						file = new File(rootDirectory + souvenirPhoto.getSouvenirPhotoPath());
						System.out.println(file.getAbsolutePath());
						if (!file.exists()) {
							file.createNewFile();
						}
						multipartFile.transferTo(file);
						photos.add(souvenirPhoto);
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

		return souvenirService.insertSouvenir(souvenir);
	}

	@RequestMapping(value = DELETE_SOUVENIR_PIECE_URL, method = RequestMethod.DELETE)
	public boolean deleteSouvenir(@PathVariable(SOUVENIR_ID_REQUEST_PARAM) Integer souvenirId){
		Souvenir souvenir = new Souvenir();
		souvenir.setSouvenirId(souvenirId);
		return souvenirService.deleteSouvenir(souvenir);
	}

	@RequestMapping(value = SHOW_HIDE_SOUVENIR_PIECE_URL, method = RequestMethod.PUT)
	public boolean showHideSouvenir(@PathVariable(SOUVENIR_ID_REQUEST_PARAM) Integer souvenirId){
		Souvenir souvenir = new Souvenir();
		souvenir.setSouvenirId(souvenirId);
		return souvenirService.hideSouvenir(souvenir);
	}

}