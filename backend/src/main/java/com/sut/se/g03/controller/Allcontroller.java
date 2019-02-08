package com.sut.se.g03.controller;

import com.sut.se.g03.entity.Product;
import com.sut.se.g03.entity.Promotion;
import com.sut.se.g03.entity.Staff;
import com.sut.se.g03.entity.Typepromotion;
import com.sut.se.g03.repository.ProductRepository;
import com.sut.se.g03.repository.PromotionRepository;
import com.sut.se.g03.repository.StaffRepository;
import com.sut.se.g03.repository.TypepromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Allcontroller {

   @Autowired private ProductRepository productRepository;
   @Autowired private PromotionRepository promotionRepository;
   @Autowired private StaffRepository staffRepository;
   @Autowired private TypepromotionRepository typepromotionRepository;


    @GetMapping(path = "/product")
    private Collection<Product> getProduct(){
        return this.productRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/promotion")
    private Collection<Promotion> getPromotion(){
        return this.promotionRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/staff")
    private Collection<Staff> getStaff(){
        return this.staffRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/typepromotion")
    private Collection<Typepromotion> getTypepromotion(){
        return this.typepromotionRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(path = "/promotion/{addproduct}/{promotinoName}/{code}/{startDate}/{stopDate}//{staffName}/{typePromotinos}")
    public Promotion promotion(@PathVariable Long addproduct, @PathVariable String promotinoName, @PathVariable String code, @PathVariable Date startDate,@PathVariable Date stopDate,@PathVariable Long staffName,@PathVariable Long typePromotinos){
        Promotion promotion = new Promotion();
        promotion.setPromotinoName(promotinoName);
        promotion.setCode(code);
        promotion.setStartDate(startDate);
        promotion.setStopDate(stopDate);

        
        Product product1 = productRepository.findById(addproduct).get();
        promotion.setProduct(product1);

        Staff staff1 = staffRepository.findById(staffName).get();
        promotion.setStaff(staff1);

        Typepromotion typepromotion1 = typepromotionRepository.findById(typePromotinos).get();
        promotion.setTypepromotion(typepromotion1);

        promotionRepository.save(promotion);
        return promotion;
    }

}
