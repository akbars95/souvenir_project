package com.mtsmda.souvenir.spring.stereotype.repository;

import com.mtsmda.souvenir.model.Souvenir;

import java.util.List;

/**
 * Created by MTSMDA on 16.11.2015.
 */
public interface SouvenirRepository {

    public boolean insertSouvenir(Souvenir souvenir);
    public boolean updateSouvenir(Souvenir souvenir);
    public boolean deleteSouvenir(Souvenir souvenir);
    public Souvenir getSouvenir(Integer souvenirId);
    public List<Souvenir> getAllSouvenir();
    
    public List<Souvenir> getAllSouvenirWithCategoryAndAudit(boolean withSouvenirPhotos);

    public boolean hideSouvenir(Souvenir souvenir);
    
    public Souvenir getLastAddedSouvenir();

}