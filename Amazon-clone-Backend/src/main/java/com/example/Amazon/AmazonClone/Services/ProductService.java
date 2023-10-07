package com.example.Amazon.AmazonClone.Services;

import com.example.Amazon.AmazonClone.Entity.ProductEntity;
import com.example.Amazon.AmazonClone.Model.ProductDTO;
import com.example.Amazon.AmazonClone.ObjectMapper.ProductMapper;
import com.example.Amazon.AmazonClone.Repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Boolean saveProductDetails(ProductDTO p){

        ProductEntity productEntity = ProductMapper.dtoToEntity(p);
//        BeanUtils.copyProperties(p, productEntity);

        ProductEntity obj = productRepository.findByTitle(productEntity.getTitle());
        if(obj != null && obj.getProductId() > 0){
            return (false);
        }

        System.out.println(obj);
        productRepository.save(productEntity);
        return (true);
    }

    public List<ProductDTO> getProductsDetailsBasedOnCategory(String category){
        List<ProductEntity> productEntities = productRepository.getProductsBasedOnCategory(category);

        List<ProductDTO> productDTOS = new ArrayList<>();
        productEntities.forEach(productEntity -> {
            ProductDTO productDTO = ProductMapper.entityToDTO(productEntity);
//            BeanUtils.copyProperties(productEntity, productDTO);
            productDTOS.add(productDTO);

        });

        return (productDTOS);
    }

    public List<ProductDTO> getAllProductsDetails(){
        List<ProductEntity> productEntities = productRepository.findAll();

        List<ProductDTO> productDTOS = new ArrayList<>();
        productEntities.forEach(productEntity -> {
            ProductDTO productDTO = ProductMapper.entityToDTO(productEntity);
//            BeanUtils.copyProperties(productEntity, productDTO);
            productDTOS.add(productDTO);
        });

        return (productDTOS);
    }
}
