package org.umss.scesi.spring_course.final_project.dtos;

import org.springframework.stereotype.Component;
import org.umss.scesi.spring_course.final_project.models.Departamento;

@Component
public class DepartamentoMapper {

    public DepartamentoDTO toDTO(Departamento departamento) {
        DepartamentoDTO departamentoDTO = new DepartamentoDTO();
        departamentoDTO.setUuid(departamento.getUuid());
        departamentoDTO.setNombre(departamento.getNombre());
        departamentoDTO.setDescripcion(departamento.getDescripcion());
        return departamentoDTO;
    }

    public Departamento getDepartamento(DepartamentoDTO departamentoDTO) {
        Departamento departamento = new Departamento();
        departamento.setUuid(departamentoDTO.getUuid());
        departamento.setNombre(departamentoDTO.getNombre());
        departamento.setDescripcion(departamentoDTO.getDescripcion());
        return departamento;


    }
}
