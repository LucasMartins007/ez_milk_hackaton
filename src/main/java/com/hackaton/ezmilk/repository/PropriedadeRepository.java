package com.hackaton.ezmilk.repository;

import com.hackaton.ezmilk.model.Propriedade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropriedadeRepository extends JpaRepository<Propriedade, Integer> {
}
