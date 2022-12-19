package br.ada.redesocial.perfil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
    private final String data;
    private final String hora;
    private final String comentario;
    public Post(String comentario) {
        this.data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.hora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
        this.comentario = comentario;
    }

    public String getData() {
        return data;
    }

    public String getComentario() {
        return comentario;
    }

    public String getHora() {
        return hora;
    }

}
