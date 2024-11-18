package br.com.eadtt.aula01.model.exceptions;

import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Value
public class PaymentNotFoundException extends DomainException {
    private final Integer clientId;
    private final Integer atendimentoId;
    private final LocalDateTime atendimentoDate;
}
