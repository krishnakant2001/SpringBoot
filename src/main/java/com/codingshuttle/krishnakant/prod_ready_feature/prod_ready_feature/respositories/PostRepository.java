package com.codingshuttle.krishnakant.prod_ready_feature.prod_ready_feature.respositories;

import com.codingshuttle.krishnakant.prod_ready_feature.prod_ready_feature.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
