package org.umss.scesi.spring_course.final_project.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class ProyectoDTO {

    private String uuid;

    @NotNull
    @Size(max=20, min=2, message = "Titulo deberia ser de dos caracteres o mas")
    private String titulo;

    @NotNull
    @Size(max=20, min=2, message = "Descripcion deberia ser de dos caracteres o mas")
    private String descripcion;

    @NotNull
    private Date fechaComienzo;

    @NotNull
    private Date fechaFin;

    public ProyectoDTO(String uuid, String titulo, String descripcion, Date fechaComienzo, Date fechaFin) {
        this.uuid = uuid;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaComienzo = fechaComienzo;
        this.fechaFin = fechaFin;
    }

    public ProyectoDTO() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public @NotNull @Size(max = 20, min = 2, message = "Titulo deberia ser de dos caracteres o mas") String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NotNull @Size(max = 20, min = 2, message = "Titulo deberia ser de dos caracteres o mas") String titulo) {
        this.titulo = titulo;
    }

    public @NotNull @Size(max = 20, min = 2, message = "Descripcion deberia ser de dos caracteres o mas") String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(@NotNull @Size(max = 20, min = 2, message = "Descripcion deberia ser de dos caracteres o mas") String descripcion) {
        this.descripcion = descripcion;
    }

    public @NotNull Date getFechaComienzo() {
        return fechaComienzo;
    }

    public void setFechaComienzo(@NotNull Date fechaComienzo) {
        this.fechaComienzo = fechaComienzo;
    }

    public @NotNull Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(@NotNull Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
