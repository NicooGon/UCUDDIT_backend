package com.example.ucuddit.respository;
import com.example.ucuddit.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<Rate, Integer> {
    Rate findByrateId(Integer rateId);
}
