package com.mtsmda.souvenir.spring.stereotype.object.request;

import com.mtsmda.souvenir.model.SouvenirCategory;
import com.mtsmda.souvenir.model.modelI.SouvenirCategoryI;

import java.io.Serializable;

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