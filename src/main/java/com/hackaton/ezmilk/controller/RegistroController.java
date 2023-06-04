package com.hackaton.ezmilk.controller;

import com.hackaton.ezmilk.model.Registro;
import com.hackaton.ezmilk.model.dto.HistoricoDTO;
import com.hackaton.ezmilk.model.dto.RegistroDTO;
import com.hackaton.ezmilk.service.RegistroService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registro")
@RequiredArgsConstructor
public class RegistroController {


    private final RegistroService registroService;

    private final ModelMapper modelMapper;

    @PostMapping("/{pessoaId}")
    public RegistroDTO novoRegistro(@RequestBody RegistroDTO registroDTO, @PathVariable("pessoaId") Integer pessoaId) {
        final Registro registro = modelMapper.map(registroDTO, Registro.class);

        return modelMapper.map(registroService.novoRegistro(registro, pessoaId), RegistroDTO.class);
    }

    @GetMapping("/{pessoaId}/historico")
    public HistoricoDTO getHistorico(@PathVariable("pessoaId") Integer pessoaId, @RequestParam("mes") Integer mes) {
        return registroService.getHistorico(pessoaId, mes);
    }
}
