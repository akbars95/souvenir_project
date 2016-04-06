package com.mtsmda.souvenir.repository;

import com.mtsmda.souvenir.model.SouvenirPhoto;

import java.util.List;

public interface SouvenirPhotoRepository {
	
	public boolean insertSouvenirPhoto(SouvenirPhoto souvenirPhoto);
	public boolean updateSouvenirPhoto(SouvenirPhoto souvenirPhoto);
	public boolean deleteSouvenirPhoto(SouvenirPhoto souvenirPhoto);
	public SouvenirPhoto getSouvenirPhoto(SouvenirPhoto souvenirPhoto);
	public List<SouvenirPhoto> getAllSouvenirPhotos();
	public List<SouvenirPhoto> getSouvenirPhotosBySouvenirId(Integer souvenirId);
}