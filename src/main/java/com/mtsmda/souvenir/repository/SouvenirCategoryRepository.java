package com.mtsmda.souvenir.repository;


import com.mtsmda.souvenir.model.SouvenirCategory;

import java.util.List;

/**
 * Created by c-DMITMINZ on 29.01.2016.
 */
public interface SouvenirCategoryRepository {

    public boolean insertSouvenirCategory(SouvenirCategory souvenirCategory);
    public boolean updateSouvenirCategory(SouvenirCategory souvenirCategory);
    public boolean deleteSouvenirCategory(SouvenirCategory souvenirCategory);
    public SouvenirCategory getSouvenirCategory(Integer souvenirCategoryId);
    public List<SouvenirCategory> getAllSouvenirCategories();

}