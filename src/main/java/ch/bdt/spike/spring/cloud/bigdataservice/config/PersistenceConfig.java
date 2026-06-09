package ch.bdt.spike.spring.cloud.bigdataservice.config;

import ch.bdt.spike.spring.cloud.bigdataservice.api.Category;
import ch.bdt.spike.spring.cloud.bigdataservice.api.Product;
import ch.bdt.spike.spring.cloud.bigdataservice.core.dao.ProductDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.security.SecureRandom;
import java.util.Random;

@Configuration
@EnableJpaRepositories(basePackages = "ch.bdt.spike.spring.cloud.bigdataservice.core.dao")
@EnableTransactionManagement
@Slf4j
public class PersistenceConfig {

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    CommandLineRunner initProducts(ProductDAO repository) {
        return args -> {
            log.info("Inserting 100 products");
            // On insère 100 Product avec name et price random
            for (int i = 1; i <= 100; i++) {
                Product product = new Product();
                product.setName("Product " + i);
                product.setCategory(Category.values()[i % Category.values().length]);
                product.setDescription(DESCRIPTION[(int)Math.floor(Math.random() * DESCRIPTION.length)]);
                product.setPrice(Math.round(Math.random() * 100 * 100) / 100.0);

                repository.save(product);
                //log.info("{} inserted", product);
            }
            log.info("100 products inserted");
        };
    }

    public static final String[] DESCRIPTION = {
            "Montre Quartz Classic : Élégance intemporelle, bracelet en cuir véritable et cadran épuré.",
            "Cafetière Espresso Pro : Un café riche en arômes chaque matin grâce à sa pression de 15 bars.",
            "Sac à dos Nomad 30L : Imperméable et ergonomique, le compagnon idéal pour vos randonnées.",
            "Écouteurs PureSound : Réduction de bruit active et 24h d'autonomie pour une immersion totale.",
            "Gourde Isotherme 1L : Garde vos boissons fraîches pendant 24h ou chaudes durant 12h. En inox.",
            "Crème Éclat Bio : Hydrate intensément et illumine le teint grâce aux actifs d'aloe vera.",
            "Baskets RunAir : Semelle ultra-légère et tissu respirant pour un confort de course inégalé.",
            "Enceinte Bluetooth Wave : Un son puissant à 360° dans un boîtier compact et étanche.",
            "Poêle Céramique 28cm : Revêtement antiadhésif sain, sans PFAS, pour une cuisson homogène.",
            "Liseuse InkBook : Écran haute résolution sans reflet, parfait pour lire de jour comme de nuit.",
            "Huile Barbe Premium : Nourrit le poil et adoucit la peau avec son parfum boisé subtil.",
            "Projecteur MiniHD : Cinéma à la maison avec une image nette jusqu'à 3m de diagonale.",
            "Théière en Fonte 0.8L : Style japonais traditionnel avec filtre en inox amovible inclus.",
            "Clavier MécaSilent : Frappe ultra-rapide et frappe silencieuse pour le bureau ou le jeu.",
            "Bougie Cire Végétale : Parfum délicat de lavande, 40 heures de combustion sereine."
    };
}