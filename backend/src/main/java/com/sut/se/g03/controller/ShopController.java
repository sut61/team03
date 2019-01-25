package project.se.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.se.demo.entity.*;
import project.se.demo.repository.*;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ShopController {
    @Autowired private final ShopRepository shopRepository;
    @Autowired private ItemRepository itemRepository;
    @Autowired private CustomerRepository customerRepository;
    @Autowired private DistrictRepository districtRepository;

    @Autowired
    ShopController(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @GetMapping("/Shops")
    public Collection<Shop> Shop() {
        return shopRepository.findAll().stream()
                .collect(Collectors.toList());
    }
    @GetMapping("/Shop/{id}")
    public Shop View(@PathVariable Long id) {
        Shop S = shopRepository.findByShopId(id);
        return S;
    }


    @PostMapping("/Customer/add/{username}/{customerName}/{tel}/{email}/{subdist}/{itemId}/{itemNum}/{districtId}")
    public Shop newShop(@PathVariable String username ,@PathVariable String customerName, @PathVariable String tel,
                        @PathVariable String email, @PathVariable String subdist, @PathVariable Long itemId,
                        @PathVariable int itemNum, @PathVariable long districtId ){
        Shop newShop = new Shop();
        Customer customer = customerRepository.findByUsername(username);
        Item item = itemRepository.findByItemId(itemId);
        District district = districtRepository.findById(districtId);

        newShop.setSubdist(subdist);
        newShop.setItem(item);
        newShop.setItemNum(itemNum);
        newShop.setDistrictShop(district);
        newShop.setCustomerShop(customer);
        newShop.setCustomerName(customerName);
        newShop.setTel(tel);
        newShop.setEmail(email);
        return shopRepository.save(newShop);
    }


}
