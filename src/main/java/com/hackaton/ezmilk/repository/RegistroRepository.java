package com.hackaton.ezmilk.repository;

import com.hackaton.ezmilk.model.Pessoa;
import com.hackaton.ezmilk.model.Registro;
import com.hackaton.ezmilk.model.TipoRegistro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Integer> {

    List<Registro> findAllByPessoaId(Integer pessoaId);

    @Query(" select r from Registro r where r.pessoa = :pessoa and MONTH(r.dataRegistro) = :mes ")
    List<Registro> findAllByPessoaAndMonthEquals(Pessoa pessoa, Integer mes);

    @Query(" select r from Registro r where r.pessoa = :pessoa and r.tipoRegistro = :tipoRegistro ")
    List<Registro> findAllByPessoaIdAndTipoRegistro(Pessoa pessoa, TipoRegistro tipoRegistro);
}
