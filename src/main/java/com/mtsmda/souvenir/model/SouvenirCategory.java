package com.mtsmda.souvenir.model;

import com.mtsmda.souvenir.annotation.ModelClassInfo;
import com.mtsmda.souvenir.model.modelI.SouvenirCategoryI;
import com.mtsmda.souvenir.validation.validators.sequence.FirstSequence;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * Created by c-DMITMINZ on 29.01.2016.
 */
@ModelClassInfo(tableName = "SOUVENIR_CATEGORIES", tableStoredProcedures = {"insertCategory", "updateCategory",
        "deleteCategoryById", "getCategoryById", "getCategoryByNameLike", "getAllCategories"})
public class SouvenirCategory implements Serializable, SouvenirCategoryI {

    private Integer souvenirCategoryId;

    @NotNull
    @Size(min = 3, max = 50, groups = {FirstSequence.class})
    private String souvenirCategory;
    private List<Souvenir> souvenirs;

    public SouvenirCategory() {

    }

    public SouvenirCategory(String souvenirCategory) {
        this.setSouvenirCategory(souvenirCategory);
    }

    public Integer getSouvenirCategoryId() {
        return souvenirCategoryId;
    }

    public void setSouvenirCategoryId(Integer souvenirCategoryId) {
        this.souvenirCategoryId = souvenirCategoryId;
    }

    @Override
    public String getSouvenirCategory() {
        return souvenirCategory;
    }

    @Override
    public void setSouvenirCategory(String souvenirCategory) {
        this.souvenirCategory = souvenirCategory;
    }

    public List<Souvenir> getSouvenirs() {
        return souvenirs;
    }

    public void setSouvenirs(List<Souvenir> souvenirs) {
        this.souvenirs = souvenirs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        SouvenirCategory that = (SouvenirCategory) o;

        if (souvenirCategoryId != null ? !souvenirCategoryId.equals(that.souvenirCategoryId)
                : that.souvenirCategoryId != null)
            return false;
        if (!souvenirCategory.equals(that.souvenirCategory))
            return false;
        return !(souvenirs != null ? !souvenirs.equals(that.souvenirs) : that.souvenirs != null);

    }

    @Override
    public int hashCode() {
        int result = souvenirCategoryId != null ? souvenirCategoryId.hashCode() : 0;
        result = 31 * result + ((souvenirCategory == null) ? 0 : souvenirCategory.hashCode());
        result = 31 * result + (souvenirs != null ? souvenirs.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SouvenirCategory{" + "souvenirCategoryId=" + souvenirCategoryId + ", souvenirCategory='"
                + souvenirCategory + '\'' + ", souvenirs=" + souvenirs + '}';
    }
}