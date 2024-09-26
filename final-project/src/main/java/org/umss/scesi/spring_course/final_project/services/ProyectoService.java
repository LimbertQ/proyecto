package org.umss.scesi.spring_course.final_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import org.umss.scesi.spring_course.final_project.dtos.ProyectoDTO;
import org.umss.scesi.spring_course.final_project.dtos.ProyectoMapper;
import org.umss.scesi.spring_course.final_project.exceptions.NotFoundException;
import org.umss.scesi.spring_course.final_project.models.Proyecto;

import org.umss.scesi.spring_course.final_project.repositories.ProyectoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProyectoService {
    @Autowired
    private ProyectoRepository proyectoRepository;

    @Autowired
    private ProyectoMapper proyectoMapper;

    public ProyectoDTO getProyecto(String proyectoUuid) {
        Proyecto proyecto = proyectoRepository.findOneByUuid(proyectoUuid);
        if(proyecto == null) {
            throw new NotFoundException("Proyecto", proyectoUuid);
        }
        return proyectoMapper.toDTO(proyecto);
    }

    public List<ProyectoDTO> getAllProyectos() {
        return proyectoRepository
                .findAll()
                .stream()
                .map(proyecto -> proyectoMapper.toDTO(proyecto))
                .collect(Collectors.toList());
    }

    public ProyectoDTO saveProyecto(ProyectoDTO proyectoDTO) {

        Proyecto proyecto = proyectoMapper.getProyecto(proyectoDTO);
        proyectoRepository.save(proyecto);

        return proyectoMapper.toDTO(proyecto);
    }

    public ProyectoDTO updateProyecto(ProyectoDTO proyectoDTO) {
        Proyecto example1 = new Proyecto(proyectoDTO.getUuid());

        Optional<Proyecto> optionalProyecto = proyectoRepository.findOne(Example.of(example1));

        if (optionalProyecto.isEmpty()) {
            throw  new NotFoundException("Proyecto", proyectoDTO.getUuid());
        }

        Proyecto proyecto = optionalProyecto.get();

        proyecto.setTitulo(proyectoDTO.getTitulo());
        proyecto.setDescripcion(proyectoDTO.getDescripcion());
        proyecto.setFechaComienzo(proyectoDTO.getFechaComienzo());
        proyecto.setFechaFin(proyectoDTO.getFechaFin());

        proyectoRepository.save(proyecto);
        return proyectoMapper.toDTO(proyecto);
    }

    public ProyectoDTO deleteProyecto(String proyectoUuid) {
        Proyecto example1 = new Proyecto(proyectoUuid);

        Optional<Proyecto> optionalProyecto = proyectoRepository.findOne(Example.of(example1));

        if (optionalProyecto.isEmpty()) {
            throw  new NotFoundException("Proyecto", proyectoUuid);
        }

        Proyecto proyecto = optionalProyecto.get();
        proyectoRepository.delete(proyecto);
        return proyectoMapper.toDTO(proyecto);


    }
}
