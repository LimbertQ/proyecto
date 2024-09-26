package org.umss.scesi.spring_course.final_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.umss.scesi.spring_course.final_project.dtos.DepartamentoDTO;
import org.umss.scesi.spring_course.final_project.dtos.ProyectoDTO;
import org.umss.scesi.spring_course.final_project.services.DepartamentoService;
import org.umss.scesi.spring_course.final_project.services.ProyectoService;

import java.util.List;

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @GetMapping("/{departamentoUuid}")
    public ProyectoDTO get(@PathVariable String proyectoUuid) {
        return proyectoService.getProyecto(proyectoUuid);
    }

    @GetMapping
    public List<ProyectoDTO> getAll() {
        return proyectoService.getAllProyectos();
    }

    @PostMapping
    public ProyectoDTO create(@RequestBody ProyectoDTO proyecto) {
        return proyectoService.saveProyecto(proyecto);
    }

    @PutMapping("/{proyectoUuid}")
    public ProyectoDTO update(@RequestBody ProyectoDTO proyecto) {

        return proyectoService.updateProyecto(proyecto);
    }

    @DeleteMapping("/{proyectoUuid}")
    public ProyectoDTO delete(@PathVariable String proyectoUuid) {

        return proyectoService.deleteProyecto(proyectoUuid);
    }

}
