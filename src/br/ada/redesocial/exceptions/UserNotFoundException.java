package br.ada.redesocial.exceptions;

public class UserNotFoundException extends RuntimeException {

    public String getMessage() {
        return "Login não existe. É preciso se cadastrar primeiro.";
    }

}
