package com.hackaton.ezmilk.service;

import com.hackaton.ezmilk.model.Registro;
import com.hackaton.ezmilk.model.dto.HistoricoDTO;

public interface RegistroService {

    Registro novoRegistro(Registro registro, Integer pessoaId);

    HistoricoDTO getHistorico(Integer pessoaId, Integer mes);
}
