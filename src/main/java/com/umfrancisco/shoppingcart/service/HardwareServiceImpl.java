package com.umfrancisco.shoppingcart.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.umfrancisco.shoppingcart.model.Hardware;
import com.umfrancisco.shoppingcart.repository.HardwareRepository;

@Service
public class HardwareServiceImpl implements HardwareService {
	
	private final HardwareRepository repository;
	
	public HardwareServiceImpl(HardwareRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Hardware save(Hardware hardware) {
		return repository.save(hardware);
	}
	
	@Override
	public List<Hardware> saveAll(List<Hardware> hardwares) {
		for (var hardware : hardwares) {
			save(hardware);
		}
		return hardwares;
	}

	@Override
	public List<Hardware> findAll() {
		return repository.findAll();
	}

	@Override
	public Hardware findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Hardware update(Hardware hardware, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
	}
	
}
