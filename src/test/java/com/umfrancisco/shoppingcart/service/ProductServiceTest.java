package com.umfrancisco.shoppingcart.service;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.umfrancisco.shoppingcart.model.Product;
import com.umfrancisco.shoppingcart.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
	
	@Mock
	private ProductRepository repository;
	
	@InjectMocks
	private ProductServiceImpl service;
	
    @Test
	void shouldReturnAllProducts() {
	    Product prod1 = new Product();
	    Product prod2 = new Product();
	    BDDMockito.given(repository.findAll()).willReturn(List.of(prod1, prod2));
	    List<Product> productList = service.getProducts();
	    Assertions.assertNotNull(productList);
	    Assertions.assertEquals(2, productList.size());
	}

}
