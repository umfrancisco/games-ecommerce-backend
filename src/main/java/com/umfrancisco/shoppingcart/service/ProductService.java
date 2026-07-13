package com.umfrancisco.shoppingcart.service;

import java.util.List;
import com.umfrancisco.shoppingcart.payload.ProductDTO;

public interface ProductService {
	ProductDTO addProduct(ProductDTO product);
	List<ProductDTO> getProducts();
	ProductDTO getProductById(Long id);
	List<ProductDTO> getProductByCategory(String category);
	ProductDTO getHighlightedProduct();
	List<ProductDTO> getHighlightedProducts();
	ProductDTO updateProduct(ProductDTO product, Long id);
	ProductDTO deleteProduct(Long id);
}
