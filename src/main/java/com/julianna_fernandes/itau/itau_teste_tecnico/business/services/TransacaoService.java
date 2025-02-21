package com.julianna_fernandes.itau.itau_teste_tecnico.business.services;

import com.julianna_fernandes.itau.itau_teste_tecnico.controller.dtos.TransacaoRequestDTO;
import com.julianna_fernandes.itau.itau_teste_tecnico.infrastructure.UnprocessableEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransacaoService {
    private final List<TransacaoRequestDTO> listaTransacoes = new ArrayList<>();

    public void adicionarTransacoes(TransacaoRequestDTO dto) {
        log.info("Iniciado o processamento de gravar transações" + dto);

        if (dto.dataHora().isAfter(OffsetDateTime.now())) {
            log.info("Data e hora maiores que a data e hora atual");
            throw new UnprocessableEntity("Data e hora maiores que a data e hora atual");
        }

        if (dto.valor() < 0) {
            log.info("Valor não pode ser menor que 0");
            throw new UnprocessableEntity("Valor não pode ser menor que 0");
        }

        listaTransacoes.add(dto);

        log.info("Transação gravada com sucesso");

    }

    public void limparTransacoes() {
        log.info("Iniciado o processamento de limpar transações");

        listaTransacoes.clear();

        log.info("Transações limpas com sucesso");
    }

    public List<TransacaoRequestDTO> buscarTransacoes(Integer intervaloBusca) {
        log.info("Iniciado o processamento de buscar transações por tempo" + intervaloBusca);

        OffsetDateTime dataHoraIntervalo = OffsetDateTime.now().minusSeconds(intervaloBusca);

        log.info("Retorno de transações com sucesso");
        return listaTransacoes.stream()
                .filter(transacao -> transacao.dataHora()
                        .isAfter(dataHoraIntervalo)).toList();

    }
}
