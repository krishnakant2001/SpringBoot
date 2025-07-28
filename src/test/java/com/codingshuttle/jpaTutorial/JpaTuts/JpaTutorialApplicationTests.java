package com.codingshuttle.jpaTutorial.JpaTuts;

import com.codingshuttle.jpaTutorial.JpaTuts.entities.ProductEntity;
import com.codingshuttle.jpaTutorial.JpaTuts.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaTutorialApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository() {
		ProductEntity productEntity = ProductEntity.builder()
				.sku("nestle123")
				.title("Nestle Chocolate")
				.price(BigDecimal.valueOf(123.21))
				.quantity(12)
				.build();
		ProductEntity savedProductEntity = productRepository.save(productEntity);
		System.out.println(savedProductEntity);
	}

	@Test
	void getRepository(){
		List<ProductEntity> entities = productRepository.findAll();
		System.out.println(entities);

		List<ProductEntity> entries = productRepository.findByTitle("Nestle Chocolate");

		List<ProductEntity> list = productRepository.findByCreatedAtAfter(
				LocalDateTime.of(2024, 4, 1, 0, 0, 0)
		);
	}

	@Test
	void getProductRepository(){
		Optional<ProductEntity> productEntity = productRepository
				.findByTitleAndPrice("Nestle Chocolate", BigDecimal.valueOf(20.21));
		productEntity.ifPresent(System.out::println);
	}

}
