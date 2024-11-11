package br.com.eadtt.aula01.validators;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CPFValidatorTest {

    @ParameterizedTest
    @CsvSource(value = {"91864082089", "51914151089", ","})
    void givenValidCpf_whenIsValid_thenReturnTrue(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        boolean theReturn = cpfValidator.isValid(cpf);
        assertThat(theReturn).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"12345", "@@@", ","})
    void givenInvalidCpf_whenIsValid_thenReturnFalse(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        boolean theReturn = cpfValidator.isValid(cpf);
        assertThat(theReturn).isFalse();
    }

    @Test
    void givenEmptyCpf_whenIsValid_thenReturnTrue() {
        CPFValidator cpfValidator = new CPFValidator();
        boolean theReturn = cpfValidator.isValid("");
        assertThat(theReturn).isTrue();
    }

    @ParameterizedTest
    @MethodSource("cpfs")
    void givenMethodSource_whenIsValid_thenReturnTrue(String cpf) {
        assertThat(cpf).isNotEmpty();
    }

    @ParameterizedTest
    @MethodSource("cpfsArgs")
    void givenMethodSource_whenIsValid_thenReturnTrue(String cpf, boolean expected) {
        CPFValidator cpfValidator = new CPFValidator();
        boolean theReturn = cpfValidator.isValid(cpf);
        assertThat(theReturn).isEqualTo(expected);
    }

    public static Stream<String> cpfs() {
        return Stream.of("91864082089", "51914151089");
    }

    public static Stream<Arguments> cpfsArgs() {
        return Stream.of(
                Arguments.of("91864082089", true),
                Arguments.of("91864082080", false)
        );
    }
}