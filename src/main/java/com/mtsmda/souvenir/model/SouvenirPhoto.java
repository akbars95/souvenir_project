package com.mtsmda.souvenir.model;

import java.io.Serializable;

import com.mtsmda.souvenir.annotation.ModelClassInfo;

@ModelClassInfo(tableName = "SOUVENIR_PHOTOS")
public class SouvenirPhoto implements Serializable {

	private Integer souvenirPhotoId;
	private String souvenirPhotoPath;
	private Souvenir souvenir;

	public SouvenirPhoto() {
		super();
	}
	
	public SouvenirPhoto(Integer souvenirPhotoId) {
		super();
		this.souvenirPhotoId = souvenirPhotoId;
	}

	public SouvenirPhoto(String souvenirPhotoPath) {
		super();
		this.souvenirPhotoPath = souvenirPhotoPath;
	}

	public Integer getSouvenirPhotoId() {
		return souvenirPhotoId;
	}

	public void setSouvenirPhotoId(Integer souvenirPhotoId) {
		this.souvenirPhotoId = souvenirPhotoId;
	}

	public String getSouvenirPhotoPath() {
		return souvenirPhotoPath;
	}

	public void setSouvenirPhotoPath(String souvenirPhotoPath) {
		this.souvenirPhotoPath = souvenirPhotoPath;
	}

	public Souvenir getSouvenir() {
		return souvenir;
	}

	public void setSouvenir(Souvenir souvenir) {
		this.souvenir = souvenir;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((souvenir == null) ? 0 : souvenir.hashCode());
		result = prime * result + ((souvenirPhotoId == null) ? 0 : souvenirPhotoId.hashCode());
		result = prime * result + ((souvenirPhotoPath == null) ? 0 : souvenirPhotoPath.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SouvenirPhoto other = (SouvenirPhoto) obj;
		if (souvenir == null) {
			if (other.souvenir != null)
				return false;
		} else if (!souvenir.equals(other.souvenir))
			return false;
		if (souvenirPhotoId == null) {
			if (other.souvenirPhotoId != null)
				return false;
		} else if (!souvenirPhotoId.equals(other.souvenirPhotoId))
			return false;
		if (souvenirPhotoPath == null) {
			if (other.souvenirPhotoPath != null)
				return false;
		} else if (!souvenirPhotoPath.equals(other.souvenirPhotoPath))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SouvenirPhoto [souvenirPhotoId=" + souvenirPhotoId + ", souvenirPhotoPath=" + souvenirPhotoPath
				+ ", souvenir=" + souvenir + "]";
	}

}