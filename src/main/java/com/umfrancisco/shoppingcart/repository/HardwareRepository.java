package com.umfrancisco.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.umfrancisco.shoppingcart.model.Hardware;

@Repository
public interface HardwareRepository extends JpaRepository<Hardware, Long> {
	
}
