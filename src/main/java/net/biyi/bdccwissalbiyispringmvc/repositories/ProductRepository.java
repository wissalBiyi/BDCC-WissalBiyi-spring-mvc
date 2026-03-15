package net.biyi.bdccwissalbiyispringmvc.repositories;

import net.biyi.bdccwissalbiyispringmvc.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByNameContains(String keyword, Pageable pageable);

}