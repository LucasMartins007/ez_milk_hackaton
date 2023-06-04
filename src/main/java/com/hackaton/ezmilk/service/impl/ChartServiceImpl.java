package com.hackaton.ezmilk.service.impl;

import com.hackaton.ezmilk.exception.DomainException;
import com.hackaton.ezmilk.model.Pessoa;
import com.hackaton.ezmilk.model.dto.HistoricoDTO;
import com.hackaton.ezmilk.model.dto.RegistroDTO;
import com.hackaton.ezmilk.repository.PessoaRepository;
import com.hackaton.ezmilk.service.ChartService;
import com.hackaton.ezmilk.service.RegistroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChartServiceImpl implements ChartService {

    private final PessoaRepository pessoaRepository;

    private final RegistroService registroService;

    @Override
    public List<List<Object>> getChart(Integer pessoaId) {
        final Pessoa pessoa = pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new DomainException("Pessoa não existe."));

        final HistoricoDTO historicoDTO = registroService.getHistorico(pessoa.getId(), null);

        final Map<String, BigDecimal> somaPorDescricao = historicoDTO.getRegistros()
                .stream()
                .collect(Collectors.groupingBy(registroDTO -> registroDTO.getTipoRegistro().getDescricao(),
                        Collectors.mapping(RegistroDTO::getPreco, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))));

        final List<List<Object>> values = new ArrayList<>();
        somaPorDescricao.forEach((key, value) -> {
            final List<Object> valuesGroup = new ArrayList<>();
            valuesGroup.add(key);
            valuesGroup.add(value);
            values.add(valuesGroup);
        });
        return values;
    }

}
