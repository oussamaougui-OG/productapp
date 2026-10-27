package net.oussama.productapp;

import net.oussama.productapp.entities.Product;
import net.oussama.productapp.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductappApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductappApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder().name("Ordinateur").price(8000).quantity(10).build());
            productRepository.save(Product.builder().name("Imprimante").price(1500).quantity(5).build());
            productRepository.save(Product.builder().name("Souris").price(120).quantity(50).build());
            System.out.println("=== Produits ajoutés ===");
            System.out.println("=== Tous les produits ===");
            productRepository.findAll().forEach(System.out::println);
        };
    }
}