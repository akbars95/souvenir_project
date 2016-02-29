package com.mtsmda.souvenir.service.impl;

import com.mtsmda.souvenir.model.Souvenir;
import com.mtsmda.souvenir.repository.SouvenirRepository;
import com.mtsmda.souvenir.service.SouvenirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MTSMDA on 18.11.2015.
 */
@Service("souvenirService")
public class SouvenirServiceImpl implements SouvenirService {

	@Autowired
	@Qualifier("souvenirRepositoryImplSPJavaStandard")
	private SouvenirRepository souvenirRepository;

	@Override
	public boolean insertSouvenir(Souvenir souvenir) {
		return this.souvenirRepository.insertSouvenir(souvenir);
	}

	@Override
	public boolean updateSouvenir(Souvenir souvenir) {
		return this.souvenirRepository.updateSouvenir(souvenir);
	}

	@Override
	public boolean deleteSouvenir(Souvenir souvenir) {
		return this.souvenirRepository.deleteSouvenir(souvenir);
	}

	@Override
	public Souvenir getSouvenir(Integer souvenirId) {
		return this.souvenirRepository.getSouvenir(souvenirId);
	}

	@Override
	public List<Souvenir> getAllSouvenir() {
		return this.souvenirRepository.getAllSouvenir();
	}

	@Override
	public boolean hideSouvenir(Souvenir souvenir) {
		return this.souvenirRepository.hideSouvenir(souvenir);
	}

	@Override
	public List<Souvenir> getAllSouvenirWithCategoryAndAudit() {
		return this.souvenirRepository.getAllSouvenirWithCategoryAndAudit();
	}
}