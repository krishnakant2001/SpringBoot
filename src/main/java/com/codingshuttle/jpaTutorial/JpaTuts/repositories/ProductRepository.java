package com.codingshuttle.jpaTutorial.JpaTuts.repositories;

import com.codingshuttle.jpaTutorial.JpaTuts.entities.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findBy(Sort sort);
    List<ProductEntity> findByOrderByPrice();

    List<ProductEntity> findByTitleContainingIgnoringCase(String title, Pageable pageable);

    List<ProductEntity> findByCreatedAtAfter(LocalDateTime now);

//    @Query("select e from ProductEntity e where e.title=?1 and e.price=?2")

    @Query("select e from ProductEntity e where e.title=:title and e.price=:price")
    Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);
}
