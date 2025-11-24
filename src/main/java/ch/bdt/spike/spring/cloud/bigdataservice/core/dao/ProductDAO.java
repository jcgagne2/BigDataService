package ch.bdt.spike.spring.cloud.bigdataservice.core.dao;

import ch.bdt.spike.spring.cloud.bigdataservice.api.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface ProductDAO extends JpaRepository<Product, Long> {
    @RestResource(path = "nameStartsWith", rel = "nameStartsWith")
    public Page<Product> findByNameStartsWith(@Param("name") String name, Pageable p);
}
