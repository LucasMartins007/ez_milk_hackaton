package com.hackaton.ezmilk.service;

import com.hackaton.ezmilk.model.dto.TipoRegistroResponseDTO;

import java.util.List;

public interface TipoRegistroService {

    List<TipoRegistroResponseDTO> getAllTipoRegistro(Integer pessoaID);

}
