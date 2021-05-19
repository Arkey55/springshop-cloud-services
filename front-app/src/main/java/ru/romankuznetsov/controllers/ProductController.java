package ru.romankuznetsov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import ru.romankuznetsov.entity.Product;

import java.util.List;

@Controller
public class ProductController {

    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/products")
    public String index(Model model){
        model.addAttribute("products", restTemplate.getForObject("http://product-app/api/v1/products", List.class));
        return "index";
    }

    @PostMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        restTemplate.delete("http://product-app/api/v1/products/"+ id);
        return "redirect:/products";
    }

    @GetMapping("/addproduct")
    public String getAddProduct(Model model){
        model.addAttribute("products", new Product());
        return "add_product";
    }

    @PostMapping("/addproduct")
    public String addProduct(Product product){
//        restTemplate.postForEntity("http://product-app/api/v1/products", product);
        return "redirect:/products";
    }
}
