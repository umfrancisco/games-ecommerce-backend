package com.umfrancisco.shoppingcart.service;

import java.util.List;
import com.umfrancisco.shoppingcart.model.Hardware;

public interface HardwareService {

	// save
	Hardware save(Hardware hardware);
	List<Hardware> saveAll(List<Hardware> hardwares);
	
	// find
	List<Hardware> findAll();
	Hardware findById(Long id);
	
	// update
	Hardware update(Hardware hardware, Long id);

	// delete
	void deleteById(Long id);
}
