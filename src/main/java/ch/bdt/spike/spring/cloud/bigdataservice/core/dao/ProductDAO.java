package ch.bdt.spike.spring.cloud.bigdataservice.core.dao;

import ch.bdt.spike.spring.cloud.bigdataservice.api.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

@RepositoryRestResource
@RepositoryRestController
public interface ProductDAO extends JpaRepository<Product, Long> {
    @RestResource
    public List<Product> findByNameStartsWith(@Param("name") String name);

    //@RestResource(path = "nameStartsWith", rel = "nameStartsWith")
    //public Page<Product> findByNameStartsWith(@Param("name") String name, Pageable p);



}
