package com.hackaton.ezmilk.service.impl;

import com.hackaton.ezmilk.exception.DomainException;
import com.hackaton.ezmilk.model.Pessoa;
import com.hackaton.ezmilk.model.Rebanho;
import com.hackaton.ezmilk.model.dto.RebanhoDTO;
import com.hackaton.ezmilk.repository.PessoaRepository;
import com.hackaton.ezmilk.repository.RebanhoRepository;
import com.hackaton.ezmilk.service.RebanhoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RebanhoServiceImpl implements RebanhoService {

    private final RebanhoRepository rebanhoRepository;

    private final PessoaRepository pessoaRepository;

    private final ModelMapper modelMapper;

    @Override
    public Rebanho findByPessoa(Integer pessoaId) {
        final Pessoa pessoa = pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new DomainException("Pessoa não existe."));

        return rebanhoRepository.findByPessoa(pessoa);
    }

    @Override
    public RebanhoDTO atualizarRebanho(Integer pessoaId, Integer rebanhoId, Rebanho rebanho) {
        final Pessoa pessoa = pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new DomainException("Pessoa não existe."));

        final Rebanho managedRebanho = rebanhoRepository.findByPessoaAndId(pessoa, rebanhoId);
        if (managedRebanho == null) {
            throw new DomainException("Rebanho não encontrado.");
        }
        rebanho.setId(managedRebanho.getId());
        rebanho.setPessoa(managedRebanho.getPessoa());
        rebanho.setQuantidadeTotal(rebanho.getBezerra() + rebanho.getNovilha() + rebanho.getSeca() + rebanho.getLactacao());
        return modelMapper.map(rebanhoRepository.save(rebanho), RebanhoDTO.class);
    }
}
