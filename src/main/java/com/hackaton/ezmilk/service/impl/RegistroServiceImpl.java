package com.hackaton.ezmilk.service.impl;

import com.hackaton.ezmilk.exception.DomainException;
import com.hackaton.ezmilk.model.Pessoa;
import com.hackaton.ezmilk.model.Registro;
import com.hackaton.ezmilk.model.TipoRegistro;
import com.hackaton.ezmilk.model.TipoRegistroFilho;
import com.hackaton.ezmilk.model.dto.HistoricoDTO;
import com.hackaton.ezmilk.model.dto.RegistroDTO;
import com.hackaton.ezmilk.model.dto.TipoRegistroDTO;
import com.hackaton.ezmilk.model.dto.TipoRegistroFilhoDTO;
import com.hackaton.ezmilk.model.enums.EnumStatusRegistro;
import com.hackaton.ezmilk.repository.PessoaRepository;
import com.hackaton.ezmilk.repository.RegistroRepository;
import com.hackaton.ezmilk.repository.TipoRegistroFilhoRepository;
import com.hackaton.ezmilk.repository.TipoRegistroRepository;
import com.hackaton.ezmilk.service.RegistroService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistroServiceImpl implements RegistroService {


    private final RegistroRepository registroRepository;

    private final PessoaRepository pessoaRepository;

    private final TipoRegistroFilhoRepository tipoRegistroFilhoRepository;

    private final TipoRegistroRepository tipoRegistroRepository;

    private final ModelMapper modelMapper;

    @Override
    public Registro novoRegistro(Registro registro, Integer pessoaId) {
        final Pessoa pessoa = pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new DomainException("Pessoa nao existe"));
        registro.setPessoa(pessoa);

        final TipoRegistro tipoRegistro = tipoRegistroRepository.findById(registro.getTipoRegistro().getId())
                .orElseThrow(() -> new DomainException("Tipo de registro não existe."));
        registro.setEntrada(tipoRegistro.isEntrada());
        registro.setTipoRegistro(tipoRegistro);

        resolverTipoRegistroFilho(registro);
        registro.setStatusRegistro(EnumStatusRegistro.REGISTRO_OK);
        return registroRepository.save(registro);
    }

    private void resolverTipoRegistroFilho(Registro registro) {
        if (registro.getTipoRegistroFilho() != null) {
            final TipoRegistroFilho tipoRegistroFilho = tipoRegistroFilhoRepository.findById(registro.getTipoRegistroFilho().getId())
                    .orElseThrow(() -> new DomainException("Tipo registro fiho nao existe. "));

            registro.setTipoRegistroFilho(tipoRegistroFilho);
        }
    }

    @Override
    public HistoricoDTO getHistorico(Integer pessoaId, Integer mes) {
        final HistoricoDTO historicoDTO = new HistoricoDTO();
        historicoDTO.setRegistros(new ArrayList<>());

        final Pessoa pessoa = pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new DomainException("Pessoa nao existe."));

        final List<Registro> registros = getAllRegistros(mes, pessoa);

        final BigDecimal somaTotal = calcularSomaTotalDosRegistros(registros);
        historicoDTO.setSaldoFinal(somaTotal);
        registros.forEach(registro -> gerarRegistroDTO(historicoDTO, somaTotal, registro));

        return historicoDTO;
    }

    private List<Registro> getAllRegistros(Integer mes, Pessoa pessoa) {
        if (mes == null) {
            return registroRepository.findAllByPessoaId(pessoa.getId());
        }
        return registroRepository.findAllByPessoaAndMonthEquals(pessoa, mes);
    }

    private BigDecimal calcularSomaTotalDosRegistros(List<Registro> registros) {
        final BigDecimal entradas = registros.stream()
                .filter(Registro::isEntrada)
                .map(Registro::getPreco)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        final BigDecimal saidas = registros.stream()
                .filter(registro -> !registro.isEntrada())
                .map(Registro::getPreco)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return entradas.subtract(saidas);

    }

    private void gerarRegistroDTO(HistoricoDTO historicoDTO, BigDecimal somaTotal, Registro registro) {
        final RegistroDTO registroDTO = new RegistroDTO();
        BigDecimal porcentagem = BigDecimal.ZERO;
        if (registro.getPreco().compareTo(BigDecimal.ZERO) != 0 && somaTotal.compareTo(BigDecimal.ZERO) != 0 && !registro.isEntrada()) {
            porcentagem = registro.getPreco()
                    .multiply(BigDecimal.valueOf(100L))
                    .divide(somaTotal, RoundingMode.FLOOR)
                    .abs();
        }

        registroDTO.setPorcentagem(porcentagem);
        registroDTO.setDataRegistro(registro.getDataRegistro());
        registroDTO.setEntrada(registro.getTipoRegistro().isEntrada());
        registroDTO.setTipoRegistro(modelMapper.map(registro.getTipoRegistro(), TipoRegistroDTO.class));
        registroDTO.setPreco(registro.getPreco());
        registroDTO.setQuantidade(registro.getQuantidade());
        registroDTO.setId(registro.getId());
        if (registro.getTipoRegistroFilho() != null) {
            registroDTO.setTipoRegistroFilho(modelMapper.map(registro.getTipoRegistroFilho(), TipoRegistroFilhoDTO.class));
        }

        historicoDTO.getRegistros().add(registroDTO);
    }

    private List<TipoRegistroFilho> getTipoRegistroFilhoSelecionado(TipoRegistro tipoRegistro, TipoRegistroFilho tipoRegistroFilho) {
        final TipoRegistroFilho managedTipoRegistroFilho = tipoRegistro.getTipoRegistroFilho()
                .stream()
                .filter(tpf -> tpf.getId().equals(tipoRegistroFilho.getId()))
                .findFirst()
                .orElseThrow(() -> new DomainException("Tipo registro filho inválido nao existe"));

        return List.of(managedTipoRegistroFilho);
    }
}
