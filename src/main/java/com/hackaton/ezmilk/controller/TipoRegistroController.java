package com.hackaton.ezmilk.controller;

import com.hackaton.ezmilk.model.dto.TipoRegistroResponseDTO;
import com.hackaton.ezmilk.service.TipoRegistroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipo-registro")
@RequiredArgsConstructor
public class TipoRegistroController {

    private final TipoRegistroService tipoRegistroService;

    @GetMapping
    public List<TipoRegistroResponseDTO> getAllTiposRegistros(@RequestParam("pessoaId") Integer pessoaId) {
        return tipoRegistroService.getAllTipoRegistro(pessoaId);
    }
}
