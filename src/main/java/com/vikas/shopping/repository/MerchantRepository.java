package com.vikas.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vikas.shopping.dto.Merchant;

public interface MerchantRepository extends JpaRepository<Merchant, String> {

	Merchant findByEmail(String email);

	Merchant findByMobile(long mobile);

}
