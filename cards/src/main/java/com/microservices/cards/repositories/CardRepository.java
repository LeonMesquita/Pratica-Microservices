package com.microservices.cards.repositories;

import com.microservices.cards.models.CardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<CardModel, Long> {
    List<CardModel> findByIncomeLessThanEqual(BigDecimal income);
}
