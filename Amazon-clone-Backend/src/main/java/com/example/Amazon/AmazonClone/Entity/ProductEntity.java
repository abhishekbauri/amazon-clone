package com.example.Amazon.AmazonClone.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Data
@NoArgsConstructor
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int productId;

    @Column(name = "title", length = 400)
    private String title;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "amount")
    private String amount;

    @Column(name = "url", length = 600)
    private String url;

    @Column(name = "rating")
    private String rating;

    @Column(name = "returnable")
    private String returnable;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL, targetEntity = CategoryEntity.class)
    @JoinColumn(name = "id",referencedColumnName = "id",nullable = true)
    private CategoryEntity categoryEntity;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @Column(insertable = false)
    private String updatedBy;
}