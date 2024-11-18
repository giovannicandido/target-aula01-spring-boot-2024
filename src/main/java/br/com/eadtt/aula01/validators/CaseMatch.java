package br.com.eadtt.aula01.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = { CaseMatchImpl.class })
public @interface CaseMatch {

    String message() default "{br.com.eadtt.aula01.validators.CaseMatch.message}";

    CaseType caseType() default CaseType.LOWER;

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
