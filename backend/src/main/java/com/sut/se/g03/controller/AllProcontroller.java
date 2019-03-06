package com.sut.se.g03.controller;

import com.sut.se.g03.entity.Addproduct;
import com.sut.se.g03.entity.Product;
import com.sut.se.g03.entity.Typeproduct;
import com.sut.se.g03.repository.AddproductRepository;
import com.sut.se.g03.repository.ProductRepository;
import com.sut.se.g03.repository.TypeproductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;

import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AllProcontroller {

    @Autowired private AddproductRepository addproductRepository;
    @Autowired private TypeproductRepository typeproductRepository;
    @Autowired private ProductRepository productRepository;

    @GetMapping(path = "/addproduct")
    private Collection<Addproduct> getAddproduct(){
        return this.addproductRepository.findAll().stream().collect(Collectors.toList());
    }
     
    @GetMapping(path = "/typeproduct")
    private Collection<Typeproduct> getTypeproduct() {
        return this.typeproductRepository.findAll().stream().collect(Collectors.toList());
    }
   
    @PostMapping(path = "/addproduct/{typeproducts}/{nameproduct}/{number}/{price}/{saleprice}/{date}")
    public Addproduct Addproduct(@PathVariable Long typeproducts,@PathVariable String nameproduct, @PathVariable int number,@PathVariable int price,@PathVariable int saleprice, @PathVariable Date date){
        Addproduct addproduct = new Addproduct();
        Product product = new Product();

        addproduct.setNumber(number);
        addproduct.setDate(date);
        addproduct.setPrice(price);
        addproduct.setSaleprice(saleprice);
        addproductRepository.save(addproduct);

        Typeproduct typeproduct1 = typeproductRepository.findById(typeproducts).get();
        product.setTypeproducts(typeproduct1);
        product.setAddproduct(nameproduct);
        product.setProduct(addproduct);
        productRepository.save(product);

        return addproduct;
    }

}
