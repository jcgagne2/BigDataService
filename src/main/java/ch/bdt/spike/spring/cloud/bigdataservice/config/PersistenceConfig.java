package ch.bdt.spike.spring.cloud.bigdataservice.config;

import ch.bdt.spike.spring.cloud.bigdataservice.api.Category;
import ch.bdt.spike.spring.cloud.bigdataservice.api.Product;
import ch.bdt.spike.spring.cloud.bigdataservice.core.dao.ProductDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "ch.bdt.spike.spring.cloud.bigdataservice.core.dao")
@EnableTransactionManagement
@Slf4j
public class PersistenceConfig {

    @Bean
    CommandLineRunner runner(ProductDAO repository) {
        return args -> {
            log.info("Inserting 100 products");
            // On insère 100 Product avec name et price random
            for (int i = 0; i < 100; i++) {
                Product product = new Product();
                product.setName("Product " + i);
                product.setCategory(Category.values()[i % Category.values().length]);
                product.setDescription("Description " + i);
                product.setPrice(Math.round(Math.random() * 100 * 100) / 100.0);
                repository.save(product);
            }
            log.info("100 products inserted");
        };
    }
}