package com.microservices.cards.repositories;

import com.microservices.cards.models.ClientCardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientCardRepository extends JpaRepository<ClientCardModel, Long> {
    List<ClientCardModel> findByCpf(String cpf);
}
