package org.umss.scesi.spring_course.final_project.dtos;

import org.springframework.stereotype.Component;
import org.umss.scesi.spring_course.final_project.models.Departamento;
import org.umss.scesi.spring_course.final_project.models.Proyecto;

@Component
public class ProyectoMapper {

    public ProyectoDTO toDTO(Proyecto proyecto) {
        ProyectoDTO proyectoDTO = new ProyectoDTO();
        proyectoDTO.setUuid(proyecto.getUuid());
        proyectoDTO.setTitulo(proyecto.getTitulo());
        proyectoDTO.setDescripcion(proyecto.getDescripcion());
        proyectoDTO.setFechaComienzo(proyecto.getFechaComienzo());
        proyectoDTO.setFechaFin(proyecto.getFechaFin());
        return proyectoDTO;
    }

    public Proyecto getProyecto(ProyectoDTO proyectoDTO) {
        Proyecto proyecto = new Proyecto();
        proyecto.setUuid(proyectoDTO.getUuid());
        proyecto.setTitulo(proyectoDTO.getTitulo());
        proyecto.setDescripcion(proyectoDTO.getDescripcion());
        proyecto.setFechaComienzo(proyectoDTO.getFechaComienzo());
        proyecto.setFechaFin(proyectoDTO.getFechaFin());
        return proyecto;


    }
}
