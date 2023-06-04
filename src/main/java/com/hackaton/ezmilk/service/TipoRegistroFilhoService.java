package com.hackaton.ezmilk.service;

import com.hackaton.ezmilk.model.TipoRegistroFilho;

import java.util.List;

public interface TipoRegistroFilhoService {

    List<TipoRegistroFilho> findByTipoRegistro(Integer tipoRegistroId);

}
