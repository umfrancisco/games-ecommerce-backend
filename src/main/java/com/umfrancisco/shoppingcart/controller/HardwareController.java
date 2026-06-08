package com.umfrancisco.shoppingcart.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.umfrancisco.shoppingcart.model.Hardware;
import com.umfrancisco.shoppingcart.service.HardwareService;

@RestController
@RequestMapping("/api/hardware")
@CrossOrigin
public class HardwareController {

	private final HardwareService service;

	public HardwareController(HardwareService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<Hardware>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@PostMapping("/data")
	public ResponseEntity<?> saveAll(@RequestBody List<Hardware> hardwares) {
		try {
			return new ResponseEntity<>(service.saveAll(hardwares), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
