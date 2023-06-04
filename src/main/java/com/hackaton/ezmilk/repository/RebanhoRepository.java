package com.hackaton.ezmilk.repository;

import com.hackaton.ezmilk.model.Pessoa;
import com.hackaton.ezmilk.model.Rebanho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RebanhoRepository extends JpaRepository<Rebanho, Integer> {

    Rebanho findByPessoaAndId(Pessoa pessoa, Integer pessoaId);

    Rebanho findByPessoa(Pessoa pessoa);

}
