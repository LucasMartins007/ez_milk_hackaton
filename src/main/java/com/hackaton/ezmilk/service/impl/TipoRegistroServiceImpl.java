package com.hackaton.ezmilk.service.impl;

import com.hackaton.ezmilk.exception.DomainException;
import com.hackaton.ezmilk.model.Pessoa;
import com.hackaton.ezmilk.model.Registro;
import com.hackaton.ezmilk.model.TipoRegistro;
import com.hackaton.ezmilk.model.dto.TipoRegistroResponseDTO;
import com.hackaton.ezmilk.model.enums.EnumStatusRegistro;
import com.hackaton.ezmilk.repository.PessoaRepository;
import com.hackaton.ezmilk.repository.RegistroRepository;
import com.hackaton.ezmilk.repository.TipoRegistroRepository;
import com.hackaton.ezmilk.service.TipoRegistroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoRegistroServiceImpl implements TipoRegistroService {

    private final TipoRegistroRepository tipoRegistroRepository;

    private final RegistroRepository registroRepository;

    private final PessoaRepository pessoaRepository;

    @Override
    public List<TipoRegistroResponseDTO> getAllTipoRegistro(Integer pessoaid) {
        final List<TipoRegistro> tipoRegistro = tipoRegistroRepository.findAll();
        final Pessoa pessoa = pessoaRepository.findById(pessoaid)
                .orElseThrow(() -> new DomainException("Pessoa não existe"));
        return tipoRegistro.stream()
                .map(tr -> {
                    final List<Registro> registros = registroRepository.findAllByPessoaIdAndTipoRegistro(pessoa, tr);

                    final Registro registroMaisRecente = registros.stream()
                            .max(Comparator.comparing(Registro::getDataRegistro))
                            .orElse(null);

                    final Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.MONTH, -1);
                    final Date umMesAtras = calendar.getTime();
                    if (registroMaisRecente != null && registroMaisRecente.getDataRegistro().before(umMesAtras)) {
                        registroMaisRecente.setStatusRegistro(EnumStatusRegistro.REGISTRO_ATRASADO);
                        registroRepository.save(registroMaisRecente);
                    }
                    final TipoRegistroResponseDTO tipoRegistroResponseDTO = new TipoRegistroResponseDTO();
                    final EnumStatusRegistro statusRegistro = registroMaisRecente != null
                            ? registroMaisRecente.getStatusRegistro()
                            : EnumStatusRegistro.SEM_REGISTRO;

                    tipoRegistroResponseDTO.setStatusRegistro(statusRegistro);
                    tipoRegistroResponseDTO.setId(tr.getId());
                    tipoRegistroResponseDTO.setDescricao(tr.getDescricao());
                    return tipoRegistroResponseDTO;
                }).toList();
    }


}
