package org.umss.scesi.spring_course.final_project.dtos;

public class DepartamentoDTO {

    private String uuid;
    private String nombre;
    private String descripcion;

    public DepartamentoDTO() {}

    public DepartamentoDTO(String uuid, String nombre, String descripcion) {
        this.uuid = uuid;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
