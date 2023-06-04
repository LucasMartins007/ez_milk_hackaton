package com.hackaton.ezmilk.controller;

import com.hackaton.ezmilk.model.dto.TipoRegistroFilhoDTO;
import com.hackaton.ezmilk.service.TipoRegistroFilhoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/registro-filho")
@RequiredArgsConstructor
public class TipoRegistroFilhoController {

    private final TipoRegistroFilhoService tipoRegistroFilhoService;

    private final ModelMapper modelMapper;

    @GetMapping
    public List<TipoRegistroFilhoDTO> findByTipoRegistro(@RequestParam(name = "tipoRegistro") Integer tipoRegistroId) {
        return tipoRegistroFilhoService.findByTipoRegistro(tipoRegistroId)
                .stream()
                .map(tipoRegistro -> modelMapper.map(tipoRegistro, TipoRegistroFilhoDTO.class))
                .toList();
    }

}
