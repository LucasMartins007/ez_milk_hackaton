package com.hackaton.ezmilk.service.impl;

import com.hackaton.ezmilk.exception.DomainException;
import com.hackaton.ezmilk.model.TipoRegistro;
import com.hackaton.ezmilk.model.TipoRegistroFilho;
import com.hackaton.ezmilk.repository.TipoRegistroFilhoRepository;
import com.hackaton.ezmilk.repository.TipoRegistroRepository;
import com.hackaton.ezmilk.service.TipoRegistroFilhoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoRegistroFilhoServiceImpl implements TipoRegistroFilhoService {

    private final TipoRegistroRepository registroRepository;

    private final TipoRegistroFilhoRepository tipoRegistroFilhoRepository;

    @Override
    public List<TipoRegistroFilho> findByTipoRegistro(Integer tipoRegistroId) {
        final TipoRegistro tipoRegistro = registroRepository.findById(tipoRegistroId)
                .orElseThrow(() -> new DomainException("Tipo registro " + tipoRegistroId + " não existe. "));

        return tipoRegistroFilhoRepository.findByTipoRegistro(tipoRegistro);
    }
}
