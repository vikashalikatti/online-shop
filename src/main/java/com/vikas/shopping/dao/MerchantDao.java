package com.vikas.shopping.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vikas.shopping.dto.Merchant;

@Repository
public class MerchantDao {

	@Autowired
	com.vikas.shopping.repository.MerchantRepository merchantRepository;

	public Merchant findByEmail(String email) {
		return merchantRepository.findByEmail(email);
	}

	public Merchant findByMobile(long mobile) {
		return merchantRepository.findByMobile(mobile);
	}

	public void save(Merchant merchant) {
		merchantRepository.save(merchant);
	}

}
