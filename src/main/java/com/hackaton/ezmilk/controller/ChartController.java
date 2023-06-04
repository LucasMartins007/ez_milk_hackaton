package com.hackaton.ezmilk.controller;

import com.hackaton.ezmilk.service.ChartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chart")
@RequiredArgsConstructor
public class ChartController {

    private final ChartService chartService;

    @GetMapping("/{pessoaId}")
    public List<List<Object>> getTipoRegistroChart(@PathVariable("pessoaId") Integer pessoaId) {
        return chartService.getChart(pessoaId);
    }
}
