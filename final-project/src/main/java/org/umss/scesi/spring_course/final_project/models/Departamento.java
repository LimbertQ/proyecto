package org.umss.scesi.spring_course.final_project.models;

import jakarta.persistence.*;
import org.hibernate.Internal;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "UPDATE departamento SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Departamento {

    @Id
    @GeneratedValue
    private Integer id;


    @Column(updatable = false, nullable = false, unique = true, length = 36)
    private String uuid;

    @Column(nullable = false, length = 80)
    private String nombre;

    @Column(nullable = false, length = 500)
    private String descripcion;

    @CreatedDate
    @Column(updatable = false)
    private Date createdDate;
    @LastModifiedDate
    @Column(updatable = false)
    private Date lastModifiedDate;

    @Column(nullable = false, columnDefinition = "BOOLEAN NOT NULL DEFAULT '0'")
    private boolean deleted;

    public Departamento (){}

    public Departamento(Integer id){
        this.id = id;
    }

    public Departamento(String uuid){
        this.uuid = uuid;
    }

    public Departamento(Integer id, String uuid, String nombre, String descripcion, Date createdDate) {
        this.id = id;
        this.uuid = uuid;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @PrePersist
    public void initializeUuid() {
        this.setUuid(UUID.randomUUID().toString());
    }


}

