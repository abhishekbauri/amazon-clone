package com.example.Amazon.AmazonClone.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ProductDTO {

    private int productId;

    private String title;

    private String brand;

    private String modelName;

    private String description;

    private String amount;

    private String url;

    private String rating;

    private String returnable;

    private CategoryDTO category;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;
}