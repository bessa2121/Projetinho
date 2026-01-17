package com.br.burguesaBurguers.repository;

import com.br.burguesaBurguers.model.Order;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    @EntityGraph(attributePaths = {"itens", "itens.product"})
    Optional<Order> findWithItensById(Long id);

}
