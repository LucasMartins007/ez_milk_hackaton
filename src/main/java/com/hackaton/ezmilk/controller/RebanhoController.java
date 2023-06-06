package com.hackaton.ezmilk.controller;

import com.hackaton.ezmilk.model.Rebanho;
import com.hackaton.ezmilk.model.dto.RebanhoDTO;
import com.hackaton.ezmilk.service.RebanhoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rebanho")
@RequiredArgsConstructor
public class RebanhoController {

    private final RebanhoService rebanhoService;

    private final ModelMapper modelMapper;

    @GetMapping("/{pessoaId}")
    public RebanhoDTO getRebanho(@PathVariable("pessoaId") Integer pessoaId) {
        return modelMapper.map(rebanhoService.findByPessoa(pessoaId), RebanhoDTO.class);
    }

    @PutMapping("/{pessoaId}/atualizar/{rebanhoId}")
    public RebanhoDTO updateRebanho(@PathVariable("pessoaId") Integer pessoaId, @PathVariable("rebanhoId") Integer rebanhoId, @RequestBody RebanhoDTO rebanhoDTO) {
        return rebanhoService.atualizarRebanho(pessoaId, rebanhoId, modelMapper.map(rebanhoDTO, Rebanho.class));
    }
}
