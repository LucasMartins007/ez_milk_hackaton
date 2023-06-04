package com.hackaton.ezmilk.repository;

import com.hackaton.ezmilk.model.TipoRegistro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRegistroRepository extends JpaRepository<TipoRegistro, Integer> {
}
