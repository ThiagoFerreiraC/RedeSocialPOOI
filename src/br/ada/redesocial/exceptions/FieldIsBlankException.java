package br.ada.redesocial.exceptions;

public class FieldIsBlankException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Campo(s) não pode(m) ser vazio(s)";
    }
}
