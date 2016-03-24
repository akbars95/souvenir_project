package com.mtsmda.souvenir.model;

import java.io.Serializable;
import java.util.List;

import com.mtsmda.souvenir.annotation.ModelClassInfo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by MTSMDA on 16.11.2015.
 */
@ModelClassInfo(tableName = "SOUVENIRS")
public class Souvenir implements Serializable {

	private Integer souvenirId;

	@NotNull
	@Size(min = 3, max = 50)
	private String souvenirName;

	@NotNull
	@Size(min = 3, max = 255)
	private String souvenirDescription;

	@NotNull
	private Boolean souvenirShow;
	private SouvenirPhoto souvenirMainPhotoId;
	private SouvenirCategory souvenirCategory;

	@NotNull
	private Double souvenirPrice;

	@NotNull
	@Max(value = 50)
	@Min(value = 1)
	private Integer souvenirCountOfDaysForOrder;

	private SouvenirAudit souvenirAudit;

	private List<SouvenirPhoto> souvenirPhotos;

	public Souvenir() {

	}

	public Integer getSouvenirId() {
		return souvenirId;
	}

	public void setSouvenirId(Integer souvenirId) {
		this.souvenirId = souvenirId;
	}

	public String getSouvenirName() {
		return souvenirName;
	}

	public void setSouvenirName(String souvenirName) {
		this.souvenirName = souvenirName;
	}

	public String getSouvenirDescription() {
		return souvenirDescription;
	}

	public void setSouvenirDescription(String souvenirDescription) {
		this.souvenirDescription = souvenirDescription;
	}

	public Boolean getSouvenirShow() {
		return souvenirShow;
	}

	public void setSouvenirShow(Boolean souvenirShow) {
		this.souvenirShow = souvenirShow;
	}

	public SouvenirPhoto getSouvenirMainPhotoId() {
		return souvenirMainPhotoId;
	}

	public void setSouvenirMainPhotoId(SouvenirPhoto souvenirMainPhotoId) {
		this.souvenirMainPhotoId = souvenirMainPhotoId;
	}

	public SouvenirCategory getSouvenirCategory() {
		return souvenirCategory;
	}

	public void setSouvenirCategory(SouvenirCategory souvenirCategory) {
		this.souvenirCategory = souvenirCategory;
	}

	public Double getSouvenirPrice() {
		return souvenirPrice;
	}

	public void setSouvenirPrice(Double souvenirPrice) {
		this.souvenirPrice = souvenirPrice;
	}

	public Integer getSouvenirCountOfDaysForOrder() {
		return souvenirCountOfDaysForOrder;
	}

	public void setSouvenirCountOfDaysForOrder(Integer souvenirCountOfDaysForOrder) {
		this.souvenirCountOfDaysForOrder = souvenirCountOfDaysForOrder;
	}

	public SouvenirAudit getSouvenirAudit() {
		return souvenirAudit;
	}

	public void setSouvenirAudit(SouvenirAudit souvenirAudit) {
		this.souvenirAudit = souvenirAudit;
	}

	public List<SouvenirPhoto> getSouvenirPhotos() {
		return souvenirPhotos;
	}

	public void setSouvenirPhotos(List<SouvenirPhoto> souvenirPhotos) {
		this.souvenirPhotos = souvenirPhotos;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Souvenir souvenir = (Souvenir) o;

		if (souvenirId != null ? !souvenirId.equals(souvenir.souvenirId) : souvenir.souvenirId != null)
			return false;
		if (!souvenirName.equals(souvenir.souvenirName))
			return false;
		if (!souvenirDescription.equals(souvenir.souvenirDescription))
			return false;
		if (!souvenirShow.equals(souvenir.souvenirShow))
			return false;
		if (souvenirCategory != null ? !souvenirCategory.equals(souvenir.souvenirCategory)
				: souvenir.souvenirCategory != null)
			return false;
		if (!souvenirPrice.equals(souvenir.souvenirPrice))
			return false;
		return souvenirCountOfDaysForOrder.equals(souvenir.souvenirCountOfDaysForOrder);

	}

	@Override
	public int hashCode() {
		int result = souvenirId != null ? souvenirId.hashCode() : 0;
		result = 31 * result + ((souvenirName == null) ? 0 : souvenirName.hashCode());
		result = 31 * result + souvenirDescription == null ? 0 : souvenirDescription.hashCode();
		result = 31 * result + (souvenirShow ==  null ? 0 : souvenirShow.hashCode());
		result = 31 * result + (souvenirCategory != null ? souvenirCategory.hashCode() : 0);
		result = 31 * result + (souvenirPrice == null ? 0 : souvenirPrice.hashCode());
		result = 31 * result + (souvenirCountOfDaysForOrder == null ? 0 : souvenirCountOfDaysForOrder.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Souvenir{" + "souvenirId=" + souvenirId + ", souvenirName='" + souvenirName + '\''
				+ ", souvenirDescription='" + souvenirDescription + '\'' + ", souvenirShow=" + souvenirShow + '\''
				+ ", souvenirCategory=" + souvenirCategory + ", souvenirPrice=" + souvenirPrice
				+ ", souvenirCountOfDaysForOrder=" + souvenirCountOfDaysForOrder + '}';
	}
}