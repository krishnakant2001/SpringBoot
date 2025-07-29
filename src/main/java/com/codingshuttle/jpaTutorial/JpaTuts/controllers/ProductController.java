package com.codingshuttle.jpaTutorial.JpaTuts.controllers;

import com.codingshuttle.jpaTutorial.JpaTuts.entities.ProductEntity;
import com.codingshuttle.jpaTutorial.JpaTuts.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    private final int PAGE_SIZE = 5;

//    @GetMapping
//    public List<ProductEntity> getAllProducts() {
//        return productRepository.findByOrderByPrice();
//    }

    @GetMapping
    public List<ProductEntity> getAllProducts(
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "0") Integer pageNumber) {

        return productRepository.findByTitleContainingIgnoringCase(
                title,
                PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(sortBy))
        );

//        return productRepository.findBy(Sort.by(
//                Sort.Order.desc(sortBy),
//                Sort.Order.asc("price")
//        ));

//        return productRepository.findBy(Sort.by(Sort.Direction.DESC, sortBy));
//        http://localhost:8080/products?sortBy=title

//        Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE);

//        Pageable pageable = PageRequest.of(
//                pageNumber,
//                PAGE_SIZE,
//                Sort.by(sortBy)
//        );

//        return productRepository.findAll(pageable).getContent();
    }
}
