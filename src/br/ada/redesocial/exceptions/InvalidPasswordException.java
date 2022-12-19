package br.ada.redesocial.exceptions;

public class InvalidPasswordException extends RuntimeException {

    public String getMessage() {
        return "Senha inválida!";
    }
}
