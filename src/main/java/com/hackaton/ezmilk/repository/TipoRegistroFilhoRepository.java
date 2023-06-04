package com.hackaton.ezmilk.repository;

import com.hackaton.ezmilk.model.TipoRegistro;
import com.hackaton.ezmilk.model.TipoRegistroFilho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoRegistroFilhoRepository extends JpaRepository<TipoRegistroFilho, Integer> {

    List<TipoRegistroFilho> findByTipoRegistro(TipoRegistro tipoRegistro);
}
