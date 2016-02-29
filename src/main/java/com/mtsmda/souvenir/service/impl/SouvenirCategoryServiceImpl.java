package com.mtsmda.souvenir.service.impl;

import com.mtsmda.souvenir.model.SouvenirCategory;
import com.mtsmda.souvenir.repository.SouvenirCategoryRepository;
import com.mtsmda.souvenir.service.SouvenirCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by c-DMITMINZ on 29.01.2016.
 */
@Service("souvenirCategoryService")
public class SouvenirCategoryServiceImpl implements SouvenirCategoryService {

    @Autowired
    @Qualifier("souvenirCategoryRepositoryImplSPJavaStandard")
    private SouvenirCategoryRepository souvenirCategoryRepository;

    @Override
    public boolean insertSouvenirCategory(SouvenirCategory souvenirCategory) {
        return souvenirCategoryRepository.insertSouvenirCategory(souvenirCategory);
    }

    @Override
    public boolean updateSouvenirCategory(SouvenirCategory souvenirCategory) {
        return souvenirCategoryRepository.updateSouvenirCategory(souvenirCategory);
    }

    @Override
    public boolean deleteSouvenirCategory(SouvenirCategory souvenirCategory) {
        return souvenirCategoryRepository.deleteSouvenirCategory(souvenirCategory);
    }

    @Override
    public SouvenirCategory getSouvenirCategory(Integer souvenirCategoryId) {
        return souvenirCategoryRepository.getSouvenirCategory(souvenirCategoryId);
    }

    @Override
    public List<SouvenirCategory> getAllSouvenirCategories() {
        return souvenirCategoryRepository.getAllSouvenirCategories();
    }
}