package br.com.eadtt.aula01.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CaseMatchImpl implements ConstraintValidator<CaseMatch, String> {
    private CaseType caseType = CaseType.LOWER;

    @Override
    public void initialize(CaseMatch constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.caseType = constraintAnnotation.caseType();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(caseType == CaseType.LOWER) {
            return value.matches("[a-z]*");
        } else {
            return value.matches("[A-Z]*");
        }
    }
}
