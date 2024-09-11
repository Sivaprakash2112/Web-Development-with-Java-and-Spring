package com.gd.ecom.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer available;

    private BigDecimal price;

    @Version
    @Column(name = "VERSION")
    private Long version;

}

/*
Here, @Version is applied to the version field. This means that whenever a Product entity is updated,
the version field will be automatically incremented by the JPA provider (like Hibernate) when the entity is persisted.
During concurrent operations, if two transactions attempt to update the same Product instance concurrently,
JPA will use the version field to detect if there was an intermediate change between the two updates.
If there was, one of the transactions will fail with an OptimisticLockException, ensuring data consistency.
*/