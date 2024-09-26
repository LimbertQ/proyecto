package org.umss.scesi.spring_course.final_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.umss.scesi.spring_course.final_project.dtos.DepartamentoDTO;
import org.umss.scesi.spring_course.final_project.repositories.DepartamentoRepository;
import org.umss.scesi.spring_course.final_project.services.DepartamentoService;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/{departamentoUuid}")
    public DepartamentoDTO get(@PathVariable String departamentoUuid) {
        return departamentoService.getDepartamento(departamentoUuid);
    }

    @GetMapping
    public List<DepartamentoDTO> getAll() {
        return departamentoService.getAllDepartamentos();
    }

    @PostMapping
    public DepartamentoDTO create(@RequestBody DepartamentoDTO departamento) {
        return departamentoService.saveDepartamento(departamento);
    }

    @PutMapping("/{universityUuid}")
    public DepartamentoDTO update(@RequestBody DepartamentoDTO departamento) {

        return departamentoService.updateDepartamento(departamento);
    }

    @DeleteMapping("/{departamentoUuid}")
    public DepartamentoDTO delete(@PathVariable String departamentoUuid) {

        return departamentoService.deleteDepartamento(departamentoUuid);
    }

}
