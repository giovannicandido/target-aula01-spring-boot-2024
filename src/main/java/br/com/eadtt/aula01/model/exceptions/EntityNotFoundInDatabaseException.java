package br.com.eadtt.aula01.model.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class EntityNotFoundInDatabaseException extends DomainException {
    private final String entityName;
    private final String entityId;
}
