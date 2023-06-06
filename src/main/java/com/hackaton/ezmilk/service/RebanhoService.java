package com.hackaton.ezmilk.service;

import com.hackaton.ezmilk.model.Rebanho;
import com.hackaton.ezmilk.model.dto.RebanhoDTO;

public interface RebanhoService {
    Rebanho findByPessoa(Integer pessoaId);

    RebanhoDTO atualizarRebanho(Integer pessoaId, Integer rebanhoId, Rebanho rebanho);
}
