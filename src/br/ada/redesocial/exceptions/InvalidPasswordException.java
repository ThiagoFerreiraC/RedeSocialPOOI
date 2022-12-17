package br.ada.redesocial.exceptions;

import javax.management.RuntimeErrorException;

public class InvalidPasswordException extends RuntimeException {

    public String getMessage() {

        return "Senha inválida!";
    }
}
