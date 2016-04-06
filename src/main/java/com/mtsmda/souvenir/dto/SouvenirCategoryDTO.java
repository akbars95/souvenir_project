package com.mtsmda.souvenir.dto;

import com.mtsmda.souvenir.model.Souvenir;
import com.mtsmda.souvenir.model.SouvenirCategory;
import com.mtsmda.souvenir.model.modelI.SouvenirCategoryI;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dminzat on 4/6/2016.
 */
public class SouvenirCategoryDTO implements Serializable, SouvenirCategoryI {

    private String souvenirCategory;

    @Override
    public String getSouvenirCategory() {
        return souvenirCategory;
    }

    @Override
    public void setSouvenirCategory(String souvenirCategory) {
        this.souvenirCategory = souvenirCategory;
    }

    public SouvenirCategory convertToSouvenirCategory() {
        return new SouvenirCategory(this.souvenirCategory);
    }

}