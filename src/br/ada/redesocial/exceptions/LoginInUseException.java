package br.ada.redesocial.exceptions;

public class LoginInUseException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Esse login já está sendo utilizado. Por favor, escolha outro.";
    }
}
