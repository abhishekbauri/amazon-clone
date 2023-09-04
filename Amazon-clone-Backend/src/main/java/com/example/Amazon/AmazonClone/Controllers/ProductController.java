package com.example.Amazon.AmazonClone.Controllers;

import com.example.Amazon.AmazonClone.Model.Product;
import com.example.Amazon.AmazonClone.Services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/api/product",produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_XML_VALUE})
@Slf4j
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/saveProduct")
    public ResponseEntity<Response> saveProduct(@RequestBody Product p){
        Product obj = productService.saveProductDetails(p);
        Response response = new Response();
        if(obj != null && obj.getProductId() > 0) {
            response.setStatus(200);
            response.setMessage("Product saved successfully");
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .header("isProductSaved", "true")
                    .body(response);
        }
        response.setStatus(200);
        response.setMessage("Did not saved due to wrong data recieved error");
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .header("notSaved", "true")
                .body(response);
    }

    @GetMapping("getAllProducts")
    public List<Product> getAllProducts(){
        return productService.getAllProductsDetails();
    }

}
