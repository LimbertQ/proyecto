package org.umss.scesi.spring_course.final_project.services;

import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import org.umss.scesi.spring_course.final_project.dtos.DepartamentoDTO;
import org.umss.scesi.spring_course.final_project.dtos.DepartamentoMapper;
import org.umss.scesi.spring_course.final_project.exceptions.NotFoundException;
import org.umss.scesi.spring_course.final_project.models.Departamento;
import org.umss.scesi.spring_course.final_project.repositories.DepartamentoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private DepartamentoMapper departamentoMapper;

    public DepartamentoDTO getDepartamento(String departamentoUuid) {
        Departamento departamento = departamentoRepository.findOneByUuid(departamentoUuid);
        if(departamento == null) {
            throw new NotFoundException("Departamento", departamentoUuid);
        }
        return departamentoMapper.toDTO(departamento);
    }

    public List<DepartamentoDTO> getAllDepartamentos() {
        return departamentoRepository
                .findAll()
                .stream()
                .map(departamento -> departamentoMapper.toDTO(departamento))
                .collect(Collectors.toList());
    }

    public DepartamentoDTO saveDepartamento(DepartamentoDTO departamentoDTO) {

        Departamento departamento = departamentoMapper.getDepartamento(departamentoDTO);
        departamentoRepository.save(departamento);

        return departamentoMapper.toDTO(departamento);
    }

    public DepartamentoDTO updateDepartamento(DepartamentoDTO departamentoDTO) {
        Departamento example1 = new Departamento(departamentoDTO.getUuid());

        Optional<Departamento> optionalDepartamento = departamentoRepository.findOne(Example.of(example1));

        if (optionalDepartamento.isEmpty()) {
            throw  new NotFoundException("Departamento", departamentoDTO.getUuid());
        }

        Departamento departamento = optionalDepartamento.get();

        departamento.setNombre(departamentoDTO.getNombre());
        departamento.setDescripcion(departamentoDTO.getDescripcion());

        departamentoRepository.save(departamento);
        return departamentoMapper.toDTO(departamento);
    }

    public DepartamentoDTO deleteDepartamento(String departamentoUuid) {
        Departamento example1 = new Departamento(departamentoUuid);

        Optional<Departamento> optionalDepartamento = departamentoRepository.findOne(Example.of(example1));

        if (optionalDepartamento.isEmpty()) {
            throw  new NotFoundException("Departamento", departamentoUuid);
        }

        Departamento departamento = optionalDepartamento.get();
        departamentoRepository.delete(departamento);
        return departamentoMapper.toDTO(departamento);


    }
}
