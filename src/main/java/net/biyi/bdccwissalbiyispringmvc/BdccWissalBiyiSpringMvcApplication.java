package net.biyi.bdccwissalbiyispringmvc;

import net.biyi.bdccwissalbiyispringmvc.entities.Product;
import net.biyi.bdccwissalbiyispringmvc.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BdccWissalBiyiSpringMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(BdccWissalBiyiSpringMvcApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(ProductRepository productRepository) {
        return args -> {

            productRepository.save(Product.builder()
                    .name("Computer")
                    .price(5400)
                    .quantity(12)
                    .build());

            productRepository.save(Product.builder()
                    .name("Printer")
                    .price(1200)
                    .quantity(11)
                    .build());

            productRepository.save(Product.builder()
                    .name("Smart Phone")
                    .price(12000)
                    .quantity(33)
                    .build());

            productRepository.findAll().forEach(p -> {
                System.out.println(p);
            });
        };
    }
}