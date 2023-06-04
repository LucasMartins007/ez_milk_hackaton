package com.hackaton.ezmilk.service;

import com.hackaton.ezmilk.model.Rebanho;

public interface RebanhoService {
    Rebanho findByPessoa(Integer pessoaId);

    void atualizarRebanho(Integer pessoaId, Integer rebanhoId, Rebanho rebanho);
}
