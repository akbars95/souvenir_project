package com.mtsmda.souvenir.model;

import java.io.Serializable;

import com.mtsmda.souvenir.annotation.ModelClassInfo;

/**
 * Created by MTSMDA on 16.11.2015.
 */
@ModelClassInfo(tableName = "SOUVENIRS")
public class Souvenir implements Serializable {

	private Integer souvenirId;
	private String souvenirName;
	private String souvenirDescription;
	private Boolean souvenirShow;
	private String souvenirPath;
	private SouvenirCategory souvenirCategory;
	private Double souvenirPrice;
	private Integer souvenirCountOfDaysForOrder;

	private SouvenirAudit souvenirAudit;

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

	public String getSouvenirPath() {
		return souvenirPath;
	}

	public void setSouvenirPath(String souvenirPath) {
		this.souvenirPath = souvenirPath;
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
		if (!souvenirPath.equals(souvenir.souvenirPath))
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
		result = 31 * result + souvenirName.hashCode();
		result = 31 * result + souvenirDescription.hashCode();
		result = 31 * result + souvenirShow.hashCode();
		result = 31 * result + souvenirPath.hashCode();
		result = 31 * result + (souvenirCategory != null ? souvenirCategory.hashCode() : 0);
		result = 31 * result + souvenirPrice.hashCode();
		result = 31 * result + souvenirCountOfDaysForOrder.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Souvenir{" + "souvenirId=" + souvenirId + ", souvenirName='" + souvenirName + '\''
				+ ", souvenirDescription='" + souvenirDescription + '\'' + ", souvenirShow=" + souvenirShow
				+ ", souvenirPath='" + souvenirPath + '\'' + ", souvenirCategory=" + souvenirCategory
				+ ", souvenirPrice=" + souvenirPrice + ", souvenirCountOfDaysForOrder=" + souvenirCountOfDaysForOrder
				+ '}';
	}
}