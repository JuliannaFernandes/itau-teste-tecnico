package com.julianna_fernandes.itau.itau_teste_tecnico.controller.dtos;

import java.time.OffsetDateTime;

public record TransacaoRequestDTO(Double valor, OffsetDateTime dataHora) {
}
