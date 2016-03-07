package com.mtsmda.souvenir.repository;

import com.mtsmda.souvenir.model.SouvenirPhoto;

public interface SouvenirPhotoRepository {
	
	public boolean insertSouvenirPhoto(SouvenirPhoto souvenirPhoto);
	public boolean updateSouvenirPhoto(SouvenirPhoto souvenirPhoto);
	public boolean deleteSouvenirPhoto(SouvenirPhoto souvenirPhoto);
	public boolean getSouvenirPhoto(SouvenirPhoto souvenirPhoto);
	public boolean getAllSouvenirPhotos();
	
}