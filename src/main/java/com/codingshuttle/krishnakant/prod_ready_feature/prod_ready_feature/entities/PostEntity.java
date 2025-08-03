package com.codingshuttle.krishnakant.prod_ready_feature.prod_ready_feature.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//hibernate envers uses for tracking the changes in the schema
@Audited
public class PostEntity extends AuditableEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;
}
